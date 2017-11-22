/**
 * 
 * Code application :
 * Composant : 
 */
package fr.epita.quiz.tests;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;
import org.w3c.dom.Document;
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
public class TestXSLT {
	
	
	@Test
	public void testTransformation() throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException {
		DocumentBuilder dbuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		
		Document doc = dbuilder.parse(new File("src/test/resources/file.xml"));
		
		
		Source transformationFile = new StreamSource("src/test/resources/quiz-transform.xsl");
		
		Transformer tx = TransformerFactory.newInstance().newTransformer(transformationFile);
		
			
		StreamResult streamResult = new StreamResult(new  File("target/transformResult.html"));
		
		tx.transform(new DOMSource(doc.getDocumentElement()), streamResult );
		
	}

}
