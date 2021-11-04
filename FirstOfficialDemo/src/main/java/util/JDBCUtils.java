package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;
    static  {
        Properties pro=new Properties();
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");//获取druid配置文件
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ds = DruidDataSourceFactory.createDataSource(pro);//创建datasource对象
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDatasource(){

        return ds;
    }
    public static Connection getConnection() throws SQLException {

        return ds.getConnection();
    }
}
