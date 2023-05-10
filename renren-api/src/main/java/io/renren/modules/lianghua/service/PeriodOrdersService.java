package io.renren.modules.lianghua.service;

import io.renren.common.service.CrudService;
import io.renren.modules.lianghua.dto.PeriodOrdersDTO;
import io.renren.modules.lianghua.entity.PeriodOrdersEntity;
import java.util.Map;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-04-01
 */
public interface PeriodOrdersService extends CrudService<PeriodOrdersEntity, PeriodOrdersDTO> {
    PeriodOrdersEntity queryByInstId(Map<String, String> params);
    void deleteAll();
    void deleteByAccount(String account);

}