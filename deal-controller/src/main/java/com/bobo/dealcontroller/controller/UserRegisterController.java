package com.bobo.dealcontroller.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bobo.deal.ServiceInterface.UserService;
import com.bobo.deal.bean.RespBean;
import com.bobo.deal.bean.User;
import com.bobo.dealcontroller.util.CryptManager;
import com.bobo.dealcontroller.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@RestController
@RequestMapping("/open")
public class UserRegisterController {
    @Autowired
    CryptManager cryptManager;

    @Autowired
    EmailUtil emailUtil;

    /**
     * 邮箱验证码发送
     * @param email
     * @param request
     * @return
     */
    @PostMapping("/register")
    public RespBean sentEmail(@RequestParam("email") String email, HttpServletRequest request){
        HttpSession session = request.getSession();
        Random random =new Random();
        String  code =String.valueOf(random.nextInt(999999)+100000);
        System.out.println(code);
        boolean status = emailUtil.sentEmail(email,code);
        if(status==true){
            session.setAttribute("code",code);
            return new RespBean("success","邮件发送成功！");
        }
        else return new RespBean("fault","邮件发送失败！请重试！");
    }

    /**
     * 注册方法
     */
    @Reference
    UserService userService;
    @PutMapping("/register")
    public RespBean text(HttpServletRequest request, @RequestParam("email") String email, @RequestParam("code") String code, @RequestParam("password") String password){
        HttpSession session = request.getSession();
        User user = new User();
        user.setCount(0);
        user.setEmail(email);
        user.setPassword(cryptManager.getCrpyt(password));
        if (session.getAttribute("code")==null){
            return new RespBean("fault","注册失败，请重新申请验证码！");
        }
        if(session.getAttribute("code").equals(code)){
            session.removeAttribute("code");
            int i =userService.UserRegister(user);
            if(i==0){
                return new  RespBean("success","注册成功！");
            }
            else if(i==1){
                return new RespBean("fault","注册失败，邮箱已经注册！");
            }
            else return new RespBean("fault","注册失败，服务端错误！");

        }
        else return new RespBean("fault","注册失败，请检查验证码是否正确！");
    }
}
