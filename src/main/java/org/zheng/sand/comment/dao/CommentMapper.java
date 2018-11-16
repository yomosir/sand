package org.zheng.sand.comment.dao;

import org.zheng.sand.comment.entity.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(String cid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(String cid);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}