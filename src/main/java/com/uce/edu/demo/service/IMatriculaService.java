package com.uce.edu.demo.service;

import com.uce.edu.demo.modelo.Matricula;

public interface IMatriculaService {
	public void generarMatricula(String cedula, String placa);

	public Matricula buscar(String fechaMatricula);

	public void actualizar(Matricula m);

	public void eliminar(String fechaMatricula);

}
