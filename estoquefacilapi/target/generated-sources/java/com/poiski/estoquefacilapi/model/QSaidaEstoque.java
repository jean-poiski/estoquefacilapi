package com.poiski.estoquefacilapi.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSaidaEstoque is a Querydsl query type for SaidaEstoque
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSaidaEstoque extends EntityPathBase<SaidaEstoque> {

    private static final long serialVersionUID = 1207152614L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSaidaEstoque saidaEstoque = new QSaidaEstoque("saidaEstoque");

    public final QCommonEntity _super = new QCommonEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> dataAlteracao = _super.dataAlteracao;

    //inherited
    public final DateTimePath<java.util.Date> dataInclusao = _super.dataInclusao;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QProduto produto;

    public final NumberPath<Double> quantidade = createNumber("quantidade", Double.class);

    //inherited
    public final StringPath usuarioAlteracao = _super.usuarioAlteracao;

    //inherited
    public final StringPath usuarioInclusao = _super.usuarioInclusao;

    public final NumberPath<Double> valor = createNumber("valor", Double.class);

    public final NumberPath<Double> valorTotal = createNumber("valorTotal", Double.class);

    public QSaidaEstoque(String variable) {
        this(SaidaEstoque.class, forVariable(variable), INITS);
    }

    public QSaidaEstoque(Path<? extends SaidaEstoque> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSaidaEstoque(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSaidaEstoque(PathMetadata metadata, PathInits inits) {
        this(SaidaEstoque.class, metadata, inits);
    }

    public QSaidaEstoque(Class<? extends SaidaEstoque> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.produto = inits.isInitialized("produto") ? new QProduto(forProperty("produto"), inits.get("produto")) : null;
    }

}

