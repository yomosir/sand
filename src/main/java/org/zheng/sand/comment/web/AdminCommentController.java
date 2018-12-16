package org.zheng.sand.comment.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zheng.sand.common.Response;

@RestController
@RequestMapping(value = "/admin/Comment")
public class AdminCommentController {

    /* 管理端对评论的操作： 1.按照文章id搜索评论 2.删除非法评论 3.回复评论*/
    public Response getCommentByArticle(String articleId){
        return null;
    }

    public Response deleteIllegalComment(String commentId){

        return null;
    }

    public Response replyComment(String parntId){
        return null;
    }
}
