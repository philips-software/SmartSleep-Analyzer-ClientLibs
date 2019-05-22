# Getting started

Provides an effective solution for sleep problems.

## How to Build

The generated code uses a few Maven dependencies e.g., Jackson, UniRest,
and Apache HttpClient. The reference to these dependencies is already
added in the pom.xml file will be installed automatically. Therefore,
you will need internet access for a successful build.

1. In order to open the client library in Eclipse click on ``` File -> Import ```.

2. In the import dialog, select ``` Existing Java Project ``` and click ``` Next ```.

3. Browse to locate the folder containing the source code. Select the detected location of the project and click ``` Finish ```.

4. Upon successful import, the project will be automatically built by Eclipse after automatically resolving the dependencies.

## How to Use

The following section explains how to use the SmartSleepAnalyzer library in a new console project.

### 1. Starting a new project

For starting a new project, click the menu command ``` File > New > Project ```.

Next, choose ``` Maven > Maven Project ```and click ``` Next ```.

Here, make sure to use the current workspace by choosing ``` Use default Workspace location ```, as shown in the picture below and click ``` Next ```.

Following this, select the *quick start* project type to create a simple project with an existing class and a ``` main ``` method. To do this, choose ``` maven-archetype-quickstart ``` item from the list and click ``` Next ```.

In the last step, provide a ``` Group Id ``` and ``` Artifact Id ``` as shown in the picture below and click ``` Finish ```.

### 2. Add reference of the library project

The created Maven project manages its dependencies using its ``` pom.xml ``` file. In order to add a dependency on the *SmartSleepAnalyzer* client library, double click on the ``` pom.xml ``` file in the ``` Package Explorer ```. Opening the ``` pom.xml ``` file will render a graphical view on the cavas. Here, switch to the ``` Dependencies ``` tab and click the ``` Add ``` button as shown in the picture below.

Clicking the ``` Add ``` button will open a dialog where you need to specify SmartSleepAnalyzer in ``` Group Id ``` and SmartSleepAnalyzer in the ``` Artifact Id ``` fields. Once added click ``` OK ```. Save the ``` pom.xml ``` file.

### 3. Write sample code

Once the ``` SimpleConsoleApp ``` is created, a file named ``` App.java ``` will be visible in the *Package Explorer* with a ``` main ``` method. This is the entry point for the execution of the created project.
Here, you can add code to initialize the client library and instantiate a *Controller* class. Sample code to initialize the client library and using controller methods is given in the subsequent sections.

## How to Test

The generated code and the server can be tested using automatically generated test cases. 
JUnit is used as the testing framework and test runner.

From the command line, test with mvn with the following (replace client credentials with your own):

1. mvn clean install site -Prelease -DclientId=<YourClientId> -DclientSecret=<YourClientSecret>

In Eclipse, for running the tests do the following:

1. Select the project *SmartSleepAnalyzer* from the package explorer.
2. Select "Run -> Run as -> JUnit Test" or use "Alt + Shift + X" followed by "T" to run the Tests.

## Initialization

### 

API client can be initialized as following.

```java
SmartSleepAnalyzerClient client = new SmartSleepAnalyzerClient();
```


# Class Reference

## <a name="list_of_controllers"></a>List of Controllers

