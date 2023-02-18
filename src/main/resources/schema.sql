drop table persons;

create table persons
(
    personId  varchar(20),
    firstName varchar(255),
    lastName  varchar(255),
    address   varchar(255),
    city      varchar(255)
);

drop table advertisement;
CREATE TABLE advertisement
(
    carRegistrationNumber varchar(255) DEFAULT NULL,
    price                 int(11) DEFAULT NULL,
    Id                    bigint(19) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (Id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

drop table car;

CREATE TABLE car
(
    Make               varchar(255) DEFAULT NULL,
    Model              varchar(255) DEFAULT NULL,
    Year               int(11) DEFAULT NULL,
    RegistrationNumber varchar(255) DEFAULT NULL,
    Fuel               varchar(255) DEFAULT NULL,
    Milage             int(11) DEFAULT NULL,
    Color              varchar(255) DEFAULT NULL,
    Id                 bigint(19) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (Id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE employee
(
    id          INT         NOT NULL AUTO_INCREMENT,
    personal_id VARCHAR(11) NOT NULL,
    name        VARCHAR(45) NOT NULL,
    surname     VARCHAR(45) NOT NULL,
    salary      INT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE mammal
(
    id   INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NULL,
    type VARCHAR(45) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE teacher
(
    documentId INT         NOT NULL,
    licence    VARCHAR(45) NOT NULL,
    firstName  VARCHAR(45) NULL,
    lastName   VARCHAR(45) NULL,
    PRIMARY KEY (documentId, licence)
);

CREATE TABLE book
(
    id    int(11) NOT NULL AUTO_INCREMENT,
    title varchar(45) DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE book_type
(
    id   int(11) NOT NULL AUTO_INCREMENT,
    type varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE student_books
(
    id     INT NOT NULL AUTO_INCREMENT,
    number VARCHAR(45) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE students
(
    id              INT NOT NULL AUTO_INCREMENT,
    first_name      VARCHAR(45) NULL,
    last_name       VARCHAR(45) NULL,
    birth_date      DATETIME NULL,
    student_book_id INT NULL,
    PRIMARY KEY (id)
);
