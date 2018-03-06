package www.evaluate.manage.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import www.evaluate.manage.bean.SysUserMsg;
import www.evaluate.manage.common.MyConstants;
import www.evaluate.manage.pojo.TbAdmin;
import www.evaluate.manage.service.AdminService;
import www.evaluate.manage.utils.EncrypUtil;
import www.evaluate.manage.utils.StringUtil;


@Controller
@RequestMapping("/")
public class LoginContrller {
	private static Logger logger = Logger.getLogger(LoginContrller.class);
	
	@Autowired
	AdminService adminServiceImpl;
	
	 @RequestMapping("/login")
	    public ModelAndView login(HttpServletRequest request){
	        ModelAndView mav = new ModelAndView("index");
	        SysUserMsg user = (SysUserMsg) request.getSession().getAttribute(MyConstants.LOIGN_SYS_USER);;
	        if(user != null){
	        	 mav.setViewName("home");
	        	 return mav;
	        }
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        logger.info("[登陆]"+username+":"+password);
	        if(StringUtil.isEmpty(username)||StringUtil.isEmpty(password)){
	            mav.setViewName("index");
	            return mav;
	        }
	        boolean loginFlag = true;
	        TbAdmin tbAdmin = adminServiceImpl.queryByUsername(username);
	        if(tbAdmin != null){
	        	logger.info("[登陆]"+EncrypUtil.getMd5Encrypt(password,MyConstants.MD5_SALT)+","+tbAdmin.getPassword());
	            if(EncrypUtil.getMd5Encrypt(password,MyConstants.MD5_SALT).equals(tbAdmin.getPassword())){
	                logger.info("[登陆]登陆成功");
	                mav.setViewName("home");
	                user = new SysUserMsg();
	                user.setUsername(tbAdmin.getUsername());
	                user.setNickname(tbAdmin.getRemark());
	                user.setRoleid(tbAdmin.getRole());
	                user.setId(tbAdmin.getId());
	                request.getSession().setAttribute(MyConstants.LOIGN_SYS_USER, user);;
	            }
	            else{
	                logger.info("[登陆]密码错误，"+username+":"+password);
	                loginFlag = false;
	            }
	        }else{
	            logger.info("[登陆]用户不存在，"+username+":"+password);
	            loginFlag = false;
	        }
	        if(!loginFlag){
	            mav.addObject("message", "用户名密码错误");
	        }
	        return mav;
	    }

}
