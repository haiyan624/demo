package com.wq.springcloudorder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OderController {
    @RequestMapping("orderTest")
    public String orderTest(){
        return "this is order";
    }
}
