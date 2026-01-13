package kr.ac.kumoh.s20260000.spring09backend.model

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "songs")
data class Song(
    @Id val id: String? = null,

    @field:NotBlank(message = "제목은 필수입니다.")
    @field:Size(min = 1, max = 100, message = "제목은 1자에서 100자 사이여야 합니다.")
    val title: String? = null,

    @field:Size(min = 1, max = 50, message = "가수 이름은 1자에서 50자 사이여야 합니다.")
    val singer: String? = null,

    @field:Min(value = 1, message = "평점은 1점 이상이어야 합니다.")
    @field:Max(value = 5, message = "평점은 5점 이하이어야 합니다.")
    val rating: Int = 0,

    @field:Size(max = 5000, message = "가사 내용이 너무 깁니다.")
    val lyrics: String? = null,
)
