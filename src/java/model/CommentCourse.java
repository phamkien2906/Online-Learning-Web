/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class CommentCourse {

    private User user;
    private int commentc_id;
    private int course_id;
    private int user_id;
    private String commentc_detail;
    private Date commentc_date;
    private int commentc_reply;
    private int commentc_like;

    public CommentCourse() {
    }

    public CommentCourse(User user, int commentc_id, int course_id, int user_id, String commentc_detail, Date commentc_date, int commentc_reply, int commentc_like) {
        this.user = user;
        this.commentc_id = commentc_id;
        this.course_id = course_id;
        this.user_id = user_id;
        this.commentc_detail = commentc_detail;
        this.commentc_date = commentc_date;
        this.commentc_reply = commentc_reply;
        this.commentc_like = commentc_like;
    }

    public CommentCourse(User user, int course_id, String commentc_detail) {
        this.user = user;
        this.course_id = course_id;
        this.commentc_detail = commentc_detail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCommentc_id() {
        return commentc_id;
    }

    public void setCommentc_id(int commentc_id) {
        this.commentc_id = commentc_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCommentc_detail() {
        return commentc_detail;
    }

    public void setCommentc_detail(String commentc_detail) {
        this.commentc_detail = commentc_detail;
    }

    public Date getCommentc_date() {
        return commentc_date;
    }

    public void setCommentc_date(Date commentc_date) {
        this.commentc_date = commentc_date;
    }

    public int getCommentc_reply() {
        return commentc_reply;
    }

    public void setCommentc_reply(int commentc_reply) {
        this.commentc_reply = commentc_reply;
    }

    public int getCommentc_like() {
        return commentc_like;
    }

    public void setCommentc_like(int commentc_like) {
        this.commentc_like = commentc_like;
    }

    public String getTimediff() {
        int num = util.TimeHandle.timeDiff(this.commentc_date);
        String s;
        switch (num) {
            case 0:
                s = "Today";
                break;
            case 1:
                s = "Yesterday";
                break;
            default:
                s = num + " days ago";
        }
        return s;
    }

    @Override
    public String toString() {
        return "CommentCourse{" + "user=" + user + ", commentc_id=" + commentc_id + ", course_id=" + course_id + ", user_id=" + user_id + ", commentc_detail=" + commentc_detail + ", commentc_date=" + commentc_date + ", commentc_reply=" + commentc_reply + ", commentc_like=" + commentc_like + '}';
    }

}
