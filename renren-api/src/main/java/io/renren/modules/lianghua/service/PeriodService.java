package io.renren.modules.lianghua.service;

import io.renren.common.service.CrudService;
import io.renren.modules.lianghua.dto.PeriodDTO;
import io.renren.modules.lianghua.entity.PeriodEntity;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-03-21
 */
public interface PeriodService extends CrudService<PeriodEntity, PeriodDTO> {

    void insertLongtou(Map<String, String> params);
    void deleteAll();
    List<PeriodEntity> queryAll(String account);
    PeriodEntity queryPeriodByAccount(String account);
    void deleteByAccount(String account);

}