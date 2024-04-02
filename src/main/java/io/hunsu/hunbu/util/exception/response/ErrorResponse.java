package io.hunsu.hunbu.util.exception.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private Integer statusCode;
    private String customCode;

    public ErrorResponse(String message, HttpStatus code){
        this.message = message;
        this.statusCode = code.value();
        this.customCode = code.getReasonPhrase();
    }
}
