package com.techie.springbootdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "Hello World";
    }

    @GetMapping("/{id}")
    public String pathVariable(@PathVariable String id){
        return "The id is : " + id;
    }

//    @GetMapping("/{id}/{id2}")
//    public String pathVariableMulti(@PathVariable String id,
//                                    @PathVariable String id2){
//        return "The id2 is : " + id2;
//    }

    @GetMapping("/{id}/{id2}")
    public String pathVariableMultiDIffName(@PathVariable String id,
                                    @PathVariable(name="id2") String uid){
        return "The id2 is : " + uid;
    }

    @GetMapping("/requestParam")
    public String requestParam(@RequestParam String name){
        return "The name is : " + name;
    }

    //http://localhost:8080/reqParam1?name=Rupesh
    @GetMapping("/reqParam1")
    public String reqParam(@RequestParam String name){
        return "The  new name is : " + name;
    }

    //http://localhost:8080/reqParam2?name=Rupesh&email=rup@gmail.com
    @GetMapping("/reqParam2")
    public String reqParamWithemail(@RequestParam String name,
                           @RequestParam String email){
        return "The  new name is : " + name + ", EMail is :" + email;
    }

    //http://localhost:8080/reqParam3?name=Rupesh&emailId=rup@gmail.com
    @GetMapping("/reqParam3")
    public String reqParamWithemailName(@RequestParam String name,
                                    @RequestParam(name="emailId") String email){
        return "The  new name is : " + name + ", EMail is :" + email;
    }

    @GetMapping("/reqParam4")
    public String reqParamWithemailDefault(@RequestParam String name,
                                        @RequestParam(name="emailId",defaultValue = "") String email){
        return "The  new name is : " + name + ", EMail is :" + email;
    }



}
