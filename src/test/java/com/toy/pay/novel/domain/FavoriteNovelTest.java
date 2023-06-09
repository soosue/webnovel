package com.toy.pay.novel.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FavoriteNovelTest {
    @Test
    void 선호작_소설이_해당_소설인지_확인한다() {
        Novel novel = new Novel();
        Novel novel2 = new Novel();
        Reader reader = new Reader();
        FavoriteNovel favoriteNovel = new FavoriteNovel(novel, reader);

        assertThat(favoriteNovel.has(novel)).isTrue();
        assertThat(favoriteNovel.has(novel2)).isFalse();
    }
}
