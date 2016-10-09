drop table tipoconta cascade constraints;
drop table enderecousuario cascade constraints;
drop table usuario cascade constraints;
drop table filme cascade constraints;
drop table fornecedor cascade constraints;
drop table enderecofornecedor cascade constraints;
drop table sala cascade constraints;
drop table sessao cascade constraints;
drop table usuario_enderecousuario cascade constraints;
drop table fornecedor_enderecofornecedor cascade constraints;
drop table cor cascade constraints;
drop table distribuidor cascade constraints;
drop table elenco cascade constraints;
drop table formato cascade constraints;
drop table genero cascade constraints;
drop table nacionalidade cascade constraints;
drop table elenco_nacionalidade cascade constraints;
drop table idioma cascade constraints;
drop table filme_elenco cascade constraints;
drop table filme_formato cascade constraints;
drop table filme_genero cascade constraints;
drop table cadeira cascade constraints;
drop table sessao_cadeira cascade constraints;


drop sequence tipoconta_seq;
drop sequence enderecousuario_seq;
drop sequence usuario_seq;
drop sequence filme_seq;
drop sequence fornecedor_seq;
drop sequence enderecofornecedor_seq;
drop sequence sala_seq;
drop sequence sessao_seq;
drop sequence cor_seq;
drop sequence distribuidor_seq;
drop sequence elenco_seq;
drop sequence formato_seq;
drop sequence genero_seq;
drop sequence nacionalidade_seq;
drop sequence elenco_nacionalidade_seq;
drop sequence idioma_seq;
drop sequence filme_elenco_seq;
drop sequence filme_formatoaudio_seq;
drop sequence filme_genero_seq;
drop sequence cadeira_seq;
drop sequence sessao_cadeira_seq;


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
create sequence sessao_seq increment by 1
    start with 1 nocache nocycle;
create sequence cor_seq increment by 1
    start with 1 nocache nocycle;
create sequence distribuidor_seq increment by 1
    start with 1 nocache nocycle;
create sequence elenco_seq increment by 1
    start with 1 nocache nocycle;
create sequence formato_seq increment by 1
    start with 1 nocache nocycle;
create sequence genero_seq increment by 1
    start with 1 nocache nocycle;
create sequence nacionalidade_seq increment by 1
    start with 1 nocache nocycle;
create sequence elenco_nacionalidade_seq increment by 1
    start with 1 nocache nocycle;
create sequence idioma_seq increment by 1
    start with 1 nocache nocycle;
create sequence filme_elenco_seq increment by 1
    start with 1 nocache nocycle;
create sequence filme_formatoaudio_seq increment by 1
    start with 1 nocache nocycle;
create sequence filme_genero_seq increment by 1
    start with 1 nocache nocycle;
create sequence cadeira_seq increment by 1
    start with 1 nocache nocycle;
create sequence sessao_cadeira_seq increment by 1
    start with 1 nocache nocycle;


