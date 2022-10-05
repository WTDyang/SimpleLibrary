package com.yxk.simpleLibrary.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.yxk.simpleLibrary.book.entity.Book;
import com.yxk.simpleLibrary.book.mapper.BookMapper;
import com.yxk.simpleLibrary.book.service.IBookService;
import com.yxk.simpleLibrary.bookCategory.mapper.BookCategoryMapper;
import com.yxk.simpleLibrary.common.Utils.utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Resource
    private BookMapper bookMapper;
    @Resource
    private BookCategoryMapper bookCategoryMapper;

    /*
     * @MethodName: bookList
     * @Description: 获取书目列表方法
     * @Author: yxk
     * @Date: 2022/5/28 18:36
     * @Param: [currentPage, pageSize, book]
     * @Return: com.baomidou.mybatisplus.core.metadata.IPage<com.yxk.simpleLibrary.book.entity.Book>
     **/
    @Override
    public IPage<Book> bookList(Integer currentPage, Integer pageSize, Book book) {
        QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<>();
        //条件查询
        if(utils.isNotBlank(book.getBookAuthor())){
            bookQueryWrapper.eq("book_author",book.getBookAuthor());
        }
        if(utils.isNotBlank(book.getBookName())){
            bookQueryWrapper.eq("book_name",book.getBookName());
        }
        if(utils.isNotBlank(book.getBookPublisher())){
            bookQueryWrapper.eq("book_publisher",book.getBookPublisher());
        }
        IPage<Book> bookIPage = this.bookMapper.selectPage(new Page<Book>(currentPage,pageSize),bookQueryWrapper);
        if(book.getCategoryId()!=null && utils.isNotBlank(book.getCategoryId().toString())) {
            List<Book> bookList = new ArrayList<>();
            bookIPage.getRecords().forEach(e -> {
                if(this.bookCategoryMapper.getIdByCategory(book.getCategory()) == e.getCategoryId()){
                    e.setCategory(this.bookCategoryMapper.getCategory(book.getCategoryId()));
                    bookList.add(e);
                }
            });
            bookIPage.setRecords(bookList);
        }else{
            bookIPage.getRecords().forEach(e ->{
                e.setCategory(this.bookCategoryMapper.getCategory(e.getCategoryId()));
            });
        }
        return bookIPage;
    }
}
