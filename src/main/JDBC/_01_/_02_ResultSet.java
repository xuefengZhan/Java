package _01_;

import java.sql.*;

public class _02_ResultSet {
    public static String url;
    public static String user;
    public static String password;
    public static Connection connection;
    public static Statement st;
    public static ResultSet rs;
    static{

        try {
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://hadoop102:3306/sdc";
            user = "root";
            password = "123456";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static class stu{
        private int id;
        private String name;
        private int age;
        private String gender;
        private String create_time;

        public stu(int id, String name, int age, String gender, String create_time) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.create_time = create_time;
        }

        @Override
        public String toString() {
            return "Bean.student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    ", create_time='" + create_time + '\'' +
                    '}';
        }
    public static void main(String[] args) throws SQLException {

        connection = DriverManager.getConnection(url, user, password);
        String sql = "select * from hh";
        st = connection.createStatement();
        rs = st.executeQuery(sql);



        while(rs.next()){

            int id = rs.getInt(1);
            String name = rs.getString(2);
            int age = rs.getInt(3);
            String gender = rs.getString(4);
            String create_time = rs.getString(5);
            System.out.println(new stu(id,name,age,gender,create_time));

        }
    }

}

}