package cn.wangyaqi.java.practice.database.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.wangyaqi.java.practice.database.entity.User;
import cn.wangyaqi.java.practice.database.service.UserService;
import cn.wangyaqi.java.practice.database.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService{

}