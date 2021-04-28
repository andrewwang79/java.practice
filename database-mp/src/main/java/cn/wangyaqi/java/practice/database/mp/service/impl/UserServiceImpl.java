package cn.wangyaqi.java.practice.database.mp.service.impl;

import cn.wangyaqi.java.practice.database.mp.entity.User;
import cn.wangyaqi.java.practice.database.mp.mapper.UserMapper;
import cn.wangyaqi.java.practice.database.mp.service.UserService;
import cn.wangyaqi.java.practice.database.mp.vo.CatDetail;
import cn.wangyaqi.java.practice.database.mp.vo.UserBrief;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.time.LocalDateTime;
import java.util.List;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

  @Resource
  private UserMapper mapper;

  public List<User> findAllByName(String name) {
    return lambdaQuery().eq(User::getName, name).list();
  }

  public List<User> findAllByName_mapper(String name) {
    return mapper.findAllByName(name);
  }

  public List<CatDetail> findCatDetailList(String userName) {
    return mapper.findCatDetailList(userName);
  }

  public boolean updatePhoneByName(String phone, String name) {
    return update(new User(), Wrappers.<User>lambdaUpdate().eq(User::getName, name).set(User::getPhone, phone));
  }

  public boolean updatePhoneById(Integer id, String phone) {
    User user = getById(id);
    user.setPhone(phone);
    return updateById(user);
  }

  public boolean deleteByName(String name) {
    return remove(Wrappers.<User>lambdaQuery().eq(User::getName, name));
  }

  public IPage<User> selectPage(IPage<User> page, LambdaQueryWrapper<User> wrappers) {
    return mapper.selectPage(page, wrappers);
  }

  public IPage<UserBrief> selectUserBriefPage(IPage<UserBrief> page, String name) {
    return mapper.selectUserBriefPage(page, name);
  }

  public IPage<CatDetail> selectCatDetailPage(Page<CatDetail> page, String name) {
    page.addOrder(OrderItem.desc("create_time"));
    QueryWrapper<CatDetail> wrapper = new QueryWrapper<>();
    wrapper.eq("u.name" , name);

    return mapper.selectCatDetailPage(page, wrapper);
  }

  public IPage<CatDetail> selectCatDetailPageSql(IPage<CatDetail> page, String userName, LocalDateTime createTime) {
    return mapper.selectCatDetailPageSql(page, userName, createTime);
  }
}
