# Descripcion

Los servicio construidos son:

* [Crear Usuario](http://localhost:8080/api/create)
* [Generar Token](http://localhost:8080/login?user=admin&password=admin)


Request de ejemplo para cada servicio:

	Crear Usuario:
{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez666.org",
    "password": "hunter2",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}



Se implementa swagger:

* [swagger-ui](http://localhost:8080/swagger-ui/index.html)

Se implementa Base de Datos H2:

* [h2-console](http://localhost:8080/h2-console)

### Instrucciones de despliege

Para desplegar el proyecto  desde STS, solo se necesita dar start al proyecto en el Boot Dashboard,
no se incluye script de BD ya que tablas se crean en funcion la las entidades descritas.

### Instrucciones de invocacion
Para generar token se debe llamar al servicio de generacion de token con usuario y password admin.
Luego para invocar el servicio se debe incluir el token generado, en el header Authorization para invocar al servicio de creacion de usuario.