create table tipoconta (
    id number(5) primary key,
    tipoConta varchar2(3) unique not null,
    descricao varchar2(60)
);
create table usuario (
    id number(5) primary key,
    usuario varchar2(20) unique not null,
    nome varchar2(20) not null,
    sobrenome varchar2(50),
    dataNasc date not null,
    idTipoConta number(5)not null,
    
    constraint fkUsuarioTipoConta
        foreign key(idTipoConta) references tipoconta(id)
);
create table enderecousuario (
    id number(5) primary key,
    idUsuario number(5) not null,
    rua varchar2(40) not null,
    numero varchar2(6) not null,
    bairro varchar2(25) not null,
    complemento varchar2(100),
    cep varchar2(8) not null,
    uf varchar2(2) not null,
    cidade varchar2(40) not null
);
create table usuario_enderecousuario (
    idUsuario number(5),
    idEnderecousuario number(5),
    
    primary key (idUsuario, idEnderecousuario),
    constraint fkUsuarioEnd foreign key(idUsuario) references usuario(id),
    constraint fkEnderecousuarioEnd foreign key(idEnderecousuario) references enderecousuario(id)
);
create table fornecedor (
    id number(5) primary key,
    nome varchar2(50) not null,
    telefone varchar2(14)
);
create table enderecofornecedor (
    id number(5) primary key,
    idFornecedor number(5) not null,
    rua varchar2(40) not null,
    numero varchar2(6) not null,
    bairro varchar2(25) not null,
    complemento varchar2(100),
    cep varchar2(8) not null,
    uf varchar2(2) not null,
    cidade varchar2(40) not null
);
create table fornecedor_enderecofornecedor (
    idFornecedor number(5),
    idEnderecofornecedor number(5),
    
    primary key (idFornecedor, idEnderecofornecedor),
    constraint fkFornecedorEnd foreign key(idFornecedor) references fornecedor(id),
    constraint fkEnderecofornecedorEnd foreign key(idEnderecofornecedor) references enderecofornecedor(id)
);
create table genero (
    id number(5) primary key,
    genero varchar(20) unique not null
);
create table distribuidor (
    id number(5) primary key,
    nome varchar(50) unique not null
);
create table cor (
    id number(5) primary key,
    cor varchar2(28) unique not null
);
create table formato (
    id number(5) primary key,
    tipo varchar2(15) unique not null
);
create table nacionalidade (
    id number(5) primary key,
    nacionalidade varchar(40) unique not null
);
create table elenco (
    id number(5) primary key,
    nome varchar2(50) not null,
    dataNasc date
);
create table elenco_nacionalidade (
    idElenco number(5) not null,
    idNacionalidade number(5) not null,
    
    constraint fkElencoElenco_Nacionalidade foreign key(idElenco)
      references elenco(id),
    constraint fkNacionalidadeElenco_Nacional foreign key(idNacionalidade)
      references nacionalidade(id)
);
create table idioma(
    id number(5) primary key,
    idioma varchar2(50) unique not null
);
create table filme (
    id number(5) primary key,
    nome varchar2(60) not null,
    sinopse varchar2(3000) not null,
    anoProducao date,
    distribuidor varchar2(40) not null,
    duracao date not null,
    idNacionalidade number(5),
    idIdioma number(5),
    idCor number(5),
    
    constraint fkNacionalidadeFilme foreign key(idNacionalidade)
      references nacionalidade(id),
    constraint fkIdiomaFilme foreign key(idIdioma)
      references idioma(id),
    constraint fkCorFilme foreign key(idCor)
      references cor(id)
);
create table filme_genero(
    idFilme number(5) not null,
    idGenero number(5) not null
);
create table filme_formato(
    idFilme number(5) not null,
    idFormato number(5) not null,
    
    constraint fkFilmeFilme_Formato foreign key(idFilme)
      references filme(id),
    constraint fkFormatoFilme_genero foreign key(idFormato)
      references formato(id)
);
create table filme_elenco(
    idFilme number(5) not null,
    idElenco number(5) not null,
    papel varchar2(50) unique not null
);
create table sala (
    id number(5) primary key,
    nome varchar2(7) not null,
    idFornecedor number(5) not null,

    constraint fkSalaFornecedor
        foreign key(idFornecedor) references fornecedor(id)
);
create table cadeira (
    id number(5) primary key,
    numero varchar2(4) unique not null,
    idSala number(5) not null,
    
    constraint fkSala_cadeira foreign key(idSala)
      references sala(id)
);
create table sessao (
    id number(5) primary key,
    data date not null,
    valor number(3,2) not null,
    idFilme number(5) not null,    
    constraint fkSessaoFilme
        foreign key(idFilme) references filme(id)
);
create table sessao_cadeira(
    idSessao number(5) not null,
    idCadeira number(5) not null
);

insert into tipoconta values(tipoconta_seq.nextval, 'ADM', 'Administração do sistema');
insert into usuario values(usuario_seq.nextval, 'admin', 'Administrador', null, '01/01/1970', tipoconta_seq.currval);
insert into tipoconta values(tipoconta_seq.nextval, 'GER', 'Usada para gerentes');
insert into usuario values(usuario_seq.nextval, 'gertoninho', 'Antonio', 'Nunes', '25/08/1986', tipoconta_seq.currval);
insert into enderecousuario values(enderecousuario_seq.nextval, usuario_seq.currval, 'Rita', 18, 'Jardim dos Santos', null, '00980000', 'SP', 'São Bernardo do Campo');
insert into tipoconta values(tipoconta_seq.nextval, 'USR', 'Usuário/Cliente');
insert into usuario values(usuario_seq.nextval, 'cli00', 'Administrador', null, '16/04/2000', tipoconta_seq.currval);
insert into enderecousuario values(enderecousuario_seq.nextval, usuario_seq.currval, 'São Paulo', 512, 'Jardim das Províncias', null, '00990000', 'SP', 'São Paulo');

