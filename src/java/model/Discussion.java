/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Discussion implements Serializable{

    private User user;
    private int discussion_id;
    private int user_id;
    private String discussion_detail;
    private Date discussion_date;
    private int discussion_reply;
    private int discussion_like;
    private String discussion_image ;

    public Discussion() {
    }

    public Discussion(User user, int discussion_id, int user_id, String discussion_detail, 
            Date discussion_date, int discussion_reply, int discussion_like,String discussion_image) {
        this.user = user;
        this.discussion_id = discussion_id;
        this.user_id = user_id;
        this.discussion_detail = discussion_detail;
        this.discussion_date = discussion_date;
        this.discussion_reply = discussion_reply;
        this.discussion_like = discussion_like;
        this.discussion_image= discussion_image ;
    }

    public Discussion(User user, String discussion_detail) {
        this.user = user;
        this.discussion_detail = discussion_detail;
    }

    public Discussion(User user, String discussion_detail, String discussion_image) {
        this.user = user;
        this.discussion_detail = discussion_detail;
        this.discussion_image = discussion_image;
    }
    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getDiscussion_id() {
        return discussion_id;
    }

    public void setDiscussion_id(int discussion_id) {
        this.discussion_id = discussion_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDiscussion_detail() {
        return discussion_detail;
    }

    public void setDiscussion_detail(String discussion_detail) {
        this.discussion_detail = discussion_detail;
    }

    public Date getDiscussion_date() {
        return discussion_date;
    }

    public void setDiscussion_date(Date discussion_date) {
        this.discussion_date = discussion_date;
    }

    public int getDiscussion_reply() {
        return discussion_reply;
    }

    public void setDiscussion_reply(int discussion_reply) {
        this.discussion_reply = discussion_reply;
    }

    public int getDiscussion_like() {
        return discussion_like;
    }

    public void setDiscussion_like(int discussion_like) {
        this.discussion_like = discussion_like;
    }

    public String getTimediff() {
        int num = util.TimeHandle.timeDiff(this.discussion_date);
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

    public String getDiscussion_image() {
        return discussion_image;
    }

    public void setDiscussion_image(String discussion_image) {
        this.discussion_image = discussion_image;
    }
    

    public static void main(String[] args) {
        String str = "2023-01-25";
        Date date = Date.valueOf(str);
//        Discussion d =new Discussion(new User(), 1, 1, "",date, 0, 0);
//        System.out.println(d.getTimediff(date));
        System.out.println(date+"");
    }

}
