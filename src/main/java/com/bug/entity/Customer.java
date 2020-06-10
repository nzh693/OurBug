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
 * @since 2020-06-10
 */
public class Customer extends Model<Customer> {

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
    private String addr;

    /**
     * 工作电话
     */
    private String telephone;

    /**
     * 客户等级:战略合作伙伴、合作伙伴、大客户、重点开发客户、普通客户、VIP客户。
     */
    private String level;

    /**
     * 客户状态：1：正常；0：已流失；
     */
    private Integer state;

    public  Customer(){

    }

    public Customer(String name, String sex, String addr, String telephone, String level, Integer state) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.addr = addr;
        this.telephone = telephone;
        this.level = level;
        this.state = state;
    }

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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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
        return "Customer{" +
        "id=" + id +
        ", name=" + name +
        ", sex=" + sex +
        ", addr=" + addr +
        ", telephone=" + telephone +
        ", level=" + level +
        ", state=" + state +
        "}";
    }
}
