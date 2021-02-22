# 2021-2-22 重新设计的数据库表
create table dm_role
(
    id          int auto_increment comment '主键'
        primary key,
    role_code   varchar(64)   not null comment '角色编码',
    role_name   varchar(64)   not null comment '角色名称',
    status      int default 0 not null comment '状态：0-创建；1-正常；2-禁用；3-删除',
    create_time datetime      null comment '创建时间',
    create_user varchar(64)   null comment '创建人',
    modify_time datetime      null comment '修改时间',
    modify_user varchar(64)   null comment '修改人'
)
comment '角色表';


create table dm_user
(
    id          int auto_increment comment '主键'
        primary key,
    username    varchar(64)   not null comment '用户名',
    password    varchar(64)   not null comment '密码',
    nickname    varchar(64)   not null comment '昵称',
    email       varchar(64)   not null comment '邮箱',
    status      int default 0 not null comment '状态：0-创建；1-正常；2-禁用；3-删除',
    create_time datetime      null comment '创建时间',
    create_user varchar(64)   null comment '创建人',
    modify_time datetime      null comment '修改时间',
    modify_user varchar(64)   null comment '修改人'
)
comment '用户表';


create table dm_user_role
(
    id      int auto_increment comment '主键'
        primary key,
    user_id int not null comment '用户表主键',
    role_id int not null comment '角色表主键'
)
comment '用户角色关系表';
