package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Matricula;
import com.uce.edu.demo.modelo.Propietario;
import com.uce.edu.demo.modelo.Vehiculo;
import com.uce.edu.demo.repository.IMatriculaRepository;
import com.uce.edu.demo.repository.IVehiculoRepository;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Autowired
	private Propietario p;

	@Autowired
	private Vehiculo v;

	@Autowired
	private Matricula m;

	@Autowired
	private IVehiculoRepository ivehiculoRepository;

	@Override
	public void generarMatricula(String cedula, String placa) {
		// TODO Auto-generated method stub
		this.p.setCedula(cedula);
		this.v = this.ivehiculoRepository.buscar(placa);

		if (this.v.getTipo().equals("liviano")) {
			this.m.setFechaMatricula(LocalDateTime.now());
			System.out.println("Vlaor del vehiculo liviano " + this.v.getPrecio());
			this.m.setValorMatricula(this.v.getPrecio().multiply(new BigDecimal(0.1)).setScale(2, RoundingMode.FLOOR));
			this.m.setPropietario(this.p);
			this.m.setVehiculo(this.v);
			System.out.println("Valor matricula sin descuento " + this.m.getValorMatricula());
			if(this.m.getValorMatricula().compareTo(new BigDecimal(2000)) == 1) {
				BigDecimal descuento = this.m.getValorMatricula().multiply(new BigDecimal(0.07));
				this.m.setValorMatricula(this.m.getValorMatricula().subtract(descuento).setScale(2, RoundingMode.FLOOR));
			}
		}else {
			this.m.setFechaMatricula(LocalDateTime.now());
			System.out.println("Vlaor del vehiculo pesado " + this.v.getPrecio());
			this.m.setValorMatricula(this.v.getPrecio().multiply(new BigDecimal(0.15)).setScale(2, RoundingMode.FLOOR));
			this.m.setPropietario(this.p);
			this.m.setVehiculo(this.v);
			System.out.println("Valor matricula sin descuento " + this.m.getValorMatricula());
			if(this.m.getValorMatricula().compareTo(new BigDecimal(2000)) == 1) {
				BigDecimal descuento = this.m.getValorMatricula().multiply(new BigDecimal(0.07));
				this.m.setValorMatricula(this.m.getValorMatricula().subtract(descuento).setScale(2, RoundingMode.FLOOR));
			}
		}
		
		this.iMatriculaRepository.insertarMatricula(this.m);
	}

	@Override
	public Matricula buscar(String fechaMatricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Matricula m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(String fechaMatricula) {
		// TODO Auto-generated method stub

	}

}
