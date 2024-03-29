package com.skcc.study.jpa.sample.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 2035137990L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member");

    public final DatePath<org.joda.time.LocalDate> birth = createDate("birth", org.joda.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QLocker locker;

    public final ListPath<MemberProduct, QMemberProduct> memberProducts = this.<MemberProduct, QMemberProduct>createList("memberProducts", MemberProduct.class, QMemberProduct.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final QTeam team;

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.locker = inits.isInitialized("locker") ? new QLocker(forProperty("locker"), inits.get("locker")) : null;
        this.team = inits.isInitialized("team") ? new QTeam(forProperty("team")) : null;
    }

}

