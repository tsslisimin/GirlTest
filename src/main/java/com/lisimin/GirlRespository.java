package com.lisimin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JpaRepository<类名,Id类型>其中类名代表操作数据库表的类的名字，Id类型表示Id的数据类型
public interface GirlRespository extends JpaRepository<DataSourceGirl,Integer> {

    //按照名字查询，方法名字必须按照某种规则书写
    public List<DataSourceGirl> findByName(String name);

    public  List<DataSourceGirl> findBySex(String sex);
}
