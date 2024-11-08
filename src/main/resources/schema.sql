create table if not exists ingredient
(
    id   varchar(4)  not null primary key,
    name varchar(25) not null,
    type varchar(10) not null
);

create table if not exists taco
(
    id         identity primary key,
    name       varchar(50) not null,
    created_at timestamp   not null,
    taco_order bigint
);

create table if not exists taco_order
(
    id              identity primary key,
    delivery_name   varchar(50) not null,
    delivery_street varchar(50) not null,
    delivery_city   varchar(50) not null,
    delivery_state  varchar(2)  not null,
    delivery_zip    varchar(10) not null,
    cc_number       varchar(16) not null,
    cc_expiration   varchar(5)  not null,
    cc_cvv          varchar(3)  not null,
    placed_at       timestamp   not null
);

create table if not exists taco_ingredients_ref
(
    taco_id       bigint     not null,
    ingredient_id varchar(4) not null,
    primary key (taco_id, ingredient_id),
    foreign key (taco_id) references taco (id),
    foreign key (ingredient_id) references ingredient (id)
);
