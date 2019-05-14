package com.philips.ai.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.philips.ai.SmartSleepAnalyzerClient;
import com.philips.ai.models.ConditionResult;
import com.philips.ai.models.TipResult;

public class ResultControllerTest {

	private final String defaultErrorMessage = "00000:Please verify the provided information is correct.";
	private final String expectedError3113 = "3113:Unable to find the conditions with the given sleepProblemId 'osa1'";
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

	@Test
	public void testGetAllConditions() throws Throwable {

		List<ConditionResult> result = analyzerClient.getResult().getAllConditions();
		Assert.assertEquals(6, result.size());
	}

	/*
	 * @Test public void testGetTipsByConditionAndInputValues() throws Throwable {
	 * String conditionId = "osa"; Map<String, Object> inputValues = new
	 * HashMap<String, Object>(); inputValues.put("alcoholAuditC", 5);
	 * List<TipResult> result =
	 * analyzerClient.getResult().getTipsByConditionAndInputValues(conditionId,
	 * inputValues); Assert.assertEquals("drinking",
	 * result.get(0).getIdentifier().toString());
	 * Assert.assertEquals("Make last call earlier.",
	 * result.get(0).getTitle().toString()); }
	 * 
	 * @Test public void testGetTipsByConditionAndInputValues_InvalidConditionId()
	 * throws Throwable { String conditionId = ""; Map<String, Object> inputValues =
	 * new HashMap<String, Object>(); inputValues.put("", ""); try {
	 * analyzerClient.getResult().getTipsByConditionAndInputValues(conditionId,
	 * inputValues); } catch (Exception e) {
	 * Assert.assertEquals(defaultErrorMessage, e.getMessage()); } }
	 * 
	 * @Test public void testGetTipIdsByConditionAndInputValues() throws Throwable {
	 * String conditionId = "osa"; Map<String, Object> inputValues = new
	 * HashMap<String, Object>(); inputValues.put("alcoholAuditC", 5); List<String>
	 * result =
	 * analyzerClient.getResult().getTipIdsByConditionAndInputValues(conditionId,
	 * inputValues); Assert.assertEquals(561, result.get(0).length()); Assert.
	 * assertEquals("<p>Your responses indicate that you sometimes have more than "
	 * + "two drinks within two hours of your bedtime", result.get(0).substring(0,
	 * 104)); }
	 * 
	 * @Test public void testGetTipIdsByConditionAndInputValues_InvalidInputs()
	 * throws Throwable { String conditionId = ""; Map<String, Object> inputValues =
	 * new HashMap<String, Object>(); inputValues.put("", ""); try {
	 * analyzerClient.getResult().getTipIdsByConditionAndInputValues(conditionId,
	 * inputValues); } catch (Exception e) {
	 * Assert.assertEquals(defaultErrorMessage, e.getMessage()); } }
	 * 
	 * @Test public void testGetTidbitIdsByCondition() throws Throwable { String
	 * conditionId = "osa";
	 * 
	 * List<String> result =
	 * analyzerClient.getResult().getTidbitIdsByCondition(conditionId);
	 * Assert.assertEquals(
	 * "Did you know? Sleep apnea sufferers come from all walks of life. " +
	 * "In fact, 1 in 5 adults in the United States have at least mild obstructive sleep apnea."
	 * , result.get(0)); Assert.assertEquals(2, result.size());
	 * 
	 * }
	 * 
	 * @Test public void testGetTidbitIdsByCondition_InvalidInput() throws Throwable
	 * { String conditionId = "osa1";
	 * 
	 * try { analyzerClient.getResult().getTidbitIdsByCondition(conditionId); }
	 * catch (Exception e) { Assert.assertEquals(expectedError3113, e.getMessage());
	 * } }
	 * 
	 * @Test public void testGetTipIdsByCondition() throws Throwable { String
	 * conditionId = "osa"; List<String> result =
	 * analyzerClient.getResult().getTipIdsByCondition(conditionId);
	 * Assert.assertEquals(5, result.size()); Assert.assertEquals(
	 * "<p>Your responses indicate that you sometimes have more than two drinks within two hours of your bedtime. "
	 * + "We recommend no more than 2 alcoholic drinks per day, " +
	 * "and that you try to avoid drinking alcohol within 2 hours of bedtime.</p><p><strong>Why?</strong> Drinking alcohol might help you fall asleep quicker, "
	 * +
	 * "but if you drink too much or too close to bedtime, it can disrupt your sleep by reducing rapid eye movement (REM), "
	 * +
	 * "an important stage of sleep. Alcohol can also block the nose and relax airway muscles, "
	 * + "making snoring and breathing problems worse.</p>", result.get(0)); }
	 * 
	 * @Test public void testGetTipIdsByCondition_InvalidInput() throws Throwable {
	 * String conditionId = "osa1"; try {
	 * analyzerClient.getResult().getTipIdsByCondition(conditionId); } catch
	 * (Exception e) { Assert.assertEquals(expectedError3113, e.getMessage()); } }
	 */
	@Test
	public void testGetCondition() throws Throwable {
		String conditionId = "osa";
		ConditionResult result;

		result = analyzerClient.getResult().getCondition(conditionId);
		Assert.assertEquals(2, result.getTidbitIdentifiers().size());
		Assert.assertEquals("Obstructive sleep apnea with snoring", result.getTitle().toString());
	}

	@Test
	public void testGetCondition_InvalidInput() throws Throwable {
		String conditionId = "osa1";
		try {
			analyzerClient.getResult().getCondition(conditionId);
		} catch (Exception e) {
			Assert.assertEquals(expectedError3113, e.getMessage());
		}

	}

}
