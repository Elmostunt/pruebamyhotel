Prueba 2 Guillermo Carcamo.

Para el levantamiento de este Componente es necesario tener una instancia de MySql corriendo. La base de datos creada y descrita en el application.properties de este mismo.
Siendo : dbtest el nombre de la bbdd, usuario "root" pass "pass"


Properties aplicacion
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/dbtest?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC 
spring.datasource.username=root
spring.datasource.password=pass
spring.jpa.hibernate.ddl-auto=create

Como faltante de implementacion quedaria:
Manejo de JWT para autenticacion.
Manejo de Swagger para levantar documentacion. 
Creacion de Querys especificas por JPA @Query


El proyecto contempla para la parte uno endpoints
com.prueba.myhotel.vehiculos.controller - VehiculosController (Maneja una lista) Auto y Camion extienden de vehiculo
com.prueba.myhotel.empresa.controller   - EmpresaController   (Maneja la base de datos)

-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------

1.- Se crea clase controladora, Siendo un CRUD completo que trabajaria con una lista. Sobre cada vehiculo se le pueden añadir mantenimientos a traves del endpoint descrito. (com.prueba.myhotel.vehiculos.controller)

Ejemplo de vehiculo (Auto a añadir) Generado para probar desde postman

{
    "tipo": "mini",
    "numeroPuertas": 2,
    "cantidadPasajeros": 2,
    "capacidadMaletero": 1,
    "marca": "chevrolet",
    "modelo": "astra",
    "patente": "ABC123",
    "año": "1999",
    "kilometraje": 1000,
    "cilindrada": 100,
    "mantenimientos": [
        {
            "fecha": "Mar 6, 2021, 5:42:27 PM",
            "detalle": "Detalle"
        }
    ]
}
Endpoints: 
	localhost:8080/vehiculo/{id} -> Endpoint GET para obtener  vehiculo de id en particular
	localhost:8080/add/vehiculo  -> Endpoint POST para Almacenar  vehiculo se retorna mensaje descriptivo, en caso de añadir JPA se puede devolver id 
	localhost:8080/eliminar/{id} -> Endpoint DELETE para obtener id de vehiculo en particular
	localhost:8080/update/vehiculo/{id}	-> Endpoint POST para actualizar vehiculo en particular dado su ID
	localhost:8080/listar/vehiculos -> Endpoint GET para actualizar vehiculo en particular dado su ID
	localhost:8080/add/mantenimiento/{id} -> Endpoint POST para Almacenar  vehiculo se retorna ID 


-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------

2.- Para la parte SQL se me dificultó un poco dado que no he estado muy activo creando consultas. 


Adjunto Schema para instalacion de Base de datos en caso de no funcionar el levantamiento de estas por JPA. Posterior a este se adjunta consultas SQL para cada caso mencionado

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`jobs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`jobs` ;

CREATE TABLE IF NOT EXISTS `mydb`.`jobs` (
  `JOB_ID` VARCHAR(10) NOT NULL,
  `JOB_TITLE` VARCHAR(35) NULL,
  `MIN_SALARY` DECIMAL(6) NULL,
  `MAX_SALARY` DECIMAL(6) NULL,
  PRIMARY KEY (`JOB_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`regions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`regions` ;

CREATE TABLE IF NOT EXISTS `mydb`.`regions` (
  `REGION_ID` DECIMAL(5) NOT NULL,
  `REGION_NAME` VARCHAR(25) NULL,
  PRIMARY KEY (`REGION_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`countries`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`countries` ;

