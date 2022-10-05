package com.yxk.simpleLibrary.book.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * book
 * @author 
 */
@Data
public class Book implements Serializable {
    /**
     * 图书id
     */
    private Long id;

    /**
     * 图书名
     */
    private String bookName;

    /**
     * 图书作者
     */
    private String bookAuthor;

    /**
     * 图书出版社
     */
    private String bookPublisher;

    /**
     * 图书类别id
     */
    private Long categoryId;

    /**
     * 图书类别
     */
    @TableField(exist = false)
    private String category;

    /**
     * 图书简介
     */
    private String bookIntroduction;

    /**
     * 出版日期
     */
    private LocalDateTime publishDate;

    /**
     * 图书总数
     */
    private Integer totalNum;

    /**
     * 剩余数量
     */
    private Integer surplusNum;

    /**
     * 创建日期
     */
    private LocalDateTime createTime;

    /**
     * 更新日期
     */
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}