package com.philips.ai.controllers;

import com.philips.ai.SmartSleepAnalyzerClient;
import com.philips.ai.models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class SurveyControllerTest {

	private static final String identifier = "sleep";
	private static final String invalidIdentifier = "sleep1";
	private static String clientId;
	private static String clientSecret;
	SmartSleepAnalyzerClient analyzerClient;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		clientId = System.getProperty("clientId");
		clientSecret = System.getProperty("clientSecret");
	}

	@Before
	public void setUp() throws Exception {
		analyzerClient = new SmartSleepAnalyzerClient(clientId, clientSecret);
	}

	/*
	 * @Test public void testStatefulSurvey() throws Throwable { // initial call to
	 * get survey state returns a new session id SurveyStateDTO surveyStateDTO =
	 * analyzerClient.getSurvey().getSurveyState(identifier, null); String sessionId
	 * = surveyStateDTO.getSessionId();
	 * 
	 * Assert.assertNotNull(sessionId); Assert.assertEquals("demographics1",
	 * surveyStateDTO.getCurrentStepRef());
	 * 
	 * // Subsequent call to get survey state returns same session id surveyStateDTO
	 * = analyzerClient.getSurvey().getSurveyState(identifier, sessionId);
	 * 
	 * Assert.assertEquals(sessionId, surveyStateDTO.getSessionId());
	 * Assert.assertEquals("demographics1", surveyStateDTO.getCurrentStepRef());
	 * 
	 * // Update the survey state to move to the next step LinkedHashMap<String,
	 * Object> answers = new LinkedHashMap<>(); answers.put("demographics1", true);
	 * UpdateSurveyStateRequestDTO updateDTO = new UpdateSurveyStateRequestDTO();
	 * updateDTO.setStepRef("demographics1"); updateDTO.setAnswers(answers);
	 * surveyStateDTO = analyzerClient.getSurvey().updateSurveyState(identifier,
	 * sessionId, updateDTO);
	 * 
	 * Assert.assertEquals("demographics3", surveyStateDTO.getCurrentStepRef());
	 * Assert.assertEquals("sex",
	 * surveyStateDTO.getSteps().get(0).getQuestionRefs().get(0));
	 * 
	 * // Update the survey state to move to the age step answers = new
	 * LinkedHashMap<>(); answers.put("sex", "male"); updateDTO = new
	 * UpdateSurveyStateRequestDTO(); updateDTO.setStepRef("demographics3");
	 * updateDTO.setAnswers(answers); surveyStateDTO =
	 * analyzerClient.getSurvey().updateSurveyState(identifier, sessionId,
	 * updateDTO);
	 * 
	 * Assert.assertEquals("demographics4", surveyStateDTO.getCurrentStepRef());
	 * Assert.assertEquals("age",
	 * surveyStateDTO.getSteps().get(0).getQuestionRefs().get(0));
	 * 
	 * // Update the survey state to move to the occupation step answers = new
	 * LinkedHashMap<>(); answers.put("age", 43); updateDTO = new
	 * UpdateSurveyStateRequestDTO(); updateDTO.setStepRef("demographics4");
	 * updateDTO.setAnswers(answers); surveyStateDTO =
	 * analyzerClient.getSurvey().updateSurveyState(identifier, sessionId,
	 * updateDTO);
	 * 
	 * Assert.assertEquals("demographics5", surveyStateDTO.getCurrentStepRef());
	 * Assert.assertEquals("occupation",
	 * surveyStateDTO.getSteps().get(0).getQuestionRefs().get(0));
	 * 
	 * // Update the survey state to move to the bed partner step answers = new
	 * LinkedHashMap<>(); answers.put("occupation", "retired"); updateDTO = new
	 * UpdateSurveyStateRequestDTO(); updateDTO.setStepRef("demographics5");
	 * updateDTO.setAnswers(answers); surveyStateDTO =
	 * analyzerClient.getSurvey().updateSurveyState(identifier, sessionId,
	 * updateDTO);
	 * 
	 * Assert.assertEquals("demographics8", surveyStateDTO.getCurrentStepRef());
	 * Assert.assertEquals("bedPartner",
	 * surveyStateDTO.getSteps().get(0).getQuestionRefs().get(0));
	 * 
	 * // Update the survey state to move to the problems step answers = new
	 * LinkedHashMap<>(); answers.put("bedPartner", false); updateDTO = new
	 * UpdateSurveyStateRequestDTO(); updateDTO.setStepRef("demographics8");
	 * updateDTO.setAnswers(answers); surveyStateDTO =
	 * analyzerClient.getSurvey().updateSurveyState(identifier, sessionId,
	 * updateDTO);
	 * 
	 * Assert.assertEquals("problems1NOP", surveyStateDTO.getCurrentStepRef());
	 * 
	 * // Update the survey state to move to the other problems step answers = new
	 * LinkedHashMap<>(); answers.put("problemSleeping", 0);
	 * answers.put("problemSleepiness", 0); answers.put("problemSnoring", 0);
	 * updateDTO = new UpdateSurveyStateRequestDTO();
	 * updateDTO.setStepRef("problems1NOP"); updateDTO.setAnswers(answers);
	 * surveyStateDTO = analyzerClient.getSurvey().updateSurveyState(identifier,
	 * sessionId, updateDTO);
	 * 
	 * Assert.assertEquals("problems2", surveyStateDTO.getCurrentStepRef());
	 * Assert.assertEquals("problemOther",
	 * surveyStateDTO.getSteps().get(0).getQuestionRefs().get(0));
	 * 
	 * // Update the survey state to move to the bed partner step answers = new
	 * LinkedHashMap<>(); answers.put("problemOther", "None"); updateDTO = new
	 * UpdateSurveyStateRequestDTO(); updateDTO.setStepRef("problems2");
	 * updateDTO.setAnswers(answers); surveyStateDTO =
	 * analyzerClient.getSurvey().updateSurveyState(identifier, sessionId,
	 * updateDTO);
	 * 
	 * Assert.assertTrue(surveyStateDTO.getFinished());
	 * 
	 * // Check the result ResultDTO resultDTO =
	 * analyzerClient.getResult().getComputeResult(identifier, sessionId);
	 * 
	 * Assert.assertEquals(sessionId, resultDTO.getSessionId());
	 * Assert.assertEquals("none",
	 * resultDTO.getConditions().get(0).getIdentifier()); }
	 */

	@Test
	public void testGetSurveyState() throws Throwable {
		SurveyStateDTO surveyStateDTO = analyzerClient.getSurvey().getSurveyState(identifier, null);
		Assert.assertEquals("Are you currently under the care of a physician for depression and/or anxiety?",
				surveyStateDTO.getQuestions().get(0).getText());
	}

	@Test
	public void testGetSurveyState_InvalidInput() throws Throwable {
		try {
			analyzerClient.getSurvey().getSurveyState(invalidIdentifier, null);
		} catch (Exception e) {
			Assert.assertEquals("1102:No survey found for identifier 'sleep1'", e.getMessage());
		}
	}

	@Test
	public void testGetSurveyStateSummary() throws Throwable {
		SurveyStateSummaryDTO surveyStateSummaryDTO = analyzerClient.getSurvey().getSurveyStateSummary(identifier, null);
		Assert.assertEquals((long)64, (long)surveyStateSummaryDTO.getStepsRemaining());
	}

	@Test
	public void testGetSurveyStateSummary_InvalidInput() throws Throwable {
		try {
			analyzerClient.getSurvey().getSurveyStateSummary(invalidIdentifier, null);
		} catch (Exception e) {
			Assert.assertEquals("1102:No survey found for identifier 'sleep1'", e.getMessage());
		}
	}

	@Test
	public void testGetQuestions() throws Throwable {
		QuestionsDTO questionsDTO = analyzerClient.getSurvey().getQuestions(identifier, null, null);
		Assert.assertEquals("demographics1", questionsDTO.getQuestions().get(0).getIdentifier());
		Assert.assertTrue(questionsDTO.getAnswersTemplate().containsKey("demographics1"));
	}

	@Test
	public void testGetQuestions_InvalidInput() throws Throwable {
		try {
			analyzerClient.getSurvey().getQuestions(invalidIdentifier, null, null);
		} catch (Exception e) {
			Assert.assertEquals("1102:No survey found for identifier 'sleep1'", e.getMessage());
		}
	}

	@Test
	public void testGetSenseQuestion() throws Throwable {
		String id = "height";
		QuestionDTO questionDTO = analyzerClient.getSurvey().getSenseQuestion(identifier, id);
		Assert.assertEquals(id, questionDTO.getIdentifier());
	}

	@Test
	public void testGetSenseQuestion_InvalidInput() throws Throwable {
		// todo: engine should throw expected error when given invalid senseid, currently throws 500
	}

	@Test
	public void testGetSenseRequiredQuestions() throws Throwable {
		String targetSense = "bmi";
		List<String> ids = Arrays.asList("height", "weight");
		List<QuestionDTO> questions = analyzerClient.getSurvey().getSenseRequiredQuestions(identifier, targetSense);
		questions.stream().map(QuestionDTO::getIdentifier).forEach(qId -> Assert.assertTrue(ids.contains(qId)));
	}

	@Test
	public void testGetSenseRequiredQuestions_InvalidInput() throws Throwable {
		// todo: engine should throw expected error when given invalid target senseid, currently throws 500
	}

	@Test
	public void testPostAnswers() throws Throwable {
		LinkedHashMap<String, Object> answers = new LinkedHashMap<>();
		answers.put("demographics1", false);
		QuestionsDTO questionsDTO = analyzerClient.getSurvey().postAnswers(identifier, answers, null);
		Assert.assertEquals("sex", questionsDTO.getQuestions().get(0).getIdentifier());
		Assert.assertTrue(questionsDTO.getAnswersTemplate().containsKey("sex"));
	}

	@Test
	public void testPostAnswers_InvalidInput() throws Throwable {
		LinkedHashMap<String, Object> answers = new LinkedHashMap<>();
		answers.put("demographics1", true);
		try {
			analyzerClient.getSurvey().postAnswers(invalidIdentifier, answers, null);
		} catch (Exception e) {
			Assert.assertEquals("1102:No survey found for identifier 'sleep1'", e.getMessage());
		}
	}

	@Test
	public void testPostAnswers_BadInput() throws Throwable {
		// todo: answers within a step are currently not validated until passed to the scoring engine
	}

	@Test
	public void testUpdateAnswers() throws Throwable {
		UpdateSurveyStateRequestDTO requestDTO = new UpdateSurveyStateRequestDTO();
		requestDTO.setStepRef("demographics1");
		LinkedHashMap<String, Object> answers = new LinkedHashMap<String, Object>();
		answers.put("demographics1", false);
		requestDTO.setAnswers(answers);
		QuestionsDTO questionsDTO = analyzerClient.getSurvey().updateAnswers(identifier, requestDTO, null);
		Assert.assertEquals("sex", questionsDTO.getQuestions().get(0).getIdentifier());
		Assert.assertTrue(questionsDTO.getAnswersTemplate().containsKey("sex"));
	}

	@Test
	public void testUpdateAnswers_InvalidInput() throws Throwable {
		UpdateSurveyStateRequestDTO requestDTO = new UpdateSurveyStateRequestDTO();
		requestDTO.setStepRef("demographics1");
		LinkedHashMap<String, Object> answers = new LinkedHashMap<>();
		answers.put("demographics1", true);
		requestDTO.setAnswers(answers);
		try {
			analyzerClient.getSurvey().updateAnswers(invalidIdentifier, requestDTO, null);
		} catch (Exception e) {
			Assert.assertEquals("1103:No survey found for identifier 'sleep1'", e.getMessage());
		}
	}

	@Test
	public void testUpdateAnswers_BadInput() throws Throwable {
		UpdateSurveyStateRequestDTO requestDTO = new UpdateSurveyStateRequestDTO();
		requestDTO.setStepRef("xyz");
		LinkedHashMap<String, Object> answers = new LinkedHashMap<>();
		answers.put("xyz", true);
		requestDTO.setAnswers(answers);
		try {
			analyzerClient.getSurvey().updateAnswers(identifier, requestDTO, null);
		} catch (Exception e) {
			Assert.assertEquals("1103:No step found for identifier 'xyz'", e.getMessage());
		}
	}

	@Test
	public void testUpdateSurveyState() throws Throwable {
		UpdateSurveyStateRequestDTO requestDTO = new UpdateSurveyStateRequestDTO();
		requestDTO.setStepRef("demographics1");
		LinkedHashMap<String, Object> answers = new LinkedHashMap<String, Object>();
		answers.put("demographics1", false);
		requestDTO.setAnswers(answers);
		SurveyStateDTO surveyStateDTO = analyzerClient.getSurvey().updateSurveyState(identifier, null, requestDTO);
		Assert.assertEquals("demographics", surveyStateDTO.getSectionStates().get(0).getIdentifier());
		Assert.assertEquals("Background and Demographics", surveyStateDTO.getSectionStates().get(0).getName());
	}

	@Test
	public void testUpdateSurveyState_InvalidInput() throws Throwable {
		UpdateSurveyStateRequestDTO requestDTO = new UpdateSurveyStateRequestDTO();
		requestDTO.setStepRef("demographics1");
		LinkedHashMap<String, Object> answers = new LinkedHashMap<String, Object>();
		answers.put("demographics1", true);
		requestDTO.setAnswers(answers);
		try {
			analyzerClient.getSurvey().updateSurveyState(invalidIdentifier, null, requestDTO);
		} catch (Exception e) {
			Assert.assertEquals("1103:No survey found for identifier 'sleep1'", e.getMessage());
		}
	}

	@Test
	public void testUpdateSurveyState_BadInput() throws Throwable {
		UpdateSurveyStateRequestDTO requestDTO = new UpdateSurveyStateRequestDTO();
		requestDTO.setStepRef("xyz");
		LinkedHashMap<String, Object> answers = new LinkedHashMap<String, Object>();
		answers.put("xyz", true);
		requestDTO.setAnswers(answers);
		try {
			analyzerClient.getSurvey().updateSurveyState(identifier, null, requestDTO);
		} catch (Exception e) {
			Assert.assertEquals("1103:No step found for identifier 'xyz'", e.getMessage());
		}
	}

	@Test
	public void testCreateResetSurveyState() throws Throwable {

		analyzerClient.getSurvey().createResetSurveyState(identifier);
	}

	@Test
	public void testCreateResetSurveyState_InvaidInput() throws Throwable {

		analyzerClient.getSurvey().createResetSurveyState("sleep1");
	}
}
