package org.jiang.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jiang.model.MailSendLog;
import org.jiang.model.MailSendLogExample;

public interface MailSendLogMapper {
    long countByExample(MailSendLogExample example);

    int deleteByExample(MailSendLogExample example);

    int insert(MailSendLog record);

    int insertSelective(MailSendLog record);

    List<MailSendLog> selectByExample(MailSendLogExample example);

    int updateByExampleSelective(@Param("record") MailSendLog record, @Param("example") MailSendLogExample example);

    int updateByExample(@Param("record") MailSendLog record, @Param("example") MailSendLogExample example);
}