package io.hunsu.hunbu.user.repository;

import io.hunsu.hunbu.tables.Posting;
import io.hunsu.hunbu.tables.User;
import io.hunsu.hunbu.tables.records.PostingRecord;
import io.hunsu.hunbu.tables.records.UserRecord;
import io.hunsu.hunbu.user.dto.response.UserResponse;
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
public class UserRepository {
    private final DSLContext create;

    public UserRepository(DSLContext dslContext){
        this.create = dslContext;
    }

    @Transactional
    public void save(String name, String email, Integer lv){
        this.create.insertInto(User.USER)
                .columns(User.USER.NAME, User.USER.EMAIL, User.USER.LV, User.USER.CREATED_AT, User.USER.UPDATED_AT)
                .values(name, email, lv, LocalDateTime.now(), LocalDateTime.now())
                .execute();
    }
    @Transactional
    public void update(Integer id, String name, String email){
         create.update(User.USER)
                .set(User.USER.NAME, name )
                .set(User.USER.EMAIL, email)
                .set(User.USER.UPDATED_AT, LocalDateTime.now())
                .where(User.USER.ID.eq(id))
                 .execute();
    }

    public Optional<UserResponse> findOne(Integer id){
        Record record = create.selectFrom(User.USER)
                .where(User.USER.ID.eq(id))
                .orderBy(User.USER.CREATED_AT)
                .fetchAny();

        return Optional.of(record.into(UserResponse.class));
    }

    public Optional<List<UserResponse>> findAll(){
        Result<UserRecord> fetch = create.selectFrom(User.USER).fetch();
        List<UserResponse> list = fetch.into(UserResponse.class);
        return Optional.of(list);
    }


}
