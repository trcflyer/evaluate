package www.evaluate.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.evaluate.manage.dao.TbDepartMapper;
import www.evaluate.manage.pojo.TbDepart;
import www.evaluate.manage.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	TbDepartMapper tbDepartMapper;
	public List<TbDepart> getAll() {
		return tbDepartMapper.getAll();
	}

}
