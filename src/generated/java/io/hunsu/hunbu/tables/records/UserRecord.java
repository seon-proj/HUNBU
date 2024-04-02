/*
 * This file is generated by jOOQ.
 */
package io.hunsu.hunbu.tables.records;


import io.hunsu.hunbu.tables.User;

import java.time.LocalDateTime;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>hunbu.USER.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>hunbu.USER.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>hunbu.USER.NAME</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>hunbu.USER.NAME</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>hunbu.USER.EMAIL</code>.
     */
    public void setEmail(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>hunbu.USER.EMAIL</code>.
     */
    public String getEmail() {
        return (String) get(2);
    }

    /**
     * Setter for <code>hunbu.USER.LV</code>.
     */
    public void setLv(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>hunbu.USER.LV</code>.
     */
    public Integer getLv() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>hunbu.USER.CREATED_AT</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>hunbu.USER.CREATED_AT</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>hunbu.USER.UPDATED_AT</code>.
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>hunbu.USER.UPDATED_AT</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(Integer id, String name, String email, Integer lv, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(User.USER);

        setId(id);
        setName(name);
        setEmail(email);
        setLv(lv);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        resetChangedOnNotNull();
    }
}
