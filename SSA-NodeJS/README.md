# Getting started

Provides an effective solution for sleep problems.

## How to Build

The generated SDK relies on [Node Package Manager](https://www.npmjs.com/) (NPM) being available to resolve dependencies. If you don't already have NPM installed, please go ahead and follow instructions to install NPM from [here](https://nodejs.org/en/download/).
The SDK also requires Node to be installed. If Node isn't already installed, please install it from [here](https://nodejs.org/en/download/)
> NPM is installed by default when Node is installed

To check if node and npm have been successfully installed, write the following commands in command prompt:

* `node --version`
* `npm -version`

Now use npm to resolve all dependencies by running the following command in the root directory (of the SDK folder):

```bash
npm install
```

This will install all dependencies in the `node_modules` folder.

Once dependencies are resolved, you will need to move the folder `SmartSleepAnalyzer ` in to your `node_modules` folder.

## How to Use

The following section explains how to use the library in a new project.

### 1. Open Project Folder
Open an IDE/Text Editor for JavaScript like Sublime Text. The basic workflow presented here is also applicable if you prefer using a different editor or IDE.

Click on `File` and select `Open Folder`.

Select the folder of your SDK and click on `Select Folder` to open it up in Sublime Text. The folder will become visible in the bar on the left.

### 2. Creating a Test File

Now right click on the folder name and select the `New File` option to create a new test file. Save it as `index.js` Now import the generated NodeJS library using the following lines of code:

```js
var lib = require('lib');
```

Save changes.

### 3. Running The Test File

To run the `index.js` file, open up the command prompt and navigate to the Path where the SDK folder resides. Type the following command to run the file:

```
node index.js
```

## How to Test

These tests use Mocha framework for testing, coupled with Chai for assertions. These dependencies need to be installed for tests to run.
Tests can be run in a number of ways:

### Method 1 (Run all tests)

1. Navigate to the root directory of the SDK folder from command prompt.
2. Type `mocha --recursive` to run all the tests.

### Method 2 (Run all tests)

1. Navigate to the `../test/Controllers/` directory from command prompt.
2. Type `mocha *` to run all the tests.

### Method 3 (Run specific controller's tests)

1. Navigate to the `../test/Controllers/` directory from command prompt.
2. Type `mocha  <Controller Name Here>`  to run all the tests in that controller file.

> To increase mocha's default timeout, you can change the `TEST_TIMEOUT` parameter's value in `TestBootstrap.js`.


## Initialization

### 

API client can be initialized as following:

```JavaScript
const lib = require('lib');
```



# Class Reference

## <a name="list_of_controllers"></a>List of Controllers

* [ScoringController](#scoring_controller)
* [ResultController](#result_controller)
* [SessionController](#session_controller)
* [SurveyController](#survey_controller)

## <a name="scoring_controller"></a>![Class: ](https://apidocs.io/img/class.png ".ScoringController") ScoringController

### Get singleton instance

The singleton instance of the ``` ScoringController ``` class can be accessed from the API Client.

```javascript
var SSA_ClientLib = lib(_config.clientid,_config.secretKey);
```

### <a name="get_required_question_senses"></a>![Method: ](https://apidocs.io/img/method.png ".ScoringController.getRequiredQuestionSenses") getRequiredQuestionSenses

> Returns all question senses required to compute the target sense.


```javascript
function getRequiredQuestionSenses(targetSenseId, locale)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| targetSenseId |  ``` Required ```  | Id of sense for which required inputs are returned. |
| locale |  ``` Optional ```  ``` DefaultValue ```  | Optional query param locale used to localize question sense text. |



#### Example Usage

```javascript
var targetSenseId = 'targetSenseId';
var locale = 'locale';

SSA_ClientLib.ScoringController.getRequiredQuestionSenses(targetSenseId, locale).then(function(result) {
    //TODO Business Logic
});
```



### <a name="get_computable_sleep_problem_senses"></a>![Method: ](https://apidocs.io/img/method.png ".ScoringController.getComputableSleepProblemSenses") getComputableSleepProblemSenses

> Returns all sleep problem senses which can be computed from the given input sense ids.


```javascript
function getComputableSleepProblemSenses(senseIds)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| senseIds |  ``` Optional ```  ``` Collection ```  | List of ids for all input senses that would be provided. |



#### Example Usage

```javascript
var senseIds = ['senseIds'];

SSA_ClientLib.ScoringController.getComputableSleepProblemSenses(senseIds).then(function(result) {
    //TODO Business Logic
});
```



### <a name="get_computable_senses"></a>![Method: ](https://apidocs.io/img/method.png ".ScoringController.getComputableSenses") getComputableSenses

> Returns all senses which can be computed from the given input sense ids.


```javascript
function getComputableSenses(senseIds)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| senseIds |  ``` Optional ```  ``` Collection ```  | List of ids for all input senses that would be provided. |



#### Example Usage

```javascript
var senseIds = ['senseIds'];

SSA_ClientLib.ScoringController.getComputableSenses(senseIds).then(function(result) {
    //TODO Business Logic
});
```



### <a name="get_computed_senses"></a>![Method: ](https://apidocs.io/img/method.png ".ScoringController.getComputedSenses") getComputedSenses

> Returns metadata information about all computed senses. Computed senses are derived from other senses and should
> 
> not be asked directly to an end-user.


```javascript
function getComputedSenses()
```

#### Example Usage

```javascript
SSA_ClientLib.ScoringController.getComputedSenses().then(function(result) {
    //TODO Business Logic
});
```



### <a name="get_sleep_problem_senses"></a>![Method: ](https://apidocs.io/img/method.png ".ScoringController.getSleepProblemSenses") getSleepProblemSenses

> Returns metadata information about all sleep problem senses.


```javascript
function getSleepProblemSenses()
```

#### Example Usage

```javascript
SSA_ClientLib.ScoringController.getSleepProblemSenses().then(function(result) {
    //TODO Business Logic
});
```



### <a name="get_question_senses"></a>![Method: ](https://apidocs.io/img/method.png ".ScoringController.getQuestionSenses") getQuestionSenses

> Returns metadata information about all question senses. Question senses are simple value senses which can be asked
> 
> to an end-user in the form of a question.


```javascript
function getQuestionSenses(locale)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| locale |  ``` Optional ```  ``` DefaultValue ```  | Optional query param locale used to localize question sense text. |



#### Example Usage

```javascript
var locale = 'locale';

SSA_ClientLib.ScoringController.getQuestionSenses(locale).then(function(result) {
    //TODO Business Logic
});
```



### <a name="get_all_senses"></a>![Method: ](https://apidocs.io/img/method.png ".ScoringController.getAllSenses") getAllSenses

> Returns metadata information about all available senses.


```javascript
function getAllSenses(locale)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| locale |  ``` Optional ```  ``` DefaultValue ```  | Optional query param locale used to localize question sense text. |



#### Example Usage

```javascript
var locale = 'locale';

SSA_ClientLib.ScoringController.getAllSenses(locale).then(function(result) {
    //TODO Business Logic
});
```



### <a name="get_sense"></a>![Method: ](https://apidocs.io/img/method.png ".ScoringController.getSense") getSense

> Returns metadata information about a single sense.


```javascript
function getSense(senseId, locale)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| senseId |  ``` Required ```  | The id of the sense. |
| locale |  ``` Optional ```  ``` DefaultValue ```  | Optional query param locale used to localize question sense text. |



#### Example Usage

```javascript
var senseId = 'senseId';
var locale = 'locale';

SSA_ClientLib.ScoringController.getSense(senseId, locale).then(function(result) {
    //TODO Business Logic
});
```



### <a name="compute_intermediate_and_sleep_problem_senses"></a>![Method: ](https://apidocs.io/img/method.png ".ScoringController.computeIntermediateAndSleepProblemSenses") computeIntermediateAndSleepProblemSenses

> Computes the values of all possible intermediate and sleep problem senses based on the provided input values.


```javascript
function computeIntermediateAndSleepProblemSenses(inputValues)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| inputValues |  ``` Optional ```  | Map of sense input values, keyed by sense id. |



#### Example Usage

```javascript
var inputValues = {
    id : 21
};

SSA_ClientLib.ScoringController.computeIntermediateAndSleepProblemSenses(inputValues).then(function(result) {
    //TODO Business Logic
});
```



### <a name="compute_sleep_problem_senses"></a>![Method: ](https://apidocs.io/img/method.png ".ScoringController.computeSleepProblemSenses") computeSleepProblemSenses

> Computes the values of all possible sleep problem senses based on the provided input values.


```javascript
function computeSleepProblemSenses(inputValues)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| inputValues |  ``` Optional ```  | Map of sense input values, keyed by sense id. |



#### Example Usage

```javascript
var inputValues = {
    id : 21
};

SSA_ClientLib.ScoringController.computeSleepProblemSenses(inputValues).then(function(result) {
    //TODO Business Logic
});
```



### <a name="compute_sense"></a>![Method: ](https://apidocs.io/img/method.png ".ScoringController.computeSense") computeSense

> Computes the value of a single sense based on the provided input values.


```javascript
function computeSense(senseId, inputValues)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| senseId |  ``` Required ```  | Id of the sense to compute. |
| inputValues |  ``` Optional ```  | Map of sense input values, keyed by sense id. |



#### Example Usage

```javascript
var senseId = 'senseId';
var inputValues = {
    id : 21
};

SSA_ClientLib.ScoringController.computeSense(senseId, inputValues).then(function(result) {
    //TODO Business Logic
});
```



### <a name="compute_all_senses"></a>![Method: ](https://apidocs.io/img/method.png ".ScoringController.computeAllSenses") computeAllSenses

> Computes the values of all possible senses based on the provided input values.


```javascript
function computeAllSenses(inputValues)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| inputValues |  ``` Optional ```  | Map of sense input values, keyed by sense id. |



#### Example Usage

```javascript
var inputValues = {
    id : 21
};

SSA_ClientLib.ScoringController.computeSense(inputValues).then(function(result) {
    //TODO Business Logic
});
```



[Back to List of Controllers](#list_of_controllers)

## <a name="result_controller"></a>![Class: ](https://apidocs.io/img/class.png ".ResultController") ResultController

### Get singleton instance

The singleton instance of the ``` ResultController ``` class can be accessed from the API Client.

```javascript
var SSA_ClientLib = lib(_config.clientid,_config.secretKey);
```

### <a name="get_tips_by_condition_and_input_values"></a>![Method: ](https://apidocs.io/img/method.png ".ResultController.getTipsByConditionAndInputValues") getTipsByConditionAndInputValues

> Computes and returns all tips that would be associated with the given condition, based on the given input values.


```javascript
function getTipsByConditionAndInputValues(conditionId, inputValues)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| conditionId |  ``` Optional ```  | The id of the sleep problem. |
| inputValues |  ``` Optional ```  | The sense input values. |



#### Example Usage

```javascript
var conditionId = 'conditionId';
var inputValues = {
    id : 21
};

SSA_ClientLib.ResultController.getTipsByConditionAndInputValues(conditionId, inputValues).then(function(result) {
    //TODO Business Logic
});
```



### <a name="get_tip_ids_by_condition_and_input_values"></a>![Method: ](https://apidocs.io/img/method.png ".ResultController.getTipIdsByConditionAndInputValues") getTipIdsByConditionAndInputValues

> Computes and returns the ids of all tips that would be associated with the given condition, based on the given input values.


```javascript
function getTipIdsByConditionAndInputValues(conditionId, inputValues)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| conditionId |  ``` Required ```  | The id of the sleep problem. |
| inputValues |  ``` Optional ```  | The sense input values. |



#### Example Usage

```javascript
var conditionId = 'conditionId';
var inputValues = {
    id : 21
};

SSA_ClientLib.ResultController.getTipIdsByConditionAndInputValues(conditionId, inputValues).then(function(result) {
    //TODO Business Logic
});
```



### <a name="get_tidbit_ids_by_condition"></a>![Method: ](https://apidocs.io/img/method.png ".ResultController.getTidbitIdsByCondition") getTidbitIdsByCondition

> Returns the ids of all tidbits that could be associated with the given condition.


```javascript
function getTidbitIdsByCondition(conditionId)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| conditionId |  ``` Required ```  | The id of the condition. |



#### Example Usage

```javascript
var conditionId = 'conditionId';

SSA_ClientLib.ResultController.getTidbitIdsByCondition(conditionId).then(function(result) {
    //TODO Business Logic
});
```



### <a name="get_tip_ids_by_condition"></a>![Method: ](https://apidocs.io/img/method.png ".ResultController.getTipIdsByCondition") getTipIdsByCondition

> Returns the ids of all tips that could be associated with the given condition.


```javascript
function getTipIdsByCondition(conditionId)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| conditionId |  ``` Required ```  | The id of the condition. |



#### Example Usage

```javascript
var conditionId = 'conditionId';

SSA_ClientLib.ResultController.getTipIdsByCondition(conditionId).then(function(result) {
    //TODO Business Logic
});
```



### <a name="get_condition"></a>![Method: ](https://apidocs.io/img/method.png ".ResultController.getCondition") getCondition

> Returns metadata information about an single condition.


```javascript
function getCondition(conditionId)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| conditionId |  ``` Required ```  | The id of the condition. |



#### Example Usage

```javascript
var conditionId = 'conditionId';

SSA_ClientLib.ResultController.getCondition(conditionId).then(function(result) {
    //TODO Business Logic
});
```



### <a name="submit_tip_feedback"></a>![Method: ](https://apidocs.io/img/method.png ".ResultController.submitTipFeedback") submitTipFeedback

> Submits feedback for the session on the indicated tip.


```javascript
function submitTipFeedback(requestDTO)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| requestDTO |  ``` Optional ```  | The request object. |



#### Example Usage

```javascript
var requestDTO = new UpdateTipFeedbackRequestDTO({"key":"value"});

SSA_ClientLib.ResultController.submitTipFeedback(requestDTO).then(function(result) {
    //TODO Business Logic
});
```



### <a name="get_all_conditions"></a>![Method: ](https://apidocs.io/img/method.png ".ResultController.getAllConditions") getAllConditions

> Returns metadata information about all available conditions.


```javascript
function getAllConditions()
```

#### Example Usage

```javascript
SSA_ClientLib.ResultController.getAllConditions().then(function(result) {
    //TODO Business Logic
});
```



### <a name="submit_condition_feedback"></a>![Method: ](https://apidocs.io/img/method.png ".ResultController.submitConditionFeedback") submitConditionFeedback

> Submits feedback for the session on the indicated condition.


```javascript
function submitConditionFeedback(requestDTO)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| requestDTO |  ``` Optional ```  | The request object. |



#### Example Usage

```javascript
var requestDTO = new UpdateConditionFeedbackRequestDTO({"key":"value"});

SSA_ClientLib.ResultController.submitConditionFeedback(requestDTO).then(function(result) {
    //TODO Business Logic
});
```



### <a name="compute_result"></a>![Method: ](https://apidocs.io/img/method.png ".ResultController.computeResult") computeResult

> Computes Results output for the given survey.


```javascript
function computeResult(surveyIdentifier, sessionId)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| surveyIdentifier |  ``` Required ```  | The identifier of the survey. |
| sessionId |  ``` Optional ```  | An auth token provided by the backend, for persisting state between calls. |



#### Example Usage

```javascript
var surveyIdentifier = 'surveyIdentifier';
var sessionId = null; 

SSA_ClientLib.ResultController.submitConditionFeedback(surveyIdentifier, sessionId).then(function(result) {
    //TODO Business Logic
});
```



[Back to List of Controllers](#list_of_controllers)

## <a name="session_controller"></a>![Class: ](https://apidocs.io/img/class.png ".SessionController") SessionController

### Get singleton instance

The singleton instance of the ``` SessionController ``` class can be accessed from the API Client.

```javascript
var SSA_ClientLib = lib(_config.clientid,_config.secretKey);
```

### <a name="activate_session"></a>![Method: ](https://apidocs.io/img/method.png ".SessionController.activateSession") activateSession

> Activates a session.


```javascript
function activateSession(sessionDTO)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| sessionDTO |  ``` Optional ```  | Object containing the session's credentials. |



#### Example Usage

```javascript
var sessionDTO = new SessionDTO({"key":"value"});

SSA_ClientLib.SessionController.activateSession(sessionDTO).then(function(result) {
    //TODO Business Logic
});
```



### <a name="retrieve_activated_session"></a>![Method: ](https://apidocs.io/img/method.png ".SessionController.retrieveActivatedSession") retrieveActivatedSession

> Retrieves the details of the activated session.


```javascript
function retrieveActivatedSession()
```

#### Example Usage

```javascript
SSA_ClientLib.SessionController.retrieveActivatedSession().then(function(result) {
    //TODO Business Logic
});
```



### <a name="deactivate_session"></a>![Method: ](https://apidocs.io/img/method.png ".SessionController.deactivateSession") deactivateSession

> Deactivates the current session.


```javascript
function deactivateSession()
```

#### Example Usage

```javascript
SSA_ClientLib.SessionController.deactivateSession().then(function(result) {
    //TODO Business Logic
});
```



### <a name="create_session"></a>![Method: ](https://apidocs.io/img/method.png ".SessionController.createSession") createSession

> Creates a new session with the provided information.


```javascript
function createSession(sessionDTO)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| sessionDTO |  ``` Optional ```  | The provided session information. |



#### Example Usage

```javascript
var sessionDTO = new SessionDTO({"key":"value"});

SSA_ClientLib.SessionController.createSession(sessionDTO).then(function(result) {
    //TODO Business Logic
});
```



[Back to List of Controllers](#list_of_controllers)

## <a name="survey_controller"></a>![Class: ](https://apidocs.io/img/class.png ".SurveyController") SurveyController

### Get singleton instance

The singleton instance of the ``` SurveyController ``` class can be accessed from the API Client.

```javascript
var SSA_ClientLib = lib(_config.clientid,_config.secretKey);
```

### <a name="reset_survey_state"></a>![Method: ](https://apidocs.io/img/method.png ".SurveyController.resetSurveyState") resetSurveyState

> Resets the state of the survey for the current session. In other words, all the session's answers are removed and the
> survey should start back at the beginning.


```javascript
function resetSurveyState(identifier)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |



#### Example Usage

```javascript
var identifier = 'identifier';

SSA_ClientLib.SurveyController.resetSurveyState(identifier).then(function(result) {
    //TODO Business Logic
});
```

### <a name="get_survey_state"></a>![Method: ](https://apidocs.io/img/method.png ".SurveyController.getSurveyState") getSurveyState

> Retrieves the state of a survey for the current session.


```javascript
function getSurveyState(identifier, sessionId)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |
| sessionId |  ``` Optional ```  | An auth token provided by the backend, for persisting state between calls. |



#### Example Usage

```javascript
var identifier = 'identifier';
var sessionId = null;

SSA_ClientLib.SurveyController.getSurveyState(identifier, sessionId).then(function(result) {
    //TODO Business Logic
});
```



### <a name="update_survey_state"></a>![Method: ](https://apidocs.io/img/method.png ".SurveyController.updateSurveyState") updateSurveyState

> Updates the state of a survey for the current session, and returns the portion of the survey state necessary for the 
client to render the survey based on the update.


```javascript
function updateSurveyState(identifier, requestDTO, sessionId)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |
| requestDTO |  ``` Optional ```  | The update request object. |
| sessionId |  ``` Optional ```  | An auth token provided by the backend, for persisting state between calls. |



#### Example Usage

```javascript
var identifier = 'identifier';
var requestDTO = new UpdateSurveyStateRequestDTO({"key":"value"});
var sessionId = null;

SSA_ClientLib.SurveyController.updateSurveyState(identifier, requestDTO, sessionId).then(function(result) {
    //TODO Business Logic
});
```

### <a name="get_sense_question"></a>![Method: ](https://apidocs.io/img/method.png ".SurveyController.getSenseQuestion") getSenseQuestion

> Get the QuestionDTO for a given sense, and for the given survey.


```javascript
function getSenseQuestion(identifier, senseId)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |
| senseId |  ``` Required ```  | The id of the sense we want a list of required QuestionDTO for. |



#### Example Usage

```javascript
var identifier = 'identifier';
var senseId = 'height';

SSA_ClientLib.SurveyController.getSenseQuestion(identifier, senseId).then(function(result) {
    //TODO Business Logic
});
```

### <a name="get_sense_required_questions"></a>![Method: ](https://apidocs.io/img/method.png ".SurveyController.getSenseRequiredQuestions") getSenseRequiredQuestions

> Get a list of required QuestionDTO items for a given sense, and for the given survey.


```javascript
function getSenseRequiredQuestions(identifier, senseId)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |
| senseId |  ``` Required ```  | The id of the sense we want a list of required QuestionDTO for. |



#### Example Usage

```javascript
var identifier = 'identifier';
var senseId = 'height';

SSA_ClientLib.SurveyController.getSenseRequiredQuestions(identifier, senseId).then(function(result) {
    //TODO Business Logic
});
```

### <a name="get_questions"></a>![Method: ](https://apidocs.io/img/method.png ".SurveyController.getQuestions") getQuestions

> Retrieves the current question set, per the current survey state, or per the given Step Id reference.
> Templates are also provided for immediately submitting via PostAnswers, or later submission via UpdateAnswers.
> 


```javascript
function getQuestions(identifier, stepRef, sessionId)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |
| stepRef |  ``` Optional ```  | Optional Step Id we wish to query QuestionDTOs for. Defaults to the latest step, if unspecified. |
| sessionId |  ``` Optional ```  | An auth token provided by the backend, for persisting state between calls. |



#### Example Usage

```javascript
var identifier = 'identifier';
var stepRef = null;
var sessionId = null;

SSA_ClientLib.SurveyController.getSenseRequiredQuestions(identifier, stepRef, sessionId).then(function(result) {
    //TODO Business Logic
});
```

### <a name="post_answers"></a>![Method: ](https://apidocs.io/img/method.png ".SurveyController.postAnswers") postAnswers

> Submits answers to the most recent, unanswered questions for the current survey session,
> and returns the next batch of unanswered survey questions if successful.


```javascript
function postAnswers(identifier, answers, sessionId)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |
| answers |  ``` Optional ```  | The answers for the most recent, unanswered questions available in the survey. |
| sessionId |  ``` Optional ```  | An auth token provided by the backend, for persisting state between calls. |



#### Example Usage

```javascript
var identifier = 'identifier';
var answers={'demographics1':true};
var sessionId = null;

SSA_ClientLib.SurveyController.postAnswers(identifier, answers, sessionId).then(function(result) {
    //TODO Business Logic
});
```

### <a name="update_answers"></a>![Method: ](https://apidocs.io/img/method.png ".SurveyController.updateAnswers") updateAnswers

> Re-submits answers to a potentially existing set of questions, from a previous step,
   and returns the next batch of unanswered survey questions if successful.
> This endpoint gracefully handles first-time submissions as well, similar to the simpler PostAnswers endpoint.


```javascript
function updateAnswers(identifier, updateSurveyStateRequestDTO, sessionId)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |
| updateSurveyStateRequestDTO |  ``` Required ```  | A DTO with the step ref, and answers to re-submit. |
| sessionId |  ``` Optional ```  | An auth token provided by the backend, for persisting state between calls. |



#### Example Usage

```javascript
var identifier = 'identifier';
var updateSurveyStateRequestDTO={
    'stepRef': 'demographics1',
    'answers': {
    'demographics1':true,
    }
};
var sessionId = null;

SSA_ClientLib.SurveyController.postAnswers(identifier, updateSurveyStateRequestDTO, sessionId).then(function(result) {
    //TODO Business Logic
});
```

### <a name="get_survey_state_summary"></a>![Method: ](https://apidocs.io/img/method.png ".SurveyController.getSurveyStateSummary") getSurveyStateSummary

> Retrieves the state of a survey for the current session.


```javascript
function getSurveyStateSummary(identifier, sessionId)
```
#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |
| sessionId |  ``` Optional ```  | An auth token provided by the backend, for persisting state between calls. |



#### Example Usage

```javascript
var identifier = 'identifier';
var sessionId = null;

SSA_ClientLib.SurveyController.getSurveyStateSummary(identifier, sessionId).then(function(result) {
    //TODO Business Logic
});
```


[Back to List of Controllers](#list_of_controllers)



