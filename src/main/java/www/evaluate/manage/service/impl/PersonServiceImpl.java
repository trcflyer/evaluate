package www.evaluate.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.evaluate.manage.dao.TbPersonMapper;
import www.evaluate.manage.pojo.TbPerson;
import www.evaluate.manage.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	TbPersonMapper  tbPersonMapper;
	
	public List<TbPerson> getAll() {
		return tbPersonMapper.getAll();
	}
}
