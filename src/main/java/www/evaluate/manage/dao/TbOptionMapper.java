package www.evaluate.manage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import www.evaluate.manage.pojo.TbOption;
import www.evaluate.manage.pojo.TbOptionExample;

public interface TbOptionMapper {
    int countByExample(TbOptionExample example);

    int deleteByExample(TbOptionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbOption record);

    int insertSelective(TbOption record);

    List<TbOption> selectByExample(TbOptionExample example);

    TbOption selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbOption record, @Param("example") TbOptionExample example);

    int updateByExample(@Param("record") TbOption record, @Param("example") TbOptionExample example);

    int updateByPrimaryKeySelective(TbOption record);

    int updateByPrimaryKey(TbOption record);
    
    List<TbOption> getAll();
}