insert into distribuidor values(distribuidor_seq.nextval, '20th Century Fox Film Corporation');
insert into distribuidor values(distribuidor_seq.nextval, '20th Century Fox');
insert into distribuidor values(distribuidor_seq.nextval, 'Fox 2000 pictores');
insert into distribuidor values(distribuidor_seq.nextval, 'Fox Searchlight Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Paramount Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'MTV Films');
insert into distribuidor values(distribuidor_seq.nextval, 'Nickelodeon Movies');
insert into distribuidor values(distribuidor_seq.nextval, 'Famous Studios');
insert into distribuidor values(distribuidor_seq.nextval, 'Paramount Classics/ Paramount Vantage');
insert into distribuidor values(distribuidor_seq.nextval, 'DreamWorks');
insert into distribuidor values(distribuidor_seq.nextval, 'Republic Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Sony Pictures Entertainment');
insert into distribuidor values(distribuidor_seq.nextval, 'Columbia Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'TriStar Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Screen Gems');
insert into distribuidor values(distribuidor_seq.nextval, 'Triumph Films');
insert into distribuidor values(distribuidor_seq.nextval, 'Sony Pictures Classics');
insert into distribuidor values(distribuidor_seq.nextval, 'Destination Films');
insert into distribuidor values(distribuidor_seq.nextval, 'NBC Universal');
insert into distribuidor values(distribuidor_seq.nextval, 'Universal Studios');
insert into distribuidor values(distribuidor_seq.nextval, 'Focus Features');
insert into distribuidor values(distribuidor_seq.nextval, 'Warner Bros. Entertainment');
insert into distribuidor values(distribuidor_seq.nextval, 'Warner Bros. Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Warner Independent Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Castle Rock Entertainment');
insert into distribuidor values(distribuidor_seq.nextval, 'New Line Cinema');
insert into distribuidor values(distribuidor_seq.nextval, 'HBO');
insert into distribuidor values(distribuidor_seq.nextval, 'HBO Films');
insert into distribuidor values(distribuidor_seq.nextval, 'Picturehouse');
insert into distribuidor values(distribuidor_seq.nextval, 'Buena Vista Motion Pictures Group');
insert into distribuidor values(distribuidor_seq.nextval, 'Disney Channel Original Movies');
insert into distribuidor values(distribuidor_seq.nextval, 'Walt Disney Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Hollywood Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Touchstone Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Pixar Animation Studios');
insert into distribuidor values(distribuidor_seq.nextval, 'Miramax Films');
insert into distribuidor values(distribuidor_seq.nextval, 'Marvel Studios');
insert into distribuidor values(distribuidor_seq.nextval, 'Lucasfilm');
insert into distribuidor values(distribuidor_seq.nextval, 'ABC Studios.');
insert into distribuidor values(distribuidor_seq.nextval, 'Metro-Goldwyn-Mayer');
insert into distribuidor values(distribuidor_seq.nextval, 'United Artists');
insert into distribuidor values(distribuidor_seq.nextval, 'Orion Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Aardman Animations');
insert into distribuidor values(distribuidor_seq.nextval, 'Alliance Atlantis');
insert into distribuidor values(distribuidor_seq.nextval, 'Amblin Entertainment');
insert into distribuidor values(distribuidor_seq.nextval, 'American Zoetrope');
insert into distribuidor values(distribuidor_seq.nextval, 'American Mutoscope and Biograph Company');
insert into distribuidor values(distribuidor_seq.nextval, 'Baltimore Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Bristol Bay Productions');
insert into distribuidor values(distribuidor_seq.nextval, 'Canal +');
insert into distribuidor values(distribuidor_seq.nextval, 'Capitol Films');
insert into distribuidor values(distribuidor_seq.nextval, 'Caravan Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Carrington Productions International');
insert into distribuidor values(distribuidor_seq.nextval, 'Casey Silver Productions');
insert into distribuidor values(distribuidor_seq.nextval, 'CBS');
insert into distribuidor values(distribuidor_seq.nextval, 'Centropolis Entertainment');
insert into distribuidor values(distribuidor_seq.nextval, 'Channel Four Films');
insert into distribuidor values(distribuidor_seq.nextval, 'Content Film');
insert into distribuidor values(distribuidor_seq.nextval, 'Davis Entertainment');
insert into distribuidor values(distribuidor_seq.nextval, 'Davis Films / Impact Canada');
insert into distribuidor values(distribuidor_seq.nextval, 'Distant Horizon');
insert into distribuidor values(distribuidor_seq.nextval, 'Dualstar Productions');
insert into distribuidor values(distribuidor_seq.nextval, 'EMI Films');
insert into distribuidor values(distribuidor_seq.nextval, 'FilmAuro');
insert into distribuidor values(distribuidor_seq.nextval, 'Fireworks Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'The Geffen Film Company');
insert into distribuidor values(distribuidor_seq.nextval, 'Golden Harvest');
insert into distribuidor values(distribuidor_seq.nextval, 'Gold Circle Films');
insert into distribuidor values(distribuidor_seq.nextval, 'Greenestreet Films');
insert into distribuidor values(distribuidor_seq.nextval, 'Gullane Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'IFC Entertainment');
insert into distribuidor values(distribuidor_seq.nextval, 'Imagine Entertainment');
insert into distribuidor values(distribuidor_seq.nextval, 'Initial Entertainment Group');
insert into distribuidor values(distribuidor_seq.nextval, 'Interscope Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Jim Henson Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'The Kennedy/Marshall Company');
insert into distribuidor values(distribuidor_seq.nextval, 'Kopelson Entertainment');
insert into distribuidor values(distribuidor_seq.nextval, 'Lakeshore Entertainment');
insert into distribuidor values(distribuidor_seq.nextval, 'Lyrick Studios');
insert into distribuidor values(distribuidor_seq.nextval, 'Lions Gate Films');
insert into distribuidor values(distribuidor_seq.nextval, 'Artisan Entertainment');
insert into distribuidor values(distribuidor_seq.nextval, 'Mandalay Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Mandeville Films');
insert into distribuidor values(distribuidor_seq.nextval, 'Mark IV Pictures Incorporated');
insert into distribuidor values(distribuidor_seq.nextval, 'Media 8 Entertainment');
insert into distribuidor values(distribuidor_seq.nextval, 'The Montecito Picture Company');
insert into distribuidor values(distribuidor_seq.nextval, 'Morgan Creek Productions');
insert into distribuidor values(distribuidor_seq.nextval, 'Nelson Entertainment');
insert into distribuidor values(distribuidor_seq.nextval, 'New Regency');
insert into distribuidor values(distribuidor_seq.nextval, 'Northern Lights Entertainment');
insert into distribuidor values(distribuidor_seq.nextval, 'PolyGram Filmed Entertainment');
insert into distribuidor values(distribuidor_seq.nextval, 'Producers Releasing Corporation');
insert into distribuidor values(distribuidor_seq.nextval, 'Rankin-Bass');
insert into distribuidor values(distribuidor_seq.nextval, 'Revere Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Revolution Studios');
insert into distribuidor values(distribuidor_seq.nextval, 'RKO Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Rogue Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Salter Street Films');
insert into distribuidor values(distribuidor_seq.nextval, 'The Samuel Goldwyn Company');
insert into distribuidor values(distribuidor_seq.nextval, 'Seven Arts');
insert into distribuidor values(distribuidor_seq.nextval, 'Spelling Films');
insert into distribuidor values(distribuidor_seq.nextval, 'Spyglass Entertainment');
insert into distribuidor values(distribuidor_seq.nextval, 'Strand Releasing');
insert into distribuidor values(distribuidor_seq.nextval, 'StudioCanal');
insert into distribuidor values(distribuidor_seq.nextval, 'Tapestry Films');
insert into distribuidor values(distribuidor_seq.nextval, 'Tartan Films');
insert into distribuidor values(distribuidor_seq.nextval, 'Trimark Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Troma Entertainment');
insert into distribuidor values(distribuidor_seq.nextval, 'Valhalla Motion Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Vanguard Films');
insert into distribuidor values(distribuidor_seq.nextval, 'Village Roadshow Pictures');
insert into distribuidor values(distribuidor_seq.nextval, 'Walden Media');
insert into distribuidor values(distribuidor_seq.nextval, 'The Weinstein Company');
insert into distribuidor values(distribuidor_seq.nextval, 'Dimension Films');
insert into distribuidor values(distribuidor_seq.nextval, 'Zeitgeist Films');
insert into distribuidor values(distribuidor_seq.nextval, 'Constantin Film');
insert into distribuidor values(distribuidor_seq.nextval, 'Gaumont');
insert into distribuidor values(distribuidor_seq.nextval, 'Pathe');
insert into distribuidor values(distribuidor_seq.nextval, 'EuropaCorp.');
insert into distribuidor values(distribuidor_seq.nextval, 'Bavaria Film');
insert into distribuidor values(distribuidor_seq.nextval, 'UFA');
insert into distribuidor values(distribuidor_seq.nextval, 'UGC');
insert into distribuidor values(distribuidor_seq.nextval, 'PorchLight Entertainment');

insert into nacionalidade values(nacionalidade_seq.nextval, 'Afeganistão');
insert into nacionalidade values(nacionalidade_seq.nextval, 'África do Sul');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Akrotiri');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Albânia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Alemanha');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Andorra');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Angola');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Anguila');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Antárctida');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Antígua e Barbuda');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Antilhas Neerlandesas');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Arábia Saudita');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Arctic Ocean');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Argélia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Argentina');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Arménia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Aruba');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Ashmore and Cartier Islands');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Atlantic Ocean');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Austrália');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Áustria');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Azerbaijão');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Baamas');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Bangladeche');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Barbados');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Barém');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Bélgica');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Belize');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Benim');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Bermudas');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Bielorrússia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Birmânia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Bolívia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Bósnia e Herzegovina');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Botsuana');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Brasil');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Brunei');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Bulgária');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Burquina Faso');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Burúndi');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Butão');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Cabo Verde');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Camarões');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Camboja');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Canadá');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Catar');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Cazaquistão');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Chade');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Chile');
insert into nacionalidade values(nacionalidade_seq.nextval, 'China');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Chipre');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Clipperton Island');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Colômbia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Comores');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Congo-Brazzaville');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Congo-Kinshasa');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Coral Sea Islands');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Coreia do Norte');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Coreia do Sul');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Costa do Marfim');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Costa Rica');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Croácia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Cuba');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Dhekelia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Dinamarca');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Domínica');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Egipto');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Emiratos Árabes Unidos');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Equador');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Eritreia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Eslováquia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Eslovénia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Espanha');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Estados Unidos');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Estónia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Etiópia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Faroé');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Fiji');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Filipinas');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Finlândia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'França');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Gabão');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Gâmbia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Gana');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Gaza Strip');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Geórgia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Geórgia do Sul e Sandwich do Sul');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Gibraltar');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Granada');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Grécia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Gronelândia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Guame');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Guatemala');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Guernsey');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Guiana');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Guiné');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Guiné Equatorial');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Guiné-Bissau');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Haiti');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Honduras');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Hong Kong');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Hungria');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Iémen');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Ilha Bouvet');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Ilha do Natal');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Ilha Norfolk');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Ilhas Caimão');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Ilhas Cook');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Ilhas dos Cocos');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Ilhas Falkland');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Ilhas Heard e McDonald');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Ilhas Marshall');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Ilhas Salomão');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Ilhas Turcas e Caicos');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Ilhas Virgens Americanas');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Ilhas Virgens Britânicas');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Índia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Indian Ocean');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Indonésia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Irão');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Iraque');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Irlanda');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Islândia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Israel');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Itália');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Jamaica');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Jan Mayen');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Japão');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Jersey');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Jibuti');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Jordânia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Kuwait');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Laos');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Lesoto');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Letónia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Líbano');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Libéria');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Líbia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Listenstaine');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Lituânia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Luxemburgo');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Macau');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Macedónia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Madagáscar');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Malásia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Malávi');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Maldivas');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Mali');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Malta');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Man, Isle of');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Marianas do Norte');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Marrocos');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Maurícia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Mauritânia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Mayotte');
insert into nacionalidade values(nacionalidade_seq.nextval, 'México');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Micronésia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Moçambique');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Moldávia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Mónaco');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Mongólia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Monserrate');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Montenegro');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Mundo');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Namíbia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Nauru');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Navassa Island');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Nepal');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Nicarágua');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Níger');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Nigéria');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Niue');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Noruega');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Nova Caledónia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Nova Zelândia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Omã');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Pacific Ocean');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Países Baixos');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Palau');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Panamá');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Papua-Nova Guiné');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Paquistão');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Paracel Islands');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Paraguai');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Peru');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Pitcairn');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Polinésia Francesa');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Polónia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Porto Rico');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Portugal');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Quénia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Quirguizistão');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Quiribáti');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Reino Unido');
insert into nacionalidade values(nacionalidade_seq.nextval, 'República Centro-Africana');
insert into nacionalidade values(nacionalidade_seq.nextval, 'República Checa');
insert into nacionalidade values(nacionalidade_seq.nextval, 'República Dominicana');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Roménia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Ruanda');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Rússia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Salvador');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Samoa');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Samoa Americana');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Santa Helena');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Santa Lúcia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'São Cristóvão e Neves');
insert into nacionalidade values(nacionalidade_seq.nextval, 'São Marinho');
insert into nacionalidade values(nacionalidade_seq.nextval, 'São Pedro e Miquelon');
insert into nacionalidade values(nacionalidade_seq.nextval, 'São Tomé e Príncipe');
insert into nacionalidade values(nacionalidade_seq.nextval, 'São Vicente e Granadinas');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Sara Ocidental');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Seicheles');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Senegal');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Serra Leoa');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Sérvia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Singapura');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Síria');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Somália');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Southern Ocean');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Spratly Islands');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Sri Lanca');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Suazilândia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Sudão');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Suécia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Suíça');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Suriname');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Svalbard e Jan Mayen');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Tailândia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Taiwan');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Tajiquistão');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Tanzânia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Território Britânico do Oceano Índico');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Territórios Austrais Franceses');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Timor Leste');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Togo');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Tokelau');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Tonga');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Trindade e Tobago');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Tunísia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Turquemenistão');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Turquia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Tuvalu');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Ucrânia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Uganda');
insert into nacionalidade values(nacionalidade_seq.nextval, 'União Europeia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Uruguai');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Usbequistão');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Vanuatu');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Vaticano');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Venezuela');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Vietname');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Wake Island');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Wallis e Futuna');
insert into nacionalidade values(nacionalidade_seq.nextval, 'West Bank');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Zâmbia');
insert into nacionalidade values(nacionalidade_seq.nextval, 'Zimbabué');

