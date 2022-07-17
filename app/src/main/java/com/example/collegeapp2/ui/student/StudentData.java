package com.example.collegeapp2.ui.student;

public class StudentData {

    private String name;
    private String email;
    private String roll_no;
    private String image;
    private String phone_No;
    private String session;
    private String key;

    public StudentData() {
    }

    public StudentData(String name, String email, String roll_no, String image, String phone_No,String session,String key) {
        this.name = name;
        this.email = email;
        this.roll_no = roll_no;
        this.image = image;
        this.phone_No = phone_No;
        this.session=session;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone_No() {
        return phone_No;
    }

    public void setPhone_No(String phone_No) {
        this.phone_No = phone_No;
    }


    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }



    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }


}