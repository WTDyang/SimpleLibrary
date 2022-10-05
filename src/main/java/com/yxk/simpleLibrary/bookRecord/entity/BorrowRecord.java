package com.yxk.simpleLibrary.bookRecord.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * borrow_record
 * @author 
 */
@Data
public class BorrowRecord implements Serializable {
    /**
     * 借阅记录id
     */
    private Long id;

    /**
     * 借阅者id
     */
    private Long userId;

    /**
     * 借阅图书id
     */
    private Long bookId;

    /**
     * 借阅日期
     */
    private LocalDateTime borrowDate;

    /**
     * 最晚归还日期
     */
    private LocalDateTime returnDate;

    /**
     * 是否已归还 0表示未归还 1表示已归还
     */
    private Integer isReturn;

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