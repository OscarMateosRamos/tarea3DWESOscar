package com.Tarea3DWESOscar.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tarea3DWESOscar.modelo.Planta;
import com.Tarea3DWESOscar.repositories.PlantaRepository;

@Service
public class ServiciosPlanta {

	@Autowired
	PlantaRepository plantarepo;

	public boolean validarPlanta(Planta pl) {

		if (pl.getCodigo().isEmpty()) {
			return false;
		}

		if (pl.getCodigo().length() < 3 || pl.getCodigo().length() > 20) {
			return false;
		}
		
		if (plantarepo.findByCodigo(pl.getCodigo()) != null) {
			System.out.println("El codigo ya existe....");
			return false;
		}

		if (pl.getNombrecientifico().length() > 45) {
			return false;
		}

		if (pl.getNombrecomun().length() > 40) {
			return false;
		}

		return true;

	}

	public void insertarPlanta(Planta pl) {
		plantarepo.saveAndFlush(pl);
	}

	public void modificarPlanta(Planta pl) {
		plantarepo.saveAndFlush(pl);
	}

	public void vertodasPlantas() {
		List<Planta> plantas = plantarepo.findAll();
		System.out.println("----LISTADO DE PLANTAS-----");
		for (Planta p : plantas) {
			
			System.out.println(p);
			
		}
		System.out.println("----------------------------");
//		for (Planta p : plantas) {
//			System.out.println(p);
//		}
	}
}