CREATE TABLE IF NOT EXISTS `mydb`.`countries` (
  `COUNTRY_ID` VARCHAR(2) NOT NULL,
  `COUNTRY_NAME` VARCHAR(40) NULL,
  `REGION_ID` DECIMAL NULL,
  PRIMARY KEY (`COUNTRY_ID`),
  INDEX `REGION_ID_idx` (`REGION_ID` ASC) VISIBLE,
  CONSTRAINT `REGION_ID`
    FOREIGN KEY (`REGION_ID`)
    REFERENCES `mydb`.`regions` (`REGION_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`locations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`locations` ;

CREATE TABLE IF NOT EXISTS `mydb`.`locations` (
  `LOCATION_ID` DECIMAL(4) NOT NULL,
  `STREET_ADDRESS` VARCHAR(40) NULL,
  `POSTAL_CODE` VARCHAR(12) NULL,
  `CITY` VARCHAR(30) NULL,
  `STATE_PROVINCE` VARCHAR(25) NULL,
  `COUNTRY_ID` VARCHAR(2) NULL,
  PRIMARY KEY (`LOCATION_ID`),
  INDEX `COUNTRY_ID_idx` (`COUNTRY_ID` ASC) VISIBLE,
  CONSTRAINT `COUNTRY_ID`
    FOREIGN KEY (`COUNTRY_ID`)
    REFERENCES `mydb`.`countries` (`COUNTRY_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`departments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`departments` ;

CREATE TABLE IF NOT EXISTS `mydb`.`departments` (
  `DEPARTMENT_ID` DECIMAL(4) NOT NULL,
  `DEPARTMENT_NAME` VARCHAR(30) NULL,
  `MANAGER_ID` DECIMAL(6) NULL,
  `LOCATION_ID` DECIMAL(4) NULL,
  PRIMARY KEY (`DEPARTMENT_ID`),
  INDEX `LOCATION_ID_idx` (`LOCATION_ID` ASC) VISIBLE,
  CONSTRAINT `LOCATION_ID`
    FOREIGN KEY (`LOCATION_ID`)
    REFERENCES `mydb`.`locations` (`LOCATION_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`job_history`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`job_history` ;

CREATE TABLE IF NOT EXISTS `mydb`.`job_history` (
  `EMPLOYEE_ID` DECIMAL(6) NOT NULL,
  `START_DATE` DATE NULL,
  `END_DATE` DATE NULL,
  `JOB_ID` VARCHAR(10) NULL,
  `DEPARTMENT_ID` DECIMAL(4) NULL,
  PRIMARY KEY (`EMPLOYEE_ID`),
  INDEX `JOB_ID_idx` (`JOB_ID` ASC) VISIBLE,
  INDEX `DEPARTMENT_ID_idx` (`DEPARTMENT_ID` ASC) VISIBLE,
  CONSTRAINT `JOB_ID`
    FOREIGN KEY (`JOB_ID`)
    REFERENCES `mydb`.`jobs` (`JOB_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `DEPARTMENT_ID`
    FOREIGN KEY (`DEPARTMENT_ID`)
    REFERENCES `mydb`.`departments` (`DEPARTMENT_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`employees`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`employees` ;

CREATE TABLE `mydb`.`employees` (
  `EMPLOYEE_ID` DECIMAL(6) NOT NULL,
  `FIRST_NAME` VARCHAR(20) NULL,
  `LAST_NAME` VARCHAR(25) NULL,
  `EMAIL` VARCHAR(25) NULL,
  `PHONE_NUMBER` VARCHAR(20) NULL,
  `HIRE_DATE` DATE NULL,
  `JOB_ID` VARCHAR(10) NULL,
  `SALARY` DECIMAL(8,2) NULL,
  `COMMISION_PCT` DECIMAL(2,2) NULL,
  `MANAGER_ID` DECIMAL(6) NULL,
  `DEPARTMENT_ID` DECIMAL(4) NULL,
  PRIMARY KEY (`EMPLOYEE_ID`),
  INDEX `JOB_ID_idx` (`JOB_ID` ASC) VISIBLE,
  INDEX `DEPARTMENT_ID_idx` (`DEPARTMENT_ID` ASC) VISIBLE,
  CONSTRAINT `JOB_ID_EMP`
    FOREIGN KEY (`JOB_ID`)
    REFERENCES `mydb`.`jobs` (`JOB_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `DEPARTMENT_ID_EMP`
    FOREIGN KEY (`DEPARTMENT_ID`)
    REFERENCES `mydb`.`departments` (`DEPARTMENT_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

CONSULTAS EJERCICIO 2

i )
SELECT COUNT(*) FROM EMPLOYEES WHERE SALARY < 3500 OK
SELECT COUNT(*) FROM EMPLOYEES WHERE SALARY >= 3500 AND SALARY < 8000
SELECT COUNT(*) FROM EMPLOYEES WHERE SALARY >= 8000

ii ) 
SELECT COUNT(*) FROM EMPLOYEES e, DEPARTMENTS d WHERE SALARY < 3500 AND d.DEPARTMENT_ID = e.DEPARTMENT_ID AND e.DEPARTMENT_ID = 1;
SELECT COUNT(*) FROM EMPLOYEES e, DEPARTMENTS d WHERE SALARY  >= 3500 AND d.DEPARTMENT_ID = e.DEPARTMENT_ID AND e.DEPARTMENT_ID = 1;
SELECT COUNT(*) FROM EMPLOYEES e, DEPARTMENTS d WHERE SALARY >= 8000 AND d.DEPARTMENT_ID = e.DEPARTMENT_ID AND e.DEPARTMENT_ID = 1;

SELECT COUNT(*) FROM EMPLOYEES e, DEPARTMENTS d WHERE SALARY < 3500 AND d.DEPARTMENT_ID = e.DEPARTMENT_ID AND e.DEPARTMENT_ID = 2;
SELECT COUNT(*) FROM EMPLOYEES e, DEPARTMENTS d WHERE SALARY  >= 3500 AND d.DEPARTMENT_ID = e.DEPARTMENT_ID AND e.DEPARTMENT_ID = 2;
SELECT COUNT(*) FROM EMPLOYEES e, DEPARTMENTS d WHERE SALARY >= 8000 AND d.DEPARTMENT_ID = e.DEPARTMENT_ID AND e.DEPARTMENT_ID = 2;

iii) 
SELECT d.department_id , d.department_name, MAX(SALARY) FROM employees e , departments d  WHERE  d.department_id =  e.department_id GROUP BY  department_id;  (MALA) 

vi)
SELECT * FROM EMPLOYEES WHERE TIMESTAMPDIFF(YEAR, HIRE_DATE, '2021-03-03') > 15;


v ) 
SELECT AVG(SALARY) FROM EMPLOYEES e , Departments d WHERE e.department in (SELECT department_id)  WHERE SELECT COUNT > 10 


vi) 

SELECT COUNT(*) AVG(SALARY), MAX(SALARY) Salario_maximo, MIN(SALARY) salario_minimo, promedio_años 
SELECT brand_name, MAX(list_price) max_list_price FROM EMPLOYEES e,
GROUP BY country_name (MALA)



-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------

3.- Para el componente del segundo ejercicio dejo estructura creada para levantar schema en base de datos Mysql a partir del codigo , se emplea @Entity, @Table, @ManyToOne, entre otras anotaciones, estas proveen soporte hacia la base de datos creando el schema completo. 

Por temas de tiempo no alcance a completar logica, pero Las consultas que se describen en la parte 2 las podria crear en JAVA dado las implementaciones de repositorios.
Se crean repositorios para cada tabla, ya con estos la logica de algunas consultas se pueden crear aqui.
Pero en otros casos de puede implementar las Querys sobre los repositorios con  @Query sobre el repositorio del que quisiese obtener informacion.

Endpoints: 
De momento solo cree endpoints para el manejo de empleados.
	 @GetMapping(path= "/getall")
	 @PostMapping(path="/addEmployee")
	 @DeleteMapping(path="/deleteEmployee/{id}")
	 @GetMapping(path="getEmployeeById/{id}")

