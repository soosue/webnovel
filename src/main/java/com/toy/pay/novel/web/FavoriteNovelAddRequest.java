package com.toy.pay.novel.web;

public class FavoriteNovelAddRequest {
    private Long novelId;
    private Long userId;

    public Long getNovelId() {
        return novelId;
    }

    public void setNovelId(Long novelId) {
        this.novelId = novelId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
