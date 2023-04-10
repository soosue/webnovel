package com.toy.pay.novel.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void 선호작을_추가한다() {
        Novel novel = new Novel();
        User user = new User();

        assertDoesNotThrow(() -> user.addFavoritesNovel(novel));
    }

    @Test
    void 이미_추가한_선호작을_추가한다() {
        Novel novel = new Novel();
        User user = new User();
        user.addFavoritesNovel(novel);

        assertThatThrownBy(() -> user.addFavoritesNovel(novel))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 선호작에 추가한 소설입니다");
    }
}
