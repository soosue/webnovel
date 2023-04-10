package com.toy.pay.novel.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.toy.pay.novel.service.UserService;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/favorite")
    public ResponseEntity<Void> addFavoriteNovel(@RequestBody FavoriteNovelAddRequest request) {
        userService.addFavoriteNovel(request);
        return ResponseEntity.ok().build();
    }
}
