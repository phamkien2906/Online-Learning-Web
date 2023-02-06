/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class UserDAO extends DBContext {

    public boolean checkUser(String s) {
        String sql = "SELECT  [user_name]\n"
                + "  FROM [SWP-Project].[dbo].[User]\n"
                + "  where [user_name]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s);
            ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return false;
            }
        } catch (SQLException e) {
        }
        return true;
    }

    public void addUser(String user, String pass) {
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ([user_name]\n"
                + "           ,[user_password])\n"
                + "     VALUES(?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            st.executeUpdate();
        } catch (SQLException e) {
            
        }
    }
    

}
