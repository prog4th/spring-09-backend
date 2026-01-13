package kr.ac.kumoh.s20260000.spring09backend.service

import kr.ac.kumoh.s20260000.spring09backend.model.Song
import kr.ac.kumoh.s20260000.spring09backend.repository.SongRepository
import org.springframework.stereotype.Service

@Service
class SongService(
    private val repository: SongRepository
) {
    fun getAllSongs(): List<Song> = repository.findAll()
    fun getSongById(id: String): Song?
            = repository.findById(id).orElseThrow {
        IllegalArgumentException("노래(${id})를 찾을 수 없습니다.")
    }
    fun registerSong(song: Song): Song = repository.save(song)
}