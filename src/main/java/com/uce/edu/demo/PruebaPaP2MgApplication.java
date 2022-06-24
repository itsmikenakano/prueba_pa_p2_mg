package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.Propietario;
import com.uce.edu.demo.modelo.Vehiculo;
import com.uce.edu.demo.repository.IPropietarioRepository;
import com.uce.edu.demo.service.IMatriculaGestorService;
import com.uce.edu.demo.service.IMatriculaService;
import com.uce.edu.demo.service.IPropietarioService;
import com.uce.edu.demo.service.IVehiculoService;

@SpringBootApplication
public class PruebaPaP2MgApplication implements CommandLineRunner {

	@Autowired
	private Propietario propietario;

	@Autowired
	private Vehiculo vehiculo;

	@Autowired
	private IMatriculaGestorService iMatriculaGestorService;
	
	@Autowired
	private IPropietarioService iPropietarioService;
	
	@Autowired
	private IVehiculoService iVehiculoService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaPaP2MgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		this.vehiculo.setMarca("Mazzda");
		this.vehiculo.setPlaca("PGYI245");
		this.vehiculo.setPrecio(new BigDecimal(2500));
		this.vehiculo.setTipo("L");
		this.iVehiculoService.registrarVehiculo(this.vehiculo);
		
		//2
		this.vehiculo.setPrecio(new BigDecimal(3500));
		this.vehiculo.setMarca("Mazda");
		this.iVehiculoService.actualizar(this.vehiculo);
		
		//3
		this.propietario.setNombre("Michael ");
		this.propietario.setApellido("Garcia");
		this.propietario.setCedula("2300290992");
		this.propietario.setFechaNacimiento(LocalDateTime.of(2001, 04, 07, 3, 55));
		this.iPropietarioService.registrarPropietario(this.propietario);
		
		
		this.iMatriculaGestorService.generar(this.propietario.getCedula(), this.vehiculo.getPlaca());
		
	}

}
