DROP DATABASE if exists NotesDB;
CREATE DATABASE NotesDB;

USE NotesDB;

CREATE TABLE `roles` (
  `roleid` int(11) NOT NULL,
  `rolename` varchar(25) NOT NULL,
  PRIMARY KEY (`RoleID`)
);

CREATE TABLE `users`( 
    username VARCHAR(20) NOT NULL, 
    password VARCHAR(20) NOT NULL, 
    firstname VARCHAR(20), 
    lastname VARCHAR(20), 
    email VARCHAR(40), 

    `role` INT(11) NOT NULL,
    PRIMARY KEY (username),
    KEY `FK_Role_User` (`role`),
    CONSTRAINT `FK_Role_User` FOREIGN KEY (`role`) REFERENCES `roles` (`roleid`) ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE `notes` (
  `noteid` int(11) NOT NULL AUTO_INCREMENT,
  `datecreated` datetime NOT NULL,
  `title` varchar(30) NOT NULL,
  `contents` varchar(20000) CHARACTER SET utf8 NOT NULL,
  `owner` varchar(10) NOT NULL,
  PRIMARY KEY (`noteid`),
  KEY `FK_Note_User` (`owner`),
  CONSTRAINT `FK_Note_User` FOREIGN KEY (`owner`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ;



INSERT INTO `roles` VALUES (1,'admin');
INSERT INTO `roles` VALUES (2,'regular user');

INSERT INTO `users` VALUES ('admin', 'password', '', '', 'cprg352+admin@gmail.com', 1);
INSERT INTO `users` VALUES ('admin2', 'password', 'Admin2', 'Admin2', 'cprg352+admin2@gmail.com', 1);
INSERT INTO `users` VALUES ('admin3', 'password', 'Admin3', 'Admin3', 'cprg352+admin3@gmail.com', 1);
INSERT INTO `users` VALUES ('anne', 'password', 'Anne', 'Annie', 'cprg352+anne@gmail.com', 2);
INSERT INTO `users` VALUES ('barb', 'password', 'Barb', 'Barker', 'cprg352+barb@gmail.com', 2);
INSERT INTO `users` VALUES ('carl', 'password', 'Carl', 'Carlson', 'cprg352+carl@gmail.com', 2);

INSERT INTO `notes` (`datecreated`, `title`, `contents`, `owner`) VALUES (NOW(), 'Sample note 1', 'This is a sample note.\n\nMore text in the sample note.', 'anne');
INSERT INTO `notes` (`datecreated`, `title`, `contents`, `owner`) VALUES (NOW(), 'Sample note 2', 'This is a sample note.\n\nMore text in the sample note.', 'anne');
INSERT INTO `notes` (`datecreated`, `title`, `contents`, `owner`) VALUES (NOW(), 'Sample note 3', 'This is a sample note.\n\nMore text in the sample note.', 'anne');
