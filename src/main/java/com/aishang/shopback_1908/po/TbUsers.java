package com.aishang.shopback_1908.po;

import javax.persistence.*;

@Table(name = "shop..tb_users")
public class TbUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "depID")
    private Integer depid;

    @Column(name = "userName")
    private String username;

    @Column(name = "userPwd")
    private String userpwd;

    @Column(name = "userCode")
    private String usercode;

    @Column(name = "userSex")
    private String usersex;

    @Column(name = "userAge")
    private Integer userage;

    /**
     * 0代表普通管理员，1,代表超级管理员
     */
    @Column(name = "userPower")
    private Integer userpower;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return depID
     */
    public Integer getDepid() {
        return depid;
    }

    /**
     * @param depid
     */
    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    /**
     * @return userName
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return userPwd
     */
    public String getUserpwd() {
        return userpwd;
    }

    /**
     * @param userpwd
     */
    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    /**
     * @return userCode
     */
    public String getUsercode() {
        return usercode;
    }

    /**
     * @param usercode
     */
    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    /**
     * @return userSex
     */
    public String getUsersex() {
        return usersex;
    }

    /**
     * @param usersex
     */
    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    /**
     * @return userAge
     */
    public Integer getUserage() {
        return userage;
    }

    /**
     * @param userage
     */
    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    /**
     * 获取0代表普通管理员，1,代表超级管理员
     *
     * @return userPower - 0代表普通管理员，1,代表超级管理员
     */
    public Integer getUserpower() {
        return userpower;
    }

    /**
     * 设置0代表普通管理员，1,代表超级管理员
     *
     * @param userpower 0代表普通管理员，1,代表超级管理员
     */
    public void setUserpower(Integer userpower) {
        this.userpower = userpower;
    }
}