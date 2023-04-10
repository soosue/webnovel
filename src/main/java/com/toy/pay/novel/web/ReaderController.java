package com.toy.pay.novel.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.toy.pay.novel.service.ReaderService;

@RestController
public class ReaderController {
    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @PostMapping("/favorite")
    public ResponseEntity<Void> addFavoriteNovel(@RequestBody FavoriteNovelAddRequest request) {
        readerService.addFavoriteNovel(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/favorite")
    public ResponseEntity<ListResponse<FavoriteNovelGetResponse>> getFavoriteNovel(@RequestBody FavoriteNovelGetRequest request) {

        return ResponseEntity.ok(readerService.getFavoriteNovel(request));
    }
}
