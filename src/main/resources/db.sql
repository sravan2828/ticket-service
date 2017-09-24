-- Dumping database structure for concretepage
CREATE DATABASE IF NOT EXISTS `service`;
USE `service`;
-- Dumping structure for table concretepage.articles
CREATE TABLE IF NOT EXISTS `ticket` (
  `ticket_id` int(5) NOT NULL AUTO_INCREMENT,
  `ticket_type` varchar(200) NOT NULL,
  `ticket_category` varchar(100) NOT NULL,
  PRIMARY KEY (`ticket_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
-- Dumping data for table concretepage.articles: ~3 rows (approximately)
INSERT INTO `ticket` (`ticket_id`, `ticket_type`, `ticket_category`) VALUES
	(1, 'Java Concurrency', 'Java'),
	(2, 'Hibernate HQL ', 'Hibernate'),
	(3, 'Spring MVC with Hibernate', 'Spring'); 