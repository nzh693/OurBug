package com.bug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Liewona
 * @since 2020-06-09
 */
@ApiModel("服务")
public class Services extends Model<Services> {

    private static final long serialVersionUID=1L;

    /**
     * 服务id
     */
    @ApiModelProperty("服务id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 服务类型：1：咨询 2：投诉 3：建议
     */
    @ApiModelProperty("服务类型")
    private Integer type;

    /**
     * 服务创建人
     */
    @ApiModelProperty("服务创建人id")
    private Integer userid;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 服务被分配
     */
    @ApiModelProperty("服务分配到指定id")
    private Integer dealUserid;

    /**
     * 0：未分配；1：已分配，2 已处理，3 已归档
     */
    @ApiModelProperty("服务状态")
    private Integer state;

    /**
     * 服务请求内容
     */
    @ApiModelProperty("服务请求内容")
    private String serviceContent;

    /**
     * 服务处理过程
     */
    @ApiModelProperty("服务处理过程")
    private String serviceDispose;

    /**
     * 分配时间
     */
    @ApiModelProperty("分配时间")
    private LocalDateTime allocationTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getDealUserid() {
        return dealUserid;
    }

    public void setDealUserid(Integer dealUserid) {
        this.dealUserid = dealUserid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getServiceContent() {
        return serviceContent;
    }

    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent;
    }

    public String getServiceDispose() {
        return serviceDispose;
    }

    public void setServiceDispose(String serviceDispose) {
        this.serviceDispose = serviceDispose;
    }

    public LocalDateTime getAllocationTime() {
        return allocationTime;
    }

    public void setAllocationTime(LocalDateTime allocationTime) {
        this.allocationTime = allocationTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Services{" +
        "id=" + id +
        ", type=" + type +
        ", userid=" + userid +
        ", createTime=" + createTime +
        ", dealUserid=" + dealUserid +
        ", state=" + state +
        ", serviceContent=" + serviceContent +
        ", serviceDispose=" + serviceDispose +
        ", allocationTime=" + allocationTime +
        "}";
    }
}
