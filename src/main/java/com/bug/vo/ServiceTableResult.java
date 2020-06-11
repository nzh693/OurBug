package com.bug.vo;

/*
 *   Author = Liewona
 *   Date = 2020/6/11 17:30
 */
public class ServiceTableResult {


    private Integer id; //服务id
    private Integer type;   //服务类型
    private Integer userid; //创建人id
    private Integer deal_userid;    //分配人id
    private Integer customer_id; //客户id
    private String cusName; // 客户姓名
    private String telephone; //客户电话
    private String service_content; //服务内容
    private String create_time; //创建时间
    private Integer state; //服务状态
    private String allocation_time; //分配时间
    private String service_dispose; //处理方法
    private Integer satisfaction; //满意度
    private String comment;   //反馈结果


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

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
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

    public String getService_content() {
        return service_content;
    }

    public void setService_content(String service_content) {
        this.service_content = service_content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAllocation_time() {
        return allocation_time;
    }

    public void setAllocation_time(String allocation_time) {
        this.allocation_time = allocation_time;
    }

    public String getService_dispose() {
        return service_dispose;
    }

    public void setService_dispose(String service_dispose) {
        this.service_dispose = service_dispose;
    }

    public Integer getDeal_userid() {
        return deal_userid;
    }

    public void setDeal_userid(Integer deal_userid) {
        this.deal_userid = deal_userid;
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
}