insert into genero values(genero_seq.nextval, 'Ação');
insert into genero values(genero_seq.nextval, 'Animação');
insert into genero values(genero_seq.nextval, 'Aventura');
insert into genero values(genero_seq.nextval, 'Chanchada');
insert into genero values(genero_seq.nextval, 'Cinema catástrofe');
insert into genero values(genero_seq.nextval, 'Comédia');
insert into genero values(genero_seq.nextval, 'Comédia romântica');
insert into genero values(genero_seq.nextval, 'Comédia dramática');
insert into genero values(genero_seq.nextval, 'Comédia de ação');
insert into genero values(genero_seq.nextval, 'Cult');
insert into genero values(genero_seq.nextval, 'Dança');
insert into genero values(genero_seq.nextval, 'Documentários');
insert into genero values(genero_seq.nextval, 'Drama');
insert into genero values(genero_seq.nextval, 'Espionagem');
insert into genero values(genero_seq.nextval, 'Erótico');
insert into genero values(genero_seq.nextval, 'Fantasia');
insert into genero values(genero_seq.nextval, 'Faroeste');
insert into genero values(genero_seq.nextval, 'Ficção científica');
insert into genero values(genero_seq.nextval, 'Séries/Franchise');
insert into genero values(genero_seq.nextval, 'Guerra');
insert into genero values(genero_seq.nextval, 'Machinima');
insert into genero values(genero_seq.nextval, 'Masala');
insert into genero values(genero_seq.nextval, 'Musical');
insert into genero values(genero_seq.nextval, 'Filme noir');
insert into genero values(genero_seq.nextval, 'Policial');
insert into genero values(genero_seq.nextval, 'Pornochanchada');
insert into genero values(genero_seq.nextval, 'Pornográfico');
insert into genero values(genero_seq.nextval, 'Romance');
insert into genero values(genero_seq.nextval, 'Suspense');
insert into genero values(genero_seq.nextval, 'Terror');
insert into genero values(genero_seq.nextval, 'Trash');

