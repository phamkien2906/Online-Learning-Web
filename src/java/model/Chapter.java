/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import dal.DAO ;
/**
 *
 * @author admin
 */
public class Chapter {
    List<Lesson> list = new ArrayList<>();
    private int chapter_id;
    private int course_id;
    private String chapter_name;

    public Chapter() {
    }

    public Chapter(int chapter_id, int course_id, String chapter_name) {
        this.chapter_id = chapter_id;
        this.course_id = course_id;
        this.chapter_name = chapter_name;
    }

    public int getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(int chapter_id) {
        this.chapter_id = chapter_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }
    
    
}
