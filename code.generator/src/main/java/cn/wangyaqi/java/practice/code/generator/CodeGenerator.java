package cn.wangyaqi.java.practice.code.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Scanner;

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
        AutoGenerator ag = new AutoGenerator();

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
        // 设置 resultMap
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setFileOverride(true);
        gc.setSwagger2(false);
        gc.setEnableCache(true);
        gc.setIdType(IdType.AUTO);
        ag.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DbUrl);
        dsc.setDriverName(DbDriverName);
        dsc.setUsername(DbUsername);
        dsc.setPassword(DbPassword);
        ag.setDataSource(dsc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(PackageParent);
        // pc.setModuleName(scanner("模块名"));
        pc.setModuleName(ModuleName);
        pc.setController("controller");
        pc.setService("service");
        pc.setMapper("mapper");
        pc.setEntity("entity");
        ag.setPackageInfo(pc);

//        // 如果模板引擎是 velocity
//        String templatePath = "/templates/mapper.xml.vm";
//
//        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return String.format("%s/%s/%s/%sMapper%s", projectPath, pc.getModuleName(), "/src/main/resources/mapper/", tableInfo.getEntityName(), StringPool.DOT_XML);
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setXml(null);
        ag.setTemplate(templateConfig);

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
        ag.setStrategy(strategy);
        ag.execute();
    }
}