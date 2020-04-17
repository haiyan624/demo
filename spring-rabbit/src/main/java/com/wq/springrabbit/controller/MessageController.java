package com.wq.springrabbit.controller;

import com.wq.springrabbit.service.IMessageProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@Slf4j
public class MessageController {
    @Autowired
    private IMessageProductService messageProductServiceImpl;

    @RequestMapping("/sendMsg2")
    @ResponseBody
    public String sendMsg2(HttpServletRequest request) {
        String msg = request.getParameter("msg");
        log.info("sendMsg ---  msg--" + String.valueOf(msg));
        messageProductServiceImpl.sendMessage(msg);
        return "send ok";
    }

}
