package com.toy.pay.novel.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class FavoriteNovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    private Novel novel;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    protected FavoriteNovel() {
    }

    public FavoriteNovel(Novel novel, User user) {
        this.novel = novel;
        this.user = user;
    }

    public Novel getNovel() {
        return novel;
    }

    public boolean has(Novel novel) {
        return this.novel.equals(novel);
    }
}
