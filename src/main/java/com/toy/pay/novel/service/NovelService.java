package com.toy.pay.novel.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toy.pay.novel.domain.Author;
import com.toy.pay.novel.domain.AuthorRepository;
import com.toy.pay.novel.domain.Novel;
import com.toy.pay.novel.domain.NovelRepository;
import com.toy.pay.novel.web.NovelRegisterRequest;

@Service
@Transactional(readOnly = true)
public class NovelService {
    private final AuthorRepository authorRepository;
    private final NovelRepository novelRepository;

    public NovelService(AuthorRepository authorRepository, NovelRepository novelRepository) {
        this.authorRepository = authorRepository;
        this.novelRepository = novelRepository;
    }

    @Transactional
    public Long registerNovel(NovelRegisterRequest request) {
        Author author = findAuthorById(request.getAuthorId());

        Novel novel = new Novel(request.getTitle(), request.getCategory(), author);
        novelRepository.save(novel);

        return novel.getId();
    }

    private Author findAuthorById(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 저자입니다"));
    }
}
