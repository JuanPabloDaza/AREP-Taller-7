# AREP-Taller-7

En este taller se tuvo como objetivo realizar un servidor web utilizando Spark que implementara llaves privadas para mantener la seguridad de las peticiones.

## Para ejecutar el programa

Se puede hacer uso del comando git clone y usar la URL del repositorio:
```
https://github.com/JuanPabloDaza/AREP-Taller-7
```

## Prerequisitos

Es necesario tener instalado maven para compilar y probar los test del programa, si no se tiene maven puede instalar [aqui](https://maven.apache.org/install.html).

## Despliegue del programa:

Es necesario ejecutar el comando:

```
mvn exec:java
```

Este comando debe ser ejecutado en dos directorios, el primero OtherService y el segundo LoginService


## Descripcion del programa:

### Diseño:

En este programa se usa la clase LoginService.java para dar un login a los usuarios y una vez identificados se conectara con el otro servidor para solicitarle un servicio.

### Implementacion:

#### Desarrollo servidor:

Para empezar tenemos la clase LoginService.java que recibe las peticiones y retorna la pagina principal o utiliza la clase HttpConnectionExample.java para realizar las peticiones a alguno de los servicios.<br>

![](./Images/Login.png)<br>

Cuando un usuario se autentica correctamente LoginService hace un llamado a OtherService con al finalidad de que le retorne la informacion al usuario, en este caso es una simple pagina. Para probar la funcionalidad el único usuario registrado es juan con contraseña 123.<br>

![](./Images/OtherService.png)<br>



#### Manejo de llaves y encriptado:

Para el ejercicio se crearon llaves privadas, las cuales estan en el directorio keystore de ambos servidores. Si comentamos el codigo donde le asignamos su llave a OtherService.java e intentamos realizar el llamado podemos ver que se genera la siguiente error debido a que no tiene la llave en la que LoginService confia:<br>

![](./Images/Llaves.png)<br>

Las contraseñas de los usuarios son encriptadas desde el javaScript de la pagina index.html para garantizar que no se conozcan las contraseñas.


## Construido con:

* [Maven](https://maven.apache.org/) - Manejo de dependecias.

## Autor

* Juan Pablo Daza Pinzón