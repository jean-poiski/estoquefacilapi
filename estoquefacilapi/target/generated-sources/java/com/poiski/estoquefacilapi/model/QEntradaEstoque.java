package com.poiski.estoquefacilapi.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEntradaEstoque is a Querydsl query type for EntradaEstoque
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEntradaEstoque extends EntityPathBase<EntradaEstoque> {

    private static final long serialVersionUID = 1285296327L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEntradaEstoque entradaEstoque = new QEntradaEstoque("entradaEstoque");

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

    public QEntradaEstoque(String variable) {
        this(EntradaEstoque.class, forVariable(variable), INITS);
    }

    public QEntradaEstoque(Path<? extends EntradaEstoque> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEntradaEstoque(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEntradaEstoque(PathMetadata metadata, PathInits inits) {
        this(EntradaEstoque.class, metadata, inits);
    }

    public QEntradaEstoque(Class<? extends EntradaEstoque> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.produto = inits.isInitialized("produto") ? new QProduto(forProperty("produto"), inits.get("produto")) : null;
    }

}

