package org.jiang.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jiang.model.Oplog;
import org.jiang.model.OplogExample;

public interface OplogMapper {
    long countByExample(OplogExample example);

    int deleteByExample(OplogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Oplog record);

    int insertSelective(Oplog record);

    List<Oplog> selectByExample(OplogExample example);

    Oplog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Oplog record, @Param("example") OplogExample example);

    int updateByExample(@Param("record") Oplog record, @Param("example") OplogExample example);

    int updateByPrimaryKeySelective(Oplog record);

    int updateByPrimaryKey(Oplog record);
}