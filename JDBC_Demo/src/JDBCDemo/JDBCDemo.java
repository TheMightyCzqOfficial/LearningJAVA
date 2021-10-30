package JDBCDemo;

import JDBCUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args)throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= JDBCUtils.getConnection();
        String sql="select * from account";
        String update="update account set money=money+1 where sname='黄显0'";
        Statement stmt=conn.createStatement();
        stmt.executeUpdate(update);
        ResultSet set = stmt.executeQuery(sql);
        while(set.next()){
            String sname = set.getString(1);
            int i = set.getInt(2);
            int i1 = set.getInt(3);
            System.out.println(sname+","+i+","+i1);
        }



        System.out.println(set);
        conn.close();
        stmt.close();
    }
}
