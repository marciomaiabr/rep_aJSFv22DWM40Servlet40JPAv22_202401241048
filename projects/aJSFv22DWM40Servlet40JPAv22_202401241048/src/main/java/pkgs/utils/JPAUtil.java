package pkgs.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	public static EntityManagerFactory criaEntityManagerFactoryWithCreateAuto() {
		String url = null;
		String user = null;
		String password = null;

		try {
			url = Files.readString(Paths.get("C:\\tmp\\p1.txt"));
			user = Files.readString(Paths.get("C:\\tmp\\p2.txt"));
			password = Files.readString(Paths.get("C:\\tmp\\p3.txt"));

			System.out.println("[url="+url+"][user="+user+"][password.hashCode()="+password.hashCode()+"]");
		} catch (Exception e) {
			System.err.println("Falha ao abrir arquivos de configuração [e.getMessage()="+e.getMessage()+"] ...");
		}

		EntityManagerFactory emf = null;

		if(url != null && user != null && password != null) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
			map.put("javax.persistence.jdbc.url", url);
			map.put("javax.persistence.jdbc.user", user);
			map.put("javax.persistence.jdbc.password", password);
			map.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
			map.put("hibernate.show_sql", "true");
			map.put("hibernate.format_sql", "true");
			map.put("use_sql_comments", "true");
			map.put("hibernate.hbm2ddl.auto", "create");
			//chama o "sql-load-script-source" somente quando "hibernate.hbm2ddl.auto" é "create"
			map.put("javax.persistence.sql-load-script-source", "META-INF/sqls/Inserts.sql");
			map.put("hibernate.archive.autodetection", "class");
			emf = Persistence.createEntityManagerFactory("myPU", map);
		}

		return emf;
	}

	public static EntityManagerFactory criaEntityManagerFactoryWithCreateNone() {
		String url = null;
		String user = null;
		String password = null;

		try {
			url = Files.readString(Paths.get("C:\\tmp\\p1.txt"));
			user = Files.readString(Paths.get("C:\\tmp\\p2.txt"));
			password = Files.readString(Paths.get("C:\\tmp\\p3.txt"));

			System.out.println("[url="+url+"][user="+user+"][password.hashCode()="+password.hashCode()+"]");
		} catch (Exception e) {
			System.err.println("Falha ao abrir arquivos de configuração [e.getMessage()="+e.getMessage()+"] ...");
		}

		EntityManagerFactory emf = null;

		if(url != null && user != null && password != null) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
			map.put("javax.persistence.jdbc.url", url);
			map.put("javax.persistence.jdbc.user", user);
			map.put("javax.persistence.jdbc.password", password);
			map.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
			map.put("hibernate.show_sql", "true");
			map.put("hibernate.format_sql", "true");
			map.put("use_sql_comments", "true");
			map.put("hibernate.hbm2ddl.auto", "none");
			map.put("hibernate.archive.autodetection", "class");
			emf = Persistence.createEntityManagerFactory("myPU", map);
		}

		return emf;
	}

}
