package www.evaluate.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.evaluate.manage.dao.TbOptionMapper;
import www.evaluate.manage.pojo.TbOption;
import www.evaluate.manage.service.OptionService;

@Service
public class OptionServiceImpl implements OptionService {

	@Autowired
	TbOptionMapper tbOptionMapper;
	public List<TbOption> getAll() {
		// TODO Auto-generated method stub
		return tbOptionMapper.getAll();
	}

}
