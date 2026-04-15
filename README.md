# Libro de Clases Digital — Backend

Sistema de microservicios para gestion academica del Colegio Bernardo O'Higgins. Arquitectura basada en Spring Boot con API Gateway y bases de datos MySQL independientes por servicio.

## Arquitectura

```
                    ┌─────────────────┐
                    │   API Gateway   │ :8080
                    └────────┬────────┘
            ┌────────────────┼────────────────┐
            v                v                v
   ┌────────────────┐ ┌─────────────┐ ┌──────────────┐
   │ ms-academico   │ │ms-asistencia│ │ms-mensajeria │
   │     :8081      │ │    :8082    │ │    :8083     │
   └───────┬────────┘ └──────┬──────┘ └──────┬───────┘
           v                 v               v
   ┌────────────────┐ ┌─────────────┐ ┌──────────────┐
   │ MySQL          │ │ MySQL       │ │ MySQL        │
   │ academico_db   │ │asistencia_db│ │mensajeria_db │
   └────────────────┘ └─────────────┘ └──────────────┘
```

## Tecnologias

- Java 21 (Amazon Corretto)
- Spring Boot 4.0.5
- Spring Cloud Gateway (Server MVC)
- Spring Data JPA
- MySQL 8.0
- Docker + Docker Compose

## Microservicios

### ms-academico (:8081)
Gestion de informacion academica.

| Metodo | Ruta | Descripcion |
|--------|------|-------------|
| GET/POST/PUT/DELETE | `/api/asignaturas` | CRUD Asignaturas |
| GET/POST/PUT/DELETE | `/api/cursos` | CRUD Cursos |
| GET/POST/PUT/DELETE | `/api/alumnos` | CRUD Alumnos |
| GET/POST/PUT/DELETE | `/api/profesores` | CRUD Profesores |
| GET/POST/PUT/DELETE | `/api/evaluaciones` | CRUD Evaluaciones |

### ms-asistencia (:8082)
Registro de asistencia y conducta.

| Metodo | Ruta | Descripcion |
|--------|------|-------------|
| GET/POST/PUT/DELETE | `/api/asistencias` | Registro de asistencia |
| GET/POST/PUT/DELETE | `/api/anotaciones` | Anotaciones de conducta |

### ms-mensajeria (:8083)
Comunicacion entre actores del colegio.

| Metodo | Ruta | Descripcion |
|--------|------|-------------|
| GET/POST/DELETE | `/api/mensajes` | Envio y consulta de mensajes |
| PATCH | `/api/mensajes/{id}/leer` | Marcar mensaje como leido |

## Despliegue

### Requisitos
- Docker Engine
- Docker Compose v2
- Docker Buildx >= 0.17

### Levantar servicios

```bash
git clone https://github.com/Fr4nk13d3vs/LibroClaseDigital.git
cd LibroClaseDigital
docker compose up -d --build
```

### Contenedores

| Contenedor | Puerto | Servicio |
|------------|--------|----------|
| mysql-academico | 3307 | BD academico_db |
| mysql-asistencia | 3308 | BD asistencia_db |
| mysql-mensajeria | 3309 | BD mensajeria_db |
| ms-academico | 8081 | Microservicio Academico |
| ms-asistencia | 8082 | Microservicio Asistencia |
| ms-mensajeria | 8083 | Microservicio Mensajeria |
| api-gateway | 8080 | API Gateway |
| frontend | 3000 | Frontend React |

### Probar

```bash
# Listar asignaturas
curl http://localhost:8080/api/asignaturas

# Crear asignatura
curl -X POST http://localhost:8080/api/asignaturas \
  -H "Content-Type: application/json" \
  -d '{"codigo":"MAT101","nombre":"Matematicas","descripcion":"Matematicas basica"}'
```

## Frontend

El frontend React se encuentra en un repositorio separado:
https://github.com/Fr4nk13d3vs/LibroClaseDigitalWEB
