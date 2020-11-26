package com.sample.slack.slackwebhooks.controller;

import com.sample.slack.slackwebhooks.service.MainService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/slack")
public class MainController {

    MainService mainService;

    public MainController(MainService mainService){
        this.mainService = mainService;
    }
    
    @GetMapping("/sendmsg")
    public void sendMsg(@RequestParam String msg){
        mainService.sendMsg(msg);
    }
}
