package com.mysoft.lps_healthy_server.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mysoft.lps_healthy_server.domain.entity.ReportRecord;
import com.mysoft.lps_healthy_server.domain.mydo.DoReportRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReportRecordMapper extends BaseMapper<ReportRecord> {

    int insertReportRecord(@Param("reportRecord") DoReportRecord reportRecord);

    List<ReportRecord> selectAllReportRecordByPatId(@Param("patientId") Long patientId);

}
