package com.toy.pay.novel.web;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/novel/{id}")
    public ResponseEntity<Void> writeNovel(@PathVariable Long id, @RequestBody NovelWriteRequest request) {

        Long volumeId = novelService.writeNovel(id, request);

        return ResponseEntity.created(URI.create("/novel/" + id + "/" + volumeId)).build();
    }

    @DeleteMapping("/novel/{id}")
    public ResponseEntity<Void> deleteNovel(@PathVariable Long id) {
        novelService.deleteNovel(id);
        return ResponseEntity.ok().build();
    }
}
