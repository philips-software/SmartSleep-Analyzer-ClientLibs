package com.philips.ai.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.philips.ai.SmartSleepAnalyzerClient;
import com.philips.ai.models.SenseDTO;
import com.philips.ai.models.SenseDependencyDTO;

public class ScoringControllerTest {

	SmartSleepAnalyzerClient analyzerClient;
	private static String clientId;
	private static String clientSecret;
	private final String defaultErrorMessage = "00000:Please verify the provided information is correct.";

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
	public void testGetRequiredQuestionSenses() throws Throwable {
		String targetSenseId = "osa";
		String locale = "en-US";
		List<SenseDTO> result;
		List<String> questionList = new ArrayList<String>();
		// default test
		result = analyzerClient.getScoring().getRequiredQuestionSenses(targetSenseId, locale);
		for (SenseDTO senseDTO : result) {
			questionList.add(senseDTO.getQuestionText());
		}
		Assert.assertEquals(19, questionList.size());
		Assert.assertTrue(questionList.contains("What is your current weight?"));

	}

	@Test
	public void testGetRequiredQuestionSenses_InvalidInput() throws Throwable {
		String targetSenseId = "osa1";
		String locale = "en-US";
		// wrong input test
		try {
			analyzerClient.getScoring().getRequiredQuestionSenses(targetSenseId, locale);
		} catch (Exception e) {
			Assert.assertEquals(defaultErrorMessage, e.getMessage());
		}
	}

	@Test
	public void testGetComputedSenses() throws Throwable {
		List<SenseDTO> result = new ArrayList<SenseDTO>();
		List<String> senseIdList = new ArrayList<String>();

		// default test
		result = analyzerClient.getScoring().getComputedSenses();
		Assert.assertEquals(result.get(2).getId(), "insomnia");
		for (SenseDTO senseDTO : result) {
			senseIdList.add(senseDTO.getId());

		}
		Assert.assertTrue(senseIdList.contains("ess"));
		Assert.assertEquals(16, senseIdList.size());

	}

	@Test
	public void testGetSleepProblemSenses() throws Throwable {
		List<String> senseIdList = new ArrayList<String>();

		List<SenseDTO> result = new ArrayList<SenseDTO>();

		// default test
		result = analyzerClient.getScoring().getSleepProblemSenses();
		Assert.assertEquals("snoring", result.get(5).getId());
		for (SenseDTO senseDTO : result) {
			senseIdList.add(senseDTO.getId());
		}
		Assert.assertTrue(senseIdList.contains("snoring"));
		Assert.assertEquals(6, senseIdList.size());

	}

	@Test
	public void testGetQuestionSenses() throws Throwable {
		String locale = "";
		List<SenseDTO> result = new ArrayList<SenseDTO>();
		List<String> senseIdList = new ArrayList<String>();
		result = analyzerClient.getScoring().getQuestionSenses(locale);
		Assert.assertEquals("highBloodPressure", result.get(2).getId());

		for (SenseDTO senseDTO : result) {
			senseIdList.add(senseDTO.getId());
		}
		Assert.assertTrue(senseIdList.contains("breathingStopped"));
		Assert.assertEquals(100, senseIdList.size());

	}

	@Test
	public void testGetAllSenses() throws Throwable {
		String locale = "";
		List<SenseDTO> result = new ArrayList<SenseDTO>();

		List<String> senseIdList = new ArrayList<String>();

		result = analyzerClient.getScoring().getAllSenses(locale);
		Assert.assertEquals("highBloodPressure", result.get(8).getId());
		for (SenseDTO senseDTO : result) {
			senseIdList.add(senseDTO.getId());
		}
		Assert.assertTrue(senseIdList.contains("bmi"));
		Assert.assertEquals(116, senseIdList.size());

	}

	@Test
	public void testGetSense() throws Throwable {
		String senseId = "osa";
		String locale = "en-US";
		SenseDTO result = new SenseDTO();
		List<String> senseIdList = new ArrayList<String>();

		result = analyzerClient.getScoring().getSense(senseId, locale);
		List<SenseDependencyDTO> dependencies = result.getDependencies();
		Assert.assertEquals("osa50", dependencies.get(0).getSenseId());
		Assert.assertEquals("ess", dependencies.get(1).getSenseId());
		for (SenseDependencyDTO dependencyDTO : dependencies) {
			senseIdList.add(dependencyDTO.getSenseId());
		}
		Assert.assertTrue(senseIdList.contains("highBloodPressure"));
	}

