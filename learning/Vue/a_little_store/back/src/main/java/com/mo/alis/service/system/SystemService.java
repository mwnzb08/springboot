package com.mo.alis.service.system;

import com.alibaba.fastjson.JSONObject;
import com.mo.alis.model.User;
import com.mo.alis.service.system.reponsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

@Service
public class SystemService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BaseService baseService;

    @Autowired
    private UserRepository userRepository;

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

    public List getResultBySql(String sql, Object[] params) {
        try {
            return jdbcTemplate.queryForList(sql, params);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("not data");
            return null;
        }
    }

    public List<User> getLoginResult(String name, String pwd) {
        return userRepository.findAllByUserAccountAndUserPassword(name,pwd);
    }

    public List getLevelsAndMoneyResult(JSONObject jsonObject){
        String account = jsonObject.getString("account");
        Long uid = userRepository.findIdByUserAccount(account);
        System.out.println("?????????" + uid);
        return baseService.mappingDomain("ViewFindUserMoneyLevels").findAll();
    }
}
