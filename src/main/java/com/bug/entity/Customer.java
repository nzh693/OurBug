package com.bug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
@Data
public class Customer extends Model<Customer> {

    private static final long serialVersionUID=1L;

    public Customer(String name, String sex, String addr, String telephone, String level, Integer state) {
        this.name = name;
        this.sex = sex;
        this.addr = addr;
        this.telephone = telephone;
        this.level = level;
        this.state = state;
    }

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

}
