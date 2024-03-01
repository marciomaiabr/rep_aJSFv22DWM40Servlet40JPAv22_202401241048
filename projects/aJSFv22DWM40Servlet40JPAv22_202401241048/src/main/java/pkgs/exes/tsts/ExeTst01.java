package pkgs.exes.tsts;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import pkgs.utils.JPAUtil;

public class ExeTst01 {

	public static void main(String[] args) {
		System.out.println("ExeTst01.main()");
		runAppMM();
	}

	private static void runAppMM() {
		System.out.println("ExeTst01.runAppMM()");
		ExeTst01 exeTst01 = new ExeTst01();
		exeTst01.startAppMM();
		System.out.println("[exeTst01=" + (exeTst01) + "]");
	}

	private void startAppMM() {
		System.out.println("ExeTst01.startAppMM()");
		mTst01();
	}

	private void mTst01() {
		System.out.println("ExeTst01.mTst01()");

		EntityManagerFactory emf01 = null;

		EntityManager em01_emf01 = null;
		EntityManager em02_emf01 = null;
		EntityManager em03_emf01 = null;

		EntityManagerFactory emf02 = null;

		try {
			emf01 = JPAUtil.criaEntityManagerFactoryWithCreateNone();
			System.out.println("[emf01=" + (emf01) + "]");

			em01_emf01 = emf01.createEntityManager();
			System.out.println("[em01_emf01=" + (em01_emf01) + "]");

			System.out.println("[em01_emf01.getTransaction()=" + (em01_emf01.getTransaction()) + "]");
			System.out.println("[em01_emf01.getTransaction()=" + (em01_emf01.getTransaction()) + "]");

			System.out.println("[em01_emf01.getTransaction()=" + (em01_emf01.getTransaction()) + "]");
			em01_emf01.getTransaction().begin();
			// em01_emf01.merge(new Pessoa("[em01_emf01][" + (em01_emf01) + "][em01_emf01.getTransaction()][" + (em01_emf01.getTransaction()) + "]"));
			// em01_emf01.flush();

			em02_emf01 = emf01.createEntityManager();
			System.out.println("[em02_emf01=" + (em02_emf01) + "]");

			System.out.println("[em02_emf01.getTransaction()=" + (em02_emf01.getTransaction()) + "]");
			em02_emf01.getTransaction().begin();
			// em02_emf01.merge(new Pessoa("[em02_emf01][" + (em02_emf01) + "]"));
			// em02_emf01.flush();

			em03_emf01 = emf01.createEntityManager();
			System.out.println("[em03_emf01=" + (em03_emf01) + "]");

			System.out.println("[em03_emf01.getTransaction()=" + (em03_emf01.getTransaction()) + "]");
			em03_emf01.getTransaction().begin();

			emf02 = JPAUtil.criaEntityManagerFactoryWithCreateNone();
			System.out.println("[emf02=" + (emf02) + "]");

			em01_emf01.getTransaction().commit();
			em01_emf01.getTransaction().begin();
			em01_emf01.getTransaction().commit();

			em02_emf01.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//
		}

		System.out.println("/ExeTst01.mTst01()");
	}

}
