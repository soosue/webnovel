package com.toy.pay.novel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toy.pay.novel.domain.FavoriteNovel;
import com.toy.pay.novel.domain.FavoriteNovelRepository;
import com.toy.pay.novel.domain.LastRead;
import com.toy.pay.novel.domain.LastReadRepository;
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
    private final LastReadRepository lastReadRepository;

    public ReaderService(NovelService novelService, ReaderRepository readerRepository, FavoriteNovelRepository favoriteNovelRepository, LastReadRepository lastReadRepository) {
        this.novelService = novelService;
        this.readerRepository = readerRepository;
        this.favoriteNovelRepository = favoriteNovelRepository;
        this.lastReadRepository = lastReadRepository;
    }

    @Transactional
    public void addFavoriteNovel(FavoriteNovelAddRequest request, Long readerId) {
        Reader reader = findReaderById(readerId);
        Novel novel = novelService.findNovel(request.getNovelId());

        reader.addFavoriteNovel(novel);
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

    @Transactional
    public void readVolume(Long novelId, Long volumeId, Long readerId) {
        LastRead lastRead = lastReadRepository.findByReaderIdAndNovelId(readerId, novelId)
                .orElseGet(() -> new LastRead(readerId, novelId, volumeId));

        lastRead.read(volumeId);
        lastReadRepository.save(lastRead);
    }
}
