package www.evaluate.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import www.evaluate.manage.common.EUDataGridResult;
import www.evaluate.manage.dao.TbAdminMapper;
import www.evaluate.manage.pojo.TbAdmin;
import www.evaluate.manage.pojo.TbAdminExample;
import www.evaluate.manage.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	TbAdminMapper TbAdminMapper;
	  /**
     * 根据用户名查找用户
     */
    public TbAdmin queryByUsername(String username) {
        return TbAdminMapper.queryByUsername(username);
    }
	public EUDataGridResult getItemList(int page, int rows) {
		 //查询商品列表
        TbAdminExample example = new TbAdminExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbAdmin> list = TbAdminMapper.selectByExample(example);
        if(list != null && list.size()>0){
        	 for(TbAdmin tb : list){
             	if("1".equals(tb.getRole()))
             		tb.setRole("超级管理员");
             	else if("2".equals(tb.getRole()))
             		tb.setRole("普通管理员");
             }
        }
       
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbAdmin> pageInfo = new PageInfo<TbAdmin>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
	}
	public TbAdmin selectByPrimaryKey(Integer id) {
		 return TbAdminMapper.selectByPrimaryKey(id);
	}
	public int updateByPrimaryKey(TbAdmin record) {
	       Integer row =  TbAdminMapper.updateByPrimaryKey(record);
	       if(row==null)
	           row = 0;
	        return row ;
	}
	public int insertAdmin(TbAdmin record) {
		  Integer row =  TbAdminMapper.insert(record);
	       if(row==null)
	           row = 0;
	        return row ;
	}

}
