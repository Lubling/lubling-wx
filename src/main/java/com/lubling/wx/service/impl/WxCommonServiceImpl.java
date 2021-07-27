package com.lubling.wx.service.impl;

import com.lubling.wx.request.CheckServerRequest;
import com.lubling.wx.service.WxCommonService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 微信公众号消息处理Service实现类
 */
@Service
public class WxCommonServiceImpl implements WxCommonService {
    @Override
    public String checkSignature(CheckServerRequest request) {
        String signature = request.getSignature();
        String timestamp = request.getTimestamp();
        String nonce = request.getNonce();
        List<String> paramList = new ArrayList<>();
        paramList.add(signature);
        paramList.add(timestamp);
        paramList.add(nonce);
        Collections.sort(paramList);
        StringBuilder sumStr = new StringBuilder();
        for(String str : paramList) {
            sumStr.append(str);
        }
        String calculationValue = DigestUtils.sha1Hex(sumStr.toString());
        if(request.getSignature().equals(calculationValue)) {
            return calculationValue;
        } else {
            return null;
        }
    }
}
