/**
 * Ce fichier est la propriété de l'agence de la Biomédecine Code application : Composant :
 */
package fr.epita.quiz.tests;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * <h3>Description</h3>
 * <p>
 * Cette classe permet de ...
 * </p>
 *
 * <h3>Utilisation</h3>
 * <p>
 * Elle s'utilise de la manière suivante :
 * 
 * <pre>
 * <code>${type_name} instance = new ${type_name}();</code>
 * </pre>
 * </p>
 * 
 * @since $${version}
 * @see Voir aussi $${link}
 * @author ${user}
 *
 *         ${tags}
 */
public class TestDOM {

	private static final Logger LOGGER = LogManager.getLogger(TestDOM.class);

	@Test
	public void testReadDomFromXmlFile() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder dbuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		Document document = dbuilder.parse(this.getClass().getResourceAsStream("/file.xml"));

		NodeList quizList = document.getElementsByTagName("quiz");
		Element quizElement = (Element) quizList.item(0);
		String quizName = quizElement.getAttribute("name");

		Assert.assertEquals("test", quizName);

		LOGGER.info(quizName);

	}

	@Test
	public void testParseFromXml() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder dbuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		Document document = dbuilder.parse(this.getClass().getResourceAsStream("/file.xml"));

		NodeList optionsList = document.getElementsByTagName("option");

		for (int i = 0; i < optionsList.getLength(); i++) {
			Element option = (Element) optionsList.item(i);
			String valid = option.getAttribute("valid");
			NodeList optionChildNodes = option.getChildNodes();
			LOGGER.info("option is valid {}", valid);
			for (int j = 0; j < optionChildNodes.getLength(); j++) {
				Node node = optionChildNodes.item(j);
				if (node instanceof Element) {
					Element child = (Element) node;
					LOGGER.info("  option {} with value : {}", child.getTagName(), child.getTextContent());
				}
			}

		}

	}

}
