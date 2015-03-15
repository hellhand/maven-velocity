DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `USER_ID` int(10) unsigned NOT NULL,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `ENABLED` tinyint(1) NOT NULL,
  PRIMARY KEY (`USER_ID`)
);
INSERT INTO `users` (`USER_ID`, `USERNAME`, `PASSWORD`, `ENABLED`) VALUES (100, 'myself', 'myself', 1);

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `USER_ROLE_ID` int(10) unsigned NOT NULL,
  `USER_ID` int(10) unsigned NOT NULL,
  `AUTHORITY` varchar(45) NOT NULL,
  PRIMARY KEY (`USER_ROLE_ID`),
  CONSTRAINT `FK_user_roles` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)
);
INSERT INTO `user_roles` (`USER_ROLE_ID`, `USER_ID`, `AUTHORITY`) VALUES (1, 100, 'ROLE_USER');

DROP TABLE IF EXISTS `messages`;
CREATE TABLE IF NOT EXISTS `messages` (
  `MESSAGE_ID` int(10) unsigned NOT NULL,
  `KEY` varchar(255) NOT NULL,
  `MESSAGE` varchar(255) NOT NULL,
  PRIMARY KEY (`MESSAGE_ID`),
);
INSERT INTO `messages` (`MESSAGE_ID`, `KEY`, `MESSAGE`) VALUES (1, 'access.denied', 'Access Denied');