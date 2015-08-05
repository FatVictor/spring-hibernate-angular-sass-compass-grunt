# spring-hibernate-angular-sass-compass-grunt
This project is experiment for Spring, Hibernate, AngularJs, SASS and GruntJs


Step:
1. Create database name <db_name> for mysql

2. Create table person with structure like below:

    CREATE TABLE `person` (
    
      `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
      
      `name` varchar(100) NOT NULL,
      
      `country` varchar(50) NOT NULL,
      
      PRIMARY KEY (`id`) USING BTREE
      
    ) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

3. Update database connection in file WEB-INF/app-context.xml

