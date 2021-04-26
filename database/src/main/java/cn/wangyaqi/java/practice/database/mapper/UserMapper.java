package cn.wangyaqi.java.practice.database.mapper;

import cn.wangyaqi.java.practice.database.entity.User;
import cn.wangyaqi.java.practice.database.vo.CatDetail;
import cn.wangyaqi.java.practice.database.vo.UserBrief;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

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

  @Select("SELECT cat.*, user.name AS userName FROM user, cat WHERE user.id=cat.user_id AND user.name=#{userName}")
  List<CatDetail> findCatDetailList(String userName);

  IPage<UserBrief> selectUserBriefPage(IPage<UserBrief> page, String name);

  @Select("SELECT cat.*, user.name AS userName FROM user LEFT JOIN cat on user.id=cat.user_id ${ew.customSqlSegment}")
  IPage<CatDetail> selectCatDetailPage(IPage<CatDetail> page, @Param(Constants.WRAPPER) QueryWrapper<CatDetail> wrapper);

  IPage<CatDetail> selectCatDetailPageSql(IPage<CatDetail> page, @Param("userName") String userName, @Param("createTime") LocalDateTime createTime);
}
