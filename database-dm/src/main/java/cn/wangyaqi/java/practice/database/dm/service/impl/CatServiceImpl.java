package cn.wangyaqi.java.practice.database.dm.service.impl;

import cn.wangyaqi.java.practice.database.dm.entity.Cat;
import cn.wangyaqi.java.practice.database.dm.mapper.CatMapper;
import cn.wangyaqi.java.practice.database.dm.service.CatService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangyaqi
 * @since 2021-04-22
 */
@Service
public class CatServiceImpl extends ServiceImpl<CatMapper, Cat> implements CatService {

  @Resource
  private CatMapper mapper;

  public IPage<Cat> selectPage(IPage<Cat> page, LambdaQueryWrapper<Cat> wrappers) {
    return mapper.selectPage(page, wrappers);
  }
}
