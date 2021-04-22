package cn.wangyaqi.java.practice.database.service.impl;

import cn.wangyaqi.java.practice.database.entity.User;
import cn.wangyaqi.java.practice.database.mapper.UserMapper;
import cn.wangyaqi.java.practice.database.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangyaqi
 * @since 2021-04-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
