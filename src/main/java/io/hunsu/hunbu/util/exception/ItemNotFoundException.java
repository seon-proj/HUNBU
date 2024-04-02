package io.hunsu.hunbu.util.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(String msg){
        super(msg);
    }
}
