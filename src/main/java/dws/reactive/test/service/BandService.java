package dws.reactive.test.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import dws.reactive.test.exception.BandsNotFoundException;
import dws.reactive.test.exception.handler.BandCompareFilterFactory;
import dws.reactive.test.model.Band;
import reactor.core.publisher.Flux;

@Service
public class BandService {
	
	@Autowired
	private BandsRequester bandsRequester;
	
	@Autowired
	private BandCompareFilterFactory bandCompareFilterFactory;
	
	
	@Cacheable("bandsByName")
	public Flux<Band> findAllFlux() {
		return Optional.ofNullable(bandsRequester.findAll()).orElseThrow(BandsNotFoundException::new);
	}
}
