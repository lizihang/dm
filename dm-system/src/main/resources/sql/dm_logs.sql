create table logs
(
    id          int auto_increment
        primary key,
    username    varchar(64)  null,
    method      varchar(256) null,
    remark      varchar(256) null,
    logtype     varchar(16)  null,
    operatetime timestamp    null
);

INSERT INTO dm.logs (id, username, method, remark, logtype, operatetime) VALUES (1, 'admin', 'test', 'ceshi', '10', '2020-11-06 10:12:12');
INSERT INTO dm.logs (id, username, method, remark, logtype, operatetime) VALUES (2, 'admin', 'queryLog', 'ceshi', '20', '2020-11-09 15:19:49');