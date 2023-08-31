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
AUTO_INCREMENT = 13;


INSERT INTO `tasks` (`id`,`task`,`task_status`,`completed_at`,`is_deleted`,`user_id`) VALUES (1,'Install MySQL Workbench','PENDING',NULL,0,101);
INSERT INTO `tasks` (`id`,`task`,`task_status`,`completed_at`,`is_deleted`,`user_id`) VALUES (2,'Install MySQL Workbench','PENDING',NULL,0,101);
INSERT INTO `tasks` (`id`,`task`,`task_status`,`completed_at`,`is_deleted`,`user_id`) VALUES (4,'Install MySQL Workbench','PENDING',NULL,0,NULL);

-- ----------------------------------------------------------------------------
-- Table vinit_core_java_project.users
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `vinit_core_java_project`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `email_id` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
AUTO_INCREMENT = 115;

INSERT INTO `users` (`user_id`,`user_name`,`password`,`email_id`) VALUES (101,'Vinit','Passw0rd!','vinit.gore@ctr.freshworks.com');
INSERT INTO `users` (`user_id`,`user_name`,`password`,`email_id`) VALUES (102,'Vinit','Passw0rd!90183495022600','vinit.gore90183495002600@example.com');
INSERT INTO `users` (`user_id`,`user_name`,`password`,`email_id`) VALUES (103,'Vinit','Passw0rd!90185490177800','vinit.gore90185490169400@example.com');
