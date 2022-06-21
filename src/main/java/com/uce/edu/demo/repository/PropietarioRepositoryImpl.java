package com.uce.edu.demo.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Propietario;

@Repository
public class PropietarioRepositoryImpl implements IPropietarioRepository {

	@Override
	public void insertarPropietario(Propietario p) {
		// TODO Auto-generated method stub
		System.out.println("Se ha insertado en la base el propietario: " + p);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		System.out.println("Se ha eliminado en la base el propietario con cedula: " + cedula);
	}

}
