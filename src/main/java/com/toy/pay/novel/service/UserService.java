package com.toy.pay.novel.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toy.pay.novel.domain.Novel;
import com.toy.pay.novel.domain.User;
import com.toy.pay.novel.domain.UserRepository;
import com.toy.pay.novel.web.FavoriteNovelAddRequest;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final NovelService novelService;

    private final UserRepository userRepository;

    public UserService(NovelService novelService, UserRepository userRepository) {
        this.novelService = novelService;
        this.userRepository = userRepository;
    }

    @Transactional
    public void addFavoriteNovel(FavoriteNovelAddRequest request) {
        User user = findUserById(request.getUserId());
        Novel novel = novelService.findNovel(request.getNovelId());

        user.addFavoritesNovel(novel);
    }

    private User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다"));
    }
}
