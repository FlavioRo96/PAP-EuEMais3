drop sequence tipoconta_seq;
drop sequence enderecousuario_seq;
drop sequence usuario_seq;
drop sequence filme_seq;
drop table tipoconta cascade constraint;
drop table enderecousuario cascade constraint;
drop table usuario cascade constraint;
drop table filme cascade constraint;


create sequence tipoconta_seq increment by 1
    start with 1 nocache nocycle;
create sequence enderecousuario_seq increment by 1
    start with 1 nocache nocycle;
create sequence usuario_seq increment by 1
    start with 1 nocache nocycle;
create sequence filme_seq increment by 1
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
    
    constraint fkTipoConta
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

    constraint fkUsuario
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





