package com.lisimin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(value = "/simin")
public class GirlTest {
    @Value("${girl.name}")
    private String myname;
    @Value("${girl.age}")
    private  String myage;
    @Value("${mycontext}")
    private  String data;
    @Autowired
    GirlDao girldao;

//    @RequestMapping(value ={"/hello","/hi"},method = RequestMethod.GET)
    @GetMapping(value = {"/hello","/hi"})
    public  String sayhello(@RequestParam(value = "id",required = false,defaultValue = "0") String myid){
//        return myname+"..."+myage;
        return girldao.getName()+".."+girldao.getAge()+".."+girldao.getSex()+".."+myid;
    }

    @GetMapping(value = "/name1")
    public String httpTest(@RequestParam(value = "name",required = true) String myname){
        return "my name is"+ myname;
    }

    @GetMapping(value = "{id}/pass")
    public String httpTest2(@PathVariable("id") Integer myid){

        return "my id is "+myid;
    }
}
