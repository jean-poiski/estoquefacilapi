package com.poiski.estoquefacilapi.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDespesa is a Querydsl query type for Despesa
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDespesa extends EntityPathBase<Despesa> {

    private static final long serialVersionUID = -631828433L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDespesa despesa = new QDespesa("despesa");

    public final QCommonEntity _super = new QCommonEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> dataAlteracao = _super.dataAlteracao;

    //inherited
    public final DateTimePath<java.util.Date> dataInclusao = _super.dataInclusao;

    public final StringPath descricao = createString("descricao");

    public final QEntradaEstoque estoque;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath observacoes = createString("observacoes");

    //inherited
    public final StringPath usuarioAlteracao = _super.usuarioAlteracao;

    //inherited
    public final StringPath usuarioInclusao = _super.usuarioInclusao;

    public final NumberPath<Double> valor = createNumber("valor", Double.class);

    public QDespesa(String variable) {
        this(Despesa.class, forVariable(variable), INITS);
    }

    public QDespesa(Path<? extends Despesa> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDespesa(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDespesa(PathMetadata metadata, PathInits inits) {
        this(Despesa.class, metadata, inits);
    }

    public QDespesa(Class<? extends Despesa> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.estoque = inits.isInitialized("estoque") ? new QEntradaEstoque(forProperty("estoque"), inits.get("estoque")) : null;
    }

}

