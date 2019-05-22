package com.philips.ai.controllers;

import org.junit.Before;
import org.junit.BeforeClass;

import com.philips.ai.SmartSleepAnalyzerClient;
import com.philips.ai.models.SessionDTO;

public class SessionControllerTest {

	String timeStamp;
	SessionDTO resultDTO;
	private static String clientId;
	private static String clientSecret;
	private final String defaultErrorMessage = "00000:Please verify the provided information is correct.";
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
	 * //@Test public void testCreateSession() throws Throwable { SessionDTO
	 * resultDTO = createSession(); Assert.assertEquals("testFirstName",
	 * resultDTO.getFirstName()); }
	 *
	 * //@Test public void testCreateSession_ExistingSession() throws Throwable {
	 * SessionDTO resultDTO = createSession(); SessionDTO sessionDTO = new SessionDTO();
	 * sessionDTO.setSessionKey(resultDTO.getSessionKey());
	 * sessionDTO.setFirstName("testFirstName"); sessionDTO.setLastName("testLastName");
	 * sessionDTO.setEmail("test@test.com"); sessionDTO.setDataKey("testSessionKey");
	 *
	 * try { analyzerClient.getSession().createSession(sessionDTO); } catch (Exception e) {
	 * Assert.assertEquals("4101:SessionKey \""+ sessionDTO.getSessionKey().toString()
	 * +"\" is already taken", e.getMessage()); } }
	 *
	 * //@Test public void testCreateSession_EmptyCreateSessionDetails() throws
	 * Throwable { SessionDTO sessionDTO = new SessionDTO(); try {
	 * analyzerClient.getSession().createSession(sessionDTO); } catch (Exception e) {
	 * Assert.assertEquals("4101:SessionKey is required", e.getMessage()); } }
	 *
	 * //@Test public void testActivateSession() throws Throwable { SessionDTO resultDTO =
	 * createSession(); SessionDTO sessionDTO = new SessionDTO();
	 * sessionDTO.setSessionKey(resultDTO.getSessionKey());
	 * sessionDTO.setEmail(resultDTO.getEmail()); sessionDTO.setDataKey("testSessionKey");
	 * SessionDTO result = analyzerClient.getSession().activateSession(sessionDTO);
	 * Assert.assertEquals(resultDTO.getId(), result.getId());
	 * Assert.assertEquals(resultDTO.getLastName(), result.getLastName());
	 * Assert.assertEquals(resultDTO.getFirstName(), result.getFirstName());
	 * Assert.assertEquals(resultDTO.getSessionKey(), result.getSessionKey());
	 * Assert.assertEquals(resultDTO.getEmail(), result.getEmail());
	 * Assert.assertEquals(resultDTO.getDataKey(), null);
	 *
	 * }
	 *
	 * //@Test public void testcreateSession_InvalidSession() throws Throwable { SessionDTO
	 * sessionDTO = new SessionDTO(); sessionDTO.setId(123456789L);
	 * sessionDTO.setSessionKey("testActivateSession" + new Random().nextLong());
	 * sessionDTO.setEmail("test@test.com"); sessionDTO.setDataKey("testSessionKey");
	 *
	 * try { analyzerClient.getSession().activateSession(sessionDTO); } catch (Exception e) {
	 * Assert.assertEquals("4201:SessionKey and/or DataKey is incorrect.",
	 * e.getMessage()); } }
	 *
	 * //@Test public void testcreateSession_EmptyCreateSessionDetails() throws Throwable
	 * { SessionDTO sessionDTO = new SessionDTO(); try {
	 * analyzerClient.getSession().activateSession(sessionDTO); } catch (Exception e) {
	 * Assert.assertEquals("4201:SessionKey and/or DataKey is incorrect.",
	 * e.getMessage()); } }
	 *
	 * //@Test public void testRetrieve() throws Throwable { try {
	 * analyzerClient.getSession().retrieveActivatedSession(); } catch (Exception e) {
	 * Assert.assertEquals(defaultErrorMessage, e.getMessage()); } }
	 *
	 * //@Test public void testdeactivateSession() throws Throwable {
	 * analyzerClient.getSession().deactivateSession(); }
	 */

	/*
	 * private SessionDTO createSession() throws Throwable { SessionDTO sessionDTO = new
	 * SessionDTO(); sessionDTO.setSessionKey("testsession" + new
	 * SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
	 * sessionDTO.setFirstName("testFirstName"); sessionDTO.setLastName("testLastName");
	 * sessionDTO.setEmail("test@test.com"); sessionDTO.setDataKey("testSessionKey");
	 * SessionDTO resultDTO = analyzerClient.getSession().createSession(sessionDTO); return
	 * resultDTO; }
	 */
}
