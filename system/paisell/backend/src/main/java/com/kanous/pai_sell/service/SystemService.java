package com.kanous.pai_sell.service;

import com.alibaba.fastjson.JSONObject;
import com.kanous.pai_sell.model.Systemuser;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class SystemService {
    @Autowired BaseService baseService;

    public String encryption(String plaintext,String type) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String saveCiphertext = null;
        if (plaintext != null && plaintext.length() > 0) {
            //创建加密对象
            MessageDigest messageDigest = MessageDigest.getInstance(type);
            // 传入加密的字符串
            messageDigest.update(plaintext.getBytes());
            // 得到bytes类型结果
            byte[] ciphertextBytes = messageDigest.digest();
            int i;
            // 得到字符集
            StringBuffer stringBuffer = new StringBuffer();
            for (i = 0; i < ciphertextBytes.length; i++) {
                stringBuffer.append(ciphertextBytes[i]);
            }
            //转换为String
            String ciphertext = stringBuffer.toString();
            //base64转换
            saveCiphertext = Base64.getEncoder().encodeToString(ciphertext.getBytes("utf-8"));
        }
        return saveCiphertext;
    }

    public JSONObject registry(JSONObject json) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        JSONObject result = new JSONObject();
        String userId = UUID.randomUUID().toString().replace("-","");
        String pwd = encryption(json.getString("password"),"SHA-512");
        Systemuser systemuser = Systemuser.builder()
                .userId(userId)
                .callName(json.getString("callName"))
                .password(pwd)
                .build();
        try {
            baseService.mappingDomain("Systemuser").save(systemuser);
            result.put("result", "successful");
        } catch (Exception err) {
            result.put("result", "unknown error");
        }

        return result;
    }

    public JSONObject login(JSONObject json, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        JSONObject result = new JSONObject();
        String pwd = encryption(json.getString("password"),"SHA-512");
        List<Systemuser> list= baseService.mappingDomain("Systemuser")
                .findByString(new String[]{"callName", "password"}, new String[]{json.getString("callName"), pwd});
        if (list.size() == 1) {
            result.put("users", list.get(0));
            result.put("isLogin", true);
            session.setAttribute("name", list.get(0).getCallName());
        } else {
            result.put("isLogin", false);
        }
        return result;
    }

    public JSONObject loginOut(JSONObject json, HttpSession session) {
        session.removeAttribute("name");
        return null;
    }

    public JSONObject CallNameCheck(JSONObject json) {
        JSONObject result = new JSONObject();
        try {
            List<Systemuser> list= baseService.mappingDomain("Systemuser").findByString(new String[]{"callName"}, new String[]{json.getString("callName")});
            if (list.isEmpty()) {
                result.put("isSuccessful","true");
            } else {
                result.put("isSuccessful","false");
            }
        } catch (Exception err) {
            result.put("result", "unknown error");
        }
        return result;
    }
}
