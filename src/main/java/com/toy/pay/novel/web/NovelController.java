package com.toy.pay.novel.web;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.toy.pay.novel.service.NovelService;

@RestController
public class NovelController {
    private final NovelService novelService;

    public NovelController(NovelService novelService) {
        this.novelService = novelService;
    }

    @PostMapping("/novel")
    public ResponseEntity<Void> registerNovel(@RequestBody NovelRegisterRequest request) {

        Long novelId = novelService.registerNovel(request);

        return ResponseEntity.created(URI.create("/novel/" + novelId)).build();
    }
}
