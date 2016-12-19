package com.kaishengit.dao;

import com.kaishengit.entity.LoginLog;
import com.kaishengit.util.Dbhelp;

/**
 * Created by Acer on 2016/12/17.
 */
public class LoginLogDao {
    /**
     * 记录登录日志
     * @param loginLog
     */
    public void save(LoginLog loginLog) {
        String sql = "insert into t_login_log(ip,t_user_id) values(?,?)";
        Dbhelp.update(sql,loginLog.getIp(),loginLog.getT_user_id());
    }
}
