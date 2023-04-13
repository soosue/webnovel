package com.toy.pay.novel.service;

import com.toy.pay.novel.domain.Volume;

public class VolumeGetResponse {
    private String content;

    public VolumeGetResponse(Volume volume) {
        this.content = volume.getContent();
    }

    public String getContent() {
        return content;
    }
}
