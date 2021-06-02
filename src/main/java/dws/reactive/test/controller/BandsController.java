package dws.reactive.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dws.reactive.test.model.Band;
import dws.reactive.test.service.BandService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/isobarfm/v1")
public class BandsController {
	
	@Autowired
	private BandService bandService;

	@GetMapping("/getAllBands")
	public Flux<Band> getAllBands() {
		return bandService.findAllFlux();
	}
}
