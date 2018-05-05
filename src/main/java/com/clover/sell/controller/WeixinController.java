package com.clover.sell.controller;

import org.hibernate.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wuzhentao
 * 2018/5/5 11:32
 */
@RestController
@RequestMapping("/weixin")
public class WeixinController {
    private static final Logger LOG = LoggerFactory.getLogger(WeixinController.class);

    @GetMapping(value = "/auth")
    public void auth(@RequestParam("code") String code){
        LOG.info("进入auth方法。。。。");
        LOG.info("code={}",code);

        String accessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx2baf1eaca23dbd25&secret=5045f0e5c4c65776dbdc67181c797fbd"
                +"&code="+ code +"&grant_type=authorization_code";
        RestTemplate template = new RestTemplate();
        String response = template.getForObject(accessTokenUrl,String.class);
        LOG.info(response);

    }
}
