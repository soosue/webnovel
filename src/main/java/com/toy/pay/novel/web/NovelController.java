package com.toy.pay.novel.web;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.toy.pay.novel.service.NovelRegisterRequest;
import com.toy.pay.novel.service.NovelService;
import com.toy.pay.novel.service.NovelWriteRequest;
import com.toy.pay.novel.service.ReaderService;
import com.toy.pay.novel.service.VolumeGetResponse;
import com.toy.pay.novel.service.VolumeService;
import com.toy.pay.security.ReaderId;

@RestController
public class NovelController {
    private final NovelService novelService;
    private final VolumeService volumeService;
    private final ReaderService readerService;

    public NovelController(NovelService novelService, VolumeService volumeService, ReaderService readerService) {
        this.novelService = novelService;
        this.volumeService = volumeService;
        this.readerService = readerService;
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

    @GetMapping("/novel/{novelId}/volume/{volumeId}")
    public ResponseEntity<VolumeGetResponse> readVolume(@PathVariable Long novelId, @PathVariable Long volumeId, @ReaderId Long readerId) {
        VolumeGetResponse response = volumeService.findVolume(volumeId);
        readerService.readVolume(novelId, volumeId, readerId);

        return ResponseEntity.ok(response);
    }
}
