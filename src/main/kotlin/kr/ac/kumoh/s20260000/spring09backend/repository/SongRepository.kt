package kr.ac.kumoh.s20260000.spring09backend.repository

import kr.ac.kumoh.s20260000.spring09backend.model.Song
import org.springframework.data.mongodb.repository.MongoRepository

interface SongRepository : MongoRepository<Song, String> {
}