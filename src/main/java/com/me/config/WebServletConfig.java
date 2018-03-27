package com.me.config;

/**
 * Created by pengt on 2017/10/9.
 */
import java.util.ArrayList;
import java.util.List;


import com.me.security.servlet.CaptchaServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebServletConfig implements WebMvcConfigurer {

    @Bean
    public ServletRegistrationBean getJcaptchaServlet(){
        CaptchaServlet captchaServlet=new CaptchaServlet();
        ServletRegistrationBean registrationBean=new ServletRegistrationBean();
        registrationBean.setServlet(captchaServlet);
        List<String> urlMappings=new ArrayList<String>();
        urlMappings.add("/resources/jcaptcha.jpg");
        registrationBean.setUrlMappings(urlMappings);
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

}