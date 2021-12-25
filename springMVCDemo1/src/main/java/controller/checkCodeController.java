package controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.VerificationCode;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;

@Controller
public class checkCodeController {

    /**
     * 用于生成带四位数字验证码的图片
     */
    @RequestMapping(value = "/checkCode")
    @ResponseBody
    public String imageCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        OutputStream os = response.getOutputStream();
        //返回验证码和图片的map
        Map<String,Object> map = VerificationCode.getImageCode(86, 37, os);
        String simpleCaptcha = "checkCode";
        request.getSession().setAttribute(simpleCaptcha, map.get("strEnsure").toString().toLowerCase());
        request.getSession().setAttribute("codeTime",new Date().getTime());
        try {
            ImageIO.write((BufferedImage) map.get("image"), "jpg", os);
        } catch (IOException e) {
            return "";
        }   finally {
            if (os != null) {
                os.flush();
                os.close();
            }
        }
        return null;
    }

    @RequestMapping(value = "/verify",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String checkCode(HttpServletRequest request,
                            HttpSession session,
                            String code) throws Exception {

        // 获得验证码对象
        Object cko = session.getAttribute("checkCode");
        if (cko == null) {
            request.setAttribute("errorMsg", "请输入验证码！");
            return "请输入验证码！";
        }
        String captcha = cko.toString();
        // 判断验证码输入是否正确
        if (StringUtils.isEmpty(code) || captcha == null || !(code.equalsIgnoreCase(captcha))) {
            request.setAttribute("errorMsg", "验证码错误！");
            return "验证码错误，请重新输入！";
        }
        else {

            // 在这里可以处理自己需要的事务，比如验证登陆等


            return "验证通过！";
        }
    }
}
