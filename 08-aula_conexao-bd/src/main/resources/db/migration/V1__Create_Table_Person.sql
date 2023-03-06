CREATE TABLE `person` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `first_name` varchar(80) NOT NULL,
                          `last_name` varchar(255) DEFAULT NULL,
                          `address` varchar(255) DEFAULT NULL,
                          `gender` varchar(6) DEFAULT NULL,
                          PRIMARY KEY (`id`)
);