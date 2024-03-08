package pkgs.exes;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import pkgs.utils.JPAUtil;

public class Exe03 {

	public static void main(String[] args) {
		System.out.println("Exe03.main()");
		runAppMM();
	}

	private static void runAppMM() {
		System.out.println("Exe03.runAppMM()");
		Exe03 exe = new Exe03();
		exe.startAppMM();
		System.out.println("[exe=" + (exe) + "]");
	}

	private void startAppMM() {
		System.out.println("Exe03.startAppMM()");
		m01();
	}

	private void m01() {
		System.out.println("Exe03.m01()");

		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = JPAUtil.criaEntityManagerFactoryWithCreateNone();
			System.out.println("[emf=" + (emf) + "]");

			em = emf.createEntityManager();
			System.out.println("[em=" + (em) + "]");

			if (em instanceof Session) {
				Session session = em.unwrap(Session.class);
				System.out.println("[" + session + "]");

				session.doWork(new Work() {

					@Override
					public void execute(Connection connection) throws SQLException {

						try {
							String jasperFile = "D:\\marciomaia\\Git\\rep_aJSFv22DWM40Servlet40JPAv22_202401241048\\projects\\aJSFv22DWM40Servlet40JPAv22_202401241048\\src\\main\\java\\relatorios\\JasperReportName202403080751.jasper";

							JasperPrint jasperPrint = null;

							jasperPrint = JasperFillManager.fillReport(jasperFile, null, connection);
							JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\tmp\\202403080910.pdf");
						} catch (Exception e) {
							throw new RuntimeException("Falha ao gerar relatório, [" + (e.getClass()) + "][" + (e) + "][" + (e.getMessage()) + "]", e);
						}
					}

				});

			}

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

		System.out.println("/Exe03.m01()");
	}

}
