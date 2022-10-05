package com.yxk.simpleLibrary.bookCategory.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * book_category
 * @author 
 */
@Data
public class BookCategory implements Serializable {
    /**
     * 分类id
     */
    private Long id;

    /**
     * 分类名
     */
    private String category;

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