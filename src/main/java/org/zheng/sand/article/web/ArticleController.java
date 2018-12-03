package org.zheng.sand.article.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {
    /* 文章包含操作： 发表（publish），保存草稿（save as draft） ， 删除 （delete） ,  下架 （put off） */
    /*前端展示文章页面 ： 点赞 （praise）, 根据id查询文章 （details of one）[包括评论], 文章简要信息（summary），*/
}
