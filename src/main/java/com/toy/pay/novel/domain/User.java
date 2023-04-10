package com.toy.pay.novel.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
    @Id
    private Long id;
    @OneToMany(mappedBy = "user")
    private List<FavoriteNovel> favoriteNovels = new ArrayList<>();

    public void addFavoritesNovel(Novel novel) {
        boolean alreadyAdd = favoriteNovels.stream()
                .filter(fNovel -> fNovel.has(novel))
                .findFirst()
                .isPresent();

        if (alreadyAdd) {
            throw new IllegalArgumentException("이미 선호작에 추가한 소설입니다");
        }

        favoriteNovels.add(new FavoriteNovel(novel, this));
    }
}
