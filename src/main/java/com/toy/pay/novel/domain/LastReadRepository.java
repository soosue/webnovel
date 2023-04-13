package com.toy.pay.novel.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LastReadRepository extends JpaRepository<LastRead, Long> {
    Optional<LastRead> findByReaderIdAndNovelId(Long readerId, Long novelId);
}
