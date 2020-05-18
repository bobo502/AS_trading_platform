package com.bobo.dealcontroller.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CryptManager {
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    /**
     * * 加密字符串并返回
     * * @param rawData
     * * @return
     * */
    public String getCrpyt(String rawData){
        return bCryptPasswordEncoder.encode(rawData);
    }
    /**
     * * 判断元数据是否加密后数据匹配     *
     * @param rawData     *
     * @param encodedData     *
     * @return     */
    public boolean matched(String rawData, String encodedData){
        return bCryptPasswordEncoder.matches(rawData, encodedData);
    }

}
