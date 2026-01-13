package kr.ac.kumoh.s20260000.spring09backend.exception

import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

// 공통 에러 응답을 위한 DTO (Data Transfer Object)
data class ErrorResponse(
    val message: String,
    val code: String,
    val traceId: String? = null,
    val timestamp: LocalDateTime = LocalDateTime.now(),
)

@RestControllerAdvice
class GlobalExceptionHandler {
    companion object {
        private val log = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(
        e: IllegalArgumentException
    ): ResponseEntity<ErrorResponse> {
        log.warn("잘못된 요청 발생: {}", e.message)

        val errorBody = ErrorResponse(
            message = e.message ?: "잘못된 요청입니다.",
            code = "BAD_REQUEST_001",
            traceId = MDC.get("traceId")
        )
        return ResponseEntity
            .badRequest()
            .body(errorBody)
    }
}