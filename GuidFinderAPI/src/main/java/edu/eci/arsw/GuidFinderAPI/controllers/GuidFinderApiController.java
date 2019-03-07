/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.GuidFinderAPI.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.GuidFinderDesktop.model.UIrequest;
import edu.eci.arsw.GuidFinderDesktop.model.UIresponse;
import edu.eci.arsw.GuidFinderDesktop.services.GuidServices;

/**
 *
 * @author cristian
 */

@RestController
@RequestMapping(value = "/guid")
public class GuidFinderApiController {

	@Autowired
	private GuidServices guidServices;

	@GetMapping
	public ResponseEntity<?> getAll() {
		try {

			List<UIresponse> data = guidServices.getAll();
			return new ResponseEntity<>(data, HttpStatus.ACCEPTED);

		} catch (Exception ex) {
	
			return new ResponseEntity<>("No se encontró el recurso solicitado", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<?> consult(@RequestBody UIrequest uuid) {
		try {
			UIresponse data = guidServices.consult(uuid);
			return new ResponseEntity<>(data, HttpStatus.CREATED);

		} catch (ExceptionInInitializerError ex) {
			
			return new ResponseEntity<>("No se encontró el recurso solicitado", HttpStatus.NOT_FOUND);
		}
	}

}
