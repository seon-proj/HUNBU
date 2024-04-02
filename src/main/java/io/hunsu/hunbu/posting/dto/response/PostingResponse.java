package io.hunsu.hunbu.posting.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class PostingResponse {
    private final String id;
    private final String title;
    private final String text;
    private final String userId;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
}
