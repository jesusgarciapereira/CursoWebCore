package com.ejemplo.proyecto0.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@GetMapping("/tercer-weblink")
	public String tercerMetodoHandler(Model model) {
		model.addAttribute("titulo", "Hola mundo");
		model.addAttribute("cabecera", "Hola mundo 03!!!!");
		model.addAttribute("parrafo", "Todo esto lo he sacado del model");
		return "nivel00/hola-mundo03";
	}
}
