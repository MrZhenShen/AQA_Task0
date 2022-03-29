 CREATE SCHEMA `aqa_task` ;

 GO
 CREATE TABLE `aqa_task`.`client` (
   `id_client` INT NOT NULL,
   `first_name` VARCHAR(45) NULL,
   `second_name` VARCHAR(45) NULL,
   `join_date` DATETIME NULL,
   `job` VARCHAR(45) NULL,
   PRIMARY KEY (`id_client`));

   go
   CREATE TABLE `aqa_task`.`device` (
     `id_device` INT NOT NULL,
     `model` VARCHAR(45) NULL,
     `type` VARCHAR(45) NULL,
     PRIMARY KEY (`id_device`));


CREATE TABLE `aqa_task`.`client_order` (
  `id_client_order` INT NOT NULL,
  `id_client` VARCHAR(45) NULL,
  `id_device` VARCHAR(45) NULL,
  PRIMARY KEY (`id_client_order`));
