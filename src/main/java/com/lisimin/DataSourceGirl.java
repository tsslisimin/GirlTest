package com.lisimin;

import org.hibernate.annotations.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//程序运行时候，jpa会自动按根据类的名称建表，表名和类名一致，字段分别自定义的字段
@Entity
public class DataSourceGirl {

    @Id
//    表示id 递增
    @GeneratedValue
    private  Integer id;
    private String name;
    private String sex;
    private  Integer age;

    public DataSourceGirl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
