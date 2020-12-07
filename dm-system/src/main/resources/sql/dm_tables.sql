create table logs
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

INSERT INTO dm.logs (id, username, method, remark, logtype, operatetime, createUser, createDate, modifyUser, modifyDate) VALUES (1, 'admin', 'test', 'ceshi', '10', '2020-11-06 10:12:12', null, null, null, null);
INSERT INTO dm.logs (id, username, method, remark, logtype, operatetime, createUser, createDate, modifyUser, modifyDate) VALUES (2, 'admin', 'queryLog', 'ceshi', '20', '2020-11-09 15:19:49', null, null, null, null);
create table qrtz_blob_triggers
(
    SCHED_NAME    varchar(120) not null,
    TRIGGER_NAME  varchar(200) not null,
    TRIGGER_GROUP varchar(200) not null,
    BLOB_DATA     blob         null,
    primary key (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP),
    constraint qrtz_blob_triggers_ibfk_1
        foreign key (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP) references qrtz_triggers (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP)
);


create table qrtz_calendars
(
    SCHED_NAME    varchar(120) not null,
    CALENDAR_NAME varchar(200) not null,
    CALENDAR      blob         not null,
    primary key (SCHED_NAME, CALENDAR_NAME)
);


create table qrtz_cron_triggers
(
    SCHED_NAME      varchar(120) not null,
    TRIGGER_NAME    varchar(200) not null,
    TRIGGER_GROUP   varchar(200) not null,
    CRON_EXPRESSION varchar(200) not null,
    TIME_ZONE_ID    varchar(80)  null,
    primary key (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP),
    constraint qrtz_cron_triggers_ibfk_1
        foreign key (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP) references qrtz_triggers (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP)
);


create table qrtz_fired_triggers
(
    SCHED_NAME        varchar(120) not null,
    ENTRY_ID          varchar(95)  not null,
    TRIGGER_NAME      varchar(200) not null,
    TRIGGER_GROUP     varchar(200) not null,
    INSTANCE_NAME     varchar(200) not null,
    FIRED_TIME        bigint(13)   not null,
    SCHED_TIME        bigint(13)   not null,
    PRIORITY          int          not null,
    STATE             varchar(16)  not null,
    JOB_NAME          varchar(200) null,
    JOB_GROUP         varchar(200) null,
    IS_NONCONCURRENT  varchar(1)   null,
    REQUESTS_RECOVERY varchar(1)   null,
    primary key (SCHED_NAME, ENTRY_ID)
);


create table qrtz_job_details
(
    SCHED_NAME        varchar(120) not null,
    JOB_NAME          varchar(200) not null,
    JOB_GROUP         varchar(200) not null,
    DESCRIPTION       varchar(250) null,
    JOB_CLASS_NAME    varchar(250) not null,
    IS_DURABLE        varchar(1)   not null,
    IS_NONCONCURRENT  varchar(1)   not null,
    IS_UPDATE_DATA    varchar(1)   not null,
    REQUESTS_RECOVERY varchar(1)   not null,
    JOB_DATA          blob         null,
    primary key (SCHED_NAME, JOB_NAME, JOB_GROUP)
);


create table qrtz_locks
(
    SCHED_NAME varchar(120) not null,
    LOCK_NAME  varchar(40)  not null,
    primary key (SCHED_NAME, LOCK_NAME)
);

INSERT INTO dm.qrtz_locks (SCHED_NAME, LOCK_NAME) VALUES ('scheduler', 'TRIGGER_ACCESS');
create table qrtz_paused_trigger_grps
(
    SCHED_NAME    varchar(120) not null,
    TRIGGER_GROUP varchar(200) not null,
    primary key (SCHED_NAME, TRIGGER_GROUP)
);


create table qrtz_scheduler_state
(
    SCHED_NAME        varchar(120) not null,
    INSTANCE_NAME     varchar(200) not null,
    LAST_CHECKIN_TIME bigint(13)   not null,
    CHECKIN_INTERVAL  bigint(13)   not null,
    primary key (SCHED_NAME, INSTANCE_NAME)
);


create table qrtz_simple_triggers
(
    SCHED_NAME      varchar(120) not null,
    TRIGGER_NAME    varchar(200) not null,
    TRIGGER_GROUP   varchar(200) not null,
    REPEAT_COUNT    bigint(7)    not null,
    REPEAT_INTERVAL bigint(12)   not null,
    TIMES_TRIGGERED bigint(10)   not null,
    primary key (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP),
    constraint qrtz_simple_triggers_ibfk_1
        foreign key (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP) references qrtz_triggers (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP)
);


