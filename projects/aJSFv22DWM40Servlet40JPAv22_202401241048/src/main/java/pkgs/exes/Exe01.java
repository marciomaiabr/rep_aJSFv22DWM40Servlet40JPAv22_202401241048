package pkgs.exes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import pkgs.utils.JPAUtil;

public class Exe01 {

	public static void main(String[] args) {
		System.out.println("Exe01.main()");
		runAppMM();
	}

	private static void runAppMM() {
		System.out.println("Exe01.runAppMM()");
		Exe01 exe01 = new Exe01();
		exe01.startAppMM();
		System.out.println("[exe01=" + (exe01) + "]");
	}

	private void startAppMM() {
		System.out.println("Exe01.startAppMM()");
		m01();
	}

	private void m01() {
		System.out.println("Exe01.m01()");

		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;

		try {
			emf = JPAUtil.criaEntityManagerFactoryWithCreateNone();
			System.out.println("[emf=" + (emf) + "]");

			em = emf.createEntityManager();
			System.out.println("[em=" + (em) + "]");

			et = em.getTransaction();
			System.out.println("[et=" + (et) + "]");

			et.begin();

			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				et.rollback();
			} catch (Exception e2) {
			}
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

}
