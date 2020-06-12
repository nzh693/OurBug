package com.bug.vo;

/*
 *   Author = Liewona
 *   Date = 2020/6/11 17:30
 */
public class ServiceTableResult {


    private Integer id; //服务id
    private Integer type;   //服务类型
    private Integer userid; //创建人id
    private Integer dealUserid;    //分配人id
    private Integer customerId; //客户id
    private String cusName; // 客户姓名
    private String telephone; //客户电话
    private String serviceContent; //服务内容
    private String createTime; //创建时间
    private Integer state; //服务状态
    private String allocationTime; //分配时间
    private String serviceDispose; //处理方法
    private Integer satisfaction; //满意度
    private String comment;   //反馈结果
    private Integer serviceBackId; // 服务反馈的

    public Integer getServiceBackId() {
        return serviceBackId;
    }

    public void setServiceBackId(Integer serviceBackId) {
        this.serviceBackId = serviceBackId;
    }

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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAllocationTime() {
        return allocationTime;
    }

    public void setAllocationTime(String allocationTime) {
        this.allocationTime = allocationTime;
    }

    public Integer getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Integer satisfaction) {
        this.satisfaction = satisfaction;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getDealUserid() {
        return dealUserid;
    }

    public void setDealUserid(Integer dealUserid) {
        this.dealUserid = dealUserid;
    }

    public String getServiceContent() {
        return serviceContent;
    }

    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getServiceDispose() {
        return serviceDispose;
    }

    public void setServiceDispose(String serviceDispose) {
        this.serviceDispose = serviceDispose;
    }
}
