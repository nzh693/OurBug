package com.bug.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Result
 * @Description 返回结果
 * @Author 柳成荫
 * @Date 2020/6/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> {
    private Integer code;   // 结果码 - 成功-0 失败-1
    private String msg;     // 结果消息
    private Integer count;  // 记录数
    private T data;         // 数据

    public ResponseResult(T data){
        this(0,"成功!",0,data);
    }
}
