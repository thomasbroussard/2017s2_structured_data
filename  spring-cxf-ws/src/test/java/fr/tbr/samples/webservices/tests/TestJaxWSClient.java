/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.tbr.samples.webservices.tests;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.spring.service.HelloWorld;

/**
 * <h3>Description</h3>
 * <p>This class allows to ...</p>
 *
 * <h3>Usage</h3>
 * <p>This class should be used as follows:
 *   <pre><code>${type_name} instance = new ${type_name}();</code></pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 * ${tags}
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestJaxWSClient {


	@Inject
	HelloWorld client;

	@Test
	public void testClient() {
		client.sayHi("hi!");


	}


}
