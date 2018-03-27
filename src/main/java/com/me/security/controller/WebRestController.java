package com.me.security.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pengt on 2017/10/10.
 */
@RestController
public class WebRestController {
    private Logger logger = LogManager.getLogger(WebRestController.class);

    @RequestMapping(value = "/welcome.do")
    public String fWelcome(HttpServletRequest request) {
        logger.info("############### 验证JSP 暂时不用 ...........");
        return "welcome";
    }


}
