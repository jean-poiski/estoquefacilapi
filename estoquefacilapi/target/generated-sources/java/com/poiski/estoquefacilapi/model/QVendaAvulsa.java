package com.poiski.estoquefacilapi.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVendaAvulsa is a Querydsl query type for VendaAvulsa
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVendaAvulsa extends EntityPathBase<VendaAvulsa> {

    private static final long serialVersionUID = 1200173424L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVendaAvulsa vendaAvulsa = new QVendaAvulsa("vendaAvulsa");

    public final QCommonEntity _super = new QCommonEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> dataAlteracao = _super.dataAlteracao;

    //inherited
    public final DateTimePath<java.util.Date> dataInclusao = _super.dataInclusao;

    public final QSaidaEstoque estoque;

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

    public QVendaAvulsa(String variable) {
        this(VendaAvulsa.class, forVariable(variable), INITS);
    }

    public QVendaAvulsa(Path<? extends VendaAvulsa> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVendaAvulsa(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVendaAvulsa(PathMetadata metadata, PathInits inits) {
        this(VendaAvulsa.class, metadata, inits);
    }

    public QVendaAvulsa(Class<? extends VendaAvulsa> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.estoque = inits.isInitialized("estoque") ? new QSaidaEstoque(forProperty("estoque"), inits.get("estoque")) : null;
        this.produto = inits.isInitialized("produto") ? new QProduto(forProperty("produto"), inits.get("produto")) : null;
    }

}

