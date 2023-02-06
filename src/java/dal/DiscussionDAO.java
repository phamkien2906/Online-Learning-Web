/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.User;
import model.Discussion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DiscussionDAO extends DBContext {

    public List<Discussion> getDiscussion() {
        List<Discussion> list = new ArrayList<>();
        try {
            String sql = "Select * from [Discussion] as DI\n"
                    + "Join [User] as US on DI.[user_id] =US.User_Id\n"
                    + "where DI.discussion_reply=0";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Discussion(new User(rs.getInt(8), rs.getString(9),
                        rs.getString(11), rs.getInt(12)),
                        rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Discussion> getReplyDiscussion() {
        List<Discussion> list = new ArrayList<>();
        try {
            String sql = "Select * from [Discussion] as DI\n"
                    + "Join [User] as US on DI.[user_id] =US.User_Id\n"
                    + "where DI.discussion_reply >0 ";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Discussion(new User(rs.getInt(8), rs.getString(9),
                        rs.getString(11), rs.getInt(12)),
                        rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getString(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void rateDiscussion(int id) {
        String sql = "UPDATE [dbo].[Discussion]\n"
                + "   SET \n"
                + "      [discussion_like] +=1\n"
                + " WHERE [discussion_Id]= ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void replyDiscussion(int id, Discussion d) {
        String sql = "INSERT INTO [dbo].[Discussion]\n"
                + "           ([user_id]\n"
                + "           ,[discussion_detail]\n"
                + "           ,[discussion_date]\n"
                + "           ,[discussion_reply])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, d.getUser().getUser_id());
            st.setString(2, d.getDiscussion_detail());
            long millis = System.currentTimeMillis();
            Date date = new Date(millis);
            st.setDate(3, date);
            st.setInt(4, id);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void addDiscussion( Discussion d) {
        String sql = "INSERT INTO [dbo].[Discussion]\n"
                + "           ([user_id]\n"
                + "           ,[discussion_detail]\n"
                + "           ,[discussion_date]\n"
                + "           ,[discussion_image])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, d.getUser().getUser_id());
            st.setString(2, d.getDiscussion_detail());
            long millis = System.currentTimeMillis();
            Date date = new Date(millis);
            st.setDate(3, date);
            st.setString(4, d.getDiscussion_image());
            System.out.println(d.getUser().getUser_id());
            System.out.println(d.getDiscussion_detail());
            System.out.println(date);
            System.out.println(d.getDiscussion_image());
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public static void main(String[] args) {
        DiscussionDAO d = new DiscussionDAO();
        Discussion di = new Discussion(new User(1, "kienpt", "123", 1),
                "Hello world","834856.png");
        d.addDiscussion(di);
    }
}
