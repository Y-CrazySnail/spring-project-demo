create table user
(
    id                      bigint(11) auto_increment
        primary key,
    username                varchar(255) not null,
    password                varchar(255) not null,
    account_non_expired     tinyint(1)   not null,
    account_non_locked      tinyint(1)   not null,
    credentials_non_expired tinyint(1)   not null,
    enabled                 tinyint(1)   not null
)
    charset = utf8;

create table role
(
    id          bigint(11) auto_increment
        primary key,
    name        varchar(63)  not null,
    description varchar(127) not null
);

create table permission
(
    id          bigint(11) auto_increment
        primary key,
    url         varchar(255) not null,
    name        varchar(255) not null,
    description varchar(255) null
)
    charset = utf8;


create table user_role
(
    user_id bigint(11) not null,
    role_id bigint(11) not null
)
    charset = utf8;

create table role_permission
(
    role_id       bigint(11) not null,
    permission_id bigint(11) not null
)
    charset = utf8;

create table oauth_client_details
(
    client_id               varchar(48)   not null
        primary key,
    resource_ids            varchar(256)  null,
    client_secret           varchar(256)  null,
    scope                   varchar(256)  null,
    authorized_grant_types  varchar(256)  null,
    web_server_redirect_uri varchar(256)  null,
    authorities             varchar(256)  null,
    access_token_validity   int           null,
    refresh_token_validity  int           null,
    additional_information  varchar(4096) null,
    autoapprove             varchar(256)  null
)
    charset = utf8;
