package fr.epita.quiz.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.epita.quiz.datamodel.Quiz;
import fr.epita.quiz.datamodel.QuizQuestion;
import fr.epita.quiz.tests.TestJSON;

/**
 * Servlet implementation class Validate
 */

@WebServlet("/quiz-validation")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LogManager.getLogger(Validate.class);

	/**
	 * Default constructor.
	 */
	public Validate() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Given
		Quiz quiz = new Quiz();
		quiz.setId(1);
		quiz.setName("Structured Data Quiz");

		// When
		ObjectMapper mapper = new ObjectMapper();
		String actual = mapper.writeValueAsString(quiz);
		LOGGER.info(actual);

		response.getWriter().println(actual);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
