package com.lubling.wx.request;

import lombok.Data;

/**
 * 公众号绑定校验入参
 */
@Data
public class CheckServerRequest {
    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;
}
