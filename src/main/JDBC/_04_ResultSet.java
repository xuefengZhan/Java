import Bean.student;

import java.sql.*;

public class _04_ResultSet {

    public static Connection connection;
    public static PreparedStatement pst;
    public static ResultSet rs;


    public static void main(String[] args) throws SQLException {

        connection = main.JDBC.JDBCUtils.getConnection();

        String sql = "SELECT * FROM 20_student WHERE dept_id= ?";
        pst = connection.prepareStatement(sql);
        //pst.setString(1,"student_name");
        pst.setInt(1,1);
        rs = pst.executeQuery(sql);

        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String gender = rs.getString(3);
            int dept_id = rs.getInt(4);

            System.out.println(new student(id,name,gender,dept_id));

        }
        main.JDBC.JDBCUtils.close(connection,pst,rs);
    }

}
