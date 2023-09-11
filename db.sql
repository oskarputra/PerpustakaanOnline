CREATE DATABASE `perpustakaan` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `book_transaction` (
  `is_return` bit(1) NOT NULL,
  `borrow_date` datetime(6) DEFAULT NULL,
  `return_date` datetime(6) DEFAULT NULL,
  `transaction_id` bigint NOT NULL,
  `book_isbn` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  UNIQUE KEY `UK_rb3hox4en7bbmwlyx12y9rwlp` (`book_isbn`),
  UNIQUE KEY `UK_nkfha4a1qh89dm615uj8sg9re` (`user_email`),
  CONSTRAINT `FK3f8jy5pqpe1hddpmhd2lkhvfw` FOREIGN KEY (`user_email`) REFERENCES `users` (`email`),
  CONSTRAINT `FKmp16n0f1cbau90wl114qt2xfe` FOREIGN KEY (`book_isbn`) REFERENCES `books` (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `book_transaction_history` (
  `is_return` bit(1) NOT NULL,
  `borrow_date` datetime(6) DEFAULT NULL,
  `return_date` datetime(6) DEFAULT NULL,
  `transaction_id` bigint NOT NULL,
  `book_isbn` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  UNIQUE KEY `UK_80mmxm6tk8qp0vs7lue007xe2` (`book_isbn`),
  UNIQUE KEY `UK_5uhwk2hqbq2qmlf1y09nxes0u` (`user_email`),
  CONSTRAINT `FK_5uhwk2hqbq2qmlf1y09nxes0u` FOREIGN KEY (`user_email`) REFERENCES `users` (`email`),
  CONSTRAINT `FK_80mmxm6tk8qp0vs7lue007xe2` FOREIGN KEY (`book_isbn`) REFERENCES `books` (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `book_transaction_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `books` (
  `author` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `role` int NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
