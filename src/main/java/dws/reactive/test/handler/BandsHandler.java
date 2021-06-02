package dws.reactive.test.handler;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import dws.reactive.test.model.Band;
import dws.reactive.test.service.BandService;
import reactor.core.publisher.Mono;

@Component
public class BandsHandler {

	@Autowired
	private BandService bandService;

	public Mono<ServerResponse> getBands(ServerRequest request) {
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(bandService.findAllFlux(), Band.class);
	}
}
