CREATE TABLE IF NOT EXISTS `locations` (
  `location_id` bigint NOT NULL,
  `location_name` varchar(100) NOT NULL,
  `address` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `capacity` int NOT NULL,
  `rental_price` decimal(10, 2), -- (max digits, decimal places)
  `created_at` date NOT NULL,
  `created_by` varchar(20) NOT NULL,
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL
);