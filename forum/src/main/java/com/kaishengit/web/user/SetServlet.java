package com.kaishengit.web.user;

import com.google.common.collect.Maps;
import com.kaishengit.dto.JsonResult;
import com.kaishengit.entity.User;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.service.RegService;
import com.kaishengit.web.SendHttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Acer on 2016/12/18.
 */
@WebServlet("/set")
public class SetServlet extends SendHttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forward("user/set",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action = req.getParameter("action");
        if("email".equals(action)){

            changeEmail(req,resp);
        }else if("password".equals(action)){
            changePassword(req,resp);
        }

    }
    //用于处理修改邮箱的代码
    private void changeEmail(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        System.out.println(email);
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("curr_user");//获取当前登录用户在session中存储的对象
        System.out.println(user);
        RegService regService = new RegService();
        regService.changeEmail(email,user);
        Map<String,Object> result = Maps.newHashMap();
        result.put("state","success");
        readJson(result,resp);
    }

    //通过方法将内容封装而不是全部堆积在判断代码块里面
    private void changePassword(HttpServletRequest req, HttpServletResponse resp) {
        String oldpassword = req.getParameter("oldpassword");
        String newpassword = req.getParameter("newpassword");
        User user = getSeesion("curr_user",req);
        RegService regService = new RegService();
        try {
            regService.resetPassword(user,oldpassword,newpassword);
            JsonResult json = new JsonResult();
            json.setState();
        }catch (ServiceException ex){

        }

    }
}
