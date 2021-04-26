package cn.wangyaqi.java.practice.database.base;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import java.time.LocalDateTime;
import org.apache.ibatis.reflection.MetaObject;

public class ThMetaObjectHandler implements MetaObjectHandler {

  @Override
  public void insertFill(MetaObject metaObject) {
    this.strictInsertFill(metaObject, "createTime" , LocalDateTime.class, LocalDateTime.now());
    this.strictInsertFill(metaObject, "updateTime" , LocalDateTime.class, LocalDateTime.now());
    this.strictInsertFill(metaObject, "deleted" , Integer.class, 0);
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    this.strictUpdateFill(metaObject, "updateTime" , LocalDateTime.class, LocalDateTime.now());
  }
}
