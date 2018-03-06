package www.evaluate.manage.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import www.evaluate.manage.pojo.TbDepart;
import www.evaluate.manage.pojo.TbEvaluate;
import www.evaluate.manage.pojo.TbOption;
import www.evaluate.manage.pojo.TbPerson;
import www.evaluate.manage.pojo.TbUser;
import www.evaluate.manage.service.DepartmentService;
import www.evaluate.manage.service.EvaluateService;
import www.evaluate.manage.service.OptionService;
import www.evaluate.manage.service.PersonService;
import www.evaluate.manage.service.UserService;

@Controller
@RequestMapping("/")
@SessionAttributes(value={"listDepart","listPerson"})
public class VoteController {
	private static Logger logger = Logger.getLogger(VoteController.class);

	@Autowired
	UserService userServiceImpl;
	
	@Autowired
	DepartmentService departmentServiceImpl;
	
	@Autowired
	PersonService personServiceImpl;
	
	@Autowired
	OptionService optionServiceImpl;
	
	@Autowired
	EvaluateService evaluateService;
	
	@RequestMapping("/list")
	public ModelAndView voteList(HttpServletRequest request) {
		logger.info("[投票]开始");
		ModelAndView mav = new ModelAndView("vote");
		String phone = request.getParameter("phone");
		logger.info("[投票]phone："+phone);
		TbUser tbuser = userServiceImpl.selectByPhone(phone);
		if(tbuser == null){
			mav.setViewName("welcome");
			mav.addObject("message", "用户不存在，请输入正确的手机号");
		}
		request.getSession().setAttribute("tbuser", tbuser);
		
		List<TbDepart> listDepart= departmentServiceImpl.getAll();
		logger.info("[投票]查询到的部门大小为："+listDepart.size());
		
		List<TbPerson> listPerson= personServiceImpl.getAll();
		logger.info("[投票]查询到的用户大小为："+listPerson.size());
		
		List<TbOption> listOption = optionServiceImpl.getAll();
		logger.info("[投票]查询到的选项大小为："+listOption.size());
		
		mav.addObject("listDepart", listDepart);
		mav.addObject("listPerson", listPerson);
		mav.addObject("size", listDepart.size()+listDepart.size());
		
		
		mav.addObject("listOption", listOption);

		return mav;
	}
	@RequestMapping("/evaluate")
	public ModelAndView evaluate(@ModelAttribute("listDepart") List<TbDepart> listDepart ,
			@ModelAttribute("listPerson") List<TbPerson> listPerson ,HttpServletRequest request) {
		logger.info("[提交投票结果]开始");
		ModelAndView mav = new ModelAndView("result");
		TbUser tbuser = (TbUser) request.getSession().getAttribute("tbuser");
		
		for(int i = 0 ; i < listDepart.size() ; i ++){
			TbDepart tbDepart = listDepart.get(i);
			int temp = i+1;
			String[] checkedStr = request.getParameterValues("option-depart-name"+temp);
			int checked = Integer.parseInt(checkedStr[0].trim());
			TbEvaluate record = new TbEvaluate();
			record.setOptionid(checked);
			record.setResid(tbDepart.getId());
			record.setUserid(tbuser.getId());
			record.setRes("depart");
			evaluateService.insertEvaluate(record);
		}
		for(int i = 0 ; i < listPerson.size() ; i ++){
			TbDepart tbDepart = listDepart.get(i);
			int temp = i+1;
			String[] checkedStr = request.getParameterValues("option-person-name"+temp);
			int checked = Integer.parseInt(checkedStr[0].trim());
			TbEvaluate record = new TbEvaluate();
			record.setOptionid(checked);
			record.setResid(tbDepart.getId());
			record.setRes("person");
			record.setUserid(tbuser.getId());
			evaluateService.insertEvaluate(record);
		}
		logger.info("[提交投票结果]成功");
		
		return mav;

		
	}
	@RequestMapping("/showresult/depart")
	public void showResultDepart(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		 req.setCharacterEncoding("UTF-8");
	        resp.setHeader("Content-type", "text/html;charset=UTF-8");
	        resp.setCharacterEncoding("UTF-8");
		logger.info("[部门显示投票结果]开始");
		List<TbDepart> listDepart= departmentServiceImpl.getAll();
		List<TbEvaluate> listEvaluate = evaluateService.getAllByRes("depart");
		List<TbOption> listOption = optionServiceImpl.getAll();
		JSONArray array = new JSONArray();
		for(TbDepart depart:listDepart){
			JSONObject object = new JSONObject();
			int score = 0;
			for(TbEvaluate evaluate:listEvaluate){
				if(depart.getId().equals(evaluate.getResid())){
					for(TbOption option:listOption){
						if(option.getId().equals(evaluate.getOptionid())){
							score += option.getScore();
						}
					}
				}
			}
			object.put("genre", depart.getDepartname());
			object.put("sold", score);
			array.add(object);
		}
		String result = array.toJSONString();
		logger.info("[部门显示投票结果]结果为："+result);
		  PrintWriter pw = resp.getWriter();
	        pw.write(result);
	        pw.flush();
	        pw.close();
	}
	@RequestMapping("/showresult/person")
	public void showResultPerson(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		 req.setCharacterEncoding("UTF-8");
	        resp.setHeader("Content-type", "text/html;charset=UTF-8");
	        resp.setCharacterEncoding("UTF-8");
		logger.info("[人员显示投票结果]开始");
		List<TbPerson> listPerson= personServiceImpl.getAll();
		List<TbEvaluate> listEvaluate = evaluateService.getAllByRes("person");
		List<TbOption> listOption = optionServiceImpl.getAll();
		JSONArray array = new JSONArray();
		for(TbPerson person:listPerson){
			JSONObject object = new JSONObject();
			int score = 0;
			for(TbEvaluate evaluate:listEvaluate){
				if(person.getId().equals(evaluate.getResid())){
					for(TbOption option:listOption){
						if(option.getId().equals(evaluate.getOptionid())){
							score += option.getScore();
						}
					}
				}
			}
			object.put("genre", person.getPersonname());
			object.put("sold", score);
			array.add(object);
		}
		String result = array.toJSONString();
		logger.info("[人员显示投票结果]结果为："+result);
		  PrintWriter pw = resp.getWriter();
	        pw.write(result);
	        pw.flush();
	        pw.close();
	}
}
