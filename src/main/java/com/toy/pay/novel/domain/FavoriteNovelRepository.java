package com.toy.pay.novel.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteNovelRepository extends JpaRepository<FavoriteNovel, Long> {
    List<FavoriteNovel> findByReaderId(Long readerId);
}
