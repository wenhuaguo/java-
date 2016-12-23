package com.kaishengit.service;

import com.kaishengit.dao.NodeDao;
import com.kaishengit.dao.PostDao;
import com.kaishengit.dao.ReplyDao;
import com.kaishengit.dao.UserDao;
import com.kaishengit.entity.Node;
import com.kaishengit.entity.Post;
import com.kaishengit.entity.Reply;
import com.kaishengit.entity.User;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.util.readconfig.ReadConfig;
import org.apache.commons.lang3.StringUtils;



import java.sql.Timestamp;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

/**
 * Created by Acer on 2016/12/20.
 */
public class PostService {
    private PostDao postdao = new PostDao();
    private NodeDao nodedao = new NodeDao();
    private UserDao userdao = new UserDao();
    private ReplyDao replydao = new ReplyDao();
    /**
     * 对用户发布的新帖进行保存到数据库
     * @param node
     * @param user
     * @param title
     * @param content
     */
    public Post saveUserNewPost(Integer node, Integer userid, String title, String content) {
        Post newPost = new Post();
        newPost.setContent(content);
        newPost.setNodeid(node);
        newPost.setTitle(title);
        newPost.setUserid(userid);
        //暂时设置最后回复时间为当前时间
        //获取1970年至现在的毫秒数
        System.out.println("毫秒数："+ System.currentTimeMillis());
        newPost.setLastreplytime(new Timestamp(System.currentTimeMillis()));
        //根据保存过程中返回来的id将id对应的帖的详细内容查询出来
        Integer postId = postdao.save(newPost);
        System.out.println(postId);
        //?????是否应该去数据库再查询一遍
        newPost.setId(postId);
        //每当用户发帖都会有所有分类节点那么我们就可以更新node节点中某一节点的发帖数量
        Node nodeCount = nodedao.findByNodeId(node);
        if(nodeCount != null){
            nodeCount.setNodecount(nodeCount.getNodecount() +1);
            nodedao.update(nodeCount);
        }else {
            throw new ServiceException("该节点不存在");
        }
        //返回用户发布的新帖的详细内容供显示
        return newPost;
    }

    /**
     * 读取数据库中的节点
     */
    public List<Node> readNode() {
        return nodedao.readNode();
    }

    /**
     * 根据postid
     * @param integer
     */
    public Post findPostById(String postId) {
        if(StringUtils.isNumeric(postId)){
            Post post = postdao.findById(Integer.valueOf(postId));
            if(post != null){
                User user  = userdao.findById(post.getUserid());
                Node node = nodedao.findByNodeId(post.getNodeid());
                //将七牛连接设置为可更改的
                user.setAvatar(ReadConfig.get("qiniu.internate") + user.getAvatar());
                post.setUser(user);
                post.setNode(node);
                return post;
            }else {
                throw new ServiceException("该贴不存在或已被删除");
            }
        }else {
            throw new ServiceException("参数错误");
        }
    }

    /**
     * 保存用户的恢复内容
     * @param postId
     * @param content
     * @param userId
     */
    public void saveReply(String postId, String content, Integer userId) {
        if(StringUtils.isNumeric(postId)) {
            Post post = postdao.findById(Integer.valueOf(postId));
            if(post != null) {
                Reply reply = new Reply();
                reply.setUserid(userId);
                reply.setContent(content);
                reply.setPostid(Integer.valueOf(postId));
                replydao.saveReply(reply);
            }else {
                throw new ServiceException("该贴不存在或已被删除不能回复");
            }
        }else {
            throw new ServiceException("参数错误");
        }
    }

    /**
     * 统计点击次数
     * @param postId
     */
    public void clickCount(String postId) {
        if(StringUtils.isNumeric(postId)){
            Post post = postdao.findById(Integer.valueOf(postId));
            if(post != null){
                post.setClicknum(post.getClicknum()+1);
                postdao.update(post);
            }else {
                throw new ServiceException("该贴不存在或已被删除");
            }
        }else {
            throw new ServiceException("参数错误");
        }
    }

    /**
     * 保存用户收藏的记录
     * @param postId
     */
    public Post count(String postId,String type) {
        if(StringUtils.isNumeric(postId)) {
         Post post=postdao.findById(Integer.valueOf(postId));
            if(post != null && "save".equals(type)){
                post.setSavenum(post.getSavenum()+1);
                postdao.update(post);
                return post;
            }else if(post != null && "thank".equals(type)){
                post.setThanknum(post.getThanknum()+1);
                postdao.update(post);
                return post;
            }else {
                throw new ServiceException("该贴不存在或已被删除");
            }
        }else {
            throw new ServiceException("参数错误");
        }
    }

    /**
     * 显示某一帖的所有回复连表查询
     * @param postId
     * @return
     */
    public List<Reply> findAllReply(String postId) {
        if(StringUtils.isNumeric(postId)){
            List<Reply> replyList = replydao.findByPostId(Integer.valueOf(postId));
            if(replyList != null){
                return replyList;
            }else {
                throw new ServiceException("该贴不存在或已被删除");
            }
        }else {
            throw new ServiceException("参数错误");
        }
    }
}
