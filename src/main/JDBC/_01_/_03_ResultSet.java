package _01_;

import Bean.student;
import Utils.JDBCUtils;

import java.sql.*;

public class _03_ResultSet {

    public static Connection connection;
    public static Statement st;
    public static ResultSet rs;


    public static void main(String[] args) throws SQLException {

        connection = JDBCUtils.getConnection();

        String sql = "select * from 20_student";
        st = connection.createStatement();
        rs = st.executeQuery(sql);



        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String gender = rs.getString(3);
            int dept_id = rs.getInt(4);

//            System.out.println(new student(id,name,gender,dept_id));

        }
        JDBCUtils.close(connection,st,rs);
    }

}

