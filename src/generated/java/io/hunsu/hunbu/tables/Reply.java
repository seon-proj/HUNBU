/*
 * This file is generated by jOOQ.
 */
package io.hunsu.hunbu.tables;


import io.hunsu.hunbu.Hunbu;
import io.hunsu.hunbu.Keys;
import io.hunsu.hunbu.tables.Reply.ReplyPath;
import io.hunsu.hunbu.tables.records.ReplyRecord;

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
public class Reply extends TableImpl<ReplyRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>hunbu.REPLY</code>
     */
    public static final Reply REPLY = new Reply();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ReplyRecord> getRecordType() {
        return ReplyRecord.class;
    }

    /**
     * The column <code>hunbu.REPLY.ID</code>.
     */
    public final TableField<ReplyRecord, Integer> ID = createField(DSL.name("ID"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>hunbu.REPLY.USER_ID</code>.
     */
    public final TableField<ReplyRecord, Integer> USER_ID = createField(DSL.name("USER_ID"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>hunbu.REPLY.TEXT</code>.
     */
    public final TableField<ReplyRecord, String> TEXT = createField(DSL.name("TEXT"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>hunbu.REPLY.PARENT_REPLY_ID</code>.
     */
    public final TableField<ReplyRecord, Integer> PARENT_REPLY_ID = createField(DSL.name("PARENT_REPLY_ID"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>hunbu.REPLY.POSTING_ID</code>.
     */
    public final TableField<ReplyRecord, Integer> POSTING_ID = createField(DSL.name("POSTING_ID"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>hunbu.REPLY.CREATED_AT</code>.
     */
    public final TableField<ReplyRecord, LocalDateTime> CREATED_AT = createField(DSL.name("CREATED_AT"), SQLDataType.LOCALDATETIME(0), this, "");

    /**
     * The column <code>hunbu.REPLY.UPDATED_AT</code>.
     */
    public final TableField<ReplyRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("UPDATED_AT"), SQLDataType.LOCALDATETIME(0), this, "");

    private Reply(Name alias, Table<ReplyRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Reply(Name alias, Table<ReplyRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>hunbu.REPLY</code> table reference
     */
    public Reply(String alias) {
        this(DSL.name(alias), REPLY);
    }

    /**
     * Create an aliased <code>hunbu.REPLY</code> table reference
     */
    public Reply(Name alias) {
        this(alias, REPLY);
    }

    /**
     * Create a <code>hunbu.REPLY</code> table reference
     */
    public Reply() {
        this(DSL.name("REPLY"), null);
    }

    public <O extends Record> Reply(Table<O> path, ForeignKey<O, ReplyRecord> childPath, InverseForeignKey<O, ReplyRecord> parentPath) {
        super(path, childPath, parentPath, REPLY);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class ReplyPath extends Reply implements Path<ReplyRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> ReplyPath(Table<O> path, ForeignKey<O, ReplyRecord> childPath, InverseForeignKey<O, ReplyRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private ReplyPath(Name alias, Table<ReplyRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public ReplyPath as(String alias) {
            return new ReplyPath(DSL.name(alias), this);
        }

        @Override
        public ReplyPath as(Name alias) {
            return new ReplyPath(alias, this);
        }

        @Override
        public ReplyPath as(Table<?> alias) {
            return new ReplyPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Hunbu.HUNBU;
    }

    @Override
    public Identity<ReplyRecord, Integer> getIdentity() {
        return (Identity<ReplyRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<ReplyRecord> getPrimaryKey() {
        return Keys.KEY_REPLY_PRIMARY;
    }

    @Override
    public List<ForeignKey<ReplyRecord, ?>> getReferences() {
        return Arrays.asList(Keys.PARENT_REPLY_ID_FK);
    }

    private transient ReplyPath _reply;

    /**
     * Get the implicit join path to the <code>hunbu.REPLY</code> table.
     */
    public ReplyPath reply() {
        if (_reply == null)
            _reply = new ReplyPath(this, Keys.PARENT_REPLY_ID_FK, null);

        return _reply;
    }

    @Override
    public Reply as(String alias) {
        return new Reply(DSL.name(alias), this);
    }

    @Override
    public Reply as(Name alias) {
        return new Reply(alias, this);
    }

    @Override
    public Reply as(Table<?> alias) {
        return new Reply(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Reply rename(String name) {
        return new Reply(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Reply rename(Name name) {
        return new Reply(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Reply rename(Table<?> name) {
        return new Reply(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Reply where(Condition condition) {
        return new Reply(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Reply where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Reply where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Reply where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Reply where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Reply where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Reply where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Reply where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Reply whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Reply whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
