package com.example.kad;

public class Bookings {
    String email;
    Integer student_number;
    public Bookings(String email, Integer student_number) {
        this.email = email;
        this.student_number = student_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStudent_number() {
        return student_number;
    }

    public void setStudent_number(Integer student_number) {
        this.student_number = student_number;
    }
}
