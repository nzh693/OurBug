package com.bug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
public class Services extends Model<Services> {

    private static final long serialVersionUID=1L;

    /**
     * 服务id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 服务类型：1：咨询 2：投诉 3：建议
     */
    private Integer type;

    /**
     * 服务创建人
     */
    private Integer userid;

    /**
     * 创建时间
     */
    private LocalDateTime time;

    /**
     * 服务被分配
     */
    private Integer dealUserid;

    /**
     * 0：未分配；1：已分配
     */
    private Integer state;

    /**
     * 服务请求内容
     */
    private String serviceContent;

    /**
     * 服务处理过程
     */
    private String serviceDispose;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Integer getDealUserid() {
        return dealUserid;
    }

    public void setDealUserid(Integer dealUserid) {
        this.dealUserid = dealUserid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getServiceContent() {
        return serviceContent;
    }

    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent;
    }

    public String getServiceDispose() {
        return serviceDispose;
    }

    public void setServiceDispose(String serviceDispose) {
        this.serviceDispose = serviceDispose;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Services{" +
        "id=" + id +
        ", type=" + type +
        ", userid=" + userid +
        ", time=" + time +
        ", dealUserid=" + dealUserid +
        ", state=" + state +
        ", serviceContent=" + serviceContent +
        ", serviceDispose=" + serviceDispose +
        "}";
    }
}
