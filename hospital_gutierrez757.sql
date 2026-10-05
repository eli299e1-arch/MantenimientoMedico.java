-- Proyecto Final Desarrollo de Software III
-- Estudiante: Elizabeth Gutiérrez
-- Pasaporte: 20-53-8757
-- Grupo: 2026_1_1GS221_DS3

CREATE DATABASE IF NOT EXISTS `hospital_gutierrez757`;
USE `hospital_gutierrez757`;

DROP TABLE IF EXISTS `paciente`;
CREATE TABLE `paciente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cedula` varchar(15) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(7) NOT NULL,
  `provincia` varchar(20) NOT NULL,
  `edad` int NOT NULL,
  `sexo` char(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_paciente_cedula` (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `paciente` (`cedula`,`nombre`,`apellido`,`direccion`,`telefono`,`provincia`,`edad`,`sexo`) VALUES
('8-231-4101','Camila','Reyes','Bella Vista','6314101','Panama',24,'F'),
('4-842-4102','Mateo','Solis','David Centro','6314102','Chiriqui',37,'M'),
('3-453-4103','Valeria','Rios','Chitre Norte','6314103','Herrera',30,'F'),
('7-164-4104','Diego','Salazar','Aguadulce','6314104','Cocle',43,'M'),
('9-975-4105','Isabella','Mendez','Santiago Centro','6314105','Veraguas',28,'F'),
('2-586-4106','Gabriel','Vega','Las Tablas','6314106','Los Santos',51,'M'),
('6-297-4107','Natalia','Fuentes','Colon Centro','6314107','Colon',35,'F'),
('1-708-4108','Samuel','Herrera','Changuinola','6314108','Bocas del Toro',46,'M'),
('8-419-4109','Daniela','Paredes','San Miguelito','6314109','Panama',32,'F'),
('10-120-4110','Andres','Castillo','Arraijan','6314110','Panama Oeste',39,'M');

DROP TABLE IF EXISTS `medico`;
CREATE TABLE `medico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(4) NOT NULL,
  `cedula` varchar(15) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(7) NOT NULL,
  `especialidad` varchar(20) NOT NULL,
  `pacientes_mes` int NOT NULL,
  `pacientes_anual` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_medico_codigo` (`codigo`),
  UNIQUE KEY `uk_medico_cedula` (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `medico` (`codigo`,`cedula`,`nombre`,`apellido`,`direccion`,`telefono`,`especialidad`,`pacientes_mes`,`pacientes_anual`) VALUES
('E101','8-201-5101','Paula','Moreno','Via Argentina','6425101','Cardiologia',27,324),
('E102','8-202-5102','Julian','Acosta','Costa del Este','6425102','Pediatria',31,372),
('E103','4-203-5103','Renata','Rojas','David','6425103','Dermatologia',23,276),
('E104','3-204-5104','Tomas','Quiroz','Chitre','6425104','Medicina General',42,504),
('E105','7-205-5105','Adriana','Luna','Penonome','6425105','Ortopedia',29,348),
('E106','9-206-5106','Nicolas','Franco','Santiago','6425106','Neurologia',21,252),
('E107','2-207-5107','Beatriz','Santos','Las Tablas','6425107','Oftalmologia',25,300),
('E108','6-208-5108','Esteban','Ruiz','Colon','6425108','Ginecologia',34,408),
('E109','1-209-5109','Karla','Delgado','Bocas del Toro','6425109','Psiquiatria',19,228),
('E110','10-210-5110','Martin','Campos','La Chorrera','6425110','Odontologia',36,432);
