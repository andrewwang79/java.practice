package cn.wangyaqi.java.practice.database.dm.vo;

import cn.wangyaqi.java.practice.database.dm.base.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author wangyaqi
 * @since 2021-04-22
 */
public class UserBrief implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  /**
   * 姓名
   */
  private String name;

  /**
   * 创建时间
   */
  @JsonFormat(pattern = DateUtil.DateTimeFormat)
  private LocalDateTime createTime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }
}