insert into formato values(formato_seq.nextval, '3D');
insert into formato values(formato_seq.nextval, '4DX');
insert into formato values(formato_seq.nextval, 'IMAX');
insert into formato values(formato_seq.nextval, 'Macro XE');
insert into formato values(formato_seq.nextval, 'XD');
insert into formato values(formato_seq.nextval, 'Dublado');
insert into formato values(formato_seq.nextval, 'Legendado');

insert into idioma values(idioma_seq.nextval, 'Akan');
insert into idioma values(idioma_seq.nextval, 'Alemão');
insert into idioma values(idioma_seq.nextval, 'Amárica');
insert into idioma values(idioma_seq.nextval, 'Assamês');
insert into idioma values(idioma_seq.nextval, 'Awadhi');
insert into idioma values(idioma_seq.nextval, 'Azeri');
insert into idioma values(idioma_seq.nextval, 'Balúchi');
insert into idioma values(idioma_seq.nextval, 'Bengali');
insert into idioma values(idioma_seq.nextval, 'Bhojpuri');
insert into idioma values(idioma_seq.nextval, 'Bielorrusso');
insert into idioma values(idioma_seq.nextval, 'Birmanês');
insert into idioma values(idioma_seq.nextval, 'Canarês');
insert into idioma values(idioma_seq.nextval, 'Cazaque');
insert into idioma values(idioma_seq.nextval, 'Cebuano');
insert into idioma values(idioma_seq.nextval, 'Chatgaya');
insert into idioma values(idioma_seq.nextval, 'Chhattisgarhi');
insert into idioma values(idioma_seq.nextval, 'Chona');
insert into idioma values(idioma_seq.nextval, 'Cingalês');
insert into idioma values(idioma_seq.nextval, 'Cinianja');
insert into idioma values(idioma_seq.nextval, 'Concani');
insert into idioma values(idioma_seq.nextval, 'Coreano');
insert into idioma values(idioma_seq.nextval, 'Crioulo haitiano');
insert into idioma values(idioma_seq.nextval, 'Curdo');
insert into idioma values(idioma_seq.nextval, 'Deccani');
insert into idioma values(idioma_seq.nextval, 'Dhundhari');
insert into idioma values(idioma_seq.nextval, 'Espanhol');
insert into idioma values(idioma_seq.nextval, 'Francês');
insert into idioma values(idioma_seq.nextval, 'Fulani');
insert into idioma values(idioma_seq.nextval, 'Gan');
insert into idioma values(idioma_seq.nextval, 'Grego');
insert into idioma values(idioma_seq.nextval, 'Guzerate');
insert into idioma values(idioma_seq.nextval, 'Hakka');
insert into idioma values(idioma_seq.nextval, 'Hariani');
insert into idioma values(idioma_seq.nextval, 'Haúça');
insert into idioma values(idioma_seq.nextval, 'Hiligaynon');
insert into idioma values(idioma_seq.nextval, 'Hindi');
insert into idioma values(idioma_seq.nextval, 'Hmong');
insert into idioma values(idioma_seq.nextval, 'Húngaro');
insert into idioma values(idioma_seq.nextval, 'Igbo');
insert into idioma values(idioma_seq.nextval, 'Ilocano');
insert into idioma values(idioma_seq.nextval, 'Inglês');
insert into idioma values(idioma_seq.nextval, 'Iorubá');
insert into idioma values(idioma_seq.nextval, 'Italiano');
insert into idioma values(idioma_seq.nextval, 'Japonês');
insert into idioma values(idioma_seq.nextval, 'Javanês');
insert into idioma values(idioma_seq.nextval, 'Jin');
insert into idioma values(idioma_seq.nextval, 'Khmer');
insert into idioma values(idioma_seq.nextval, 'Kirundi');
insert into idioma values(idioma_seq.nextval, 'Madurês');
insert into idioma values(idioma_seq.nextval, 'Magahi');
insert into idioma values(idioma_seq.nextval, 'Maithili');
insert into idioma values(idioma_seq.nextval, 'Malaiala');
insert into idioma values(idioma_seq.nextval, 'Malaio');
insert into idioma values(idioma_seq.nextval, 'Malgaxe');
insert into idioma values(idioma_seq.nextval, 'Mandarim');
insert into idioma values(idioma_seq.nextval, 'Marati');
insert into idioma values(idioma_seq.nextval, 'Marvari');
insert into idioma values(idioma_seq.nextval, 'Min Bei');
insert into idioma values(idioma_seq.nextval, 'Min Dong');
insert into idioma values(idioma_seq.nextval, 'Min Nan');
insert into idioma values(idioma_seq.nextval, 'More');
insert into idioma values(idioma_seq.nextval, 'Neerlandês');
insert into idioma values(idioma_seq.nextval, 'Nepalês');
insert into idioma values(idioma_seq.nextval, 'Oriá');
insert into idioma values(idioma_seq.nextval, 'Oromo');
insert into idioma values(idioma_seq.nextval, 'Panjabi');
insert into idioma values(idioma_seq.nextval, 'Pastó');
insert into idioma values(idioma_seq.nextval, 'Persa');
insert into idioma values(idioma_seq.nextval, 'Polonês');
insert into idioma values(idioma_seq.nextval, 'Português');
insert into idioma values(idioma_seq.nextval, 'Quiniaruanda');
insert into idioma values(idioma_seq.nextval, 'Quíchua');
insert into idioma values(idioma_seq.nextval, 'Romeno');
insert into idioma values(idioma_seq.nextval, 'Russo');
insert into idioma values(idioma_seq.nextval, 'Seraiki');
insert into idioma values(idioma_seq.nextval, 'Serbo-croata');
insert into idioma values(idioma_seq.nextval, 'Sindi');
insert into idioma values(idioma_seq.nextval, 'Somali');
insert into idioma values(idioma_seq.nextval, 'Sueco');
insert into idioma values(idioma_seq.nextval, 'Sundanês');
insert into idioma values(idioma_seq.nextval, 'Sylheti');
insert into idioma values(idioma_seq.nextval, 'Tagalo');
insert into idioma values(idioma_seq.nextval, 'Tailandês');
insert into idioma values(idioma_seq.nextval, 'Tcheco');
insert into idioma values(idioma_seq.nextval, 'Telugo');
insert into idioma values(idioma_seq.nextval, 'Turco');
insert into idioma values(idioma_seq.nextval, 'Turcomano');
insert into idioma values(idioma_seq.nextval, 'Tâmil');
insert into idioma values(idioma_seq.nextval, 'Ucraniano');
insert into idioma values(idioma_seq.nextval, 'Uigur');
insert into idioma values(idioma_seq.nextval, 'Urdu');
insert into idioma values(idioma_seq.nextval, 'Usbeque');
insert into idioma values(idioma_seq.nextval, 'Vietnamita');
insert into idioma values(idioma_seq.nextval, 'Wu (Xangainês)');
insert into idioma values(idioma_seq.nextval, 'Xhosa');
insert into idioma values(idioma_seq.nextval, 'Xiang');
insert into idioma values(idioma_seq.nextval, 'Yue (Cantonês)');
insert into idioma values(idioma_seq.nextval, 'Zhuang');
insert into idioma values(idioma_seq.nextval, 'Zulu');
insert into idioma values(idioma_seq.nextval, 'Árabe');

