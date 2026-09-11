# Actividad2EstructuraDatos
Proyecto academico actividad 2, clase de estructura de datos. 

## Nombre de la aplicación

**Sistema de soporte técnico**

## Descripción no técnica del problema

La aplicación está orientada a una empresa dedicada a la venta e instalación de maquinaria, en la cual los clientes pueden requerir soporte después de recibir e instalar sus equipos.
Las solicitudes pueden estar relacionadas con dudas sobre el funcionamiento de la máquina o con inconvenientes que requieran algun tipo de ayuda/soporte. 
El soporte puede realizarse de manera virtual o por medio de una visita técnica presencial.
El problema que se busca resolver con la aplicación es la gestión de las solicitudes de soporte pendientes, manteniendo el orden en que fueron recibidas para establecer cuál debe ser atendida primero.

## Descripción de la solución

La aplicación permite registrar y administrar solicitudes de soporte técnico pendientes.

Cada solicitud almacena información como:

* Identificador de la solicitud.
* Nombre del cliente.
* Número de contacto.
* Referencia de la máquina.
* Descripción del problema o solicitud.
* Fecha de solicitud.
* Tipo de soporte: virtual o presencial.

El sistema permite registrar nuevas solicitudes, atender la solicitud que lleva más tiempo esperando, consultar cual es la proxima solicitud que se debe atender, mostrar las solicitudes pendientes y consultar el estado de la cola.
La aplicación utiliza una capacidad máxima de **5 solicitudes pendientes**, establecida para el modelo de este proyecto académico.

## Estructura de datos seleccionada

La estructura seleccionada es una **cola implementada mediante un vector de tamaño fijo**, utilizando un comportamiento de **cola circular**.
La cola sigue el principio **FIFO (First In, First Out)**, por lo que la primera solicitud registrada es la primera que será atendida.

El vector tiene 5 posiciones y la estructura utiliza las siguientes variables para controlar su funcionamiento:

* `front`: indica la posición de la próxima solicitud que será atendida.
* `rear`: indica la posición donde se realizará la próxima inserción.
* `size`: indica la cantidad de solicitudes actualmente almacenadas.
* `capacidadVector`: establece la capacidad máxima del vector.

Cuando `front` o `rear` llegan a la última posición del vector, vuelven a la posición inicial, permitiendo reutilizar las posiciones que hayan quedado disponibles.

## Justificación técnica de la elección

La cola es adecuada para este problema porque las solicitudes deben ser atendidas respetando el orden en que fueron recibidas.
La implementación mediante un vector circular permite aprovechar las posiciones disponibles sin necesidad de desplazar los demás elementos cada vez que se atiende una solicitud.
Las principales operaciones tienen las siguientes características:

* **Registrar una solicitud:** `O(1)`, ya que se inserta directamente en la posición indicada por `rear`.
* **Atender una solicitud:** `O(1)`, ya que se accede directamente a la posición indicada por `front`.
* **Consultar la próxima solicitud:** `O(1)`, porque se consulta directamente `front`.
* **Mostrar las solicitudes pendientes:** `O(n)`, porque es necesario recorrer las solicitudes almacenadas.

Además, el uso de `size` permite controlar fácilmente cuándo la cola está vacía o cuándo ha alcanzado su capacidad máxima.
Al utilizar una cola circular, no es necesario desplazar los elementos después de atender una solicitud. La posición que queda libre puede ser reutilizada despues.

## Análisis de lo que ocurriría al utilizar otra estructura

Como alternativa se podría utilizar una **pila implementada mediante un vector**.

Una pila utiliza el principio **LIFO (Last In, First Out)**, por lo que la última solicitud registrada sería la primera en ser atendida. Esto no corresponde con el comportamiento esperado para este sistema, ya que una solicitud nueva podría ser atendida antes que otras que llevan más tiempo esperando.
Desde el punto de vista técnico, tanto una pila como una cola pueden realizar sus operaciones principales en tiempo `O(1)` cuando están implementadas adecuadamente mediante un vector.
Sin embargo, la cola requiere controlar dos extremos (`front` y `rear`), mientras que la pila puede administrar sus operaciones utilizando principalmente un único extremo (`top`).
Por esta razón, aunque una pila podría almacenar las mismas solicitudes, sería necesario cambiar la lógica de atención y el orden de procesamiento. La cola resulta más adecuada porque su comportamiento coincide  con el flujo de atención requerido.

## Instrucciones para ejecutar el programa

El proyecto está desarrollado en **Java**.

Para ejecutarlo:

1. Abrir el código en un entorno compatible con Java.
2. Compilar el programa.
3. Ejecutar la clase `Main`.
4. Seleccionar una opción del menú ingresando el número correspondiente.

El menú principal permite:

```text
1. Registrar solicitud
2. Atender solicitud
3. Consultar próxima solicitud
4. Mostrar solicitudes pendientes
5. Verificar estado de la cola
6. Salir
```

Al registrar una solicitud, la fecha debe ingresarse utilizando el formato indicado por el programa:

```text
dd/MM/yyyy HH:mm
```

Por ejemplo:

```text
12/06/2026 14:30
```

## Casos de prueba utilizados

### Caso normal

Se registraron varias solicitudes y se verificó que fueran atendidas respetando el orden de llegada.

Ejemplo:

```text
Registrar S001
Registrar S002
Registrar S003
```

Al consultar la próxima solicitud se obtiene `S001`.

Después de atenderla, `S001` sale de la cola y las solicitudes pendientes continúan siendo:

```text
S002
S003
```

También se verificó el funcionamiento circular registrando nuevas solicitudes después de atender algunas, comprobando que las posiciones liberadas del vector pudieran reutilizarse sin alterar el orden lógico de la cola.

### Caso límite: cola llena

Se registraron 10 solicitudes hasta alcanzar la capacidad máxima del vector.
despues se intentó registrar una solicitud adicional.

El sistema valido que la cola estaba llena y no permitió realizar la inserción, manteniendo sin cambios el estado de la estructura.

### Caso límite: cola vacía

También se verificó el comportamiento cuando no existen solicitudes pendientes.

Al intentar atender o consultar una solicitud con la cola vacía, el sistema informa que no existen solicitudes pendientes y no modifica la estructura.

## Limitaciones y posibles mejoras

Una de las principales limitaciones es que la cola tiene una **capacidad fija de 5 solicitudes**, por lo que no puede almacenar más solicitudes pendientes sin modificar la capacidad definida para el programa.

Otra limitación es que todas las solicitudes se procesan utilizando el mismo orden FIFO. El sistema no toma en cuenta los niveles de prioridad, por lo que una solicitud urgente tendría que esperar su turno detrás de las solicitudes anteriores.

Como posible mejora se podría implementar una **cola de prioridad**, permitiendo atender primero las solicitudes que tengan un nivel de urgencia mayor.
