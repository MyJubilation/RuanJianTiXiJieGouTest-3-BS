package com.beetles.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;
/**
 * @author beetles
 * @date 2024/10/17
 * @Description
 */


@Data
@EqualsAndHashCode(callSuper = false)
@TableName("people")
public class PeopleTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *  名字
     */
    @TableField("name")
    private String name;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    /**
     * 电话号码
     */
    @TableField("phone")
    private String phone;


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
}