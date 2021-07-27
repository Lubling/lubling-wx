package com.lubling.wx.service;

import com.lubling.wx.request.CheckServerRequest;

/**
 * 微信公众号消息处理Service类
 */
public interface WxCommonService {
    /**
     * 接入校验
     * @param request 入参
     * @return 随机码
     */
    String  checkSignature(CheckServerRequest request);
}
