package com.bug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bug.entity.BuyProduct;
import com.bug.entity.WarnLost;
import com.bug.mapper.BuyProductMapper;
import com.bug.service.IBuyProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bug.service.IWarnLostService;
import javafx.scene.input.DataFormat;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.assertj.core.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.modelmbean.ModelMBean;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
@Service
public class BuyProductServiceImpl extends ServiceImpl<BuyProductMapper, BuyProduct> implements IBuyProductService {

    private final static int COMPARE_STARDARD=6;//月份前置个数
    private final static String DATE_FORMAT="yyyy-MM-dd HH:mm:ss";//时间格式
    private Logger logger= LoggerFactory.getLogger(BuyProduct.class);
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

    @Autowired
    private IWarnLostService warnLostService;


    /**
     * 在历史订单表查询6个月没有消费的订单，筛选生成流程预警
     * @return
     */
    @Override
    @Transactional
    public List<WarnLost> createWarnLost() {
        String oldDate=Maketime(COMPARE_STARDARD);
        QueryWrapper<WarnLost> qw = new QueryWrapper<>();
        qw.gt("id",1);
        getBaseMapper().deleteAllWarnInfo();//删除旧的预警记录
        List<Integer> cid=getBaseMapper().selectNoBuy(oldDate);//扫描获取客户id
        List<WarnLost> warnLosts=new ArrayList<>();
        Random random=new Random();
        for (Integer i:cid){//生成b本次扫描的预警信息
            Integer uid = random.nextInt(20);
            Integer lid = random.nextInt(20);
            String nowDate=simpleDateFormat.format(new Date());
            WarnLost warnLost = new WarnLost(uid, lid,nowDate , 1, null,
                    null, null, "文与可"+String.valueOf(i), i);
            warnLostService.save(warnLost);
            warnLosts.add(warnLost);
        }
        logger.debug(warnLosts.toString());
        return warnLosts;
    }

    /**
     * 生成需要比对的时间字符串
     * @return
     */
    @Override
    public String Maketime(int size){

        String date=simpleDateFormat.format(new Date());
        logger.info("当前时间："+date);
        int month= DateUtil.monthOf(new Date());//当前月份
        String strMonth;
        if (month>=size){//月份前置6个月
            month-=size;
        }else{
            month=12-Math.abs(month-size);
        }
        if (month<10){//不满两位则补足
            strMonth="0"+String.valueOf(month);
        }else {
            strMonth=month+"";
        }
        String[] strs=date.split("-|\\:|\\s");//  需要转义的特殊符号【* ^ : | . \】
        date=strs[0]+"-"+strMonth+"-"+strs[2]+" "+strs[3]+":"+strs[4]+":"+strs[5];
        logger.info("前置后："+date);
        return date;
    }

    /**
     * 按页面要求返回预警记录
     * @param page 页码
     * @param size 页大小
     * @param warnLosts 所有数据
     * @return
     */
    @Override
    public List<WarnLost> getPageWarLost(int page,int size,List<WarnLost> warnLosts){
        int total=warnLosts.size();
        int sIndex,eIndex;
        if (page*size>total){//请求页数超出范围
            int tindex=--page*size;
            if (tindex<total){//未超出尾页数据
                sIndex=tindex;
                return warnLosts.subList(sIndex,total-1);
            }
            return null;//超出尾页
        }else {
            sIndex=(page-1)*size;
            eIndex=sIndex+size;
            warnLosts=warnLosts.subList(sIndex,eIndex);
        }

        return warnLosts;
    }

}
