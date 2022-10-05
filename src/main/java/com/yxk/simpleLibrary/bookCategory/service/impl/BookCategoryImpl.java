package com.yxk.simpleLibrary.bookCategory.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yxk.simpleLibrary.bookCategory.entity.BookCategory;
import com.yxk.simpleLibrary.bookCategory.mapper.BookCategoryMapper;
import com.yxk.simpleLibrary.bookCategory.service.IBookCategoryService;

public class BookCategoryImpl extends ServiceImpl<BookCategoryMapper, BookCategory> implements IBookCategoryService {
    @Override
    public String getCategory(Long id) {
        return this.baseMapper.getCategory(id);
    }
}
