package com.toy.pay.novel.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toy.pay.novel.domain.Volume;
import com.toy.pay.novel.domain.VolumeRepository;

@Service
@Transactional(readOnly = true)
public class VolumeService {
    private final VolumeRepository volumeRepository;

    public VolumeService(VolumeRepository volumeRepository) {
        this.volumeRepository = volumeRepository;
    }

    public VolumeGetResponse findVolume(Long id) {
        Volume volume = findVolumeById(id);
        return new VolumeGetResponse(volume);
    }

    private Volume findVolumeById(Long id) {
        return volumeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 편입니다"));
    }
}
