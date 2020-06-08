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
 * @since 2020-06-08
 */
public class SaleChance extends Model<SaleChance> {

    private static final long serialVersionUID=1L;

    /**
     * 机会id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 机会来源
     */
    private String chanceFrom;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 成功几率(%)
     */
    private Integer successRate;

    /**
     * 概要
     */
    private String schema;

    /**
     * 机会描述
     */
    private String desc;

    /**
     * 创建人
     */
    private Integer createUserid;

    /**
     * 创建时间
     */
    private String time;

    /**
     * 指派给
     */
    private Integer userid;

    /**
     * 指派时间
     */
    private String assginTime;

    /**
     * 机会状态：0：未分派；1：已分派；2：开发成功；3：开发失败
     */
    private Integer state;


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

    public String getChanceFrom() {
        return chanceFrom;
    }

    public void setChanceFrom(String chanceFrom) {
        this.chanceFrom = chanceFrom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(Integer successRate) {
        this.successRate = successRate;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Integer createUserid) {
        this.createUserid = createUserid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAssginTime() {
        return assginTime;
    }

    public void setAssginTime(String assginTime) {
        this.assginTime = assginTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
        ", chanceFrom=" + chanceFrom +
        ", telephone=" + telephone +
        ", successRate=" + successRate +
        ", schema=" + schema +
        ", desc=" + desc +
        ", createUserid=" + createUserid +
        ", time=" + time +
        ", userid=" + userid +
        ", assginTime=" + assginTime +
        ", state=" + state +
        "}";
    }
}
