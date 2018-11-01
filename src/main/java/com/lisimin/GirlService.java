package com.lisimin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRespository girlRespository;

    @Transactional
    public void insertTwo(){
        DataSourceGirl dataSourceGirlA=new DataSourceGirl();
//        dataSourceGirlA.setId(6);

        dataSourceGirlA.setAge(22);
        dataSourceGirlA.setName("老八");
        dataSourceGirlA.setSex("man");
        girlRespository.save(dataSourceGirlA);

        DataSourceGirl dataSourceGirlB=new DataSourceGirl();
        dataSourceGirlB.setAge(33);
        dataSourceGirlB.setName("彭九");
        dataSourceGirlB.setSex("woman");
        girlRespository.save(dataSourceGirlB);
//        dataSourceGirlB.setId(7);
    }
}
