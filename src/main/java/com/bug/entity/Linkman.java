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
 * @since 2020-06-09
 */
public class Linkman extends Model<Linkman> {

    private static final long serialVersionUID=1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 联系人姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 职位
     */
    private String position;
    /**
     * 工作电话
     */
    private String telephone;
    /**
     * 手机
     */
    private String phone;
    /**
     * 备注信息
     */
    private String comment;
    /**
     * 销售机会id
     */
    private Integer chanceid;
    /**
     * 客户id
     */
    private Integer customerid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getChanceid() {
        return chanceid;
    }

    public void setChanceid(Integer chanceid) {
        this.chanceid = chanceid;
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
        return "Linkman{" +
        "id=" + id +
        ", name=" + name +
        ", sex=" + sex +
        ", position=" + position +
        ", telephone=" + telephone +
        ", phone=" + phone +
        ", comment=" + comment +
        ", chanceid=" + chanceid +
        ", customerid=" + customerid +
        "}";
    }
}
