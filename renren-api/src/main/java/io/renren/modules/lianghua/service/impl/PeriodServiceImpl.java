package io.renren.modules.lianghua.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.lianghua.dao.PeriodDao;
import io.renren.modules.lianghua.dto.PeriodDTO;
import io.renren.modules.lianghua.entity.PeriodEntity;
import io.renren.modules.lianghua.service.PeriodService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-03-21
 */
@Service
public class PeriodServiceImpl extends CrudServiceImpl<PeriodDao, PeriodEntity, PeriodDTO> implements PeriodService {

    @Override
    public QueryWrapper<PeriodEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PeriodEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }
    @Override
    public void insertLongtou(Map<String, String> params) {
        baseDao.insertLongtou(params);
    }
    @Override
    public void deleteAll() {
        baseDao.deletePeriodTemp();
    }
    @Override
    public List<PeriodEntity> queryAll(String account) {
        List<PeriodEntity> result= baseDao.queryAll(account);
        return result;
    }
    @Override
    public PeriodEntity queryPeriodByAccount(String account) {
        PeriodEntity entity= baseDao.queryPeriodByAccount(account);
        return entity;
    }
    @Override
    public void deleteByAccount(String account){
        baseDao.deleteByAccount(account);
    }

}
