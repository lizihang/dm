create table dm_book
(
    id       int auto_increment comment '主键'
        primary key,
    name     varchar(64)              not null comment '书名',
    author   varchar(64) default '佚名' not null comment '作者，无值时默认：佚名',
    publish  varchar(64)              null comment '出版社',
    type     varchar(32)              not null comment '书籍类型',
    language varchar(32)              not null comment '默认：简体中文',
    price    decimal                  null comment '单价',
    number   int                      null comment '数量',
    cover    longtext                 null comment '封面',
    location varchar(64)              null comment '存放位置',
    constraint dm_book_name_uindex
        unique (name)
);

