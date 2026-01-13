package kr.ac.kumoh.s20260000.spring09backend.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "songs")
data class Song(
    @Id val id: String? = null,
    val title: String? = null,
    val singer: String? = null,
    val rating: Int,
    val lyrics: String? = null,
)
