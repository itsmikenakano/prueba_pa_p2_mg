package com.uce.edu.demo.repository;

import com.uce.edu.demo.modelo.Matricula;

public interface IMatriculaRepository {
	public void insertarMatricula(Matricula m);

	public Matricula buscar(String fechaMatricula);

	public void actualizar(Matricula m);

	public void eliminar(String fechaMatricula);
}
