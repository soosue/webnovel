package com.toy.pay.novel.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Novel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Category category;
    @ManyToOne
    private Author author;

    protected Novel() {
    }

    public Novel(String title, Category category, Author author) {
        this.title = title;
        this.category = category;
        this.author = author;
    }

    public enum Category {
        FANTASY, ROMANCE_FANTASY
    }

    public Long getId() {
        return id;
    }
}