	@Test
	public void testGetSense_Invalidinput() throws Throwable {
		String senseId = "123";
		String locale = "en-US";
		try {
			analyzerClient.getScoring().getSense(senseId, locale);
		} catch (Exception e) {
			Assert.assertEquals("2121:Unable to find the sense with id '123'", e.getMessage());
		}
	}

	@Test
	public void testGetSense_EmptyInput() throws Throwable {
		String senseId = "";
		String locale = "en-US";
		try {
			analyzerClient.getScoring().getSense(senseId, locale);
		} catch (Exception e) {
			Assert.assertEquals(defaultErrorMessage, e.getMessage());
		}
	}

	@Test
	public void testComputeIntermediateAndSleepProblemSenses() throws Throwable {
		Map<String, Object> inputValues = prepareinput(175, 75);
		LinkedHashMap<String, Object> sleepProblemSensesMap = analyzerClient.getScoring()
				.computeIntermediateAndSleepProblemSenses(inputValues);
		Assert.assertEquals(4, sleepProblemSensesMap.get("isi"));
		Assert.assertEquals(true, sleepProblemSensesMap.get("hasAccidentRisk"));
	}

	@Test
	public void testComputeIntermediateAndSleepProblemSenses_Invalidinput() throws Throwable {
		Map<String, Object> inputValues = prepareinput(175, "abc");
		try {
			analyzerClient.getScoring().computeIntermediateAndSleepProblemSenses(inputValues);
		} catch (Exception e) {
			Assert.assertEquals("2102:Invalid value 'abc' for sense 'weight' of type 'DoubleSenseValue'",
					e.getMessage());
		}
	}

	@Test
	public void testComputeIntermediateAndSleepProblemSenses_EmptyInput() throws Throwable {
		Map<String, Object> inputValues = new HashMap<String, Object>();
		LinkedHashMap<String, Object> map = analyzerClient.getScoring()
				.computeIntermediateAndSleepProblemSenses(inputValues);
		Assert.assertEquals(0, map.size());
	}

	@Test
	public void testComputeSleepProblemSenses() throws Throwable {
		Object inputValues = prepareinput(175, 75);
		LinkedHashMap<String, Object> sleepProblemSensesMap = analyzerClient.getScoring()
				.computeSleepProblemSenses(inputValues);
		Map<Object, Object> osaObject = (Map<Object, Object>) sleepProblemSensesMap.get("osa");
		Assert.assertEquals(null, osaObject.get("object"));
		Assert.assertEquals("--", osaObject.get("classification"));
		Map<Object, Object> snoringObject = (Map<Object, Object>) sleepProblemSensesMap.get("snoring");
		Assert.assertEquals("Occasional Snoring", snoringObject.get("classification"));
		Assert.assertEquals(1, snoringObject.get("riskRating"));
	}

	@Test
	public void testComputeSleepProblemSenses_Invalidinput() throws Throwable {
		Map<String, Object> inputValues = prepareinput(175, "abc");
		try {
			analyzerClient.getScoring().computeSleepProblemSenses(inputValues);
		} catch (Exception e) {
			Assert.assertEquals("2102:Invalid value 'abc' for sense 'weight' of type 'DoubleSenseValue'",
					e.getMessage());
		}
	}

	@Test
	public void testComputeSleepProblemSenses_EmptyInput() throws Throwable {
		Map<String, Object> inputValues = new HashMap<String, Object>();
		try {
			analyzerClient.getScoring().computeSleepProblemSenses(inputValues);
		} catch (Exception e) {
			Assert.assertEquals(defaultErrorMessage, e.getMessage());
		}
	}

	@Test
	public void testComputeSense() throws Throwable {
		String senseId = "bmi";
		HashMap<String, Object> inputValues = new HashMap<>();
		inputValues.put("height", 180);
		inputValues.put("weight", 75);
		LinkedHashMap<String, Object> computeSenseMap = analyzerClient.getScoring().computeSense(senseId, inputValues);
		Assert.assertEquals(23.148148148148145, computeSenseMap.get("bmi"));
	}

	@Test
	public void testComputeSense_InvalidSenseId() throws Throwable {
		String senseId = "bmi1";
		HashMap<String, Object> inputValues = new HashMap<>();
		inputValues.put("height", 180);
		inputValues.put("weight", 75);
		try {
			analyzerClient.getScoring().computeSense(senseId, inputValues);
		} catch (Exception e) {
			Assert.assertEquals(defaultErrorMessage, e.getMessage());
		}
	}

