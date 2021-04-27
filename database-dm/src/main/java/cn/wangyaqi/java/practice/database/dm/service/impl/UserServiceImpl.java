package cn.wangyaqi.java.practice.database.dm.service.impl;

import cn.wangyaqi.java.practice.database.dm.entity.User;
import cn.wangyaqi.java.practice.database.dm.mapper.UserMapper;
import cn.wangyaqi.java.practice.database.dm.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
  private UserMapper userMapper;

  public List<User> findAllt() {
    return userMapper.findAllt();
  }

  public List<User> findAllByName(String name) {
    return lambdaQuery().eq(User::getName, name).list();
  }

  public List<User> findAllByName_mapper(String name) {
    return userMapper.findAllByName(name);
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
}
