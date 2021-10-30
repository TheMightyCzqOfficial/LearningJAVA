package JDBCUtils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String password;
    private static String user;
    private static  String url;
    private static  String driver;
    static {
        Properties pro=new Properties();

        try {
            ClassLoader classLoader=JDBCUtils.class.getClassLoader();//加载类获取对应配置文件的路径
            URL resource = classLoader.getResource("jdbc.properties");
            String path = URLDecoder.decode(resource.getPath(),"utf-8");//空格字符的处理
            System.out.println("--------");
            System.out.println(path);
            pro.load(new FileReader(path));
             url = pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void close(ResultSet rs,Statement stmt, Connection conn){//释放资源
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Statement stmt,Connection conn){//释放资源
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static Connection getConnection()throws Exception{
        return DriverManager.getConnection(url,user,password);
    }
}
