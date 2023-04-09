package com.toy.pay.novel.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Volume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    private Novel novel;

    public Volume() {
    }

    public Volume(String content) {
        this.content = content;
    }

    public void setNovel(Novel novel) {
        this.novel = novel;
    }

    public Long getId() {
        return id;
    }
}
