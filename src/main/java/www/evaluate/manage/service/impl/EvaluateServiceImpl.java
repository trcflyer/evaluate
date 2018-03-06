package www.evaluate.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.evaluate.manage.dao.TbEvaluateMapper;
import www.evaluate.manage.pojo.TbEvaluate;
import www.evaluate.manage.service.EvaluateService;

@Service
public class EvaluateServiceImpl implements EvaluateService {

	@Autowired
	TbEvaluateMapper tbEvaluateMapper;
	public int insertEvaluate(TbEvaluate record) {
		  Integer row =  tbEvaluateMapper.insert(record);
	       if(row==null)
	           row = 0;
	        return row ;
	}
	public List<TbEvaluate> getAll() {
		return tbEvaluateMapper.getAll();
	}
	public List<TbEvaluate> getAllByRes(String res) {
		return tbEvaluateMapper.getAllByRes(res);
	}

}
