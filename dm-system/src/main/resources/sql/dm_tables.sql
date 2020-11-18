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
create table sys_menu
(
    id         int auto_increment
        primary key,
    name       varchar(64) not null,
    router     varchar(64) null,
    icon_class varchar(64) null,
    `group`    varchar(16) null,
    idx        int         null,
    level      int         null,
    parent_id  int         null
);

INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id) VALUES (1, '基础资料', 'base', 'el-icon-help', null, 1, 1, null);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id) VALUES (2, '日志管理', 'log', 'el-icon-document', null, 2, 1, null);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id) VALUES (3, '系统管理', 'system', 'el-icon-setting', null, 3, 1, null);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id) VALUES (4, '大区', '/base/area', null, '基础码表', 1, 2, 1);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id) VALUES (5, '国别地区', '/base/country', null, '基础码表', 2, 2, 1);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id) VALUES (6, '登录日志', '/log/login', null, null, 1, 2, 2);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id) VALUES (7, '操作日志', '/log/operate', null, null, 2, 2, 2);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id) VALUES (8, '用户管理', '/system/user', null, null, 1, 2, 3);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id) VALUES (9, '角色管理', '/system/role', null, null, 2, 2, 3);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id) VALUES (10, '菜单管理', '/system/menu', null, null, 3, 2, 3);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id) VALUES (11, '部门管理', '/system/department', null, null, 4, 2, 3);
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