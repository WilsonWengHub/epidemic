package com.yueqian.epidemic.controller;


import com.yueqian.epidemic.beans.UserInfo;
import com.yueqian.epidemic.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 配置Controller
 */
@Controller//声明为Controller类的Bean  会被SpringMVCConfig所扫描
@RequestMapping("/user")//一级映射路径
public class UserController {
    @Autowired//自动注入该Bean
    private UserService userService;
    //添加日志管理器
    public  static Logger logger = Logger.getLogger(UserController.class);
    @RequestMapping("login")//二级映射路径  返回值为视图  表单提交的数据回到这里
    //UserInfo userInfo获取表单中的数据 自动调用set方法  userInfo.getUserName()获取输入用户名
    //model为request作用域
    // session为会话域，涉及转发页面的数据共享
    public String login(UserInfo userInfo, Model model , HttpSession session){
        logger.debug("login()方法被执行了" +"账号：" +userInfo.getAccount()+"密码"+userInfo.getPassword());
        //通过业务逻辑层service 获取用户对应的信息 获取对应信息
        //表单用户对象userInfo.getAccount()
        UserInfo user = this.userService.findByAccount(userInfo.getAccount());//数据库用户对象
        if(user == null){
            model.addAttribute("msg" , "账号为空，请重新输入");//设置主页标签提示
            return "login";//返回登陆视图
        }
        //数据库获取数据匹配 登陆成功
        if(user.getPassword().equals(userInfo.getPassword())){
            //将用户名保存到session对象里  显示在前端页面
            session.setAttribute("loginedUser",user);
//            session.invalidate(); 清空session缓存
            //重定向  而不选用转发  解决f5刷新 安全问题
            return "redirect:/main.jsp";//返回main视图  后被SpringMVCConfig中的视图解析器解析为main.jsp
        }
        //密码不正确
        model.addAttribute("msg","密码错误");
        return  "login";
    }
    @RequestMapping("logout")
    public String logOut(HttpSession session){
        //清理session
        session.invalidate();
        return "redirect:/epidemic.jsp";
    }
}
