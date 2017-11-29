/**
 * 
 * Code application : Composant :
 */
package fr.epita.quiz.tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.epita.quiz.datamodel.Quiz;
import fr.epita.quiz.datamodel.QuizQuestion;

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
public class TestJSON {

	private static final Logger LOGGER = LogManager.getLogger(TestJSON.class);

	@Test
	public void testQuizJsonFormatting() throws JsonProcessingException {

		// Given
		Quiz quiz = new Quiz();
		quiz.setId(1);
		quiz.setName("Structured Data Quiz");

		// When
		ObjectMapper mapper = new ObjectMapper();
		String actual = mapper.writeValueAsString(quiz);

		// Then
		String expected = "{\"id\":1,\"name\":\"Structured Data Quiz\"}";
		Assert.assertEquals(expected, actual);
		LOGGER.info(actual);

	}

	@Test
	public void testQuizQuestionsJsonFormatting() throws JsonProcessingException {
		
		//Given
		QuizQuestion question1 = new QuizQuestion(0, "How to compare two strings in java?", null);
		QuizQuestion question2 = new QuizQuestion(0, "How to represent the root element in XPATH? ", null);
		
		List<QuizQuestion> questions = Arrays.asList(question1, question2);
		
		//When
		ObjectMapper mapper = new ObjectMapper();
		
		
		String actual = mapper.writeValueAsString(questions);
		
		//Then
		LOGGER.info(actual);
		
		
	}
	
	@Test
	public void testQuizQuestionsJsonReading() throws IOException {
		
		//Given
		QuizQuestion question1 = new QuizQuestion(0, "How to compare two strings in java?", null);
		QuizQuestion question2 = new QuizQuestion(0, "How to represent the root element in XPATH? ", null);
		
		List<QuizQuestion> questions = Arrays.asList(question1, question2);
		
		//When
		ObjectMapper mapper = new ObjectMapper();
		
		
		List<QuizQuestion> actual = mapper.readValue("[{\"id\":0,\"subject\":\"How to compare two strings in java?\",\"quiz\":null},{\"id\":0,\"subject\":\"How to represent the root element in XPATH? \",\"quiz\":null}]\r\n" + 
				"", new TypeReference<List<QuizQuestion>>() {});
		
		//Then
		LOGGER.info(actual);
		Assert.assertEquals(questions.size(), actual.size());
		
		
	}


}
