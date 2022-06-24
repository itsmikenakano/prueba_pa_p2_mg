package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Vehiculo;

@Repository
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	@Override
	public void insertarVehiculo(Vehiculo v) {
		// TODO Auto-generated method stub
		System.out.println("Se ha insertado en la base el vehiculo: " + v);
	}

	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		System.out.println("Se ha buscado en la base el vehiculo con placa: " + placa);
		Vehiculo v = new Vehiculo();
		Random r = new Random();
		
		v.setMarca("Mazda");
		v.setPlaca(placa);
		v.setPrecio(new BigDecimal(r.nextInt(25000)));
		String [] tipos = {"L","P"};
		v.setTipo(tipos[r.nextInt(2)]);
		return v;
	}

	@Override
	public void actualizar(Vehiculo v) {
		// TODO Auto-generated method stub
		System.out.println("Se ha actualizado en la base el vehiculo: " + v);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		System.out.println("Se ha eliminado en la base el vehiculo con placa: " + placa);
	}

}
