CREATE TABLE IF NOT EXISTS `events` (
    `event_id` bigint NOT NULL,
    `event_name` varchar(100) NOT NULL,
    `event_description` varchar(255) DEFAULT NULL,
    `start_datetime` datetime NOT NULL,
    `end_datetime` datetime NOT NULL,
    `organizer_id` bigint NOT NULL,
    `location_id` bigint NOT NULL,
    `created_at` date NOT NULL,
    `created_by` varchar(20) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
  );