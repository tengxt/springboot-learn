package com.tenegxt.springbootjackson.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tenegxt.springbootjackson.config.UserSerializer;

import java.io.Serializable;
import java.util.Date;

//@JsonIgnoreProperties({"id","password"})
//@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
//@JsonSerialize(using = UserSerializer.class)
public class User implements Serializable {
    private static final long serialVersionUID = -5617919495946624537L;

    public interface UserNameView {};
    public interface AllUserFieldView extends UserNameView {};

    @JsonView(AllUserFieldView.class)
    private Integer id;
    @JsonView(UserNameView.class)
    private String userName;
    //@JsonIgnore
    @JsonView(AllUserFieldView.class)
    private String password;
    @JsonView(AllUserFieldView.class)
    private Integer age;
    //@JsonProperty("btn")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(AllUserFieldView.class)
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
