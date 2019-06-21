package com.lb.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//chain的中文含义是链式的，设置为true，则setter方法返回当前对象
public class Dept implements Serializable {

    private Long deptNo;//主键

    private String deptName;//部门名称

    private String dbSource;//数据库源


}
