package com.panda.SpringJspWeb.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.jdbc.ShardingDataSource;
import com.panda.SpringJspWeb.properties.MysqlProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Configuration
public class DataSourceConfig {

    private static final Log logger = LogFactory.getLog(DataSourceConfig.class);

    @Autowired
    private MysqlProperties mysql;

    @Bean
    public DataSource getDataSource(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(mysql.getUrl());
        datasource.setUsername(mysql.getUsername());
        datasource.setPassword(mysql.getPassword());
        datasource.setDriverClassName(mysql.getDriverClassName());

        /** configuration */
        datasource.setInitialSize(mysql.getInitialSize());
        datasource.setMinIdle(mysql.getMinIdle());
        datasource.setMaxActive(mysql.getMaxActive());
        datasource.setMaxWait(mysql.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(mysql.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(mysql.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(mysql.getValidationQuery());
        datasource.setTestWhileIdle(mysql.isTestWhileIdle());
        datasource.setTestOnBorrow(mysql.isTestOnBorrow());
        datasource.setTestOnReturn(mysql.isTestOnReturn());
        datasource.setPoolPreparedStatements(mysql.getPoolPreparedStatements());
        datasource.setMaxPoolPreparedStatementPerConnectionSize(mysql.getMaxPoolPreparedStatementPerConnectionSize());
        try
        {
            datasource.setFilters(mysql.getFilters());
        }
        catch (SQLException e)
        {
            logger.error("druid configuration initialization filter", e);
        }
        datasource.setConnectionProperties(mysql.getConnectionProperties());
        return datasource;
    }
}
