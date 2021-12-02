import Bean.student;
import Utils.JDBCUtils;

import java.sql.*;

public class _04_ResultSet {

    public static Connection connection;
    public static PreparedStatement pst;
    public static ResultSet rs;


    public static void main(String[] args) throws SQLException {

        connection = JDBCUtils.getConnection();

        String sql = "SELECT ? FROM zxf01 WHERE age = ?";
        pst = connection.prepareStatement(sql);
        pst.setString(1,"name");
        pst.setInt(1,10);
        rs = pst.executeQuery(sql);

        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int age = rs.getInt(3);
            int gender = rs.getInt(4);
            String movie = rs.getString(5);
            Time create_time = rs.getTime(6);
            System.out.println(new student(id,name,age,gender,movie,create_time));

        }

        JDBCUtils.close(connection,pst,rs);
    }

}
