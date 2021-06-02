package dws.reactive.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dws.reactive.test.model.Band;
import reactor.core.publisher.Flux;

@Service
public class BandsRequester {
	private RestTemplate restTemplate;

	@Value("${dws.bands.url}")
	private String bandsUrl;

	@Autowired
	public BandsRequester() {
		restTemplate = new RestTemplate();
	}

	public Flux<Band> findAll() {
		List<Band> bands = null;
		ResponseEntity<List<Band>> responseEntity = restTemplate.exchange(
				bandsUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<List<Band>>() {
		});
		bands = responseEntity.getBody();
		return Flux.fromIterable(bands);
	}
}
