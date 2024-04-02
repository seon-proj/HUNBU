package io.hunsu.hunbu.util.exception.handler;

import io.hunsu.hunbu.util.exception.ItemNotFoundException;
import io.hunsu.hunbu.util.exception.response.ErrorResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler  {
    @Getter
    @RequiredArgsConstructor
    public enum CustomErrorCode{
        POSTING_NOT_EXIST_CODE(404, "해당하는 포스팅이 존재하지 않습니다.");

        private final int statusCode;
        private final String description;
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(ItemNotFoundException ex){
        final ErrorResponse err = ErrorResponse.builder()
                .customCode("POSTING_NOT_EXIST_CODE")
                .message(ex.getMessage())
                .statusCode(CustomErrorCode.POSTING_NOT_EXIST_CODE.getStatusCode())
                .build();
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}
