CREATE TABLE `clients`
(
    `id`           int(11)     NOT NULL AUTO_INCREMENT,
    `username`     varchar(45) NOT NULL,
    `first_name`   varchar(45) NOT NULL,
    `second_name`  varchar(45) NOT NULL,
    `phone_number` bigint(20)  NOT NULL,
    `doctor_cards` varchar(50)          DEFAULT NULL,
    `password`     varchar(45) NOT NULL,
    `role`         int(11)     NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`),
    UNIQUE KEY `username` (`username`)
);

CREATE TABLE `pets`
(
    `id`     int(11)     NOT NULL AUTO_INCREMENT,
    `gender` varchar(50) NOT NULL DEFAULT '0',
    `name`   varchar(45)          DEFAULT NULL,
    `type`   varchar(45)          DEFAULT NULL,
    `age`    int(11)              DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `client_pets`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `client_id` int(11) NOT NULL,
    `pet_id`    int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `owner_id` (`client_id`),
    KEY `pet_id` (`pet_id`),
    CONSTRAINT `FK_connected_pets_with_owner_pets` FOREIGN KEY (`pet_id`) REFERENCES `pets` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `FK_connected_pets_with_owner_users` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `disease_histories`
(
    `id`          int(11)       NOT NULL AUTO_INCREMENT,
    `description` varchar(2000) NOT NULL,
    `sender_id`   int(11)       NOT NULL,
    `date_visit`  date          NOT NULL,
    `pet_id`      int(11)       DEFAULT NULL,
    `doctor_id`   int(11)       DEFAULT '0',
    `date_answer` date          DEFAULT NULL,
    `answer`      varchar(2000) DEFAULT NULL,
    `doctor_type` int(11)       DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `doctor_info`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `doctor_id`   int(11) DEFAULT '0',
    `vote_amount` int(11) DEFAULT '0',
    `sum_vote`    int(11) DEFAULT '0',
    `specialty`   int(11) DEFAULT '0',
    `result`      double  DEFAULT '0',
    PRIMARY KEY (`id`)
);


CREATE TABLE `unregistered_doctor_cards`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `name_card` varchar(50) DEFAULT '0',
    PRIMARY KEY (`id`)
);