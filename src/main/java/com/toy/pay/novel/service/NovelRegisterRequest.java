package com.toy.pay.novel.service;

import com.toy.pay.novel.domain.Novel;

public class NovelRegisterRequest {
    private String title;
    private Novel.Category category;
    private Long authorId;

    public Long getAuthorId() {
        return authorId;
    }

    public String getTitle() {
        return title;
    }

    public Novel.Category getCategory() {
        return category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(Novel.Category category) {
        this.category = category;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
