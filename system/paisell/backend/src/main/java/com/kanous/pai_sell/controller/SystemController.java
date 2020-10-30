package com.kanous.pai_sell.controller;

import com.alibaba.fastjson.JSONObject;
import com.kanous.pai_sell.service.SystemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(path = "/sys")
@Log4j2
public class SystemController {

    @Autowired
    private SystemService systemService;

    @PostMapping(path = "/registry")
    private JSONObject UserRegistry(@RequestBody JSONObject jsonObject) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        log.info("registry data: " + jsonObject.toJSONString());
        JSONObject result = systemService.registry(jsonObject);
        return result;
    }

    @PostMapping(path = "/login")
    private JSONObject UserLogin(@RequestBody JSONObject jsonObject, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        log.info("login data: " + jsonObject.toJSONString());
        JSONObject result = systemService.login(jsonObject, session);
        return result;
    }

    @PostMapping(path = "/loginOut")
    private void UserLoginOut(@RequestBody JSONObject jsonObject, HttpSession session) {
        log.info("loginOut data: " + jsonObject.toJSONString());
        JSONObject result = systemService.loginOut(jsonObject, session);
    }

    @PostMapping(path = "/callNameCheck")
    private JSONObject CallNameCheck(@RequestBody JSONObject jsonObject) {
        log.info("callNameCheck data: " + jsonObject.toJSONString());
        JSONObject result = systemService.CallNameCheck(jsonObject);
        return result;
    }

    @PostMapping(path = "/getSession")
    private JSONObject GetSession(@RequestBody JSONObject jsonObject,HttpSession session) {
        log.info("GetSession data: " + jsonObject.toJSONString());
        System.out.println(session.getAttribute("name"));
        return null;
    }

    @PostMapping(path = "changePwd")
    private Object UserChangePwd() {
        return null;
    }

    @PostMapping(path = "changeDetail")
    private Object UserChangeDetail() {
        return null;
    }

}
