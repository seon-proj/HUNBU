package io.hunsu.hunbu.posting.dto.request;

import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostingRequest {
    private final String title;
    private final String text;
    @Nullable
    private final Integer userId;
}
