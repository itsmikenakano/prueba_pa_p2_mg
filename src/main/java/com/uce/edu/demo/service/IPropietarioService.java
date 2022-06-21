package com.uce.edu.demo.service;

import com.uce.edu.demo.modelo.Propietario;

public interface IPropietarioService {
	public void registrarPropietario(Propietario p);

	public void eliminar(String cedula);
}
