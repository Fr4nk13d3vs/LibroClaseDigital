package cl.duoc.colegio.api_gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import java.net.URI;

@Configuration
public class GatewayConfig {

    @Value("${ACADEMICO_URL:http://localhost:8081}")
    private String academicoUrl;

    @Value("${ASISTENCIA_URL:http://localhost:8082}")
    private String asistenciaUrl;

    @Value("${MENSAJERIA_URL:http://localhost:8083}")
    private String mensajeriaUrl;

    @Bean
    public RouterFunction<ServerResponse> academicoRoutes() {
        return GatewayRouterFunctions.route("ms-academico")
                .route(RequestPredicates.path("/api/asignaturas/**")
                        .or(RequestPredicates.path("/api/cursos/**"))
                        .or(RequestPredicates.path("/api/alumnos/**"))
                        .or(RequestPredicates.path("/api/profesores/**"))
                        .or(RequestPredicates.path("/api/evaluaciones/**")),
                        HandlerFunctions.http())
                .before(BeforeFilterFunctions.routeId("ms-academico"))
                .before(BeforeFilterFunctions.uri(URI.create(academicoUrl)))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> asistenciaRoutes() {
        return GatewayRouterFunctions.route("ms-asistencia")
                .route(RequestPredicates.path("/api/asistencias/**")
                        .or(RequestPredicates.path("/api/anotaciones/**")),
                        HandlerFunctions.http())
                .before(BeforeFilterFunctions.routeId("ms-asistencia"))
                .before(BeforeFilterFunctions.uri(URI.create(asistenciaUrl)))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> mensajeriaRoutes() {
        return GatewayRouterFunctions.route("ms-mensajeria")
                .route(RequestPredicates.path("/api/mensajes/**"),
                        HandlerFunctions.http())
                .before(BeforeFilterFunctions.routeId("ms-mensajeria"))
                .before(BeforeFilterFunctions.uri(URI.create(mensajeriaUrl)))
                .build();
    }
}
