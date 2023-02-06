/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class User {
    private int user_id ;
    private String user_name ;
    private String user_password ;
    private String user_mail ;
    private int user_role ;
    private int user_gender;
    private String user_address ;
    private String user_phone ;
    private String user_avatar ;

    public User() {
    }

    public User(int user_id, String user_name, String user_password, String user_mail, int user_role, int user_gender, String user_address, String user_phone, String user_avatar) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_mail = user_mail;
        this.user_role = user_role;
        this.user_gender = user_gender;
        this.user_address = user_address;
        this.user_phone = user_phone;
        this.user_avatar = user_avatar;
    }

    public User(int user_id, String user_name, String user_password, int user_role) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_role = user_role;
    }
    
    
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public int getUser_role() {
        return user_role;
    }

    public void setUser_role(int user_role) {
        this.user_role = user_role;
    }

    public int getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(int user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password + ", user_mail=" + user_mail + ", user_role=" + user_role + ", user_gender=" + user_gender + ", user_address=" + user_address + ", user_phone=" + user_phone + ", user_avatar=" + user_avatar + '}';
    }
    
}
