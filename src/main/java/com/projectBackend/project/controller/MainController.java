package com.projectBackend.project.controller;

import com.projectBackend.project.dto.MusicUserDto;
import com.projectBackend.project.dto.PerformanceDto;
import com.projectBackend.project.service.MusicService;
import com.projectBackend.project.service.PerformanceService;
import com.projectBackend.project.service.PerformerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@Setter
@Getter
@ToString
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {
    private  final MusicService musicService;
    private final PerformanceService performanceService;

    // 조영준
    // 음악 판매순 정렬
    @GetMapping("/mainTop")
    public ResponseEntity<List<MusicUserDto>> mainTop () {
        return ResponseEntity.ok(musicService.musicSortList());
    }

    // 음악 새로운 등록 순서
    @GetMapping("/newSong")
    public  ResponseEntity<List<MusicUserDto>> newList () {
        return ResponseEntity.ok(musicService.newSongList());
    }

    // 공연 광고 영역
    @GetMapping("/perfromance/comarcial")
    public ResponseEntity<List<PerformanceDto>> performList () {
        return ResponseEntity.ok(performanceService.getPerformanceComercial());
    }
}
