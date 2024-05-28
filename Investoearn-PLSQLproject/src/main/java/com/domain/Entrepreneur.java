package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "en_entrepreneur")
public class Entrepreneur {
    @Id
    @SequenceGenerator(name = "SequenceIdGenerator", sequenceName = "EN_ENTREPRENEUR_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdGenerator")
    private Long id;

    @NotNull//(message = "first name cant be empty")
    //@Size(min = 3,max = 12,message = "must be 3 to 12 ")
    @Column(name = "first_name")
    private String firstname;

    @NotNull
    @Column(name = "last_name")
    private String lastname;

    @NotNull
    @Column(name = "user_name")
    private String username;

    @NotNull
    @Column(name = "gender")
    private String gender;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "phone_number")
    private String phonenumber;

    @NotNull
    @Column(name = "nid")
    private String nid;

    @NotNull
    @Column(name = "dob")
    private String dob;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


}
