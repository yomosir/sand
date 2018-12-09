package org.zheng.sand.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zheng.sand.article.dao.ArticleMapper;
import org.zheng.sand.article.entity.Article;
import org.zheng.sand.article.service.ArticleService;

import java.util.UUID;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public int publish(Article article) {
        article.setStatus(1);
        return   articleMapper.insertSelective(article);
    }

    @Override
    public int addDraft(Article article) {
        String article_id = UUID.randomUUID().toString();
        article.setAid(article_id);
        article.setStatus(0);
        return  articleMapper.insertSelective(article);
    }

    @Override
    public int updateDraft(Article article) {
        return articleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    public int draftToPublish(Article article) {
        article.setStatus(1);
        return articleMapper.updateByPrimaryKeySelective(article);
    }
}
