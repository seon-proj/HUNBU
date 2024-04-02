/*
 * This file is generated by jOOQ.
 */
package io.hunsu.hunbu.tables;


import io.hunsu.hunbu.Hunbu;
import io.hunsu.hunbu.Keys;
import io.hunsu.hunbu.tables.User.UserPath;
import io.hunsu.hunbu.tables.records.PostingRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Posting extends TableImpl<PostingRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>hunbu.POSTING</code>
     */
    public static final Posting POSTING = new Posting();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PostingRecord> getRecordType() {
        return PostingRecord.class;
    }

    /**
     * The column <code>hunbu.POSTING.ID</code>.
     */
    public final TableField<PostingRecord, Integer> ID = createField(DSL.name("ID"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>hunbu.POSTING.TITLE</code>.
     */
    public final TableField<PostingRecord, String> TITLE = createField(DSL.name("TITLE"), SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>hunbu.POSTING.USER_ID</code>.
     */
    public final TableField<PostingRecord, Integer> USER_ID = createField(DSL.name("USER_ID"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>hunbu.POSTING.TEXT</code>.
     */
    public final TableField<PostingRecord, String> TEXT = createField(DSL.name("TEXT"), SQLDataType.VARCHAR(140), this, "");

    /**
     * The column <code>hunbu.POSTING.CREATED_AT</code>.
     */
    public final TableField<PostingRecord, LocalDateTime> CREATED_AT = createField(DSL.name("CREATED_AT"), SQLDataType.LOCALDATETIME(0), this, "");

    /**
     * The column <code>hunbu.POSTING.UPDATED_AT</code>.
     */
    public final TableField<PostingRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("UPDATED_AT"), SQLDataType.LOCALDATETIME(0), this, "");

    private Posting(Name alias, Table<PostingRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Posting(Name alias, Table<PostingRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>hunbu.POSTING</code> table reference
     */
    public Posting(String alias) {
        this(DSL.name(alias), POSTING);
    }

    /**
     * Create an aliased <code>hunbu.POSTING</code> table reference
     */
    public Posting(Name alias) {
        this(alias, POSTING);
    }

    /**
     * Create a <code>hunbu.POSTING</code> table reference
     */
    public Posting() {
        this(DSL.name("POSTING"), null);
    }

    public <O extends Record> Posting(Table<O> path, ForeignKey<O, PostingRecord> childPath, InverseForeignKey<O, PostingRecord> parentPath) {
        super(path, childPath, parentPath, POSTING);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class PostingPath extends Posting implements Path<PostingRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> PostingPath(Table<O> path, ForeignKey<O, PostingRecord> childPath, InverseForeignKey<O, PostingRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private PostingPath(Name alias, Table<PostingRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public PostingPath as(String alias) {
            return new PostingPath(DSL.name(alias), this);
        }

        @Override
        public PostingPath as(Name alias) {
            return new PostingPath(alias, this);
        }

        @Override
        public PostingPath as(Table<?> alias) {
            return new PostingPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Hunbu.HUNBU;
    }

    @Override
    public Identity<PostingRecord, Integer> getIdentity() {
        return (Identity<PostingRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<PostingRecord> getPrimaryKey() {
        return Keys.KEY_POSTING_PRIMARY;
    }

    @Override
    public List<ForeignKey<PostingRecord, ?>> getReferences() {
        return Arrays.asList(Keys.USER_ID_FK);
    }

    private transient UserPath _user;

    /**
     * Get the implicit join path to the <code>hunbu.USER</code> table.
     */
    public UserPath user() {
        if (_user == null)
            _user = new UserPath(this, Keys.USER_ID_FK, null);

        return _user;
    }

    @Override
    public Posting as(String alias) {
        return new Posting(DSL.name(alias), this);
    }

    @Override
    public Posting as(Name alias) {
        return new Posting(alias, this);
    }

    @Override
    public Posting as(Table<?> alias) {
        return new Posting(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Posting rename(String name) {
        return new Posting(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Posting rename(Name name) {
        return new Posting(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Posting rename(Table<?> name) {
        return new Posting(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Posting where(Condition condition) {
        return new Posting(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Posting where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Posting where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Posting where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Posting where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Posting where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Posting where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Posting where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Posting whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Posting whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
