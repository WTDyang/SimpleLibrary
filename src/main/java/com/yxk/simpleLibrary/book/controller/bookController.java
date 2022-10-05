package com.yxk.simpleLibrary.book.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yxk.simpleLibrary.book.entity.Book;
import com.yxk.simpleLibrary.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("book")
public class bookController {

    @Resource
    private IBookService bookService;

    @PostMapping("/list/{currentPage}/{pageSize}")
    public IPage<Book> list(@PathVariable Integer currentPage, @PathVariable Integer pageSize, @RequestBody Book book){
        return this.bookService.bookList(currentPage, pageSize, book);
    }
}
