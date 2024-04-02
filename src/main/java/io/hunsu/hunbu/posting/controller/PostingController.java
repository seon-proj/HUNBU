package io.hunsu.hunbu.posting.controller;

import io.hunsu.hunbu.posting.dto.request.PostingRequest;
import io.hunsu.hunbu.posting.dto.response.PostingResponse;
import io.hunsu.hunbu.posting.service.PostingService;
import io.hunsu.hunbu.util.exception.rest.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hunsu/posting")
public class PostingController {

    private final PostingService postingService;

    @GetMapping("/{post_id}")
    public RestResponse<PostingResponse> getPosting(@PathVariable(name = "post_id") Integer id){
        return new RestResponse<>(postingService.getPosting(id), HttpStatus.OK.value());
    }

    @GetMapping
    public RestResponse<PostingResponse[]> getAllPosting(){
        return new RestResponse<>(postingService.getAllPosting(), HttpStatus.OK.value());
    }

    @PostMapping
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public RestResponse<?> createPosting(@RequestBody PostingRequest request){
        postingService.createPosting(request.getTitle(), request.getText(), request.getUserId());
        return new RestResponse<>("포스팅 성공", HttpStatus.OK.value());
    }

    @PutMapping("/{post_id}")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public RestResponse<?> updatePosting(@RequestBody PostingRequest request , @PathVariable(name = "post_id") Integer id) throws ClassNotFoundException{
        postingService.updatePosting(request.getTitle(), request.getText(), id);
        return new RestResponse<>("업데이트 성공", HttpStatus.OK.value());
    }
}
