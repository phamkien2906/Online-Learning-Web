/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Enroll {

    private int enroll_id;
    private int user_id;
    private int course_id;
    private String start_date;
    private String end_date;
    private int rate;

    public Enroll() {
    }

    public Enroll(int enroll_id, int user_id, int course_id, String start_date, String end_date, int rate) {
        this.enroll_id = enroll_id;
        this.user_id = user_id;
        this.course_id = course_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.rate = rate;
    }

    public int getEnroll_id() {
        return enroll_id;
    }

    public void setEnroll_id(int enroll_id) {
        this.enroll_id = enroll_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Enroll{" + "enroll_id=" + enroll_id + ", user_id=" + user_id + ", course_id=" + course_id + ", start_date=" + start_date + ", end_date=" + end_date + ", rate=" + rate + '}';
    }
    

}
