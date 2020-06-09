package com.bug.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName SaleChance
 * @Description 销售机会Pojo
 * @Author 柳成荫
 * @Date 2020/6/9
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value = "SaleChance对象",description = "销售机会对象")
public class SaleChance extends Model<SaleChance> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "销售机会ID",name = "id",example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "客户id",name = "customerId",example = "1")
    private Integer customerId;

    @ApiModelProperty(value = "客户姓名",name = "customerName",example = "赵子龙")
    private String customerName;

    @ApiModelProperty(value = "联系电话",name = "telephone",example = "15310997468")
    private String telephone;

    @ApiModelProperty(value = "性别",name = "sex",example = "男")
    private String sex;

    @ApiModelProperty(value = "地址",name = "addr",example = "重庆市九龙坡区熊家小镇")
    private String addr;

    @ApiModelProperty(value = "客户登记",name = "level",example = "战略合作伙伴、合作伙伴、大客户、重点开发客户、普通客户、VIP客户")
    private String level;

    @ApiModelProperty(value = "机会状态码",name = "state",example = "1：未分派；2：已分派；3：开发成功；4：开发失败")
    private Integer state;

    @ApiModelProperty(value = "机会来源",name = "chanceFrom",example = "新的方式去提供产品")
    private String chanceFrom;

    @ApiModelProperty(value = "成功几率(%)",name = "successRate",example = "55")
    private Integer successRate;

    @ApiModelProperty(value = "概要",name = "summary",example = "这个客户有点东西")
    private String summary;

    @ApiModelProperty(value = "机会描述",name = "description",example = "这是机会描述，这个机会难得")
    private String description;

    @ApiModelProperty(value = "创建人id",name = "createUserid",example = "2")
    private Integer createUserid;

    @ApiModelProperty(value = "创建人",name = "createUsername",example = "霍去病")
    private String createUsername;

//    @TableField(fill = FieldFill.INSERT)   // 插入时修改
    @ApiModelProperty(value = "创建时间",name = "createTime",example = "2020-06-06 09:15:29")
    private Date createTime;

    @ApiModelProperty(value = "被指派的客户经理id",name = "userid",example = "3")
    private Integer userid;

    @ApiModelProperty(value = "被指派的客户经理",name = "username",example = "刘三刀")
    private Integer username;

    @ApiModelProperty(value = "指派时间",name = "assginTime",example = "2020-06-06 09:15:29")
    private Date assginTime;
}
