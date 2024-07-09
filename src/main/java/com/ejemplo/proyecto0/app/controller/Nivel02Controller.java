package com.ejemplo.proyecto0.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejemplo.proyecto0.app.model.Animal;

@Controller
@RequestMapping("/animales")
public class Nivel02Controller {

	@GetMapping("/un-gato")
	public String m(Model model) {

		Animal miGato = new Animal("gato", 77.5, 3120);
		
		model.addAttribute("titulo", "Animales");
		model.addAttribute("cabecera", "Mostrando un gato");
		model.addAttribute("texto", "Estos son los datos de mi gato");
//		model.addAttribute("tipo", miGato.getTipo());
//		model.addAttribute("peso", miGato.getPeso());
//		model.addAttribute("precio", miGato.getPrecio());
		model.addAttribute("gato", miGato);

		return "animal/un-gato";
	}
}
