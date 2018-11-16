package org.zheng.sand.label.dao;

import org.zheng.sand.label.entity.Label;

public interface LabelMapper {
    int deleteByPrimaryKey(String lid);

    int insert(Label record);

    int insertSelective(Label record);

    Label selectByPrimaryKey(String lid);

    int updateByPrimaryKeySelective(Label record);

    int updateByPrimaryKey(Label record);
}