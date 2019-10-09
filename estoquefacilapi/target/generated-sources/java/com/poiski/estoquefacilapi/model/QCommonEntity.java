package com.poiski.estoquefacilapi.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommonEntity is a Querydsl query type for CommonEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QCommonEntity extends EntityPathBase<CommonEntity> {

    private static final long serialVersionUID = -783848492L;

    public static final QCommonEntity commonEntity = new QCommonEntity("commonEntity");

    public final DateTimePath<java.util.Date> dataAlteracao = createDateTime("dataAlteracao", java.util.Date.class);

    public final DateTimePath<java.util.Date> dataInclusao = createDateTime("dataInclusao", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath usuarioAlteracao = createString("usuarioAlteracao");

    public final StringPath usuarioInclusao = createString("usuarioInclusao");

    public QCommonEntity(String variable) {
        super(CommonEntity.class, forVariable(variable));
    }

    public QCommonEntity(Path<? extends CommonEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommonEntity(PathMetadata metadata) {
        super(CommonEntity.class, metadata);
    }

}

