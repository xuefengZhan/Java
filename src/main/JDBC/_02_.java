

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class _02_ {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection connection = null;
        Statement statement = null;

        try {
            Properties properties = new Properties();
            InputStream resourceAsStream = _01.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(resourceAsStream);

            String driverName = properties.getProperty("drivername");
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String sql = "insert into zxf02 values(5,'胡卫',20,1,'汇文')";
            int i = statement.executeUpdate(sql);

            if(i>0){
                System.out.println("insert sucess");
            }else{
                System.out.println("insert failed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                connection.close();
            }
        }
    }
}
