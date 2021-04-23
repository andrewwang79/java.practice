package cn.wangyaqi.java.practice.database.service;

import cn.wangyaqi.java.practice.database.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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

    boolean updatePhoneByName(String phone, String name);

    boolean updatePhoneById(Integer id, String phone);

    boolean deleteByName(String name);
}
