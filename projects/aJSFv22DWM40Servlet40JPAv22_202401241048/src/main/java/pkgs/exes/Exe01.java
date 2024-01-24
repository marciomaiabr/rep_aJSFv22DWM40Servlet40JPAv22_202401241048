package pkgs.exes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import pkgs.models.Empresa;
import pkgs.utils.JPAUtil;

public class Exe01 {

	public static void main(String[] args) {
		(new Exe01()).execute();
	}

	public void execute() {
		// 
		criaEntidades();
		// 
		insertEmpresa();
		// 
		listEmpresa();
	}

	private void criaEntidades() {
		System.out.println("Exe01.criaEntidades()");

		EntityManagerFactory emf = null;

		emf = JPAUtil.criaEntityManagerFactoryWithCreateAuto();

		if(emf != null) {
			EntityManager em = null;
			EntityTransaction et = null;

			try {
				em = emf.createEntityManager();
				et = em.getTransaction();
				et.begin();

				et.commit();
			} catch (Exception e) {
				try {
					et.rollback();
				} catch (Exception e2) {
				}
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
		System.out.println("/Exe01.criaEntidades()");
	}

	private void insertEmpresa() {
		System.out.println("Exe01.insertEmpresa()");

		EntityManagerFactory emf = null;

		emf = JPAUtil.criaEntityManagerFactoryWithCreateNone();

		if(emf != null) {
			EntityManager em = null;
			EntityTransaction et = null;

			try {
				em = emf.createEntityManager();
				et = em.getTransaction();
				et.begin();

				Empresa empresa = new Empresa();
				empresa.setRazaoSocial("Razão Social 1...");
				empresa.setNomeFantasia("Nome Fantasia 1...");

				em.merge(empresa);

				et.commit();
			} catch (Exception e) {
				try {
					et.rollback();
				} catch (Exception e2) {
				}
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
		System.out.println("/Exe01.insertEmpresa()");
	}

	private void listEmpresa() {
		System.out.println("Exe01.listEmpresa()");

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
		System.out.println("/Exe01.listEmpresa()");
	}

}
