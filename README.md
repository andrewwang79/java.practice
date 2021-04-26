# Java最佳实践

# 目录说明

| 目录 | 说明 |
| :-: | - |
| misc | 杂项集合 |
| database | 数据库连接，多租户 |
| autotest | 自动化测试：接口单元测试，接口集成测试 |

# misc
## Actuator
* https://www.liaoxuefeng.com/wiki/1252599548343744/1282386381766689

## Swagger
* https://juejin.cn/post/6844903991793418248
* http://localhost:8080/swagger-ui/index.html

# database
## JPA
### 资料
* domainentity, dao, service, controller
* https://cloud.tencent.com/developer/article/1685970

## MyBatis
### 资料
* domain, mapper, service, controller
* [官网](https://mp.baomidou.com/guide/quick-start.html), [所有注解](https://mp.baomidou.com/guide/annotation.html#tablename)
* [MyBatis与MyBatis-plus的区别](https://www.jianshu.com/p/8556c8468241)
* [使用示例](https://www.cnblogs.com/l-y-h/p/12859477.html)
* [官方示例](https://gitee.com/baomidou/mybatis-plus-samples)

### 注意事项
* 多租户的联表查询：每个表要有租户编号，sql里每个表都要给别名

### 代码生成文件
* [自定义代码生成器【推荐】](https://gitee.com/qiya365/longquan/code.generator) : 参数详见jar包里的示例，[资料1](https://mp.baomidou.com/guide/generator.html), [资料2](https://juejin.cn/post/6844904190683119629)
* [插件代码生成器](https://mp.baomidou.com/guide/mybatisx-idea-plugin.html) ，生成代码
![](./s/codegenerator.png)

### 代码生成SQL函数
* https://mp.baomidou.com/guide/mybatisx-idea-plugin.html，生成查询等

### 代码写法
```
尽量都在service写，不要写mapper，join的没办法

# entity
## 创建时间和更新时间
updateById()更新时间自动修改：@TableField(update = "now()")
## 逻辑删除
```