

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class _01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

            //todo 1.准备连接相关信息
            // 加载驱动类并注册驱动
             Class.forName("com.mysql.jdbc.Driver");
            //此方法返回Class对象，使用java.lang.reflect包的方法对类进行反射调用 会导致这个类被初始化
            // 而com.mysql.jdbc.Driver中有静态代码块，会注册驱动
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
