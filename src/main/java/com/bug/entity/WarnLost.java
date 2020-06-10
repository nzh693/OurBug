package com.bug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Liewona
 * @since 2020-06-11
 */
public class WarnLost extends Model<WarnLost> {

    private static final long serialVersionUID=1L;

    /**
     * 预警ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户负责人ID
     */
    private Integer userid;

    /**
     * 联系人ID
     */
    private Integer linkmanid;

    /**
     * 预警时间
     */
    private String time;

    /**
     * 预警状态
     */
    private Integer state;

    /**
     * 措施
     */
    private String measure;

    /**
     * 流失原因
     */
    private String lostReason;

    /**
     * 备注
     */
    private String comment;

    /**
     * 客户名称
     */
    private String cuname;

    /**
     * 客户id
     */
    private Integer customerid;

    public WarnLost() {
    }

    public WarnLost(Integer userid, Integer linkmanid, String time, Integer state, String measure, String lostReason, String comment, String cuname, Integer customerid) {
        this.userid = userid;
        this.linkmanid = linkmanid;
        this.time = time;
        this.state = state;
        this.measure = measure;
        this.lostReason = lostReason;
        this.comment = comment;
        this.cuname = cuname;
        this.customerid = customerid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getLinkmanid() {
        return linkmanid;
    }

    public void setLinkmanid(Integer linkmanid) {
        this.linkmanid = linkmanid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getLostReason() {
        return lostReason;
    }

    public void setLostReason(String lostReason) {
        this.lostReason = lostReason;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCuname() {
        return cuname;
    }

    public void setCuname(String cuname) {
        this.cuname = cuname;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WarnLost{" +
        "id=" + id +
        ", userid=" + userid +
        ", linkmanid=" + linkmanid +
        ", time=" + time +
        ", state=" + state +
        ", measure=" + measure +
        ", lostReason=" + lostReason +
        ", comment=" + comment +
        ", cuname=" + cuname +
        ", customerid=" + customerid +
        "}";
    }
}
