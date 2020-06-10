package com.bug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Liewona
 * @since 2020-06-10
 */
public class ContactRecord extends Model<ContactRecord> {

    private static final long serialVersionUID=1L;

    /**
     * 记录ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 记录上传时间
     */
    private String time;

    /**
     * 事件
     */
    @TableField("eventCount")
    private Integer eventCount;

    /**
     * 移动电话
     */
    private String comment;

    /**
     * 客户id
     */
    private Integer customerid;

    /**
     * 服务id
     */
    private Integer serviceid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ContactRecord{" +
        "id=" + id +
        ", time=" + time +
        ", eventCount=" + eventCount +
        ", comment=" + comment +
        ", customerid=" + customerid +
        ", serviceid=" + serviceid +
        "}";
    }
}
