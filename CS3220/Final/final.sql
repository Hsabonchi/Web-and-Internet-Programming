CREATE TABLE `expenses` (
  `id` int NOT NULL,
  `month` varchar(200) NOT NULL,
  `amount` double NOT NULL,
  `tags` varchar(900) NOT NULL
);

ALTER TABLE `expenses`
CHANGE `id` `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;

INSERT INTO `expenses` (`id`, `month`, `amount`, `tags`)
VALUES ('1', '5/2019', '17.15', 'Trader Joe, Groceries');