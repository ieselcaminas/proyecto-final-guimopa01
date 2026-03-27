**PROYECTO FINAL DE CURSO**

Programación — Desarrollo de Aplicaciones Web

**JavaFX + Spring JPA**

| **Módulo**                   | Programación — DAW                  |
| ---------------------------- | ----------------------------------- |
| **Tipo**                     | Proyecto Final Individual           |
| **Duración estimada**        | ~40 horas                           |
| **Tecnologías obligatorias** | JavaFX + Spring JPA                 |
| **Entrega**                  | Repositorio Git + presentación oral |

## **1. Introducción**

A lo largo del curso has adquirido conocimientos en programación orientada a objetos, estructuras de datos, acceso a bases de datos con Spring JPA y desarrollo de interfaces gráficas con JavaFX. El objetivo de este proyecto es que demuestres de forma integrada todo lo aprendido mediante el desarrollo de una aplicación completa.

El proyecto es de carácter individual. Puedes elegir libremente el dominio de tu aplicación (biblioteca, tienda, clínica, gimnasio, etc.), siempre que cumplas con los requisitos mínimos descritos en este documento.

## **2. Requisitos Mínimos Obligatorios**

### **2.1 Persistencia — JPA con Spring**

- Mínimo 3 entidades JPA con relaciones entre ellas (OneToMany, ManyToOne, ManyToMany...).
- Operaciones CRUD completas sobre al menos 2 de las entidades.
- Al menos una consulta personalizada usando JPQL o Query Methods de Spring Data.
- Base de datos relacional (H2, MySQL o PostgreSQL).

### **2.2 Interfaz Gráfica — JavaFX**

- Mínimo 3 pantallas o vistas diferentes con navegación entre ellas.
- Uso de al menos un componente TableView o ListView para mostrar datos.
- Formularios para crear y editar registros.
- Mensajes de confirmación o error al usuario.

### **2.3 Java — Colecciones y Streams**

- Uso de Streams para al menos una operación de filtrado, ordenación o transformación de datos.
- Al menos una clase que implemente la interfaz Comparable para ordenación natural.
- Uso justificado de ArrayList o HashMap en algún punto de la lógica.

### **2.4 Consumo de API REST externa**

- La aplicación debe consumir al menos una API REST pública o de terceros (por ejemplo: clima, películas, libros, deportes, divisas...).
- Los datos obtenidos de la API deben mostrarse en la interfaz JavaFX y/o integrarse con la lógica de la aplicación.
- Se debe gestionar correctamente la petición HTTP (con HttpClient, OkHttp o similar) y el parseo de la respuesta (JSON).
- Hay que contemplar el caso de error de conexión o respuesta inválida, informando al usuario.

### **2.5 Ficheros**

- Exportación de algún listado o informe a un fichero CSV o TXT. 

### **2.6 Programación Orientada a Objetos**

- Aplicación correcta de herencia y/o interfaces.
- Código organizado en capas: modelo (entidades), repositorio, servicio/controlador y vista (JavaFX).
- 

## **3. Entregables**

Deberás entregar los siguientes elementos antes de la fecha límite indicada por el profesor:

- Repositorio Git (GitHub, GitLab o similar) con el código fuente completo.
- Archivo README.md con: descripción del proyecto, instrucciones de instalación/ejecución, diagrama Entidad-Relación y decisiones de diseño relevantes.
- Presentación oral de 10-15 minutos explicando el proyecto y demostrando su funcionamiento.



## **4. Ideas de Proyectos**

A continuación se presentan algunas sugerencias. Son solo orientativas; puedes proponer tu propio proyecto siempre que lo consultes previamente con el profesor. 

- Gestión de biblioteca: libros, socios, préstamos y devoluciones.
- Tienda / inventario: productos, categorías, proveedores y stock.
- Clínica veterinaria: mascotas, dueños, citas y veterinarios.
- Centro educativo: alumnos, asignaturas, profesores y calificaciones.
- Gimnasio: socios, cuotas, clases grupales y reservas.
- Gestión de restaurante: carta, mesas, pedidos y tickets.
- Videoclub personal: películas, series, géneros y valoraciones.



| **Criterio**                               | **Excelente (9-10)**                                         | **Notable (7-8)**                                            | **Aprobado (5-6)**                                           | **Insuficiente (<5)**              | **Peso** |
| ------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ---------------------------------- | -------- |
| **Persistencia 	JPA + Spring**          | 3 entidades con relaciones correctas, CRUD completo y consultas 			personalizadas bien implementadas. | Alguna 			relación incorrecta o falta alguna operación CRUD. | Menos de 3 entidades, sin relaciones o sin CRUD.             | No se usa JPA o Spring.            | **20%**  |
| **Interfaz JavaFX**                        | 3 o más vistas bien diseñadas, 			`TableView/ListView `funcional, navegación fluida entre pantallas. | 2 vistas o navegación con errores menores.                   | 1 vista o interfaz incompleta.                               | No se usa JavaFX o no funciona.    | **15%**  |
| **Consumo de API REST**                    | API integrada correctamente, datos mostrados en la interfaz, gestión de errores de red implementada. | API conectada pero sin gestión de errores o integración parcial. | Llamada a la API pero sin mostrar datos o sin parseo correcto. | No se consume ninguna API.         | **15%**  |
| **Streams y Comparable**                   | Streams usados correctamente para filtrar/ordenar. Comparable bien implementado y utilizado. | Uso básico o incompleto de Streams. Comparable implementado pero sin uso real. | Uso mínimo o incorrecto.                                     | No se usan.                        | **15%**  |
| **Colecciones	(ArrayList, HashMap...)** | Colecciones usadas de forma apropiada y justificada según el contexto. | Uso básico sin aprovechar sus ventajas.                      | Uso incorrecto o confundido.                                 | No se usan. S                      | **10%**  |
| **POO y organización del código**          | Herencia/interfaces bien aplicadas. Código organizado en capas (modelo, repositorio, controlador, vista). | Estructura parcialmente correcta, algún concepto mal aplicado. | POO mínima o estructura desorganizada.                       | Sin estructura OO.                 | **10%**  |
| **Ficheros**                               | Exportación funcional a CSV o TXT con datos relevantes y formato correcto. | Exportación básica o con errores menores.                    | Exportación incompleta.                                      | No	implementada.                | **5%**   |
| **Documentación y presentación**           | README claro, diagrama E-R, explicación de decisiones. Presentación oral fluida y dominio del proyecto. | Documentación 	incompleta o presentación con dudas.       | Documentación mínima o presentación muy deficiente.          | Sin documentación ni presentación. | **10%**  |
