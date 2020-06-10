package com.bug.service.impl;

import com.bug.entity.BuyProduct;
import com.bug.entity.WarnLost;
import com.bug.mapper.BuyProductMapper;
import com.bug.service.IBuyProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import javafx.scene.input.DataFormat;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.assertj.core.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.management.modelmbean.ModelMBean;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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


    /**
     * 在历史订单表查询6个月没有消费的订单，筛选生成流程预警
     * @return
     */
    @Override
    public List<WarnLost> createWarnLost() {
        String date=Maketime(COMPARE_STARDARD);
        List<BuyProduct> buyProducts=getBaseMapper().selectNoBuy(date);
        return null;
    }

    /**
     * 生成需要比对的时间字符串
     * @return
     */
    @Override
    public String Maketime(int size){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
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
}
