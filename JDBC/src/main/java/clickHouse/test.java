package clickHouse;

import Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {

        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "select * from ods_trd_shopmall_exposure_product_hdfs limit ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,10);
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()){
                String id = resultSet.getString(1);
                String dataid = resultSet.getString(2);
                String dataname = resultSet.getString(3);
                System.out.println(" id="+id + " dataid="+dataid+" dataname="+dataname);
            }
            JDBCUtils.close(connection,pst,resultSet);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
