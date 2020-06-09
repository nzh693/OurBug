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
public class ServiceBack extends Model<ServiceBack> {

    private static final long serialVersionUID=1L;

    /**
     * 服务反馈ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 服务ID
     */
    private Integer serviceid;

    /**
     * 满意度:1,2,3,4,5
     */
    private Integer satisfaction;

    /**
     * 服务状态：1：已归档(满意度>3)；2：重新处理(满意度<3)
     */
    private Integer state;

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

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public Integer getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Integer satisfaction) {
        this.satisfaction = satisfaction;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
        return "ServiceBack{" +
        "id=" + id +
        ", serviceid=" + serviceid +
        ", satisfaction=" + satisfaction +
        ", state=" + state +
        ", comment=" + comment +
        "}";
    }
}