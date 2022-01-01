package com.gip.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
    //实体类
    private Long deptno;
    private String dname;
    private String db_source;

    public Dept(String dname){
        this.dname=dname;
    }
}
