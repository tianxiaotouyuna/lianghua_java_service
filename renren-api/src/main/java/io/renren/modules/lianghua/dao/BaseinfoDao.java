package io.renren.modules.lianghua.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.lianghua.entity.BaseinfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-03-21
 */
@Mapper
public interface BaseinfoDao extends BaseDao<BaseinfoEntity> {
    void deleteByAccount(String account);
    List<BaseinfoEntity> queryAll(String account);
}