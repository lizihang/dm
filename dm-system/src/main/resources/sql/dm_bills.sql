create table dm_bills
(
    id              int auto_increment
        primary key,
    userCode        varchar(64)    null,
    tradeCode       varchar(64)    null,
    tradeDirection  varchar(16)    null,
    goods           varchar(64)    null,
    amount          decimal(16, 4) null,
    paymentTime     timestamp      null,
    toUserCode      varchar(64)    null,
    status          varchar(16)    null,
    billType        varchar(16)    null,
    remark          varchar(255)   null,
    orderCode       varchar(64)    null,
    tradeCreateTime timestamp      null,
    tradeModifyTime timestamp      null,
    tradeSource     varchar(16)    null,
    type            varchar(16)    null,
    serviceFund     decimal(16, 4) null,
    refund          decimal(16, 4) null,
    fundStatus      varchar(16)    null
);
