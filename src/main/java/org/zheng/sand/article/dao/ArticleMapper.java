package org.zheng.sand.article.dao;

import org.zheng.sand.article.entity.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(String aid);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(String aid);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
}