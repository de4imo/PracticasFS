Pasos(hay que tener instalado postgre en docker):

1.-Con maven crear el jar de la aplicacion y poner el archivo Dockerfile(el puerto que 
	pongamos en expose será el qué usemos en windows para acceder al programa).

2.-dockerizarlo con 'docker build -t spring .' estando en el el directorio
	de la aplicacion con la terminal de windows.

3.-Crear una red dentro de docker en la que estarán la aplicación dockerizada y postgresql
	'docker network create mynetwork'.

4.-Ejecutamos postgre en esa red: 
	docker run --network mynetwork --name postgres_test -ePOSTGRES_USER=postgres -e POSTGRES_PASSWORD=contrasena -e POSTGRES_DB=test -p5432:5432 -d postgres
	ó
	docker run --network mynetwork --name postgres_test -ePOSTGRES_USER=postgres -e POSTGRES_PASSWORD=contrasena -e POSTGRES_DB=test -p5432:5432 postgres

	ciertos parametros tienen que ser iguales que los que pusimos en 
	'application.properties'

5.-Abrimos otra terminal y ejecutamos nuestra aplicación, también en la misma red:
	docker run --network mynetwork --name programa_spring_15 -p8080:8080 -d spring
	Ó
	docker run --network mynetwork --name programa_spring_15 -p8080:8080 spring
	
	
	
	
![image](https://user-images.githubusercontent.com/89456856/148206606-f2707d2a-2b19-4b5f-8c97-3b735eba87c5.png)
