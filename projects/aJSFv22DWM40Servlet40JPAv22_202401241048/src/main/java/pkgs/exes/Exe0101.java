package pkgs.exes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import pkgs.models.GrupoUsuario;
import pkgs.models.Usuario;
import pkgs.utils.JPAUtil;

public class Exe0101 {

	public static void main(String[] args) {
		System.out.println("Exe01.main()");
		runAppMM();
	}

	private static void runAppMM() {
		System.out.println("Exe01.runAppMM()");
		Exe0101 exe01 = new Exe0101();
		exe01.startAppMM();
		System.out.println("[exe01=" + (exe01) + "]");
	}

	private void startAppMM() {
		System.out.println("Exe01.startAppMM()");
		m01();
		m02();
	}

	private void m01() {
		System.out.println("Exe01.m01()");

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = JPAUtil.criaEntityManagerFactoryWithCreateNone();
			System.out.println("[emf=" + (emf) + "]");

			em = emf.createEntityManager();
			System.out.println("[em=" + (em) + "]");

			em.createQuery(" from Usuario ", Usuario.class).getResultList().forEach((u) -> {
				System.out.println(u);
				u.getGruposUsuario().forEach(System.out::println);
			});

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				em.close();
			} catch (Exception e2) {
			}
			try {
				emf.close();
			} catch (Exception e2) {
			}
		}

		System.out.println("/Exe01.m01()");
	}

	private void m02() {
		System.out.println("Exe01.m02()");

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = JPAUtil.criaEntityManagerFactoryWithCreateNone();
			System.out.println("[emf=" + (emf) + "]");

			em = emf.createEntityManager();
			System.out.println("[em=" + (em) + "]");

			em.createQuery(" from GrupoUsuario ", GrupoUsuario.class).getResultList().forEach((gu) -> {
				System.out.println(gu);
				gu.getUsuarios().forEach(System.out::println);
			});

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				em.close();
			} catch (Exception e2) {
			}
			try {
				emf.close();
			} catch (Exception e2) {
			}
		}

		System.out.println("/Exe01.m02()");
	}

}
