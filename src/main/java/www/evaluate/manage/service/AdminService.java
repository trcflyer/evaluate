package www.evaluate.manage.service;

import www.evaluate.manage.common.EUDataGridResult;
import www.evaluate.manage.pojo.TbAdmin;

public interface AdminService {
	  /**
     * 根据用户名查找用户
     */
    public TbAdmin queryByUsername(String username) ;
    EUDataGridResult getItemList(int page, int rows);
    /**
     * 根据id查找用户 
     * @param id
     * @return
     */
    TbAdmin selectByPrimaryKey(Integer id);
    /**
     * 根据id修改密码
     * @param username
     * @return
     */
    int updateByPrimaryKey(TbAdmin record);
    /**
     * 增加
     * @param username
     * @return
     */
    int insertAdmin(TbAdmin record);
}
