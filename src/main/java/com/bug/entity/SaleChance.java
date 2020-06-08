package com.bug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class SaleChance extends Model<SaleChance> {

    private static final long serialVersionUID=1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户姓名
     */
    @TableField("customerName")
    private String customerName;

    /**
     * 机会来源
     */
    @TableField("chanceSrc")
    private String chanceSrc;

    /**
     * 所有联系人id
     */
    @TableField("linkIds")
    private String linkIds;

    /**
     * 客户联系电话
     */
    private String phone;

    /**
     * 成功几率
     */
    private String percentage;

    /**
     * 概要描述
     */
    private String describe;

    /**
     * 机会状态
     */
    @TableField("chanceStatus")
    private String chanceStatus;

    /**
     * 创建人id
     */
    @TableField("createBy")
    private Integer createBy;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 指派给的联系人的id
     */
    private Integer appoint;

    /**
     * 指派时间
     */
    @TableField("appointTime")
    private LocalDateTime appointTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getChanceSrc() {
        return chanceSrc;
    }

    public void setChanceSrc(String chanceSrc) {
        this.chanceSrc = chanceSrc;
    }

    public String getLinkIds() {
        return linkIds;
    }

    public void setLinkIds(String linkIds) {
        this.linkIds = linkIds;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getChanceStatus() {
        return chanceStatus;
    }

    public void setChanceStatus(String chanceStatus) {
        this.chanceStatus = chanceStatus;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getAppoint() {
        return appoint;
    }

    public void setAppoint(Integer appoint) {
        this.appoint = appoint;
    }

    public LocalDateTime getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(LocalDateTime appointTime) {
        this.appointTime = appointTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SaleChance{" +
        "id=" + id +
        ", customerName=" + customerName +
        ", chanceSrc=" + chanceSrc +
        ", linkIds=" + linkIds +
        ", phone=" + phone +
        ", percentage=" + percentage +
        ", describe=" + describe +
        ", chanceStatus=" + chanceStatus +
        ", createBy=" + createBy +
        ", createTime=" + createTime +
        ", appoint=" + appoint +
        ", appointTime=" + appointTime +
        "}";
    }
}
