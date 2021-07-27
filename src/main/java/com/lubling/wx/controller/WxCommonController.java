package com.lubling.wx.controller;

import com.lubling.wx.request.CheckServerRequest;
import com.lubling.wx.service.WxCommonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class WxCommonController {
    @Resource
    private WxCommonService wxCommonService;
    /**
     * 公众号事件请求入口
     * @return 处理结果
     */
    @GetMapping("/msgEntrance")
    public String msgEntrance(CheckServerRequest request) {
        return wxCommonService.checkSignature(request);
    }
}
