package com.poiski.estoquefacilapi.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFornecedor is a Querydsl query type for Fornecedor
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFornecedor extends EntityPathBase<Fornecedor> {

    private static final long serialVersionUID = 1515700491L;

    public static final QFornecedor fornecedor = new QFornecedor("fornecedor");

    public final QCommonEntity _super = new QCommonEntity(this);

    public final StringPath bairro = createString("bairro");

    public final StringPath celular = createString("celular");

    public final NumberPath<Long> cep = createNumber("cep", Long.class);

    public final StringPath cidade = createString("cidade");

    public final StringPath cnpj = createString("cnpj");

    public final StringPath complemento = createString("complemento");

    //inherited
    public final DateTimePath<java.util.Date> dataAlteracao = _super.dataAlteracao;

    //inherited
    public final DateTimePath<java.util.Date> dataInclusao = _super.dataInclusao;

    public final StringPath email = createString("email");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Long> numero = createNumber("numero", Long.class);

    public final StringPath observacoes = createString("observacoes");

    public final StringPath razaoSocial = createString("razaoSocial");

    public final StringPath rua = createString("rua");

    public final StringPath telefone = createString("telefone");

    public final StringPath uf = createString("uf");

    //inherited
    public final StringPath usuarioAlteracao = _super.usuarioAlteracao;

    //inherited
    public final StringPath usuarioInclusao = _super.usuarioInclusao;

    public QFornecedor(String variable) {
        super(Fornecedor.class, forVariable(variable));
    }

    public QFornecedor(Path<? extends Fornecedor> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFornecedor(PathMetadata metadata) {
        super(Fornecedor.class, metadata);
    }

}

