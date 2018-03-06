package www.evaluate.manage.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import www.evaluate.manage.pojo.TbEvaluate;
import www.evaluate.manage.pojo.TbEvaluateExample;
import www.evaluate.manage.pojo.TbOption;

public interface TbEvaluateMapper {
    int countByExample(TbEvaluateExample example);

    int deleteByExample(TbEvaluateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbEvaluate record);

    int insertSelective(TbEvaluate record);

    List<TbEvaluate> selectByExample(TbEvaluateExample example);

    TbEvaluate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbEvaluate record, @Param("example") TbEvaluateExample example);

    int updateByExample(@Param("record") TbEvaluate record, @Param("example") TbEvaluateExample example);

    int updateByPrimaryKeySelective(TbEvaluate record);

    int updateByPrimaryKey(TbEvaluate record);
    
    List<TbEvaluate> getAll();
    
    List<TbEvaluate> getAllByRes(String res);
}