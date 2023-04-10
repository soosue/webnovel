package com.toy.pay.novel.service;

import com.toy.pay.novel.domain.FavoriteNovel;

public class FavoriteNovelGetResponse {
    private String title;

    public FavoriteNovelGetResponse(FavoriteNovel favoriteNovel) {
        this.title = favoriteNovel.getNovel().getTitle();
    }

    public String getTitle() {
        return title;
    }
}
