DROP TABLE IF EXISTS `developers`;
CREATE TABLE `developers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `age` int DEFAULT NULL,
  `languages` varchar(255) DEFAULT NULL,
  `married` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

