package com.mo.alis.controller;

import com.alibaba.fastjson.JSONObject;
import com.mo.alis.model.User;
import com.mo.alis.service.system.BaseService;
import com.mo.alis.service.system.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class SystemController {

    @Autowired
    private BaseService baseService;

    @Autowired
    private SystemService systemService;

    @PostMapping(path = "/api/{params}")
    public void getList(@PathVariable String params) {
        if (baseService.mappingDomain(params) == null) {
            System.out.print("sss");
        } else {
            System.out.print(baseService.mappingDomain(params).findAll());
        }
    }

    @PostMapping(path = "/login")
    public List<Map> login(@RequestBody JSONObject jsonObject, HttpServletRequest httpServletRequest) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.print(">>>>>>>>>jsonObject" + jsonObject);
        List<Map> list = new ArrayList<>();
        Map map = new HashMap();
        String user = jsonObject.getString("account");
        String pwd = systemService.encryption(jsonObject.getString("pwd"), "SHA-512");
        System.out.println(">>>>>>>>>pwd>>" + pwd);
        List<User> result = systemService.getLoginResult(user,pwd);
        if ( result.size() > 0 ) {
            httpServletRequest.getSession().setAttribute("user", user);
            map.put("isLogin", true);
            map.put("userName", result.get(0).getUserName());
            map.put("account", result.get(0).getUserAccount());
//            map.put("userName",result.get(0).getClass().("user_name"));
            list.add(map);
            return list;
        } else {
            map.put("isLogin", false);
            list.add(map);
            return list;
        }
    }
    @PostMapping(path = "/findLevelsAndMoney")
    public List findLevelsAndMoney(@RequestBody JSONObject jsonObject) {
        return systemService.getLevelsAndMoneyResult(jsonObject);
    }
}
