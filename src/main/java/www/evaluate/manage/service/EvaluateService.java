package www.evaluate.manage.service;

import java.util.List;

import www.evaluate.manage.pojo.TbEvaluate;

public interface EvaluateService {
	int insertEvaluate(TbEvaluate record);
	List<TbEvaluate> getAll();
	List<TbEvaluate> getAllByRes(String res);
}
