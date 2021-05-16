package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //todo 1.准备连接相关信息
           Class.forName("com.mysql.jdbc.Driver");//todo 1.加载驱动类并注册驱动
            String url = "jdbc:mysql://hadoop102:3306/sdc";
            String user = "root";
            String password = "123456";

            //todo 2.创建连接
            Connection conn = DriverManager.getConnection(
                    url,user,password
            );

            //todo 3.创建statement对象
        Statement st = conn.createStatement();

        //todo 4.int excuteUpdate(String sql)  增删改操作，返回值是影响的记录数
        //todo 5. ResultSet excuteQuery(String sql)：执行查询操作SELECT  返回结果集对象
        String sql = "INSERT INTO zxf01 VALUES(6,'xiaoqiao',22,NOW());";

        int len = st.executeUpdate(sql);

        if(len>0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }

        st.close();
        conn.close();



    }
}
