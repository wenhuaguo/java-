package com.kaishengit.dao;

import com.kaishengit.entity.Post;
import com.kaishengit.util.Dbhelp;
import org.apache.commons.dbutils.handlers.BeanHandler;


/**
 * Created by Acer on 2016/12/20.
 */
public class PostDao {
    /**
     * 对用户发的新帖进行保存
     * @param newPost
     */
    public Integer save(Post newPost) {
        String sql = "insert into t_newpost(title,content,userid,nodeid,lastreplytime) values(?,?,?,?,?)";
        return Dbhelp.insert(sql,newPost.getTitle(),newPost.getContent(),newPost.getUserid(),newPost.getNodeid(),newPost.getLastreplytime());
    }

    /**
     * 通过postid查找用户发的新帖作用是在用户界面显示用户发的帖的详细内容
     * @param postid
     */
    public Post findById(Integer postId) {
        String sql = "select * from t_newpost where id=?";
        return Dbhelp.query(sql,new BeanHandler<>(Post.class),postId);
    }

    /**
     * 对数据库信息进行更新
     * @param post
     */
    public void update(Post post) {
        String sql = "update t_newpost set title=?,content=?,clicknum=?,savenum=?,thanknum=? where id=?";
        Dbhelp.update(sql,post.getTitle(),post.getContent(),post.getClicknum(),post.getSavenum(),post.getThanknum(),post.getId());
    }
}
