package com.yxk.simpleLibrary.book.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yxk.simpleLibrary.book.entity.Book;

public interface IBookService extends IService<Book>{

    public IPage<Book> bookList(Integer currentPage, Integer pageSize, Book book);

}
