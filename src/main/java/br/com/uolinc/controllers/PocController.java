package br.com.uolinc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.Reactor;
import reactor.event.Event;
import br.com.uolinc.model.MixedJson;

@RestController
public class PocController {
	
	@Autowired
    Reactor reactor;
	
	@RequestMapping(value="/poc", method=RequestMethod.GET)
	public MixedJson poc() {
		reactor.notify("fire", Event.wrap("GET"));
		return null;
	}
	
}
