package com.toy.pay.novel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toy.pay.novel.domain.FavoriteNovel;
import com.toy.pay.novel.domain.FavoriteNovelRepository;
import com.toy.pay.novel.domain.Novel;
import com.toy.pay.novel.domain.Reader;
import com.toy.pay.novel.domain.ReaderRepository;
import com.toy.pay.novel.web.ListResponse;

@Service
@Transactional(readOnly = true)
public class ReaderService {
    private final NovelService novelService;

    private final ReaderRepository readerRepository;
    private final FavoriteNovelRepository favoriteNovelRepository;

    public ReaderService(NovelService novelService, ReaderRepository readerRepository, FavoriteNovelRepository favoriteNovelRepository) {
        this.novelService = novelService;
        this.readerRepository = readerRepository;
        this.favoriteNovelRepository = favoriteNovelRepository;
    }

    @Transactional
    public void addFavoriteNovel(FavoriteNovelAddRequest request, Long readerId) {
        Reader reader = findReaderById(readerId);
        Novel novel = novelService.findNovel(request.getNovelId());

        reader.addFavoritesNovel(novel);
    }

    public ListResponse<FavoriteNovelGetResponse> getFavoriteNovel(Long readerId) {
        List<FavoriteNovel> favoriteNovels = favoriteNovelRepository.findByReaderId(readerId);

        return new ListResponse<>(favoriteNovels.stream()
                .map(FavoriteNovelGetResponse::new)
                .toList());
    }

    private Reader findReaderById(Long readerId) {
        return readerRepository.findById(readerId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다"));
    }
}
