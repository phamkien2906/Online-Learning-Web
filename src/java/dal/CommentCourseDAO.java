/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.User;
import model.CommentCourse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CommentCourseDAO extends DBContext {

    public List<CommentCourse> getCommentCourse(int id) {
        List<CommentCourse> list = new ArrayList<>();
        try {
            String sql = "  Select * from [CommentCourse] as CC\n"
                    + "                    Join [User] as US on CC.[user_id] =US.User_Id\n"
                    + "                    Join [Course] as CO on CC.course_id =CO.Course_id \n"
                    + "                    where CC.comment_repply=0 and CO.Course_id=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new CommentCourse(new User(rs.getInt(8), rs.getString(9),
                        rs.getString(11), rs.getInt(12)),rs.getInt(1),
                        rs.getInt(3), rs.getInt(2), rs.getString(4),
                        rs.getDate(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public static void main(String[] args) {
        CommentCourseDAO d = new CommentCourseDAO();
        System.out.println(d.getCommentCourse(1).get(0));
    }
}
