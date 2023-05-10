package io.renren.modules.lianghua.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.lianghua.dao.BaseinfoDao;
import io.renren.modules.lianghua.dto.BaseinfoDTO;
import io.renren.modules.lianghua.entity.BaseinfoEntity;
import io.renren.modules.lianghua.service.BaseinfoService;
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
public class BaseinfoServiceImpl extends CrudServiceImpl<BaseinfoDao, BaseinfoEntity, BaseinfoDTO> implements BaseinfoService {

    @Override
    public QueryWrapper<BaseinfoEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<BaseinfoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

    @Override
    public List<BaseinfoEntity> queryAll(String account) {
        List<BaseinfoEntity> result= baseDao.queryAll(account);
        return result;
    }
    @Override
    public void deleteByAccount(String account){
        baseDao.deleteByAccount(account);
    }
}