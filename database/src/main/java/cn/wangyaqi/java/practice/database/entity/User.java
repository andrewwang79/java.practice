package cn.wangyaqi.java.practice.database.entity;

import cn.wangyaqi.java.practice.database.base.DateUtil;
import com.baomidou.mybatisplus.annotation.*;
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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话
     */
    private String phone;

    @JsonFormat(pattern = DateUtil.DateTimeFormat)
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    @JsonFormat(pattern = DateUtil.DateTimeFormat)
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE, update = "now()")
    /**
     * 最后修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删除(未删除0,删除1)
     */
    @TableLogic(value = "0", delval = "1")
    @TableField(fill = FieldFill.INSERT)
    private Boolean deleted;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", password=" + password +
                ", phone=" + phone +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
