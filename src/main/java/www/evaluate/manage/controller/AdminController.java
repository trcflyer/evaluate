package www.evaluate.manage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import www.evaluate.manage.bean.ResultMsg;
import www.evaluate.manage.bean.SysUserMsg;
import www.evaluate.manage.common.EUDataGridResult;
import www.evaluate.manage.common.MyConstants;
import www.evaluate.manage.pojo.TbAdmin;
import www.evaluate.manage.service.AdminService;
import www.evaluate.manage.utils.EncrypUtil;
import www.evaluate.manage.utils.StringUtil;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static Logger logger = Logger.getLogger(AdminController.class);
	@Autowired
	AdminService adminServiceImpl;

	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		logger.info(new StringBuffer("[管理员信息][列表]").append("页码:").append(page).append(",大小:").append(rows).toString());
		EUDataGridResult result = adminServiceImpl.getItemList(page, rows);
		return result;
	}

	@RequestMapping("/change")
	@ResponseBody
	public void changePassword(HttpServletRequest request, HttpServletResponse response) {
		logger.info("[管理员信息][修改密码]开始");
		try {
			String oldpassword = request.getParameter("oldpassword");
			String newpassword = request.getParameter("newpassword");
			String againpassword = request.getParameter("againpassword");
			PrintWriter printWriter = response.getWriter();
			ResultMsg resultMsg = new ResultMsg();
			boolean flag = true;
			if (StringUtil.isEmpty(newpassword) || StringUtil.isEmpty(againpassword)
					|| StringUtil.isEmpty(oldpassword)) {
				resultMsg.setMessage("密码不能为空");
				resultMsg.setState("0");
				logger.info("[管理员信息][修改密码]密码不能为空");
				flag = false;
			}
			if (!newpassword.equals(againpassword)) {
				resultMsg.setMessage("两次输入的密码不一样");
				resultMsg.setState("0");
				logger.info("[管理员信息][修改密码]两次输入的密码不一样");
				flag = false;
			}
			SysUserMsg sysUserMsg = (SysUserMsg) request.getSession().getAttribute(MyConstants.LOIGN_SYS_USER);
			if (!EncrypUtil.getMd5Encrypt(oldpassword, MyConstants.MD5_SALT)
					.equals(adminServiceImpl.selectByPrimaryKey(sysUserMsg.getId()).getPassword())) {
				resultMsg.setMessage("原密码输入错误");
				resultMsg.setState("0");
				logger.info("[管理员信息][修改密码]原密码输入错误");
				flag = false;
			}
			if (flag) {
				TbAdmin record = new TbAdmin();
				record.setId(sysUserMsg.getId());
				record.setUsername(sysUserMsg.getUsername());
				record.setRemark(sysUserMsg.getNickname());
				record.setRole(sysUserMsg.getRoleid());
				record.setPassword(EncrypUtil.getMd5Encrypt(newpassword, MyConstants.MD5_SALT));
				int row = adminServiceImpl.updateByPrimaryKey(record);
				if (row != 1) {
					resultMsg.setMessage("修改密码失败");
					resultMsg.setState("0");
					logger.info("[管理员信息][修改密码]修改密码失败");
				} else {
					resultMsg.setMessage("修改密码成功");
					resultMsg.setState("1");
					logger.info("[管理员信息][修改密码]修改密码成功");
				}
			}
			ObjectMapper mapper = new ObjectMapper();
			String jsonStr = mapper.writeValueAsString(resultMsg);
			printWriter.println(JSONObject.parse(jsonStr));
		} catch (IOException e) {
			logger.fatal("[管理员信息][修改密码]系统异常");
			e.printStackTrace();
		}
	}

	@RequestMapping("/add")
	@ResponseBody
	public void addAdmin(HttpServletRequest request, HttpServletResponse response) {
		logger.info("[管理员信息][添加管理员]开始");
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String againpassword = request.getParameter("againpassword");
			String remark = request.getParameter("remark");
			String role = request.getParameter("role");
			PrintWriter printWriter = response.getWriter();
			ResultMsg resultMsg = new ResultMsg();
			boolean flag = true;
			if ( StringUtil.isEmpty(username)) {
				resultMsg.setMessage("用户名不能为空");
				resultMsg.setState("0");
				logger.info("[管理员信息][添加管理员]用户名不能为空");
				flag = false;
			}
			if ( StringUtil.isEmpty(password)
					|| StringUtil.isEmpty(againpassword)) {
				resultMsg.setMessage("密码不能为空");
				resultMsg.setState("0");
				logger.info("[管理员信息][添加管理员]密码不能为空");
				flag = false;
			}
			if (!password.equals(againpassword)) {
				resultMsg.setMessage("两次输入的密码不一样");
				resultMsg.setState("0");
				logger.info("[管理员信息][添加管理员]两次输入的密码不一样");
				flag = false;
			}
			if (flag) {
				TbAdmin record = new TbAdmin();
				record.setUsername(username);
				record.setRemark(remark);
				record.setRole(role);
				record.setPassword(EncrypUtil.getMd5Encrypt(password, MyConstants.MD5_SALT));
				int row = adminServiceImpl.insertAdmin(record);
				if (row != 1) {
					resultMsg.setMessage("添加管理员失败");
					resultMsg.setState("0");
					logger.info("[管理员信息][添加管理员]添加管理员失败");
				} else {
					resultMsg.setMessage("添加管理员成功");
					resultMsg.setState("1");
					logger.info("[管理员信息][添加管理员]添加管理员成功");
				}
			}
			ObjectMapper mapper = new ObjectMapper();
			String jsonStr = mapper.writeValueAsString(resultMsg);
			printWriter.println(JSONObject.parse(jsonStr));
		} catch (IOException e) {
			logger.fatal("[管理员信息][添加管理员]系统异常");
			e.printStackTrace();
		}
	}
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteAdmin(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
