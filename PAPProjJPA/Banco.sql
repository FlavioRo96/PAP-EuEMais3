drop sequence tipoconta_seq;
drop sequence enderecousuario_seq;
drop sequence usuario_seq;
drop sequence filme_seq;
drop sequence fornecedor_seq;
drop sequence enderecofornecedor_seq;
drop sequence sala_seq;
drop table tipoconta cascade constraint;
drop table enderecousuario cascade constraint;
drop table usuario cascade constraint;
drop table filme cascade constraint;
drop table fornecedor cascade constraint;
drop table enderecofornecedor cascade constraint;
drop table sala cascade constraint;


create sequence tipoconta_seq increment by 1
    start with 1 nocache nocycle;
create sequence enderecousuario_seq increment by 1
    start with 1 nocache nocycle;
create sequence usuario_seq increment by 1
    start with 1 nocache nocycle;
create sequence filme_seq increment by 1
    start with 1 nocache nocycle;
create sequence fornecedor_seq increment by 1
    start with 1 nocache nocycle;
create sequence enderecofornecedor_seq increment by 1
    start with 1 nocache nocycle;
create sequence sala_seq increment by 1
    start with 1 nocache nocycle;

create table tipoconta (
    id number(5) primary key not null,
    tipoConta varchar2(7) unique not null,
    descricao varchar2(60)
);

create table usuario (
    id number(5) primary key not null,
    usuario varchar2(20) unique not null,
    nome varchar2(20) not null,
    sobrenome varchar(50),
    dataNasc date not null,
    idTipoConta number(5) not null,
    
    constraint fkUsuarioTipoConta
        foreign key(idTipoConta) references tipoconta(id)
);

create table enderecousuario (
    id number(5) primary key not null,
    idUsuario number(5) not null,
    rua varchar2(40) not null,
    numero varchar2(6) not null,
    bairro varchar2(25) not null,
    complemento varchar2(100),
    cep varchar2(8) not null,
    uf varchar2(2) not null,
    cidade varchar2(40) not null,

    constraint fkEnderecoUsuarioUsuario
        foreign key(idUsuario) references usuario(id)
    
);

create table filme (
    id number(5) primary key not null,
    nome varchar2(60) not null,
    sinopse varchar2(3000) not null,
    anoProducao date,
    direcao varchar2(100),
    distribuidor varchar2(40) not null,
    duracao date not null,
    genero varchar2(50) not null,
    elenco varchar2(500),
    nacionalidade varchar2(30),
    idioma varchar2(30),
    cor varchar2(15),
    formatoAudio varchar2(50)
);

create table fornecedor (
    id number(5) primary key not null,
    nome varchar2(30) not null,
    telefone varchar2(13)
);

create table enderecofornecedor (
    id number(5) primary key not null,
    idFornecedor number(5) not null,
    rua varchar2(40) not null,
    numero varchar2(6) not null,
    bairro varchar2(25) not null,
    complemento varchar2(100),
    cep varchar2(8) not null,
    uf varchar2(2) not null,
    cidade varchar2(40) not null,

    constraint fkEnderecoFornecedorFornecedor
        foreign key(idFornecedor) references fornecedor(id)
);

create table sala (
    id number(5) primary key not null,
    nome varchar2(7) not null,
    idFornecedor number(5) not null,

    constraint fkSalaFornecedor
        foreign key(idFornecedor) references fornecedor(id)
);