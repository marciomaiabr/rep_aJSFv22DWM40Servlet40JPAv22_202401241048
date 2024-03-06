package pkgs.exes;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import pkgs.utils.JPAUtil;
import pkgs.utils.JSEUtil;

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
			emf = JPAUtil.criaEntityManagerFactoryWithCreateAuto();
			System.out.println("[emf=" + (emf) + "]");

			em = emf.createEntityManager();
			System.out.println("[em=" + (em) + "]");

			et = em.getTransaction();
			System.out.println("[et=" + (et) + "]");

			et.begin();

		    try {
		    	System.out.println("Initial Dml's Path = [" + (JSEUtil.getInitialDmlsPath()) + "]");

		    	File[] files = JSEUtil.getInitialDmlsFiles();

		    	System.out.println("Files to execute:");
		    	for(File file : files) {
		    		System.out.println("     " + "["+file+"]");
		    	}

		    	System.out.println("Executing files...");
		    	for(File file : files) {
		    		System.out.println("     " + "["+file+"]");
		    		List<String> sqls = Files.readAllLines(file.toPath());
				    for(String sql : sqls) {
				    	if(sql.trim().equals(""))
				    		continue;
				    	System.out.println("     " + "     " + "[sql="+sql+"]");
				    	Query query = em.createNativeQuery(sql);
				    	System.out.println("[query.executeUpdate()=" + (query.executeUpdate()) + "]");
				    }
		    	}
			} catch (Exception e) {
				e.printStackTrace();
			}

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
