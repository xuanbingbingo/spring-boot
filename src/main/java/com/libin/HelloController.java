package com.libin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController等同于(@Controller和@ResponseBody的组合，单独使用@Controller返回的应该是个模版如index.html)
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;
//
//    @Value("${age}")
//    private Integer age;
//
//    @Value("${content}")
//    private String content;
    @Autowired
    private GirlProperties girlProperties;

    //请求参数，方式一：localhost:8081/hello/say/100
    //@RequestMapping(value = "/say/{id}",method = RequestMethod.GET)
//    public String say(@PathVariable("id") Integer id){
//        return "id: "+id;
////        return "index";
////        return cupSize + "-" +girlProperties.getCupSize();
//    }

    //请求参数，方式二：localhost:8081/hello/say?id=100
    @RequestMapping(value = "/say",method = RequestMethod.POST)
    //上面这段代码等同于@GetMapping(value = "/say")
    public String say(@RequestParam(value = "id",required = false, defaultValue = "0") Integer myId){
        return "id: "+ myId;
    }
}
