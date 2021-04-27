package cn.wangyaqi.java.practice.database.entity;

import cn.wangyaqi.java.practice.database.base.DateUtil;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
public class Cat implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(type = IdType.AUTO)
  private Integer id;

  /**
   * 租户编号
   */
  private Long tenantId;

  /**
   * 用户编号
   */
  private Integer userId;

  /**
   * 姓名
   */
  private String name;

  /**
   * 创建时间
   */
  @JsonFormat(pattern = DateUtil.DateTimeFormat)
  @TableField(fill = FieldFill.INSERT)
  private LocalDateTime createTime;

  /**
   * 最后修改时间
   */
  @JsonFormat(pattern = DateUtil.DateTimeFormat)
  @TableField(fill = FieldFill.INSERT_UPDATE, update = "now()")
  private LocalDateTime updateTime;

  /**
   * 逻辑删除(未删除0,删除1)
   */
  @TableLogic(value = "0" , delval = "1")
  @TableField(fill = FieldFill.INSERT)
  private Boolean deleted;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Long getTenantId() {
    return tenantId;
  }

  public void setTenantId(Long tenantId) {
    this.tenantId = tenantId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
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
