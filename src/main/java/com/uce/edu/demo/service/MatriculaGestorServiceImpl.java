package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Matricula;
import com.uce.edu.demo.modelo.Propietario;
import com.uce.edu.demo.modelo.Vehiculo;
import com.uce.edu.demo.repository.IMatriculaRepository;
import com.uce.edu.demo.repository.IPropietarioRepository;
import com.uce.edu.demo.repository.IVehiculoRepository;

@Service
public class MatriculaGestorServiceImpl implements IMatriculaGestorService {

	@Autowired
	private IPropietarioRepository iPropietarioRepository;

	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Autowired
	@Qualifier("pesado")
	private IMatriculaService matriculaServicePesado;

	@Autowired
	@Qualifier("liviano")
	private IMatriculaService matriculaServiceLiviano;
	
	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Autowired
	private Propietario propietario;

	@Autowired
	private Vehiculo vehiculo;

	@Autowired
	private Matricula matricula;

	@Override
	public void generar(String cedula, String placa) {
		// TODO Auto-generated method stub
		this.propietario = this.iPropietarioRepository.consultar(cedula);
		this.vehiculo = this.iVehiculoRepository.buscar(placa);
		String tipo = this.vehiculo.getTipo();
		BigDecimal valorMatricula;
		if (tipo.equals("P")) {
			valorMatricula = this.matriculaServicePesado.calcular(this.vehiculo.getPrecio());

		} else {
			valorMatricula = this.matriculaServiceLiviano.calcular(this.vehiculo.getPrecio());
		}

		if (valorMatricula.compareTo(new BigDecimal(2000)) > 0) {
			BigDecimal valorDescuento = valorMatricula.multiply(new BigDecimal(0.07));
			valorMatricula = valorMatricula.subtract(valorDescuento);
		}
		
		this.matricula.setFechaMatricula(LocalDateTime.now());
		this.matricula.setValorMatricula(valorMatricula);
		this.matricula.setPropietario(this.propietario);
		this.matricula.setVehiculo(vehiculo);
		
		this.iMatriculaRepository.insertarMatricula(this.matricula);
	}

}