	@Test
	public void testComputeSense_InvalidInput() throws Throwable {
		String senseId = "bmi";
		HashMap<String, Object> inputValues = new HashMap<>();
		inputValues.put("height", 180);
		inputValues.put("weight", "abc");
		try {
			analyzerClient.getScoring().computeSense(senseId, inputValues);
		} catch (Exception e) {
			Assert.assertEquals("2102:Invalid value 'abc' for sense 'weight' of type 'DoubleSenseValue'",
					e.getMessage());
		}

	}

	@Test
	public void testComputeAllSenses() throws Throwable {

		HashMap<String, Object> dict = new HashMap<>();
		dict = new HashMap<>();
		dict.put("height", 175);
		dict.put("weight", 75);
		dict.put("bedTime", "20:30");
		dict.put("riseTime", "07:00");
		LinkedHashMap<String, Object> sensesDTOMap = analyzerClient.getScoring().computeAllSenses(dict);
		Assert.assertEquals(75.0, sensesDTOMap.get("weight"));
		Assert.assertEquals(24.489795918367346, sensesDTOMap.get("bmi"));
		Assert.assertEquals("20:30", sensesDTOMap.get("bedTime"));
		Assert.assertEquals(10, sensesDTOMap.get("tib"));

	}

	@Test
	public void testComputeAllSenses_InvalidInput() throws Throwable {

		HashMap<String, Object> dict = new HashMap<>();
		dict = new HashMap<>();
		dict.put("height", "test");
		dict.put("weight", 75);
		dict.put("bedTime", "20:30");
		dict.put("riseTime", "07:00");
		try {
			analyzerClient.getScoring().computeAllSenses(dict);
		} catch (Exception e) {
			Assert.assertEquals("2102:Invalid value 'test' for sense 'height' of type 'DoubleSenseValue'",
					e.getMessage());
		}
	}

	@Test
	public void testComputeAllSenses_EmptyInput() throws Throwable {

		HashMap<String, Object> dict = new HashMap<>();

		analyzerClient.getScoring().computeAllSenses(dict);
		Assert.assertEquals(0, dict.size());

	}

	@Test
	public void testGetComputableSleepProblemSenses() throws Throwable {
		List<String> senseIds = new ArrayList<String>();
		// add osa sense inputs
		senseIds.add("osa");
		senseIds.add("sss");
		senseIds.add("problemSnoring");

		// add insomnia sense inputs, except for difficultyWakingEarly
		senseIds.add("problemSleeping");
		senseIds.add("problemSleepiness");
		senseIds.add("difficultyDuration");
		senseIds.add("isi");
		senseIds.add("sleepInitiation1");
		senseIds.add("difficultyFallingAsleep");
		senseIds.add("difficultyStayingAsleep");

		List<SenseDTO> result;

		result = analyzerClient.getScoring().getComputableSleepProblemSenses(senseIds);
		Assert.assertEquals("snoring", result.get(0).getId());
	}

	@Test
	public void testGetComputableSleepProblemSenses_InvalidSenseId() throws Throwable {
		List<String> senseIds = new ArrayList<String>();
		// add osa sense inputs
		senseIds.add("osa1");
		senseIds.add("sss1");
		senseIds.add("problemSnoring1");

		// add insomnia sense inputs
		senseIds.add("problemSleeping1");
		senseIds.add("problemSleepiness1");
		senseIds.add("difficultyDuration1");
		senseIds.add("isi1");
		senseIds.add("sleepInitiation11");
		senseIds.add("difficultyFallingAsleep1");
		senseIds.add("difficultyStayingAsleep1");

		List<SenseDTO> senseDTOs = analyzerClient.getScoring().getComputableSleepProblemSenses(senseIds);
		Assert.assertEquals(0, senseDTOs.size());
	}

	@Test
	public void testGetComputableSleepProblemSenses_EmptySenseId() throws Throwable {
		List<String> senseIds = new ArrayList<String>();

		senseIds.add("");

		List<SenseDTO> senseDTOs = analyzerClient.getScoring().getComputableSleepProblemSenses(senseIds);
		Assert.assertEquals(0, senseDTOs.size());
	}

