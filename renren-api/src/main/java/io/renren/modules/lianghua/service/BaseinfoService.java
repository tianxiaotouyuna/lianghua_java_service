package io.renren.modules.lianghua.service;

import io.renren.common.service.CrudService;
import io.renren.modules.lianghua.dto.BaseinfoDTO;
import io.renren.modules.lianghua.entity.BaseinfoEntity;

import java.util.List;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-03-21
 */
public interface BaseinfoService extends CrudService<BaseinfoEntity, BaseinfoDTO> {
    /**
     * 查询上次的InsetId
     */
    List<BaseinfoEntity> queryAll(String account);
    void deleteByAccount(String account);
}