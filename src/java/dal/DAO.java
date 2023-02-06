/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Chapter;
import model.Course;
import model.Enroll;
import model.Lesson;
import model.User;

/**
 *
 * @author admin
 */
public class DAO extends DBContext {

    public User check(String username, String password) {
        String sql = "SELECT [User_Id]\n"
                + "      ,[user_name]\n"
                + "      ,[user_mail]\n"
                + "      ,[user_password]\n"
                + "      ,[user_role]\n"
                + "      ,[user_gender]\n"
                + "      ,[user_address]\n"
                + "      ,[user_phone]\n"
                + "      ,[user_avatar]\n"
                + "  FROM [dbo].[User]\n"
                + "  where user_name=? and user_password=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User u = new User(rs.getInt("User_Id"), username, password,
                        rs.getString("user_mail"), rs.getInt("user_role"),
                        rs.getInt("user_gender"), rs.getString("user_address"),
                        rs.getString("user_phone"), rs.getString("user_avatar"));
                return u;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void change(User a) {
        String sql = "UPDATE [dbo].[User]\n"
                + "   SET \n"
                + "      [user_password] = ?\n"
                + "      \n"
                + " WHERE user_name=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getUser_password());
            st.setString(2, a.getUser_name());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Course> getAllCourse() {

        List<Course> list = new ArrayList<>();
        String sql = "SELECT [Course_id]\n"
                + "      ,[Course_name]\n"
                + "      ,[course_description]\n"
                + "      ,[course_price]\n"
                + "      ,[course_number_lesson]\n"
                + "      ,[course_image]\n"
                + "  FROM [dbo].[Course]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Course c = new Course(rs.getInt("Course_id"), rs.getString("Course_name"), rs.getString("course_description"), rs.getInt("course_price"), rs.getInt("course_number_lesson"), rs.getString("course_image"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Chapter> getChapterByCourseID(int courseId) {

        List<Chapter> list = new ArrayList<>();
        String sql = "SELECT [Chapter_id]\n"
                + "      ,[course_id]\n"
                + "      ,[chapter_name]\n"
                + "  FROM [dbo].[Chapter]\n"
                + "  where course_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, courseId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Chapter c = new Chapter(rs.getInt("Chapter_id"), courseId, rs.getString("chapter_name"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Course getCourseById(int id) {

        String sql = "SELECT [Course_id]\n"
                + "      ,[course_name]\n"
                + "      ,[course_description]\n"
                + "      ,[course_price]\n"
                + "      ,[course_number_lesson]\n"
                + "      ,[course_image]\n"
                + "  FROM [dbo].[Course]\n"
                + "  where Course_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Course c = new Course(rs.getInt("Course_id"), rs.getString("course_name"), rs.getString("course_description"), rs.getFloat("course_price"), rs.getInt("course_number_lesson"), rs.getString("course_image"));
                return c;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Lesson> listLesson1() {

        List<Lesson> list = new ArrayList<>();
        String sql = "SELECT [lesson_id]\n"
                + "      ,[lesson_video]\n"
                + "      ,[lesson_Percentage]\n"
                + "      ,[lesson_level]\n"
                + "      ,[chapter_id]\n"
                + "      ,[image_id]\n"
                + "      ,[lesson_content]\n"
                + "      ,[lesson_number]\n"
                + "      ,[question_id]\n"
                + "  FROM [SWP-Project].[dbo].[Lesson]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Lesson l = new Lesson(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7),
                        rs.getInt(8), rs.getInt(9));
                list.add(l);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public int countCommentCourse(int id) {
        int num = 0;
        String sql = "SELECT COUNT([comment_id])\n"
                + "  FROM [CommentCourse]\n"
                + "  WHERE [course_id]=?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return num;
    }

    public List<Enroll> listAllEnroll(int id) {
        List<Enroll> list = new ArrayList<>();
        String sql = "SELECT TOP (1000) [Enroll_id]\n"
                + "      ,[user_id]\n"
                + "      ,[course_id]\n"
                + "      ,[start_date]\n"
                + "      ,[end_date]\n"
                + "      ,[rate]\n"
                + "  FROM [SWP-Project].[dbo].[Enroll]\n"
                + "  where [user_id]=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Enroll e = new Enroll(rs.getInt("Enroll_id"), rs.getInt("user_id"),
                        rs.getInt("course_id"), rs.getString("start_date"),
                        rs.getString("end_date"),
                        rs.getInt("rate"));
                list.add(e);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        DAO d = new DAO();
        System.out.println(d.getAllCourse().size());
    }

}
