package com.mysoft.lps_healthy_server.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mysoft.lps_healthy_server.domain.entity.OrderRecord;
import com.mysoft.lps_healthy_server.domain.mydo.DoOrderRecord;
import com.mysoft.lps_healthy_server.domain.response.OrderRecordPatResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface OrderRecordMapper extends BaseMapper<OrderRecord> {

    int insertOrderRecord(@Param("orderRecord") DoOrderRecord orderRecord);

    List<OrderRecord> selectOrderRecordByPatId(@Param("patientId") Long patientId);

    OrderRecord selectOrderByPatIdAndOrderTimeAndDocId(@Param("patientId") Long patientId,
                                                       @Param("orderTime")LocalDate date,
                                                       @Param("surplusNum") Integer surplusNum,
                                                       @Param("docId")Long docId);


    OrderRecordPatResponse getOrderInfo(@Param("patId") Long patId);

    List<OrderRecord> selectOrderRecordByDocId(@Param("docId") Long docId);
}
