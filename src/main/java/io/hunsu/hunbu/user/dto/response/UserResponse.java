package io.hunsu.hunbu.user.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class UserResponse {
    private final Integer id;
    private final String name;
    private final String email;
    private final Integer lv;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
}
