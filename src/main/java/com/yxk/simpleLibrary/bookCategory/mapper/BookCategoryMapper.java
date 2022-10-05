package com.yxk.simpleLibrary.bookCategory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yxk.simpleLibrary.bookCategory.entity.BookCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookCategoryMapper extends BaseMapper<BookCategory>{

    String getCategory(@Param("id") Long id);

    Long getIdByCategory(@Param("category") String category);

    int deleteByPrimaryKey(Long id);

    int insert(BookCategory record);

    int insertSelective(BookCategory record);

    BookCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BookCategory record);

    int updateByPrimaryKey(BookCategory record);
}