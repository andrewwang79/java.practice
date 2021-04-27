package cn.wangyaqi.java.practice.database.dm.mapper;

import cn.wangyaqi.java.practice.database.dm.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wangyaqi
 * @since 2021-04-22
 */
public interface UserMapper extends BaseMapper<User> {

  List<User> findAllByName(@Param("name") String name);

  List<User> findAllt();

}
