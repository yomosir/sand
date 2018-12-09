package org.zheng.sand.article.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zheng.sand.article.entity.Article;
import org.zheng.sand.article.service.ArticleService;
import org.zheng.sand.common.Response;
import org.zheng.sand.common.ResponseUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/admin/article")
public class AdminArticleController {

    private static final int PUBLISHFAILEDCODE                 =   1006;

    @Autowired
    private ArticleService articleService;

    /* 文章包含操作： 发表（publish），保存草稿（save as draft） ， 删除 （delete） ,  下架 （put off） */
    /*前端展示文章页面 ： 点赞 （praise）, 根据id查询文章 （details of one）[包括评论], 文章简要信息（summary），*/

    /**
     * 发布文章接口
     * @param article 文章类实体
     * @return
     */
    @RequestMapping(value = "publish",method = RequestMethod.POST)
    public Response publish(Article article){
        boolean isDraft = false;
        /* 先判断文章是否有ID，是否在数据库中存在草稿 */
        if(article.getAid() != null){
            isDraft = true;
        }
        int status = 0;
        if(!isDraft) {
            /* 为新建文章设置id */
            String article_id = UUID.randomUUID().toString();
            article.setAid(article_id);
            status = articleService.publish(article);
        }else {
            /* 将草稿文章发布 */
            status = articleService.draftToPublish(article);
        }
        Response response = new Response();
        List<String> msg = new LinkedList<>();
        if(status == 1){
            return ResponseUtil.success();
        }else {
            return ResponseUtil.error(PUBLISHFAILEDCODE,"publish failed");
        }
    }

    @RequestMapping(value = "saveToDraft",method = RequestMethod.POST)
    public String saveAsDraft(Article article){
        boolean isExisted = false;
        if(article.getAid() != null){
            isExisted = true;
        }
        int status = 0;
        if(isExisted){
            /* 更新的草稿 */
            status = articleService.updateDraft(article);

        }else{
            /* 新建的草稿 */
            status = articleService.addDraft(article);
        }
        return null;
    }
}
