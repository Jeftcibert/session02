package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TbUsuario;

public class Pruebas {

	public static void main(String[] args) {
System.out.println("-->>Listar<<---");
		
		// 1. fabrica el acceso a los datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("JPA_Class1x");
		// 2. crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		List<TbUsuario> lstUsuarios =em.createQuery("Select a From TbUsuario a", TbUsuario.class).getResultList();
		System.out.println("================================");
		System.out.println("Nro de usuarios: "+lstUsuarios.size());
		System.out.println("================================");
		
		
		/*Listar todos los usuarios*/
		System.out.println("Lista de usuarios:");
		System.out.println("-----------------");
		for(TbUsuario u: lstUsuarios){
			System.out.println("usuario: "+u.getNomUsua()+ " " + u.getApeUsua()+ " "+ u.getClaUsua());
		}
		System.out.println("==============================================");

	}

}
