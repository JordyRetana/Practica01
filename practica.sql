/*Se crea la base de datos */
drop schema if exists practica;
drop user if exists usuario_prueba;
CREATE SCHEMA practica ;

/*Se crea un usuario para la base de datos llamado "usuario_prueba" y tiene la contraseña "Usuario_Clave."*/
create user 'usuario_pruebaarbol'@'%' identified by 'Usuar1o_Clavearbol.';

/*Se asignan los prvilegios sobr ela base de datos TechShop al usuario creado */
grant all privileges on practica.* to 'usuario_pruebaarbol'@'%';
flush privileges;

/* la tabla de categoria contiene categorias de productos*/
create table practica.arbol (
  id_arbol INT NOT NULL AUTO_INCREMENT,
  nombre_común VARCHAR(30) NOT NULL,
  tipo_flor VARCHAR(30) NOT NULL,
  dureza_madera VARCHAR(30) NOT NULL,
  otros VARCHAR(30) NOT NULL,
  ruta_imagen varchar(1024),
  activo bool,
  PRIMARY KEY (id_arbol))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
