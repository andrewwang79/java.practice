package cn.wangyaqi.java.practice.database.mp.vo;

import cn.wangyaqi.java.practice.database.mp.base.DateUtil;
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
public class CatDetail implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  /**
   * 用户名称
   */
  private String userName;

  /**
   * 姓名
   */
  private String name;

  @JsonFormat(pattern = DateUtil.DateTimeFormat)
  /**
   * 创建时间
   */
  private LocalDateTime createTime;

  @JsonFormat(pattern = DateUtil.DateTimeFormat)
  /**
   * 最后修改时间
   */
  private LocalDateTime updateTime;

  /**
   * 逻辑删除(未删除0,删除1)
   */
  private Boolean deleted;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
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

  public LocalDateTime getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(LocalDateTime updateTime) {
    this.updateTime = updateTime;
  }

  public Boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }
}
