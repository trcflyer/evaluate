package www.evaluate.manage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import www.evaluate.manage.pojo.TbDepart;
import www.evaluate.manage.pojo.TbDepartExample;

public interface TbDepartMapper {
    int countByExample(TbDepartExample example);

    int deleteByExample(TbDepartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbDepart record);

    int insertSelective(TbDepart record);

    List<TbDepart> selectByExample(TbDepartExample example);

    TbDepart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbDepart record, @Param("example") TbDepartExample example);

    int updateByExample(@Param("record") TbDepart record, @Param("example") TbDepartExample example);

    int updateByPrimaryKeySelective(TbDepart record);

    int updateByPrimaryKey(TbDepart record);
    
    List<TbDepart> getAll();
}