package cn.wangyaqi.java.practice.database.base;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;

public class ThTenantLineHandler implements TenantLineHandler {

  /**
   * 获取租户 ID 值表达式，只支持单个 ID 值
   * <p>
   *
   * @return 租户 ID 值表达式
   */
  @Override
  public Expression getTenantId() {
    // TODO 通过过滤器从请求中获取对应租户
    return new LongValue(1);
  }

  /**
   * 根据表名判断是否忽略拼接多租户条件
   * <p>
   * 默认都要进行解析并拼接多租户条件
   *
   * @param tableName 表名
   * @return 是否忽略, true:表示忽略，false:需要解析并拼接多租户条件
   */
  @Override
  public boolean ignoreTable(String tableName) {
    return false;
//    return !"user".equalsIgnoreCase(tableName);
  }
}
