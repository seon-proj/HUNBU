package io.hunsu.hunbu.posting.repository;

import io.hunsu.hunbu.posting.dto.request.PostingRequest;
import io.hunsu.hunbu.posting.dto.response.PostingResponse;
import io.hunsu.hunbu.tables.Posting;
import io.hunsu.hunbu.tables.records.PostingRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class PostingRepository {
    private final DSLContext create;

    public PostingRepository(DSLContext dslContext){
        this.create = dslContext;
    }

    @Transactional
    public void save(String title, String text, Integer userId){
        this.create.insertInto(Posting.POSTING)
                .columns(Posting.POSTING.TITLE, Posting.POSTING.TEXT, Posting.POSTING.CREATED_AT, Posting.POSTING.UPDATED_AT, Posting.POSTING.USER_ID)
                .values(title, text, LocalDateTime.now(), LocalDateTime.now(), userId)
                .execute();
    }
    @Transactional
    public void update(Integer id, String title, String text){
         create.update(Posting.POSTING)
                .set(Posting.POSTING.TITLE, title)
                .set(Posting.POSTING.TEXT, text)
                .set(Posting.POSTING.UPDATED_AT, LocalDateTime.now())
                .where(Posting.POSTING.ID.eq(id))
                 .execute();
    }

    public Optional<PostingResponse> findOne(Integer id){
        Record record = create.selectFrom(Posting.POSTING)
                .where(Posting.POSTING.ID.eq(id))
                .orderBy(Posting.POSTING.CREATED_AT)
                .fetchAny();

        return Optional.of(record.into(PostingResponse.class));
    }

    public Optional<PostingResponse[]> findAll(){
        Result<PostingRecord> fetch = create.selectFrom(Posting.POSTING).fetch();
        PostingResponse[] postings = fetch.intoArray(fetch.size(), PostingResponse.class);
        return Optional.of(postings);
    }


}
