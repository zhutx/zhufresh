package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.Comments;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentsMapper {

    int insert(Comments comments);

}
