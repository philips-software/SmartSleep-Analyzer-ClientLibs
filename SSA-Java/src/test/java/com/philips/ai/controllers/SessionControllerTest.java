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
	 * //@Test public void testCreateRegisterUser() throws Throwable { SessionDTO
	 * resultDTO = registerUser(); Assert.assertEquals("testFirstName",
	 * resultDTO.getFirstName()); }
	 * 
	 * //@Test public void testRegisterUser_ExistingUser() throws Throwable {
	 * SessionDTO resultDTO = registerUser(); SessionDTO sessionDTO = new SessionDTO();
	 * sessionDTO.setSessionKey(resultDTO.getSessionKey());
	 * sessionDTO.setFirstName("testFirstName"); sessionDTO.setLastName("testLastName");
	 * sessionDTO.setEmail("test@test.com"); sessionDTO.setDataKey("testPassword");
	 * 
	 * try { analyzerClient.getSession().registerUser(sessionDTO); } catch (Exception e) {
	 * Assert.assertEquals("4101:Username \""+ sessionDTO.getSessionKey().toString()
	 * +"\" is already taken", e.getMessage()); } }
	 * 
	 * //@Test public void testRegisterUser_EmptyRegisterUserDetails() throws
	 * Throwable { SessionDTO sessionDTO = new SessionDTO(); try {
	 * analyzerClient.getSession().registerUser(sessionDTO); } catch (Exception e) {
	 * Assert.assertEquals("4101:Password is required", e.getMessage()); } }
	 * 
	 * //@Test public void testLoginUser() throws Throwable { SessionDTO resultDTO =
	 * registerUser(); SessionDTO sessionDTO = new SessionDTO();
	 * sessionDTO.setSessionKey(resultDTO.getSessionKey());
	 * sessionDTO.setEmail(resultDTO.getEmail()); sessionDTO.setDataKey("testPassword");
	 * SessionDTO result = analyzerClient.getSession().loginUser(sessionDTO);
	 * Assert.assertEquals(resultDTO.getId(), result.getId());
	 * Assert.assertEquals(resultDTO.getLastName(), result.getLastName());
	 * Assert.assertEquals(resultDTO.getFirstName(), result.getFirstName());
	 * Assert.assertEquals(resultDTO.getSessionKey(), result.getSessionKey());
	 * Assert.assertEquals(resultDTO.getEmail(), result.getEmail());
	 * Assert.assertEquals(resultDTO.getDataKey(), null);
	 * Assert.assertEquals(resultDTO.getNewPassword(), null);
	 * 
	 * }
	 * 
	 * //@Test public void testCreateLogin_InvalidUser() throws Throwable { SessionDTO
	 * sessionDTO = new SessionDTO(); sessionDTO.setId(123456789L);
	 * sessionDTO.setSessionKey("testLoginUser" + new Random().nextLong());
	 * sessionDTO.setEmail("test@test.com"); sessionDTO.setDataKey("testPassword");
	 * 
	 * try { analyzerClient.getSession().loginUser(sessionDTO); } catch (Exception e) {
	 * Assert.assertEquals("4201:Username and/or Password is incorrect.",
	 * e.getMessage()); } }
	 * 
	 * //@Test public void testCreateLogin_EmptyUserLoginDetails() throws Throwable
	 * { SessionDTO sessionDTO = new SessionDTO(); try {
	 * analyzerClient.getSession().loginUser(sessionDTO); } catch (Exception e) {
	 * Assert.assertEquals("4201:Username and/or Password is incorrect.",
	 * e.getMessage()); } }
	 * 
	 * //@Test public void testRetrieve() throws Throwable { try {
	 * analyzerClient.getSession().retrieveLoggedInUser(); } catch (Exception e) {
	 * Assert.assertEquals(defaultErrorMessage, e.getMessage()); } }
	 * 
	 * //@Test public void testGetLogout() throws Throwable {
	 * analyzerClient.getSession().logoutUser(); }
	 */

	/*
	 * private SessionDTO registerUser() throws Throwable { SessionDTO sessionDTO = new
	 * SessionDTO(); sessionDTO.setSessionKey("testsession" + new
	 * SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
	 * sessionDTO.setFirstName("testFirstName"); sessionDTO.setLastName("testLastName");
	 * sessionDTO.setEmail("test@test.com"); sessionDTO.setDataKey("testPassword");
	 * SessionDTO resultDTO = analyzerClient.getSession().registerUser(sessionDTO); return
	 * resultDTO; }
	 */
}
