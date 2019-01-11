package com.Blog.model;

/*
 * 作者：赵国应
 * 时间：2019-1-9
 * 描述：权限
 */

import lombok.Data;

@Data
public class Role {
    private int id;

    private String name;

    Role(){}

    Role(int id,String name){
        this.id = id;
        this.name = name;
    }
}