	@Test
	public void testGetComputableSenses() throws Throwable {
		List<String> senseIds = new ArrayList<String>();
		List<SenseDTO> result = new ArrayList<SenseDTO>();

		// add osa sense inputs
		senseIds.add("osa");
		senseIds.add("sss");
		senseIds.add("problemSnoring");

		// add insomnia sense inputs
		senseIds.add("problemSleeping");
		senseIds.add("problemSleepiness");
		senseIds.add("difficultyDuration");
		senseIds.add("isi");
		senseIds.add("sleepInitiation1");
		senseIds.add("difficultyFallingAsleep");
		senseIds.add("difficultyStayingAsleep");
		senseIds.add("difficultyWakingEarly");

		List<String> outputSenseIds = new ArrayList<String>();

		// default test
		result = analyzerClient.getScoring().getComputableSenses(senseIds);
		for (SenseDTO senseDTO : result) {
			List<SenseDependencyDTO> dependencies = senseDTO.getDependencies();
			for (SenseDependencyDTO dependencyDTO : dependencies) {
				Assert.assertTrue(senseIds.contains(dependencyDTO.getSenseId()));
			}
			outputSenseIds.add(senseDTO.getId());
		}
		Assert.assertEquals(2, outputSenseIds.size());
		Assert.assertEquals(true, outputSenseIds.contains("insomnia"));

	}

	@Test
	public void testGetComputableSenses_InvalidInput() throws Throwable {
		List<String> senseIds = new ArrayList<String>();
		List<SenseDTO> result = new ArrayList<SenseDTO>();
		senseIds.add("osa1");
		senseIds.add("sss1");
		senseIds.add("problemSleeping1");
		senseIds.add("problemSleepiness1");
		senseIds.add("difficultyDuration1");
		senseIds.add("isi1");

		senseIds.add("sleepInitiation1");

		result = analyzerClient.getScoring().getComputableSenses(senseIds);
		Assert.assertEquals(0, result.size());

	}

	@Test
	public void testGetComputableSenses_EmptyInput() throws Throwable {
		List<String> senseIds = new ArrayList<String>();
		List<SenseDTO> result = new ArrayList<SenseDTO>();

		result = analyzerClient.getScoring().getComputableSenses(senseIds);
		Assert.assertEquals(0, result.size());

	}

	private static Map<String, Object> prepareinput(Object height, Object weight) {
		Map<String, Object> dict = new HashMap<String, Object>();
		dict.put("height", height);
		dict.put("weight", weight);
		dict.put("bedTime", "20:30");
		dict.put("riseTime", "07:00");
		dict.put("sex", "male");
		dict.put("age", "42");
		dict.put("bedTime", "20:30");
		dict.put("occupation", "professional");
		dict.put("workHoursPerWeek", "45");
		dict.put("bedPartner", true);
		dict.put("shiftWorker", false);
		dict.put("problemSleeping", 0);
		dict.put("problemSleepiness", 0);
		dict.put("problemSnoring", 10);
		dict.put("problemPartnerSnoring", 0);
		dict.put("problemOther", "");

		dict.put("snoringBotherOthers", "yes");
		dict.put("breathingStopped", "no");
		dict.put("highBloodPressure", "no");
		dict.put("snoringOnBack", "yes");
		dict.put("noseOftenBlocked", "no");
		dict.put("snoringFrequency", "nightssome");
		dict.put("snoringDuration", "nightmostof");
		dict.put("snoringLoudness", "snoringheardnextroom");
		dict.put("snoringAnnoying", "very");

		dict.put("ess1", "dozeslight");
		dict.put("ess2", "dozeslight");
		dict.put("ess3", "dozenever");
		dict.put("ess4", "dozeslight");
		dict.put("ess5", "dozehigh");
		dict.put("ess6", "dozenever");
		dict.put("ess7", "dozeslight");
		dict.put("ess8", "dozeslight");

		dict.put("sleepInitiation1", "difficultsomewhat");
		dict.put("accidentRisk", true);
		dict.put("alcoholFrequency", "n2to4permonth");
		dict.put("caffeinatedDrinksPerDay", "nlessThan1");
		dict.put("smokingFrequency", "notatall");
		dict.put("difficultyDuration", "months3to6");
		dict.put("difficultyFallingAsleep", "none");
		dict.put("difficultyStayingAsleep", "none");
		dict.put("difficultyWakingEarly", "none");
		dict.put("sleepPatternDissatisfaction", "satisfied");
		dict.put("impactNoticeable", "noticeablebarely");
		dict.put("impactWorrying", "worrieddistressedbarely");
		dict.put("impactInterfering", "interferingbarely");
		return dict;

	}
}
