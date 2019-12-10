package fr.epita.javaquiz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.epita.javaquiz.model.Questionaire;

@Component
public class JavaQuizDao {
	@PersistenceContext
	private EntityManager em;
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Transactional
	public void persist(List<Questionaire> questions) {
		if (questions != null) {
			EntityManager entityManager = emf.createEntityManager();
			entityManager.getTransaction().begin();
			for (Questionaire quizQuestions : questions) {
				entityManager.persist(quizQuestions);
			}
			
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	}

	public List<Questionaire> getQuestionaire() {
		TypedQuery<Questionaire> query = em.createQuery("SELECT quest FROM Questionaire quest ORDER BY quest.qId", Questionaire.class);
		return query.getResultList();
	}
	
	public String getCorrectAnswer(int questionId) {
		String queryString = "SELECT quest FROM Questionaire quest where qId=" + questionId;
		TypedQuery<Questionaire> query = em.createQuery(queryString, Questionaire.class);
		List<Questionaire> questions = query.getResultList();
		
		return questions.get(0).getCorrectAnswer();
	}
	
}