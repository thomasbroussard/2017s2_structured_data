/**
 * 
 * Code application :
 * Composant : 
 */
package fr.epita.quiz.tests;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
public class TestXPATH {
	
	@Test
	public void testXPATH() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		DocumentBuilder dbuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		Document document = dbuilder.parse(this.getClass().getResourceAsStream("/file.xml"));
		
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		
		javax.xml.xpath.XPathExpression compiledExpression = xpath.compile("/quiz/question//option[@valid='true']/explanation");
		NodeList nl = (NodeList) compiledExpression.evaluate(document, XPathConstants.NODESET);
		
		for (int i =0 ; i <nl.getLength(); i++) {
			System.out.println(nl.item(i).getTextContent());
		}
		
		
		
	}

}
