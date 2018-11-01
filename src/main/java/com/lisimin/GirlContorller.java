package com.lisimin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.NestingKind;
import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
@RestController
//@RequestMapping("/love")
public class GirlContorller {

    @Autowired
    private GirlRespository girlRespository;
    @Autowired
    private GirlService girlService;
    /**
     * Get方式查找所有女生信息
     * @return
     */
    @GetMapping(value = "/girls")
    public List<DataSourceGirl> findAllGirl(){
        return girlRespository.findAll();
    }

    /**
     *Post方式添加一个女生
     * @param girlName
     * @param sexGirl
     * @param ageGirls
     * @return
     */
   @PostMapping(value = "/girls")
    public DataSourceGirl insertGirl(@RequestParam("name") String girlName,
                                     @RequestParam("sex") String sexGirl,@RequestParam("age") Integer ageGirls){
        DataSourceGirl girl = new DataSourceGirl();
        girl.setAge(ageGirls);
        girl.setName(girlName);
        girl.setSex(sexGirl);
        return girlRespository.save(girl);
    }

    /**
     * Get方式查询某一个用户
     * @param girlId
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public DataSourceGirl selectGirl(@PathVariable("id") Integer girlId){
        return girlRespository.findById(girlId).get();
    }

    /** 请注意@PathVariable和@RequestParam的区别
     * Put方式更新某一用户
     * @param girlId
     * @param girlName
     * @param girlAge
     * @param girlSex
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public DataSourceGirl girlUpdate(@PathVariable("id") Integer girlId,@RequestParam("name") String girlName,
                                     @RequestParam("age") Integer girlAge,@RequestParam("sex") String girlSex){
        DataSourceGirl dataSourceGirl = new DataSourceGirl();
        dataSourceGirl.setSex(girlSex);
        dataSourceGirl.setName(girlName);
        dataSourceGirl.setAge(girlAge);
        dataSourceGirl.setId(girlId);

        return girlRespository.save(dataSourceGirl);
    }

    /**
     * delete方式删除某一个用户
     * @param girlId
     */
    @DeleteMapping(value = "/girls/{id}")
    public void  girlDelete(@PathVariable("id") Integer girlId){
        girlRespository.deleteById(girlId);
    }

    /**
     * 利用jpa自定义查询函数，注意方法的命名需要遵循jpa命名规则
     * @param girlName
     * @return
     */

    @GetMapping(value = "/girls/name/{name}")
    public List<DataSourceGirl> gileFindname(@PathVariable("name") String girlName){
        return girlRespository.findByName(girlName);
    }

    /**
     *利用jpa自定义查询函数，注意方法的命名需要遵循jpa命名规则
     * @param girlSex
     * @return
     */
    @GetMapping(value = "/girls/sex/{sex}")
    public List<DataSourceGirl> girlFindSex(@PathVariable("sex") String girlSex){
        return girlRespository.findBySex(girlSex);
    }

    @PostMapping(value = "girls/two")
    public void Two(){
        girlService.insertTwo();
    }
}
