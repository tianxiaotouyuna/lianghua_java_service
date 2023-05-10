package io.renren.modules.lianghua.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.lianghua.entity.PeriodEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-03-21
 */
@Mapper
public interface PeriodDao extends BaseDao<PeriodEntity> {
    //清空指定表
    @Update("truncate table period")
    void deletePeriodTemp();
    List<PeriodEntity> queryAll(String account);
    void insertLongtou(Map<String, String> params);
    PeriodEntity queryPeriodByAccount(String account);
    void deleteByAccount(String account);
}