package io.hunsu.hunbu.user.dto.request;

import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRequest {
    private final String name;
    private final String email;
}
