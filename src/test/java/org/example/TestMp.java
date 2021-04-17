package org.example;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMp {
//    private ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testGenerator(){
        //1.全局配置
        GlobalConfig globalConfig=new GlobalConfig();
        //是否支持AR，是的话，实体类就会自动继承Model
        globalConfig.setActiveRecord(false)
                //作者
                .setAuthor("zhengbingyuan")
                //输出路径
                .setOutputDir("E:\\eclipse-workspace\\mavenmpdemo03\\src\\main\\java")
                //同名文件覆盖
                .setFileOverride(true)
                //主键策略
                .setIdType(IdType.AUTO)
                //设置生成的service接口的名字的首字母是否为i
                .setServiceName("%sService")
                //是否自动生成ResultMap
                .setBaseResultMap(true)
                //生成一个sql片段
                .setBaseColumnList(true);
        //2.数据源配置
        DataSourceConfig dataSourceConfig=new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/mp")
                .setUsername("root")
                .setPassword("123456");
        //3.策略配置
        StrategyConfig strategyConfig=new StrategyConfig();
        strategyConfig.setDbColumnUnderline(true)  //设置表名和字段名是否使用下划线
                .setCapitalMode(true) //全局大写命名
                .setNaming(NamingStrategy.underline_to_camel) //数据库表映射到实体的命名进行下划线转驼峰
                .setTablePrefix("tbl_")//找实体类对应的表时前缀
                .setInclude("tbl_employee");

        //4.包配置
        PackageConfig packageConfig=new PackageConfig();
        packageConfig.setParent("org.example")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("beans")
                .setXml("mapper");

        //5.整合配置
        AutoGenerator autoGenerator=new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);

        autoGenerator.execute();

    }

}
