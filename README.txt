/*
 * Copyright (C) 2014  Marc Boulanger
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.*
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

-------
1 ) 
	This maven project is self sustained, which means that there is no need of an external database or a application server.
		- This project is based on Spring regarding the Components and the Services,
		- It uses Spring Security for the login authentification,
		- It uses Jersey for an easier and cleaner way to work with the Controllers,
		- It uses Velocity to render the pages with Velocity Tools being used to have access to the most frequently utils,
		- It uses Jetty as an embedded application server,
		- It uses H2DB for file contained database, the schema is created and populated in the init_01.sql file, it is
		targeted in the application.properties file, and is passed as a startup argument to the driver.
	
	It can be reconfigured to use a MySQL database (example config present).
	It can be packaged to deploy it on an application server.
	
	It is done so this project can be easily used as a template for web projects, fast modifications allow it to be quite
	versatile.

-------
2)
	There are a few things that need to be done before running the application
		- make sure maven is installed on your pc and is in the classpath,
		- you can modify file.resource.loader.path in velocity.properties, change the path to match your configuration,
		if you want to override templates contained in the webapp (for production updates without redeploy),
		- you can modify app.jdbc.url in application.properties

-------
3)
	The application can be launched with : mvn clean jetty:run when you are in the maven-velocity-frontend directory