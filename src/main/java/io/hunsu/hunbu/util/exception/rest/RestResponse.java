package io.hunsu.hunbu.util.exception.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
@Getter
@Builder
@AllArgsConstructor
public class RestResponse<T> {
    private T body;
    private Integer code;
    RestResponse(ResponseEntity<T> response){
        this.body = response.getBody();
        this.code = response.getStatusCode().value();
    }
}
