package com.example.unittest.mapper.mocks;

import com.example.data.vo.v1.BookVO;
import com.example.model.Books;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockBook {

    public Books mockEntity(){
        return mockEntity(0);
    }

    public BookVO mockVO(){
        return mockVO(0);
    }

    public List<Books> mockEntityList(){
        List<Books> books = new ArrayList<>();
        for (int i = 0; i<14; i++){
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookVO> mockVOList(){
        List<BookVO> bookVOS = new ArrayList<>();
        for(int i = 0; i< 14; i++){
            bookVOS.add(mockVO(i));
        }
        return bookVOS;
    }

    public Books mockEntity(Integer number) {
        Books book = new Books();
        book.setId(number.longValue());
        book.setAuthor("Some Author" + number);
        book.setLaunchDate(new Date());
        book.setPrice(25D);
        book.setTitle("Some Title" + number);
        return book;
    }

    public BookVO mockVO(Integer number) {
        BookVO book = new BookVO();
        book.setKey(number.longValue());
        book.setAuthor("Some Author" + number);
        book.setLaunchDate(new Date());
        book.setPrice(25D);
        book.setTitle("Some Title" + number);
        return book;
    }
}
