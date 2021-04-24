package cn.wangyaqi.java.practice.database.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.*;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import cn.wangyaqi.java.practice.database.entity.User;
import cn.wangyaqi.java.practice.database.vo.UserBrief;
import cn.wangyaqi.java.practice.database.vo.CatDetail;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangyaqi
 * @since 2021-04-22
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> findAllByName(@Param("name") String name);

    IPage<UserBrief> selectUserBriefPage(IPage<UserBrief> page, String name);

    @Select("SELECT cat.*, user.name AS userName FROM user, cat WHERE user.id=cat.user_id ${ew.customSqlSegment}")
    IPage<CateDetail> selectCatDetailPage(IPage<CateDetail> page, LambdaQueryWrapper<User> wrappers);

    IPage<CateDetail> getCatDetail(String name);

    IPage<CateDetail> selectCatDetailPage(IPage<CateDetail> page, LocalDateTime createTime);
}
