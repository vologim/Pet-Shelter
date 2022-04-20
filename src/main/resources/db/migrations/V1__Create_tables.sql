create table phone_number(
    id bigint primary key auto_increment,
    number_phone varchar(20) not null unique
);

create table shelter(
    id bigint primary key auto_increment,
    name varchar(50) not null,
    address varchar(100) not null
);

create table curator(
    id bigint primary key auto_increment,
    first_name varchar(25) not null,
    last_name varchar(30) not null,
    patronymic varchar(30),
    date_birth date not null,
    address varchar(100) not null
);

create table pet(
    id bigint primary key auto_increment,
    name varchar(15) not null,
    type varchar(10) not null,
    address_photo varchar(255) not null,
    date_birth date,
    breed varchar(25) not null,
    sex char(1) not null,
    color varchar(20) not null,
    information text,
    curator_id bigint not null,
    shelter_id bigint not null,
    foreign key (curator_id) references curator(id),
    foreign key (shelter_id) references shelter(id)
);

create table phones_shelter(
    shelter_id bigint not null,
    phone_number_id bigint not null,
    foreign key (shelter_id) references shelter(id),
    foreign key (phone_number_id) references phone_number(id)
);

create table phones_curator(
    curator_id bigint not null,
    phone_number_id bigint not null,
    foreign key (curator_id) references curator(id),
    foreign key (phone_number_id) references phone_number(id)
);

create table shelter_curator(
    shelter_id bigint not null,
    curator_id bigint not null,
    foreign key (shelter_id) references shelter(id),
    foreign key (curator_id) references curator(id)
);