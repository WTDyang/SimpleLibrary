package com.yxk.simpleLibrary.bookRecord.mapper;


import com.yxk.simpleLibrary.bookRecord.entity.BorrowRecord;

public interface BorrowRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BorrowRecord record);

    int insertSelective(BorrowRecord record);

    BorrowRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BorrowRecord record);

    int updateByPrimaryKey(BorrowRecord record);
}