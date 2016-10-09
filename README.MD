# Mysql Script 

```
 CREATE TABLE `testDB`.`data` (
  `id` INT NOT NULL,
  `key` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
ALTER TABLE `testDB`.`data` 
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

```
# Compile
./gradlew build

# Run
java -jar build/libs/populatedb-0.0.1-SNAPSHOT.jar 10 2