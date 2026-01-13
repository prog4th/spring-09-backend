package kr.ac.kumoh.s20260000.spring09backend.controller

import kr.ac.kumoh.s20260000.spring09backend.model.Song
import kr.ac.kumoh.s20260000.spring09backend.service.SongService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/songs")
class SongController(
    private val service: SongService
) {
    companion object {
        private val log = LoggerFactory.getLogger(SongController::class.java)
    }

    @GetMapping
    fun list(): ResponseEntity<List<Song>> {
        log.info("노래 목록 조회 요청")

        return ResponseEntity.ok(service.getAllSongs())
    }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: String): ResponseEntity<Song> {
        log.info("노래 상세 조회 - ID: $id")

        val song = service.getSongById(id)

        log.info("노래 상세 조회 성공 - 제목: {}", song?.title)

        return ResponseEntity.ok(song)
    }
}