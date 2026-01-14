package kr.ac.kumoh.s20260000.spring09backend.controller

import jakarta.validation.Valid
import kr.ac.kumoh.s20260000.spring09backend.model.Song
import kr.ac.kumoh.s20260000.spring09backend.service.SongService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/api/v1/songs")
@CrossOrigin(origins = ["http://localhost:5173"])
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

    @PostMapping
    fun create(@Valid @RequestBody song: Song): ResponseEntity<Song> {
        log.info("노래 등록 시작: $song")

        val saved = service.registerSong(song)

        log.info("노래 등록 성공: $saved")

        return ResponseEntity
            .created(URI("/api/v1/songs/${saved.id}"))
            .body(saved)
    }
}