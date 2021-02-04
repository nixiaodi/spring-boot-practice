package org.jiang.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jiang.model.Adjustsalary;
import org.jiang.model.AdjustsalaryExample;


public interface AdjustsalaryMapper {
    long countByExample(AdjustsalaryExample example);

    int deleteByExample(AdjustsalaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Adjustsalary record);

    int insertSelective(Adjustsalary record);

    List<Adjustsalary> selectByExample(AdjustsalaryExample example);

    Adjustsalary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Adjustsalary record, @Param("example") AdjustsalaryExample example);

    int updateByExample(@Param("record") Adjustsalary record, @Param("example") AdjustsalaryExample example);

    int updateByPrimaryKeySelective(Adjustsalary record);

    int updateByPrimaryKey(Adjustsalary record);
}