create table qrtz_simprop_triggers
(
    SCHED_NAME    varchar(120)   not null,
    TRIGGER_NAME  varchar(200)   not null,
    TRIGGER_GROUP varchar(200)   not null,
    STR_PROP_1    varchar(512)   null,
    STR_PROP_2    varchar(512)   null,
    STR_PROP_3    varchar(512)   null,
    INT_PROP_1    int            null,
    INT_PROP_2    int            null,
    LONG_PROP_1   bigint         null,
    LONG_PROP_2   bigint         null,
    DEC_PROP_1    decimal(13, 4) null,
    DEC_PROP_2    decimal(13, 4) null,
    BOOL_PROP_1   varchar(1)     null,
    BOOL_PROP_2   varchar(1)     null,
    primary key (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP),
    constraint qrtz_simprop_triggers_ibfk_1
        foreign key (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP) references qrtz_triggers (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP)
);


create table qrtz_triggers
(
    SCHED_NAME     varchar(120) not null,
    TRIGGER_NAME   varchar(200) not null,
    TRIGGER_GROUP  varchar(200) not null,
    JOB_NAME       varchar(200) not null,
    JOB_GROUP      varchar(200) not null,
    DESCRIPTION    varchar(250) null,
    NEXT_FIRE_TIME bigint(13)   null,
    PREV_FIRE_TIME bigint(13)   null,
    PRIORITY       int          null,
    TRIGGER_STATE  varchar(16)  not null,
    TRIGGER_TYPE   varchar(8)   not null,
    START_TIME     bigint(13)   not null,
    END_TIME       bigint(13)   null,
    CALENDAR_NAME  varchar(200) null,
    MISFIRE_INSTR  smallint(2)  null,
    JOB_DATA       blob         null,
    primary key (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP),
    constraint qrtz_triggers_ibfk_1
        foreign key (SCHED_NAME, JOB_NAME, JOB_GROUP) references qrtz_job_details (SCHED_NAME, JOB_NAME, JOB_GROUP)
);

create index SCHED_NAME
    on qrtz_triggers (SCHED_NAME, JOB_NAME, JOB_GROUP);


create table sys_job
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
    parent_id  int         null,
    createUser varchar(32) null,
    createDate timestamp   null,
    modifyUser varchar(32) null,
    modifyDate timestamp   null
);

INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (1, '基础资料', 'base', 'el-icon-help', null, 1, 1, null, null, null, null, null);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (2, '日志管理', 'log', 'el-icon-document', null, 2, 1, null, null, null, null, null);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (3, '系统管理', 'system', 'el-icon-setting', null, 3, 1, null, null, null, null, null);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (4, '大区', '/base/area', null, '基础码表', 1, 2, 1, null, null, null, null);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (5, '国别地区', '/base/country', null, '基础码表', 2, 2, 1, null, null, null, null);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (6, '登录日志', '/log/login', null, null, 1, 2, 2, null, null, null, null);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (7, '操作日志', '/log/operate', null, null, 2, 2, 2, null, null, null, null);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (8, '用户管理', '/system/user', null, null, 1, 2, 3, null, null, null, null);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (9, '角色管理', '/system/role', null, null, 2, 2, 3, null, null, null, null);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (10, '菜单管理', '/system/menu', null, null, 3, 2, 3, null, null, null, null);
INSERT INTO dm.sys_menu (id, name, router, icon_class, `group`, idx, level, parent_id, createUser, createDate, modifyUser, modifyDate) VALUES (11, '部门管理', '/system/department', null, null, 4, 2, 3, null, null, null, null);
create table users
(
    id         int(8) auto_increment
        primary key,
    username   varchar(32) not null,
    nickname   varchar(32) not null,
    password   varchar(64) not null,
    createUser varchar(32) null,
    createDate timestamp   null on update CURRENT_TIMESTAMP,
    modifyUser varchar(32) null,
    modifyDate timestamp   null,
    constraint users_username_uindex
        unique (username)
);

INSERT INTO dm.users (id, username, nickname, password, createUser, createDate, modifyUser, modifyDate) VALUES (1, 'admin', '管理员', '111111', null, '2020-10-20 10:27:51', null, '2020-10-20 00:00:00');