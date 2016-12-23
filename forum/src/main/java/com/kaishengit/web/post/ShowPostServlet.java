package com.kaishengit.web.post;

import com.kaishengit.dto.JsonResult;
import com.kaishengit.entity.Post;
import com.kaishengit.entity.Reply;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.service.PostService;
import com.kaishengit.web.SendHttpServlet;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Acer on 2016/12/20.
 */
@WebServlet("/showPost")
public class ShowPostServlet extends SendHttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PostService postService = new PostService();
        //统计某一帖子的点击次数在转向页面的时候点击次数加1
        String postId = req.getParameter("postId");
        String type = req.getParameter("type");

        try {
            if(StringUtils.isNotEmpty(type) && "save".equals(type)) {
                Post postSaveNum = postService.count(postId,type);
                JsonResult jsonResult = new JsonResult(postSaveNum);
                readJson(jsonResult, resp);
            }else if(StringUtils.isNotEmpty(type) && "thank".equals(type)){
                Post postSaveNum = postService.count(postId,type);
                JsonResult jsonResult = new JsonResult(postSaveNum);
                readJson(jsonResult, resp);
            }else {
                postService.clickCount(postId);
                Post post = postService.findPostById(postId);
                List<Reply> replyList = postService.findAllReply(postId);
                req.setAttribute("replyList",replyList);
                req.setAttribute("post", post);
                forward("post/showPost", req, resp);
            }
        }catch (ServletException ex) {
            resp.sendError(404);
        }
    }
}
