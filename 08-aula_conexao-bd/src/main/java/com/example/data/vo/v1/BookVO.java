package com.example.data.vo.v1;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@JsonPropertyOrder({"id", "author", "launchDate", "price", "title"})
public class BookVO extends RepresentationModel<BookVO> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Mapping("id")
    private Long key;

    private String author;
    private Date launchDate;

    private Double price;

    private String title;

    public BookVO() {
    }

    public BookVO(Long key, String author, Date launchDate, Double price, String title) {
        this.key = key;
        this.author = author;
        this.launchDate = launchDate;
        this.price = price;
        this.title = title;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BookVO bookVO = (BookVO) o;

        return key.equals(bookVO.key);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + key.hashCode();
        return result;
    }
}
