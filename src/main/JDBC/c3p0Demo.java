import Bean.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class c3p0Demo {

    public static Connection connection;
    public static PreparedStatement pst;
    public static ResultSet rs;


    public static void main(String[] args) throws SQLException {

        connection = c3p0Utils.getConnection();

        String sql = "SELECT * FROM 20_student";
        pst = connection.prepareStatement(sql);
        //pst.setString(1,"student_name");
        //pst.setInt(1,1);
        rs = pst.executeQuery(sql);

        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String gender = rs.getString(3);
            int dept_id = rs.getInt(4);

            System.out.println(new student(id,name,gender,dept_id));

        }
        c3p0Utils.release(connection,pst,rs);
    }

}
