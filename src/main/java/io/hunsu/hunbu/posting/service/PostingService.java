package io.hunsu.hunbu.posting.service;

import io.hunsu.hunbu.posting.dto.response.PostingResponse;
import io.hunsu.hunbu.posting.repository.PostingRepository;
import io.hunsu.hunbu.util.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;

    public PostingResponse getPosting(Integer id){
        return postingRepository.findOne(id).orElseThrow(() -> new ItemNotFoundException("해당 포스팅이 존재하지 않습니다"));
    }

    public List<PostingResponse> getAllPosting(){

        return postingRepository.findAll().orElseThrow(() -> new ItemNotFoundException("포스팅이 0건 존재합니다."));
    }

    public void createPosting(String title, String text, Integer userId){
        postingRepository.save(title, text, userId);
    }

    public void updatePosting(String title, String text, Integer id)  {
        postingRepository.update(id, title, text);
    }

}
