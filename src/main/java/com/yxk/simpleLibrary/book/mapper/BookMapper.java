package com.yxk.simpleLibrary.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yxk.simpleLibrary.book.entity.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book>{
    int deleteByPrimaryKey(Long id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}