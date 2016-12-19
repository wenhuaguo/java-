package com.kaishengit.dao;

import com.kaishengit.entity.User;

/**
 * Created by Acer on 2016/12/17.
 */
public class Test {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
       User user = userDao.findByName("shaohua");
    }
}
