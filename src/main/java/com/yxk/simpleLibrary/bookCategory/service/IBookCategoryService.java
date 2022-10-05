package com.yxk.simpleLibrary.bookCategory.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yxk.simpleLibrary.bookCategory.entity.BookCategory;
import org.apache.ibatis.annotations.Param;

public interface IBookCategoryService extends IService<BookCategory>{

    String getCategory(@Param("id") Long id);

}
