-- if we alreade have a similar table, we delete it
DROP TABLE IF EXISTS `personaje`;

-- we create the structure of the table
CREATE TABLE IF NOT EXISTS `personaje` (
  `nume` varchar(20) NOT NULL default '',
  `puteri` varchar(20) NOT NULL default '',
  `varsta` int(3) NOT NULL default '0'
);

-- we insert the data
INSERT INTO `personaje` (`nume`, `puteri`, `varsta`) VALUES ('Scufita Rosie', 'sapca rosie', 500),
('Alba ca zapada', 'alba', 700),('Dexter', 'geniu', 8),('Scooby', 'vorbeste si are pete', 20);
