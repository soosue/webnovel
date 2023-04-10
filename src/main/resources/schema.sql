drop table if exists author cascade;
create table author
(
    id       bigint       not null auto_increment,
    nickname varchar(255) not null,
    primary key (id)
) engine=InnoDB default charset=utf8mb4;

drop table if exists reader cascade;
create table reader
(
    id bigint not null auto_increment,
    primary key (id)
) engine=InnoDB default charset=utf8mb4;

drop table if exists novel cascade;
create table novel
(
    id        bigint       not null auto_increment,
    title     varchar(255) not null,
    category  varchar(255) not null,
    author_id bigint       not null,
    primary key (id)
) engine=InnoDB default charset=utf8mb4;

drop table if exists volume cascade;
create table volume
(
    id       bigint       not null auto_increment,
    content  varchar(255) not null,
    novel_id bigint       not null,
    primary key (id)
) engine=InnoDB default charset=utf8mb4;

drop table if exists favorite_novel cascade;
create table favorite_novel
(
    id        bigint not null auto_increment,
    novel_id  bigint not null,
    reader_id bigint not null,
    primary key (id)
) engine=InnoDB default charset=utf8mb4;
