package org.jiang.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jiang.model.Msgcontent;
import org.jiang.model.MsgcontentExample;

public interface MsgcontentMapper {
    long countByExample(MsgcontentExample example);

    int deleteByExample(MsgcontentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Msgcontent record);

    int insertSelective(Msgcontent record);

    List<Msgcontent> selectByExample(MsgcontentExample example);

    Msgcontent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Msgcontent record, @Param("example") MsgcontentExample example);

    int updateByExample(@Param("record") Msgcontent record, @Param("example") MsgcontentExample example);

    int updateByPrimaryKeySelective(Msgcontent record);

    int updateByPrimaryKey(Msgcontent record);
}