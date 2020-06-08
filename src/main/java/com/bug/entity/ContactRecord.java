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
 * @since 2020-06-08
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
    private String eventCount;

    /**
     * 职位
     */
    private String opsition;

    /**
     * 办公电话
     */
    private String telephone;

    /**
     * 移动电话
     */
    private String mobiephone;

    /**
     * 移动电话
     */
    private String comment;


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

    public String getEventCount() {
        return eventCount;
    }

    public void setEventCount(String eventCount) {
        this.eventCount = eventCount;
    }

    public String getOpsition() {
        return opsition;
    }

    public void setOpsition(String opsition) {
        this.opsition = opsition;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobiephone() {
        return mobiephone;
    }

    public void setMobiephone(String mobiephone) {
        this.mobiephone = mobiephone;
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
        return "ContactRecord{" +
        "id=" + id +
        ", time=" + time +
        ", eventCount=" + eventCount +
        ", opsition=" + opsition +
        ", telephone=" + telephone +
        ", mobiephone=" + mobiephone +
        ", comment=" + comment +
        "}";
    }
}
