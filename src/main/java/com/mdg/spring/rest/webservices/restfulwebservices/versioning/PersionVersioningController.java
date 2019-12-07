package com.mdg.spring.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersionVersioningController {

	@GetMapping("/v1/person")
	public PersonV1 getPersionV1() {
		return new PersonV1("Muralidhar Goud");
	}

	@GetMapping("/v2/person")
	public PersonV2 getPersionV2() {
		return new PersonV2(new Name("Muralidhar", "Goud"));
	}
	
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Muralidhar Goud");
	}

	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Muralidhar", "Goud"));
	}
	
	@GetMapping(value = "/person", headers = "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Muralidhar Goud");
	}

	@GetMapping(value = "/person", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Muralidhar", "Goud"));
	}
	
	@GetMapping(value = "/person/produces", produces = "application/mdg.company-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Muralidhar Goud");
	}

	@GetMapping(value = "/person/produces", produces = "application/mdg.company-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Muralidhar", "Goud"));
	}
}