package com.me.security.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.octo.captcha.service.multitype.GenericManageableCaptchaService;

/**
 * Created by pengt on 2017/10/9.
 */
@Component
public class CaptchaServlet extends HttpServlet implements Servlet {


    private Logger logger = LogManager.getLogger(CaptchaServlet.class);

    private static final long serialVersionUID = 1L;
    //public static ImageCaptchaService service = new DefaultManageableImageCaptchaService();

    protected void doGet(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse) throws ServletException,
            IOException {

        logger.info("########### SECURITY:: 验证码图片生成");

        httpServletResponse.setDateHeader("Expires", 0L);
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(httpServletRequest.getServletContext());
        GenericManageableCaptchaService genericManageableCaptchaService = wac.getBean(GenericManageableCaptchaService.class);
        //System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMM " + genericManageableCaptchaService);
        httpServletResponse.setHeader("Cache-Control",
                "no-store, no-cache, must-revalidate");

        httpServletResponse.addHeader("Cache-Control",
                "post-check=0, pre-check=0");

        httpServletResponse.setHeader("Pragma", "no-cache");

        httpServletResponse.setContentType("image/jpeg");

        BufferedImage bi = genericManageableCaptchaService.getImageChallengeForID(httpServletRequest
                .getSession(true).getId());

        ServletOutputStream out = httpServletResponse.getOutputStream();

        try {

            ImageIO.write(bi, "jpg", out);
            out.flush();
        } finally {
            out.close();
        }
    }

    public static boolean validateResponse(HttpServletRequest request,
                                           String userCaptchaResponse) {
        if (request.getSession(false) == null)
            return false;

        boolean validated = false;
        try {
            WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            GenericManageableCaptchaService genericManageableCaptchaService = wac.getBean(GenericManageableCaptchaService.class);
            validated = genericManageableCaptchaService.validateResponseForID(
                    request.getSession().getId(), userCaptchaResponse)
                    .booleanValue();
        } catch (Exception e) {
        }
        System.out.println("########### SECURITY:: 验证码---验证失败----");
        return validated;
    }

}
