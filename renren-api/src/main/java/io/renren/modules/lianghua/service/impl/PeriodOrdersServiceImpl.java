package io.renren.modules.lianghua.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.lianghua.dao.PeriodOrdersDao;
import io.renren.modules.lianghua.dto.PeriodOrdersDTO;
import io.renren.modules.lianghua.entity.PeriodOrdersEntity;
import io.renren.modules.lianghua.service.PeriodOrdersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-04-01
 */
@Service
public class PeriodOrdersServiceImpl extends CrudServiceImpl<PeriodOrdersDao, PeriodOrdersEntity, PeriodOrdersDTO> implements PeriodOrdersService {

    @Override
    public QueryWrapper<PeriodOrdersEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PeriodOrdersEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

    @Override
    public PeriodOrdersEntity queryByInstId(Map<String, String> params) {
        PeriodOrdersEntity result= baseDao.queryByInstId(params);
        return result;
    }
    @Override
    public void deleteAll() {
        baseDao.deletePeriodTemp();
    }
    @Override
    public void deleteByAccount(String account){
        baseDao.deleteByAccount(account);
    }
}