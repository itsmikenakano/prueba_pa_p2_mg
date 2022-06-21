package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Propietario;
import com.uce.edu.demo.repository.IPropietarioRepository;

@Service
public class PropietarioServiceImpl implements IPropietarioService {

	@Autowired
	private IPropietarioRepository iPropietarioRepository;

	@Override
	public void registrarPropietario(Propietario p) {
		// TODO Auto-generated method stub
		this.iPropietarioRepository.insertarPropietario(p);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.iPropietarioRepository.eliminar(cedula);
	}

}
