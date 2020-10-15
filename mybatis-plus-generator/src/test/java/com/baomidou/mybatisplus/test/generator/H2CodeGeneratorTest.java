package com.baomidou.mybatisplus.test.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.h2.Driver;
import org.junit.jupiter.api.Test;

/**
 * H2代码生成
 *
 * @author nieqiuqiu
 */
class H2CodeGeneratorTest {

    private static final String outPutDir = System.getProperty("os.name").toLowerCase().contains("windows") ? "D://tmp" : "/tmp";

    private DataSourceConfig dataSourceConfig() {
        String dbUrl = "jdbc:h2:mem:test;MODE=mysql;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE";
        return new DataSourceConfig.Builder(dbUrl,"sa","").driver(Driver.class).build();
    }

    private StrategyConfig strategyConfig() {
        return new StrategyConfig.Builder().enableSqlFilter(true).capitalMode(true).entityBuilder().lombok(false).naming(NamingStrategy.underline_to_camel).build();
    }

    private GlobalConfig globalConfig() {
        return new GlobalConfig.Builder().activeRecord(false).idType(IdType.ASSIGN_ID).author("test").outputDir(outPutDir).openDir(true).fileOverride(true).build();
    }

    @Test
    void testLike() {
        new AutoGenerator(dataSourceConfig())
            .global(globalConfig())
            .strategy(strategyConfig().setLikeTable(new LikeTable("USERS")))
            .execute();
    }

    @Test
    void testNotLike() {
        new AutoGenerator(dataSourceConfig())
            .global(globalConfig())
            .strategy(strategyConfig().setNotLikeTable(new LikeTable("USERS")))
            .execute();
    }

    @Test
    void testInclude() {
        new AutoGenerator(dataSourceConfig())
            .global(globalConfig())
            .strategy(strategyConfig().setInclude("USERS"))
            .execute();
    }

    @Test
    void testExclude() {
        new AutoGenerator(dataSourceConfig())
            .global(globalConfig())
            .strategy(strategyConfig().setExclude("USERS"))
            .execute();
    }

    @Test
    void testLikeAndInclude(){
        new AutoGenerator(dataSourceConfig())
            .global(globalConfig())
            .strategy(strategyConfig().setLikeTable(new LikeTable("TABLE")).setInclude("TABLE_PRIVILEGES","TABLE_TYPES"))
            .execute();
    }

    @Test
    void testLikeAndExclude(){
        new AutoGenerator(dataSourceConfig())
            .global(globalConfig())
            .strategy(strategyConfig().setLikeTable(new LikeTable("TABLE")).setExclude("TABLE_PRIVILEGES","TABLE_TYPES"))
            .execute();
    }

    @Test
    void testNotLikeAndInclude(){
        new AutoGenerator(dataSourceConfig())
            .global(globalConfig())
            .strategy(strategyConfig().setNotLikeTable(new LikeTable("TABLE")).setInclude("USERS"))
            .execute();
    }

    @Test
    void testNotLikeAndExclude(){
        new AutoGenerator(dataSourceConfig())
            .global(globalConfig())
            .strategy(strategyConfig().setNotLikeTable(new LikeTable("TABLE")).setExclude("USERS"))
            .execute();
    }
}