insert into cor values(cor_seq.nextval, 'Colorido');
insert into cor values(cor_seq.nextval, 'Preto e branco');

insert into fornecedor values (fornecedor_seq.nextval, 'Caixa Melas Artes', '(11) 4923-5267');
insert into fornecedor values (fornecedor_seq.nextval, 'Centerflex Lapa', '(11) 6039-0311');
insert into fornecedor values (fornecedor_seq.nextval, 'Cine Araújo Campo Sujo', '(11) 7381-8708');
insert into fornecedor values (fornecedor_seq.nextval, 'CineBanheiro', '(11) 4615-1149');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Aricanduva', '(11) 6023-2244');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Boulevard Tatuapé', '(11) 3553-3096');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Center Norte', '(11) 3200-1711');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Central Plaza', '(11) 5208-5671');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Cidade Jardim', '(11) 5373-7231');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Eldorado', '(11) 3951-8826');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Lar Center', '(11) 2004-7540');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Market Place', '(11) 2351-3586');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Metrô Tatuapé', '(11) 6457-3339');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Móoca', '(11) 7280-1346');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Patio Higienopolis', '(11) 7562-5879');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Paulista', '(11) 7683-2850');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Raposo', '(11) 3656-6230');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Shopping Cidade São Paulo', '(11) 8626-6133');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Shopping D', '(11) 8111-0859');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Shopping Iguatemi SP', '(11) 5978-0744');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Shopping Interlagos', '(11) 7399-4639');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Shopping Metrô Santa Cruz', '(11) 4470-0400');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus SP Market', '(11) 3129-6806');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Tietê Plaza', '(11) 7141-9665');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Tucuruvi', '(11) 4924-3015');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemarkus Villa Lobos', '(11) 5347-2573');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinépolim Itaquera', '(11) 5900-2692');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinépolim JK Iguatemi', '(11) 4788-6568');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinépolim Largo XIII', '(11) 4226-3663');
insert into fornecedor values (fornecedor_seq.nextval, 'CineTARDE', '(11) 7168-1191');
insert into fornecedor values (fornecedor_seq.nextval, 'Espaço Hitaum de Cinema - Augusta', '(11) 3311-2238');
insert into fornecedor values (fornecedor_seq.nextval, 'Espaço Hitaum de Cinema - Augusta II', '(11) 6221-3313');
insert into fornecedor values (fornecedor_seq.nextval, 'Espaço Hitaum de Cinema - Frei Caneca', '(11) 4926-3218');
insert into fornecedor values (fornecedor_seq.nextval, 'Espaço Hitaum de Cinema - Pompéia', '(11) 3172-4995');
insert into fornecedor values (fornecedor_seq.nextval, 'Moviesem Penha', '(11) 4473-4062');
insert into fornecedor values (fornecedor_seq.nextval, 'Quinoplex Itaim', '(11) 3527-1202');
insert into fornecedor values (fornecedor_seq.nextval, 'Quinoplex Vila Olímpia', '(11) 4377-1763');
insert into fornecedor values (fornecedor_seq.nextval, 'Reservação Cultural', '(11) 3152-1913');
insert into fornecedor values (fornecedor_seq.nextval, 'UCD Analia Franco', '(11) 5358-8516');
insert into fornecedor values (fornecedor_seq.nextval, 'UCD Jardim Sul', '(11) 3641-4366');
insert into fornecedor values (fornecedor_seq.nextval, 'UCD Santana', '(11) 5809-8165');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemark Extra Anchieta', '(11) 3940-9197');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemark Golden Square', '(11) 8591-5128');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinépolis São Bernardo do Campo', '(11) 6735-1323');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemark Atrium', '(11) 8868-0769');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinemark Grand Plaza Shopping', '(11) 2805-7516');
insert into fornecedor values (fornecedor_seq.nextval, 'Cine Araújo Rio Branco', '() 4335-1041');
insert into fornecedor values (fornecedor_seq.nextval, 'Centerplex - Maceió', '() 8517-4704');
insert into fornecedor values (fornecedor_seq.nextval, 'Cinesystem Maceió', '() 5449-3019');
insert into fornecedor values (fornecedor_seq.nextval, 'Kinoplex Maceió', '() 2403-3727');



commit;