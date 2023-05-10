package io.renren.modules.lianghua.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.lianghua.entity.PeriodOrdersEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-04-01
 */
@Mapper
public interface PeriodOrdersDao extends BaseDao<PeriodOrdersEntity> {
    @Update("truncate table period_order")
    void deletePeriodTemp();
    PeriodOrdersEntity queryByInstId(Map<String, String> params);

    void insertPlaced(Map<String, String> params);
    void deleteByAccount(String account);
}