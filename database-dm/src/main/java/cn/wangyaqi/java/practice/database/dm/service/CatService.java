package cn.wangyaqi.java.practice.database.dm.service;

import cn.wangyaqi.java.practice.database.dm.entity.Cat;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangyaqi
 * @since 2021-04-22
 */
public interface CatService extends IService<Cat> {

  IPage<Cat> selectPage(IPage<Cat> page, LambdaQueryWrapper<Cat> wrappers);
}
