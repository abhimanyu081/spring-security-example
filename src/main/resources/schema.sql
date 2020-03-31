CREATE TABLE `auth_service`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);

  
CREATE TABLE `auth_service`.`authorities` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `authority` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_idx` (`username` ASC) VISIBLE,
  CONSTRAINT `fk_user`
    FOREIGN KEY (`username`)
    REFERENCES `auth_service`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

    
    ALTER TABLE `auth_service`.`authorities` 
ADD INDEX `uniq_user_authority` (`username` ASC, `authority` ASC) VISIBLE;
;
