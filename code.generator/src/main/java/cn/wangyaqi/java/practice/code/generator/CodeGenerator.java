package cn.wangyaqi.java.practice.code.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.text.SimpleDateFormat;
import java.util.*;

public class CodeGenerator {
    public static String ModuleName ="database"; // 模块目录

    public static String PackageParent = "cn.wangyaqi.java.practice";
    public static String Author ="wangyaqi";

    public static String DbUrl="jdbc:mysql://47.99.132.168:18009/practice?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&useSSL=false";
    public static String DbDriverName="com.mysql.cj.jdbc.Driver";
    public static String DbUsername="root";
    public static String DbPassword="jjjHsGTbqJc5C123";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (!StringUtils.isBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpcg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(String.format("%s/%s/%s", projectPath, ModuleName, "/src/main/java"));
        gc.setAuthor(Author);
        gc.setOpen(false);
        // 设置名字
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        // 设置其他
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setFileOverride(true);
        gc.setSwagger2(false);
        gc.setEnableCache(false);
        gc.setIdType(IdType.AUTO);
        mpcg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DbUrl);
        dsc.setDriverName(DbDriverName);
        dsc.setUsername(DbUsername);
        dsc.setPassword(DbPassword);
        mpcg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(PackageParent);
        // pc.setModuleName(scanner("模块名"));
        pc.setModuleName(ModuleName);
        pc.setController("controller");
        pc.setService("service");
        pc.setMapper("mapper");
        pc.setEntity("entity");
        mpcg.setPackageInfo(pc);

        // 自定义属性注入配置
        InjectionConfig ic = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                this.setMap(map);
            }
        };
        // 自定义输出配置，优先输出
        List<FileOutConfig> focList = new ArrayList<>();
        // 模板引擎是velocity
        // 原有mapper多了一层目录xml，必须自定义输出文件名
        focList.add(new FileOutConfig() {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件路径，如果Entity设置了前后缀，文件名会跟着发生变化
                return String.format("%s/%s/%s/%sMapper%s", projectPath, pc.getModuleName(), "/src/main/resources/mapper/", tableInfo.getEntityName(), StringPool.DOT_XML);
            }
        });
        ic.setFileOutConfigList(focList);
        mpcg.setCfg(ic);

        // 模板配置
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        templateConfig.setController("templates/controller.java.vm");
        mpcg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(false);
        strategy.setRestControllerStyle(true);
        // 写于父类中的公共字段
        // strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        // strategy.setTablePrefix(pc.getModuleName() + "_");
        mpcg.setStrategy(strategy);
        mpcg.execute();
    }
}