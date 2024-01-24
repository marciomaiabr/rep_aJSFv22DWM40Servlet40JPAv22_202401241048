package pkgs.mbs;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import pkgs.models.Empresa;
import pkgs.utils.JPAUtil;

@ManagedBean
public class Teste01MB {

	public Teste01MB() {
		System.out.println("Teste01MB.Teste01MB()");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Teste01MB.postConstruct()");
	}

	public long getVersion() {
		return 202401241023l;
	}

	public void testDB() {
		System.out.println("Teste01MB.testDB()");
		EntityManagerFactory emf = null;

		emf = JPAUtil.criaEntityManagerFactoryWithCreateNone();

		if(emf != null) {
			EntityManager em = null;

			try {
				em = emf.createEntityManager();

			    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
			    CriteriaQuery<Empresa> criteriaQuery = criteriaBuilder.createQuery(Empresa.class);
			    Root<Empresa> root = criteriaQuery.from(Empresa.class);
			    criteriaQuery.select(root);
			    em.createQuery(criteriaQuery).getResultList().forEach(System.out::println);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					em.close();
				} catch (Exception e) {
				}
				try {
					emf.close();
				} catch (Exception e) {
				}
			}
		}
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Teste01MB.preDestroy()");
	}

}
