package www.evaluate.manage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import www.evaluate.manage.pojo.TbAdmin;
import www.evaluate.manage.pojo.TbAdminExample;

public interface TbAdminMapper {
    int countByExample(TbAdminExample example);

    int deleteByExample(TbAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbAdmin record);

    int insertSelective(TbAdmin record);

    List<TbAdmin> selectByExample(TbAdminExample example);

    TbAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbAdmin record, @Param("example") TbAdminExample example);

    int updateByExample(@Param("record") TbAdmin record, @Param("example") TbAdminExample example);

    int updateByPrimaryKeySelective(TbAdmin record);

    int updateByPrimaryKey(TbAdmin record);
    
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    TbAdmin queryByUsername(String username);
    
  
}