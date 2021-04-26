package cn.wangyaqi.java.practice.database.service;

import cn.wangyaqi.java.practice.database.entity.User;
import cn.wangyaqi.java.practice.database.vo.CatDetail;
import cn.wangyaqi.java.practice.database.vo.UserBrief;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangyaqi
 * @since 2021-04-22
 */
public interface UserService extends IService<User> {

  List<User> findAllByName(String name);

  List<User> findAllByName_mapper(String name);

  List<CatDetail> findCatDetailList(String userName);

  boolean updatePhoneByName(String phone, String name);

  boolean updatePhoneById(Integer id, String phone);

  boolean deleteByName(String name);

  IPage<User> selectPage(IPage<User> page, LambdaQueryWrapper<User> wrappers);

  IPage<UserBrief> selectUserBriefPage(IPage<UserBrief> page, String name);

  IPage<CatDetail> selectCatDetailPage(Page<CatDetail> page, String name);

  IPage<CatDetail> selectCatDetailPageSql(IPage<CatDetail> page, String userName, LocalDateTime createTime);
}
