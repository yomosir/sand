package org.zheng.sand.article.service;

import org.zheng.sand.article.entity.Article;

public interface ArticleService {
    int publish(Article article);
    int draftToPublish(Article article);
    int addDraft(Article article);
    int updateDraft(Article article);
}
