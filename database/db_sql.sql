/*Creating database schema called 'goodreads_db'*/
CREATE DATABASE `goodreads_db`;

/*Creating table called 'book'*/
CREATE TABLE book (
   id bigint NOT NULL AUTO_INCREMENT,
   author varchar(255) DEFAULT NULL,
   from_date datetime(6) DEFAULT NULL,
   genre varchar(255) DEFAULT NULL,
   isbn int(50) DEFAULT NULL,
   language varchar(255) DEFAULT NULL,
   published varchar(50) DEFAULT NULL,
   summary varchar(255) DEFAULT NULL,
   title varchar(255) DEFAULT NULL,
   until_date datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

/*Insert books into 'books' table*/
INSERT INTO goodreads_db.book (author, genre, isbn, language, published, summary, title)
VALUES 
("F. Scott", "Classics", "9780743273565", "EN", "April 10, 1925", "The Great Gatsby, F. Scott Fitzgerald's third book, stands as the supreme achievement of his career. This exemplary novel of the Jazz Age has been acclaimed by generations of readers.", "The Great Gatsby"),
("Harper Lee", "Fiction", "9780743273565", "EN", "January 1, 1960", "The unforgettable novel of a childhood in a sleepy Southern town and the crisis of conscience that rocked it.", "To Kill a Mockingbird");

/*Creating table called 'users'*/
CREATE TABLE users (
  id bigint NOT NULL AUTO_INCREMENT,
  about_me varchar(255) DEFAULT NULL,
  address varchar(255) DEFAULT NULL,
  date_of_birth date DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  full_name varchar(255) DEFAULT NULL,
  gender char(1) DEFAULT NULL,
  my_interests varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  phone_number varchar(255) DEFAULT NULL,
  username varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

/*Creating table called 'quote'*/
CREATE TABLE quote (
  id bigint NOT NULL AUTO_INCREMENT,
  from_date datetime(6) DEFAULT NULL,
  quote varchar(255) DEFAULT NULL,
  until_date datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

/*Creating table called 'book_shelf'*/
CREATE TABLE book_shelf (
  id bigint NOT NULL AUTO_INCREMENT,
  description varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

/*Creating table called 'community_group'*/
CREATE TABLE community_group (
  id bigint NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

/*Creating table called 'roles'*/
CREATE TABLE roles (
  id bigint NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

/*Insert roles into 'roles' table*/
INSERT INTO goodreads_db.roles (description, name)
VALUES 
("User rights", "USER"),
("Admin rights", "ADMIN");

/*Creating table called 'book_review'*/
CREATE TABLE book_review (
  user_id bigint NOT NULL,
  book_id bigint NOT NULL,
  KEY `FK29oatdl4f30mtg65oxo1nkmjg` (`book_id`),
  KEY `FKntncp0b191bex8jkm3vy3l13x` (`user_id`),
  CONSTRAINT `FK29oatdl4f30mtg65oxo1nkmjg` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FKntncp0b191bex8jkm3vy3l13x` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

/*Creating table called 'user_in_community_group'*/
CREATE TABLE user_in_community_group (
  user_id bigint NOT NULL,
  community_group_id bigint NOT NULL,
  KEY `FKowkckrggutpbl1yupkvmtr492` (`community_group_id`),
  KEY `FKn47ewqhlolpaq0mbsxdg6denp` (`user_id`),
  CONSTRAINT `FKn47ewqhlolpaq0mbsxdg6denp` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKowkckrggutpbl1yupkvmtr492` FOREIGN KEY (`community_group_id`) REFERENCES `community_group` (`id`)
);

/*Creating table called 'user_in_role'*/
CREATE TABLE user_in_role (
  user_id bigint NOT NULL,
  role_id bigint NOT NULL,
  KEY `FKkkk21vnh7bj1l211or835d1u6` (`role_id`),
  KEY `FKicvmvsdy3xjq3equobp852m7h` (`user_id`),
  CONSTRAINT `FKicvmvsdy3xjq3equobp852m7h` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKkkk21vnh7bj1l211or835d1u6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
);

/*Creating table called 'user_quotes'*/
CREATE TABLE user_quotes (
  user_id bigint NOT NULL,
  quote_id bigint NOT NULL,
  KEY `FKcl2by1kr2eqdd0n6400ujshiw` (`quote_id`),
  KEY `FKn4gnuw43k2hcftghqnypw647` (`user_id`),
  CONSTRAINT `FKcl2by1kr2eqdd0n6400ujshiw` FOREIGN KEY (`quote_id`) REFERENCES `quote` (`id`),
  CONSTRAINT `FKn4gnuw43k2hcftghqnypw647` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

/*Creating table called 'user_shelves'*/
CREATE TABLE user_shelves (
  user_id bigint NOT NULL,
  book_shelf_id bigint NOT NULL,
  KEY `FKe9fgf5w4piqdtnkslibxq76iw` (`book_shelf_id`),
  KEY `FKshwh4lje5m5nj6py2s8dm5lxg` (`user_id`),
  CONSTRAINT `FKe9fgf5w4piqdtnkslibxq76iw` FOREIGN KEY (`book_shelf_id`) REFERENCES `book_shelf` (`id`),
  CONSTRAINT `FKshwh4lje5m5nj6py2s8dm5lxg` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);




