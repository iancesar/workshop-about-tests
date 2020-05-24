package br.com.webcars.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.webcars.dtos.CarFilterDTO;
import br.com.webcars.dtos.CarResponseDTO;
import br.com.webcars.services.CarService;

@RestController
@RequestMapping(path = "/cars")
public class CarController
{

	@Autowired
	private CarService service;

	@GetMapping
	public ResponseEntity<List<CarResponseDTO>> list(@RequestParam Map<String, String> filter)
	{

		CarFilterDTO filterDTO = CarFilterDTO.from(filter);

		return ResponseEntity.ok(service.list(filterDTO));
	}

}
