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
     * 客户ID
     */
    private Integer linkmanid;

    /**
     * 预警时间
     */
    private LocalDateTime time;

    /**
     * 交易状态
     */
    private String state;

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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
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
        "}";
    }
}
