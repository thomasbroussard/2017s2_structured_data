/**
 * 
 * Code application :
 * Composant : 
 */
package fr.epita.quiz.tests;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Quiz;

/** 
 * <h3>Description</h3>  
 * <p>Cette classe permet de ...</p>
 *
 * <h3>Utilisation</h3>
 * <p>Elle s'utilise de la manière suivante :
 *   <pre><code>${type_name} instance = new ${type_name}();</code></pre>
 * </p>
 *  
 * @since $${version}
 * @see Voir aussi $${link}
 * @author ${user}
 *
 * ${tags}
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/applicationContext.xml"})
public class TestQuizToHibernate {

	@Inject
	private SessionFactory sf;
	
	@Test
	public void testHibernate() {
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Quiz quiz = new Quiz(0, "Structured Data Quiz");
		
		session.save(quiz);
		tx.commit();
		
		Assert.assertNotEquals(0, quiz.getId());
		
		  
		session.close();
	
		
	}
}
