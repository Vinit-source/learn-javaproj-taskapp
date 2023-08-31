-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: vinit_core_java_project
-- Source Schemata: vinit_core_java_project
-- Created: Wed Aug 30 17:32:03 2023
-- Workbench Version: 8.0.33
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema vinit_core_java_project
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `vinit_core_java_project` ;
CREATE SCHEMA IF NOT EXISTS `vinit_core_java_project` ;

-- ----------------------------------------------------------------------------
-- Table vinit_core_java_project.tasks
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `vinit_core_java_project`.`tasks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `task` VARCHAR(45) NULL DEFAULT NULL,
  `task_status` VARCHAR(45) NULL DEFAULT NULL,
  `completed_at` DATETIME NULL DEFAULT NULL,
  `is_deleted` TINYINT(1) NULL DEFAULT '0',
  `user_id` INT NULL DEFAULT '101',
  PRIMARY KEY (`id`),
  INDEX `FK_USER_ID_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK_USER_ID`
    FOREIGN KEY (`user_id`)
    REFERENCES `vinit_core_java_project`.`users` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `vinit_core_java_project`;

INSERT INTO `tasks` (`id`,`task`,`task_status`,`completed_at`,`is_deleted`,`user_id`) VALUES (1,'Install MySQL Workbench','PENDING',NULL,0,101);
INSERT INTO `tasks` (`id`,`task`,`task_status`,`completed_at`,`is_deleted`,`user_id`) VALUES (2,'Wash clothes','PENDING',NULL,0,101);
INSERT INTO `tasks` (`id`,`task`,`task_status`,`completed_at`,`is_deleted`,`user_id`) VALUES (4,'Pending groceries','PENDING',NULL,0,NULL);
INSERT INTO `tasks` (`id`,`task`,`task_status`,`completed_at`,`is_deleted`,`user_id`) VALUES (5,'Book train ticket','PENDING',NULL,0,NULL);
INSERT INTO `tasks` (`id`,`task`,`task_status`,`completed_at`,`is_deleted`,`user_id`) VALUES (6,'Perform project assignment','PENDING',NULL,0,NULL);

-- ----------------------------------------------------------------------------
-- Table vinit_core_java_project.users
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `vinit_core_java_project`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `email_id` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 102
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `users` (`user_id`,`user_name`,`password`,`email_id`) VALUES (101,'Vinit','Passw0rd!','vinit.gore@ctr.freshworks.com');

SET FOREIGN_KEY_CHECKS = 1;
