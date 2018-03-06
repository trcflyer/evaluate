package www.evaluate.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.evaluate.manage.dao.TbUserMapper;
import www.evaluate.manage.pojo.TbUser;
import www.evaluate.manage.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	TbUserMapper tbUserMapper;
	 /**
     * 根据id查找用户 
     * @param id
     * @return
     */
    public TbUser selectByPhone(String phone) {
    	return tbUserMapper.selectByPhone(phone);	
	}

}
