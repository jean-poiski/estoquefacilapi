package com.poiski.estoquefacilapi.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduto is a Querydsl query type for Produto
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProduto extends EntityPathBase<Produto> {

    private static final long serialVersionUID = 1796423955L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduto produto = new QProduto("produto");

    public final QCommonEntity _super = new QCommonEntity(this);

    public final StringPath codigoBarras = createString("codigoBarras");

    //inherited
    public final DateTimePath<java.util.Date> dataAlteracao = _super.dataAlteracao;

    //inherited
    public final DateTimePath<java.util.Date> dataInclusao = _super.dataInclusao;

    public final StringPath descricao = createString("descricao");

    public final QFornecedor fornecedor;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath observacoes = createString("observacoes");

    public final EnumPath<com.poiski.estoquefacilapi.enums.TipoEmbalagem> tipoEmbalagem = createEnum("tipoEmbalagem", com.poiski.estoquefacilapi.enums.TipoEmbalagem.class);

    public final EnumPath<com.poiski.estoquefacilapi.enums.Categoria> tipoProduto = createEnum("tipoProduto", com.poiski.estoquefacilapi.enums.Categoria.class);

    //inherited
    public final StringPath usuarioAlteracao = _super.usuarioAlteracao;

    //inherited
    public final StringPath usuarioInclusao = _super.usuarioInclusao;

    public final NumberPath<Double> valor = createNumber("valor", Double.class);

    public QProduto(String variable) {
        this(Produto.class, forVariable(variable), INITS);
    }

    public QProduto(Path<? extends Produto> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduto(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduto(PathMetadata metadata, PathInits inits) {
        this(Produto.class, metadata, inits);
    }

    public QProduto(Class<? extends Produto> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.fornecedor = inits.isInitialized("fornecedor") ? new QFornecedor(forProperty("fornecedor")) : null;
    }

}

