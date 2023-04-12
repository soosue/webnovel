package com.toy.pay.novel.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.toy.pay.novel.service.FavoriteNovelAddRequest;
import com.toy.pay.novel.service.FavoriteNovelGetResponse;
import com.toy.pay.novel.service.ReaderService;
import com.toy.pay.security.ReaderId;

@RestController
public class ReaderController {
    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @PostMapping("/favorite")
    public ResponseEntity<Void> addFavoriteNovel(@RequestBody FavoriteNovelAddRequest request, @ReaderId Long readerId) {
        readerService.addFavoriteNovel(request, readerId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/favorite")
    public ResponseEntity<ListResponse<FavoriteNovelGetResponse>> getFavoriteNovel(@ReaderId Long readerId) {

        return ResponseEntity.ok(readerService.getFavoriteNovel(readerId));
    }
}
