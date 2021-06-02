package dws.reactive.test.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import dws.reactive.test.handler.BandsHandler;

@Configuration
public class BandsRouter {
	
	@RouterOperation(beanClass = BandsHandler.class, beanMethod = "getBands")
	@Bean
	public RouterFunction<ServerResponse> getBandsRouter(@Autowired BandsHandler bandsHandler) {
		  return route(GET("/bands") 
				  .and(accept(MediaType.APPLICATION_JSON)), bandsHandler::getBands);
	}
}
