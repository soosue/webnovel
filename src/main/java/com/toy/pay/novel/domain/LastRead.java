package com.toy.pay.novel.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LastRead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long readerId;
    private Long novelId;
    private Long volumeId;

    protected LastRead() {
    }

    public LastRead(Long readerId, Long novelId, Long volumeId) {
        this.readerId = readerId;
        this.novelId = novelId;
        this.volumeId = volumeId;
    }

    public void read(Long volumeId) {
        this.volumeId = volumeId;
    }
}
