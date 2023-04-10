package com.toy.pay.novel.service;

public class FavoriteNovelAddRequest {
    private Long novelId;
    private Long readerId;

    public Long getNovelId() {
        return novelId;
    }

    public void setNovelId(Long novelId) {
        this.novelId = novelId;
    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }
}
