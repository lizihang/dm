create table users
(
    id         int(8) auto_increment
        primary key,
    username   varchar(32)                             not null,
    nickname   varchar(32)                             not null,
    password   varchar(64)                             not null,
    createdate timestamp default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP,
    modifydate timestamp default '0000-00-00 00:00:00' not null,
    constraint users_username_uindex
        unique (username)
);

INSERT INTO dm.users (id, username, nickname, password, createdate, modifydate) VALUES (1, 'admin', '管理员', '111111', '2020-10-20 10:27:51', '2020-10-20 00:00:00');