* [ScoringController](#scoring_controller)
* [ResultController](#result_controller)
* [SessionController](#session_controller)
* [SurveyController](#survey_controller)

## <a name="scoring_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.philips.ai.controllers.ScoringController") ScoringController

### Get singleton instance

The singleton instance of the ``` ScoringController ``` class can be accessed from the API Client.

```java
ScoringController scoring = client.getScoring();
```

### <a name="get_required_question_senses"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.getRequiredQuestionSenses") getRequiredQuestionSenses

> Returns all question senses required to compute the target sense.


```java
List<SenseDTO> getRequiredQuestionSenses(
        final String targetSenseId,
        final String locale)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| targetSenseId |  ``` Required ```  | Id of sense for which required inputs are returned. |
| locale |  ``` Optional ```  ``` DefaultValue ```  | Optional query param locale used to localize question sense text. |


#### Example Usage

```java
String targetSenseId = "targetSenseId";
String locale = "en-US";
// Invoking the API call with sample inputs
scoring.getRequiredQuestionSenses(targetSenseId, locale);

```


### <a name="get_computable_sleep_problem_senses"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.getComputableSleepProblemSenses") getComputableSleepProblemSenses

> Returns all sleep problem senses which can be computed from the given input sense ids.


```java
List<SenseDTO> getComputableSleepProblemSenses(final List<String> senseIds)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| senseIds |  ``` Optional ```  ``` Collection ```  | List of ids for all input senses that would be provided. |


#### Example Usage

```java
try {
    List<String> senseIds = new LinkedList<String>(Arrays.asList("height", "weight"));
    // Invoking the API call with sample inputs
    scoring.createGetComputableSleepProblemSenses(senseIds);
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="get_computable_senses"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.getComputableSenses") getComputableSenses

> Returns all senses which can be computed from the given input sense ids.


```java
List<SenseDTO> getComputableSenses(final List<String> senseIds)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| senseIds |  ``` Optional ```  ``` Collection ```  | List of ids for all input senses that would be provided. |


#### Example Usage

```java
try {
    List<String> senseIds = new LinkedList<String>(Arrays.asList("height", "weight"));
    // Invoking the API call with sample inputs
    scoring.createGetComputableSenses(senseIds);
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="get_computed_senses"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.getComputedSenses") getComputedSenses

> Returns metadata information about all computed senses. Computed senses are derived from other senses and should not be asked directly to an end-user.


```java
List<SenseDTO> getComputedSenses()
```

#### Example Usage

```java
// Invoking the API call with sample inputs
scoring.getComputedSenses();

```


### <a name="get_sleep_problem_senses"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.getSleepProblemSenses") getSleepProblemSenses

> Returns metadata information about all sleep problem senses.


```java
List<SenseDTO> getSleepProblemSenses()
```

#### Example Usage

```java
// Invoking the API call with sample inputs
scoring.getSleepProblemSenses();

```


### <a name="get_question_senses"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.getQuestionSenses") getQuestionSenses

> Returns metadata information about all question senses. Question senses are simple value senses which can be asked to an end-user in the form of a question.


```java
List<SenseDTO> getQuestionSenses(final String locale)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| locale |  ``` Optional ```  ``` DefaultValue ```  | Optional query param locale used to localize question sense text. |


#### Example Usage

```java
String locale = "en-US";
// Invoking the API call with sample inputs
scoring.getQuestionSenses(locale);

```


### <a name="get_all_senses"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.getAllSenses") getAllSenses

> Returns metadata information about all available senses.


```java
List<SenseDTO> getAllSenses(final String locale)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| locale |  ``` Optional ```  ``` DefaultValue ```  | Optional query param locale used to localize question sense text. |


#### Example Usage

```java
String locale = "en-US";
// Invoking the API call with sample inputs
scoring.getAllSenses(locale);

```


### <a name="get_sense"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.getSense") getSense

> Returns metadata information about a single sense.


```java
SenseDTO getSense(
        final String senseId,
        final String locale)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| senseId |  ``` Required ```  | The id of the sense. |
| locale |  ``` Optional ```  ``` DefaultValue ```  | Optional query param locale used to localize question sense text. |


#### Example Usage

```java
String senseId = "bmi";
String locale = "en-US";
// Invoking the API call with sample inputs
scoring.getSense(senseId, locale);

```


### <a name="compute_intermediate_and_sleep_problem_senses"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.computeIntermediateAndSleepProblemSenses") computeIntermediateAndSleepProblemSenses

> Computes the values of all possible intermediate and sleep problem senses based on the provided input values.


```java
LinkedHashMap<String, Object> computeIntermediateAndSleepProblemSenses(final Object inputValues)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| inputValues |  ``` Optional ```  | Map of sense input values, keyed by sense id. |


#### Example Usage

```java
try {
    Object inputValues = new Object();
    // Invoking the API call with sample inputs
    scoring.createComputeIntermediateAndSleepProblemSenses(inputValues);
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="compute_sleep_problem_senses"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.computeSleepProblemSenses") computeSleepProblemSenses

> Computes the values of all possible sleep problem senses based on the provided input values.


```java
LinkedHashMap<String, Object> computeSleepProblemSenses(final Object inputValues)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| inputValues |  ``` Optional ```  | Map of sense input values, keyed by sense id. |


#### Example Usage

```java
try {
    Object inputValues = new Object();
    // Invoking the API call with sample inputs
    scoring.createComputeSleepProblemSenses(inputValues);
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="compute_sense"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.computeSense") computeSense

> Computes the value of a single sense based on the provided input values.


```java
LinkedHashMap<String, Object> computeSense(
        final String senseId,
        final Object inputValues)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| senseId |  ``` Required ```  | Id of the sense to compute. |
| inputValues |  ``` Optional ```  | Map of sense input values, keyed by sense id. |


#### Example Usage

```java
try {
    String senseId = "bmi";
    Object inputValues = new Object();
    // Invoking the API call with sample inputs
    scoring.createComputeSense(senseId, inputValues);
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="compute_all_senses"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.computeAllSenses") computeAllSenses

> Computes the values of all possible senses based on the provided input values.


```java
LinkedHashMap<String, Object> computeAllSenses(final Object inputValues)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| inputValues |  ``` Optional ```  | Map of sense input values, keyed by sense id. |


#### Example Usage

```java
try {
    Object inputValues = new Object();
    // Invoking the API call with sample inputs
    scoring.createComputeAllSenses(inputValues);
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


[Back to List of Controllers](#list_of_controllers)

## <a name="result_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.philips.ai.controllers.ResultController") ResultController

### Get singleton instance

The singleton instance of the ``` ResultController ``` class can be accessed from the API Client.

```java
ResultController result = client.getResult();
```

### <a name="get_tips_by_condition_and_input_values"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ResultController.getTipsByConditionAndInputValues") getTipsByConditionAndInputValues

> Computes and returns all tips that would be associated with the given condition, based on the given input values.


```java
List<TipResult> getTipsByConditionAndInputValues(
        final String conditionId,
        final Object inputValues)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| conditionId |  ``` Optional ```  | The id of the sleep problem. |
| inputValues |  ``` Optional ```  | The sense input values. |


#### Example Usage

```java
try {
    String conditionId = "osa";
    Object inputValues = new Object();
    // Invoking the API call with sample inputs
    result.createGetTipsByConditionAndInputValues(conditionId, inputValues);
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="get_tip_ids_by_condition_and_input_values"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ResultController.getTipIdsByConditionAndInputValues") getTipIdsByConditionAndInputValues

> Computes and returns the ids of all tips that would be associated with the given condition, based on the given
> 
> input values.


```java
List<String> getTipIdsByConditionAndInputValues(
        final String conditionId,
        final Object inputValues)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| conditionId |  ``` Required ```  | The id of the sleep problem. |
| inputValues |  ``` Optional ```  | The sense input values. |


#### Example Usage

```java
try {
    String conditionId = "osa";
    Object inputValues = new Object();
    // Invoking the API call with sample inputs
    result.createGetTipIdsByConditionAndInputValues(conditionId, inputValues);
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="get_tidbit_ids_by_condition"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ResultController.getTidbitIdsByCondition") getTidbitIdsByCondition

> Returns the ids of all tidbits that could be associated with the given condition.


```java
List<String> getTidbitIdsByCondition(final String conditionId)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| conditionId |  ``` Required ```  | The id of the condition. |


#### Example Usage

```java
String conditionId = "osa";
// Invoking the API call with sample inputs
result.createGetTidbitIdsByCondition(conditionId);

```


### <a name="get_tip_ids_by_condition"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ResultController.getTipIdsByCondition") getTipIdsByCondition

> Returns the ids of all tips that could be associated with the given condition.


```java
List<String> getTipIdsByCondition(final String conditionId)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| conditionId |  ``` Required ```  | The id of the condition. |


#### Example Usage

```java
String conditionId = "osa";
// Invoking the API call with sample inputs
result.createGetTipIdsByCondition(conditionId);

```


### <a name="get_condition"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ResultController.getCondition") getCondition

> Returns metadata information about an single condition.


```java
ConditionResult getCondition(final String conditionId)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| conditionId |  ``` Required ```  | The id of the condition. |


#### Example Usage

```java
String conditionId = "osa";
// Invoking the API call with sample inputs
result.createGetCondition(conditionId);

```


### <a name="submit_tip_feedback"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ResultController.submitTipFeedback") submitTipFeedback

> Submits feedback for an end-user on the indicated tip.


```java
void submitTipFeedback(final UpdateTipFeedbackRequestDTO requestDTO)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| requestDTO |  ``` Optional ```  | The request object. |


#### Example Usage

```java
try {
    UpdateTipFeedbackRequestDTO requestDTO = new UpdateTipFeedbackRequestDTO();
    // Invoking the API call with sample inputs
    result.createSubmitTipFeedback(requestDTO);
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="get_all_conditions"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ResultController.getAllConditions") getAllConditions

> Returns metadata information about all available conditions.


```java
List<ConditionResult> getAllConditions()
```

#### Example Usage

```java
// Invoking the API call with sample inputs
result.getAllConditions();

```


### <a name="submit_condition_feedback"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ResultController.submitConditionFeedback") submitConditionFeedback

> Submits feedback for an end-user on the indicated condition.


```java
void submitConditionFeedback(final UpdateConditionFeedbackRequestDTO requestDTO)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| requestDTO |  ``` Optional ```  | The request object. |


#### Example Usage

```java
try {
    UpdateConditionFeedbackRequestDTO requestDTO = new UpdateConditionFeedbackRequestDTO();
    // Invoking the API call with sample inputs
    result.createSubmitConditionFeedback(requestDTO);
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="compute_result"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ResultController.computeResult") computeResult

> Computes Results output for the given survey.


```java
ResultDTO computeResult(
        final String surveyIdentifier,
        final String sessionId)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| surveyIdentifier |  ``` Required ```  | The identifier of the survey. |
| sessionId |  ``` Optional ```  | The identifier of the session. |


#### Example Usage

```java
String surveyIdentifier = "surveyIdentifier";
// Invoking the API call with sample inputs
result.computeResult(surveyIdentifier);

```


[Back to List of Controllers](#list_of_controllers)

## <a name="session_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.philips.ai.controllers.SessionController") SessionController

### Get singleton instance

The singleton instance of the ``` SessionController ``` class can be accessed from the API Client.

```java
SessionController session = client.getSession();
```

### <a name="activate_session"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SessionController.activateSession") activateSession

> Activates a session.


```java
SessionDTO activateSession(final SessionDTO sessionDTO)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| sessionDTO |  ``` Optional ```  | Object containing the session credentials. |


#### Example Usage

```java
try {
    SessionDTO sessionDTO = new SessionDTO();
    // Invoking the API call with sample inputs
    session.createSession(sessionDTO);
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="retrieve_activated_session"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SessionController.retrieveActivatedSession") retrieveActivatedSession

> Retrieves the details of the activated session.


```java
SessionDTO retrieveActivatedSession()
```

#### Example Usage

```java
// Invoking the API call with sample inputs
session.retrieve();

```


### <a name="deactivate_session"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SessionController.deactivateSession") deactivateSession

> Deactivates the current session.


```java
void deactivateSession()
```

#### Example Usage

```java
// Invoking the API call with sample inputs
session.deactivateSession();

```


### <a name="create_session"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SessionController.createSession") createSession

> Creates a new session with the provided information.


```java
SessionDTO createSession(final SessionDTO sessionDTO)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| sessionDTO |  ``` Optional ```  | The provided session information. |


#### Example Usage

```java
try {
    SessionDTO sessionDTO = new SessionDTO();
    // Invoking the API call with sample inputs
    session.createCreateSession(sessionDTO);
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


[Back to List of Controllers](#list_of_controllers)

## <a name="survey_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.philips.ai.controllers.SurveyController") SurveyController

### Get singleton instance

The singleton instance of the ``` SurveyController ``` class can be accessed from the API Client.

```java
SurveyController survey = client.getSurvey();
```

### <a name="get_matched_rules"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SurveyController.getMatchedRules") getMatchedRules

> DEVELOPMENT ONLY: Returns all rules which were matched in the computation of the session's survey state. This API is only available in development environment. In all other environments it will result in a 404 (not found).


```java
void getMatchedRules(final String identifier)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |


#### Example Usage

```java
String identifier = "sleep";
// Invoking the API call with sample inputs
survey.getMatchedRules(identifier);

```


### <a name="post_survey_answers"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SurveyController.postSurveyAnswers") postSurveyAnswers

> DEVELOPMENT ONLY: Updates all answers stored for a session for a survey to the given set of answers. This API is only available in development environment. In all other environments it will result in a 404 (not found). Returns all updated answers.


```java
void postSurveyAnswers(
        final String identifier,
        final Object answers)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |
| answers |  ``` Optional ```  | The answer values to apply. Answers are keyed by question identifier. |


#### Example Usage

```java
try {
    String identifier = "sleep";
    Object answers = new Object();
    // Invoking the API call with sample inputs
    survey.postSurveyAnswers(identifier, answers);
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="get_sense_input_values"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SurveyController.getSenseInputValues") getSenseInputValues

> DEVELOPMENT ONLY: Similar to the GET /answers API, but instead returns answers mapped to their corresponding sense values. This API is only available in development environment. In all other environments it will result in a 404 (not found).


```java
void getSenseInputValues(final String identifier)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |


#### Example Usage

```java
String identifier = "sleep";
// Invoking the API call with sample inputs
survey.getSenseInputValues(identifier);

```


### <a name="create_reset_survey_state"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SurveyController.createResetSurveyState") createResetSurveyState

> Resets the state of the survey for the current session. In other words, all the session's answers are removed and the survey should start back at the beginning.


```java
void createResetSurveyState(final String identifier)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |


#### Example Usage

```java
String identifier = "sleep";
// Invoking the API call with sample inputs
survey.createResetSurveyState(identifier);

```


### <a name="get_survey_answers"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SurveyController.getSurveyAnswers") getSurveyAnswers

> DEVELOPMENT ONLY: Gets all answers stored for a session for a given survey. This API is only available in development environment. In all other environments it will result in a 404 (not found).


```java
void getSurveyAnswers(final String identifier)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |


#### Example Usage

```java
String identifier = "sleep";
// Invoking the API call with sample inputs
survey.getSurveyAnswers(identifier);

```


### <a name="get_survey_state"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SurveyController.getSurveyState") getSurveyState

> Retrieves the state of a survey for the current session.


```java
SurveyStateDTO getSurveyState(
        final String identifier,
        final String sessionId)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |
| sessionId |  ``` Optional ```  | The identifier of the session. |


#### Example Usage

```java
String identifier = "sleep";
// Invoking the API call with sample inputs
survey.getSurveyState(identifier);

```


### <a name="update_survey_state"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SurveyController.updateSurveyState") updateSurveyState

> Updates the state of a survey for the current session, and returns the portion of the survey state necessary for the client to render the survey based on the update.


```java
void updateSurveyState(
        final String identifier,
        final UpdateSurveyStateRequestDTO requestDTO,
        final String sessionId)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |
| sessionId |  ``` Optional ```  | The identifier of the session. |
| requestDTO |  ``` Optional ```  | The update request object. |


#### Example Usage

```java
try {
    String identifier = "sleep";
    UpdateSurveyStateRequestDTO requestDTO = new UpdateSurveyStateRequestDTO();
    // Invoking the API call with sample inputs
    survey.updateSurveyState(identifier, requestDTO);
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


[Back to List of Controllers](#list_of_controllers)



