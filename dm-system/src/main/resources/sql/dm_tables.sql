create table dm_log
(
    id          int auto_increment
        primary key,
    username    varchar(64)  null,
    method      varchar(256) null,
    remark      varchar(256) null,
    logtype     varchar(16)  null,
    operatetime timestamp    null,
    createUser  varchar(32)  null,
    createDate  timestamp    null,
    modifyUser  varchar(32)  null,
    modifyDate  timestamp    null
);

INSERT INTO dm.dm_log (id, username, method, remark, logtype, operatetime, createUser, createDate, modifyUser, modifyDate) VALUES (1, 'admin', 'test', 'ceshi', '10', '2020-11-06 10:12:12', null, null, null, null);
INSERT INTO dm.dm_log (id, username, method, remark, logtype, operatetime, createUser, createDate, modifyUser, modifyDate) VALUES (2, 'admin', 'queryLog', 'ceshi', '20', '2020-11-09 15:19:49', null, null, null, null);


create table dm_sys_job
(
    jobId          int auto_increment
        primary key,
    jobName        varchar(32)  not null,
    jobGroup       varchar(32)  not null,
    jobClass       varchar(255) not null,
    cronExpression varchar(32)  not null,
    timeZoneId     varchar(32)  null,
    concurrent     varchar(32)  null,
    status         varchar(32)  not null,
    createUser     varchar(32)  null,
    createDate     timestamp    null,
    modifyUser     varchar(32)  null,
    modifyDate     timestamp    null
);


create table dm_sys_menu
(
    id         int auto_increment
        primary key,
    name       varchar(64) not null,
    router     varchar(64) null,
    icon_class varchar(64) null,
    `group`    varchar(16) null,
    idx        int         null,
    level      int         null,
    parent_id  int         null,
    createUser varchar(32) null,
    createDate timestamp   null,
    modifyUser varchar(32) null,
    modifyDate timestamp   null
);

INSERT INTO dm.dm_sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (1, '基础资料', 'base', 'el-icon-help', null, 1, 1, null, null, null, null, null);
INSERT INTO dm.dm_sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (2, '日志管理', 'log', 'el-icon-document', null, 2, 1, null, null, null, null, null);
INSERT INTO dm.dm_sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (3, '系统管理', 'system', 'el-icon-setting', null, 3, 1, null, null, null, null, null);
INSERT INTO dm.dm_sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (4, '大区', '/base/area', null, '基础码表', 1, 2, 1, null, null, null, null);
INSERT INTO dm.dm_sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (5, '国别地区', '/base/country', null, '基础码表', 2, 2, 1, null, null, null, null);
INSERT INTO dm.dm_sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (6, '登录日志', '/log/login', null, null, 1, 2, 2, null, null, null, null);
INSERT INTO dm.dm_sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (7, '操作日志', '/log/operate', null, null, 2, 2, 2, null, null, null, null);
INSERT INTO dm.dm_sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (8, '用户管理', '/system/user', null, null, 1, 2, 3, null, null, null, null);
INSERT INTO dm.dm_sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (9, '角色管理', '/system/role', null, null, 2, 2, 3, null, null, null, null);
INSERT INTO dm.dm_sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (10, '菜单管理', '/system/menu', null, null, 3, 2, 3, null, null, null, null);
INSERT INTO dm.dm_sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (11, '部门管理', '/system/department', null, null, 4, 2, 3, null, null, null, null);
