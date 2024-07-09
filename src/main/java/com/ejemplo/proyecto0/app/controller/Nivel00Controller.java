package com.ejemplo.proyecto0.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Nivel00Controller {

	@GetMapping("/mi-primer-weblink")
	public String miPrimerMetodoHandler() {
		return "nivel00/mi-primera-vista";
	}
	
	@GetMapping({"/segundo-weblink", "/segundo-segundo-weblink"})
	public String segundoMetodoHandler() {
		return "nivel00/hola-mundo02";
	}
}
