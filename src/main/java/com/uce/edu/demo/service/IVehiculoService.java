package com.uce.edu.demo.service;

import com.uce.edu.demo.modelo.Vehiculo;

public interface IVehiculoService {
	public void registrarVehiculo(Vehiculo v);

	public Vehiculo consultar(String placa);

	public void actualizar(Vehiculo v);

	public void eliminar(String placa);
}
