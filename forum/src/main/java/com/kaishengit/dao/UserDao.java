package com.kaishengit.dao;

import com.kaishengit.entity.User;
import com.kaishengit.util.Dbhelp;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * Created by Acer on 2016/12/15.
 */
public class UserDao {
    /**
     * 去数据库查询账号是否被占用
     * @param username
     * @return
     */
    public User findByName(String username) {
        String sql = "select * from t_user where username = ?";
        return Dbhelp.query(sql,new BeanHandler<>(User.class),username);
    }

    /**
     * 保存数据
     * @param user1
     */
    public void save(User user) {
        String sql = "insert into t_user(username,password,email,phone,state,avatar) values(?,?,?,?,?,?)";
        Dbhelp.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getPhone(),user.getState(),user.getAvatar());
    }

    /**
     * 查看邮箱是否已经被注册
     * @param email
     * @return
     */
    public User findByEmail(String email) {
        String sql = "select * from t_user where email = ?";
        return Dbhelp.query(sql,new BeanHandler<>(User.class),email);
    }

    /**
     * 用户进行激活账号
     * @param user
     */
    public void update(User user) {
        System.out.println(user);
        String sql = "update t_user set password=?,email=?,avatar=?,phone=?,state=? where id =  ?";
        Dbhelp.update(sql,user.getPassword(),user.getEmail(),user.getAvatar(),user.getPhone(),user.getState(),user.getId());
    }

    /**
     * 通过id找到对应的用户
     * @param integer
     * @return
     */
    public User findById(Integer id) {
        String sql = "select * from t_user where id=?";
        return Dbhelp.query(sql,new BeanHandler<>(User.class),id);
    }
}
