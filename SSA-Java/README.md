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

### <a name="get_required_question_senses_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.getRequiredQuestionSensesAsync") getRequiredQuestionSensesAsync

> Returns all question senses required to compute the target sense.


```java
void getRequiredQuestionSensesAsync(
        final String targetSenseId,
        final String locale,
        final APICallBack<List<SenseDTO>> callBack)
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
scoring.getRequiredQuestionSensesAsync(targetSenseId, locale, new APICallBack<List<SenseDTO>>() {
    public void onSuccess(HttpContext context, List<SenseDTO> response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="create_get_computable_sleep_problem_senses_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.createGetComputableSleepProblemSensesAsync") createGetComputableSleepProblemSensesAsync

> Returns all sleep problem senses which can be computed from the given input sense ids.


```java
void createGetComputableSleepProblemSensesAsync(
        final List<String> senseIds,
        final APICallBack<List<SenseDTO>> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| senseIds |  ``` Optional ```  ``` Collection ```  | List of ids for all input senses that would be provided. |


#### Example Usage

```java
try {
    List<String> senseIds = new LinkedList<String>(Arrays.asList("senseIds"));
    // Invoking the API call with sample inputs
    scoring.createGetComputableSleepProblemSensesAsync(senseIds, new APICallBack<List<SenseDTO>>() {
        public void onSuccess(HttpContext context, List<SenseDTO> response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="create_get_computable_senses_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.createGetComputableSensesAsync") createGetComputableSensesAsync

> Returns all senses which can be computed from the given input sense ids.


```java
void createGetComputableSensesAsync(
        final List<String> senseIds,
        final APICallBack<List<SenseDTO>> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| senseIds |  ``` Optional ```  ``` Collection ```  | List of ids for all input senses that would be provided. |


#### Example Usage

```java
try {
    List<String> senseIds = new LinkedList<String>(Arrays.asList("senseIds"));
    // Invoking the API call with sample inputs
    scoring.createGetComputableSensesAsync(senseIds, new APICallBack<List<SenseDTO>>() {
        public void onSuccess(HttpContext context, List<SenseDTO> response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="get_computed_senses_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.getComputedSensesAsync") getComputedSensesAsync

> Returns metadata information about all computed senses. Computed senses are derived from other senses and should
> 
> not be asked directly to an end-user.


```java
void getComputedSensesAsync(final APICallBack<List<SenseDTO>> callBack)
```

#### Example Usage

```java
// Invoking the API call with sample inputs
scoring.getComputedSensesAsync(new APICallBack<List<SenseDTO>>() {
    public void onSuccess(HttpContext context, List<SenseDTO> response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="get_sleep_problem_senses_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.getSleepProblemSensesAsync") getSleepProblemSensesAsync

> Returns metadata information about all sleep problem senses.


```java
void getSleepProblemSensesAsync(final APICallBack<List<SenseDTO>> callBack)
```

#### Example Usage

```java
// Invoking the API call with sample inputs
scoring.getSleepProblemSensesAsync(new APICallBack<List<SenseDTO>>() {
    public void onSuccess(HttpContext context, List<SenseDTO> response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="get_question_senses_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.getQuestionSensesAsync") getQuestionSensesAsync

> Returns metadata information about all question senses. Question senses are simple value senses which can be asked
> 
> to an end-user in the form of a question.


```java
void getQuestionSensesAsync(
        final String locale,
        final APICallBack<List<SenseDTO>> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| locale |  ``` Optional ```  ``` DefaultValue ```  | Optional query param locale used to localize question sense text. |


#### Example Usage

```java
String locale = "en-US";
// Invoking the API call with sample inputs
scoring.getQuestionSensesAsync(locale, new APICallBack<List<SenseDTO>>() {
    public void onSuccess(HttpContext context, List<SenseDTO> response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="get_all_senses_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.getAllSensesAsync") getAllSensesAsync

> Returns metadata information about all available senses.


```java
void getAllSensesAsync(
        final String locale,
        final APICallBack<List<SenseDTO>> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| locale |  ``` Optional ```  ``` DefaultValue ```  | Optional query param locale used to localize question sense text. |


#### Example Usage

```java
String locale = "en-US";
// Invoking the API call with sample inputs
scoring.getAllSensesAsync(locale, new APICallBack<List<SenseDTO>>() {
    public void onSuccess(HttpContext context, List<SenseDTO> response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="get_sense_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.getSenseAsync") getSenseAsync

> Returns metadata information about a single sense.


```java
void getSenseAsync(
        final String senseId,
        final String locale,
        final APICallBack<SenseDTO> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| senseId |  ``` Required ```  | The id of the sense. |
| locale |  ``` Optional ```  ``` DefaultValue ```  | Optional query param locale used to localize question sense text. |


#### Example Usage

```java
String senseId = "senseId";
String locale = "en-US";
// Invoking the API call with sample inputs
scoring.getSenseAsync(senseId, locale, new APICallBack<SenseDTO>() {
    public void onSuccess(HttpContext context, SenseDTO response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="create_compute_intermediate_and_sleep_problem_senses_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.createComputeIntermediateAndSleepProblemSensesAsync") createComputeIntermediateAndSleepProblemSensesAsync

> Computes the values of all possible intermediate and sleep problem senses based on the provided input values.


```java
void createComputeIntermediateAndSleepProblemSensesAsync(
        final Object inputValues,
        final APICallBack<LinkedHashMap<String, Object>> callBack)
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
    scoring.createComputeIntermediateAndSleepProblemSensesAsync(inputValues, new APICallBack<LinkedHashMap<String, Object>>() {
        public void onSuccess(HttpContext context, LinkedHashMap<String, Object> response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="create_compute_sleep_problem_senses_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.createComputeSleepProblemSensesAsync") createComputeSleepProblemSensesAsync

> Computes the values of all possible sleep problem senses based on the provided input values.


```java
void createComputeSleepProblemSensesAsync(
        final Object inputValues,
        final APICallBack<LinkedHashMap<String, Object>> callBack)
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
    scoring.createComputeSleepProblemSensesAsync(inputValues, new APICallBack<LinkedHashMap<String, Object>>() {
        public void onSuccess(HttpContext context, LinkedHashMap<String, Object> response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="create_compute_sense_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.createComputeSenseAsync") createComputeSenseAsync

> Computes the value of a single sense based on the provided input values.


```java
void createComputeSenseAsync(
        final String senseId,
        final Object inputValues,
        final APICallBack<LinkedHashMap<String, Object>> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| senseId |  ``` Required ```  | Id of the sense to compute. |
| inputValues |  ``` Optional ```  | Map of sense input values, keyed by sense id. |


#### Example Usage

```java
try {
    String senseId = "senseId";
    Object inputValues = new Object();
    // Invoking the API call with sample inputs
    scoring.createComputeSenseAsync(senseId, inputValues, new APICallBack<LinkedHashMap<String, Object>>() {
        public void onSuccess(HttpContext context, LinkedHashMap<String, Object> response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="create_compute_all_senses_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ScoringController.createComputeAllSensesAsync") createComputeAllSensesAsync

> Computes the values of all possible senses based on the provided input values.


```java
void createComputeAllSensesAsync(
        final Object inputValues,
        final APICallBack<LinkedHashMap<String, Object>> callBack)
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
    scoring.createComputeAllSensesAsync(inputValues, new APICallBack<LinkedHashMap<String, Object>>() {
        public void onSuccess(HttpContext context, LinkedHashMap<String, Object> response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
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

### <a name="create_get_tips_by_condition_and_input_values_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ResultController.createGetTipsByConditionAndInputValuesAsync") createGetTipsByConditionAndInputValuesAsync

> Computes and returns all tips that would be associated with the given condition, based on the given input values.


```java
void createGetTipsByConditionAndInputValuesAsync(
        final String conditionId,
        final Object inputValues,
        final APICallBack<List<TipResult>> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| conditionId |  ``` Optional ```  | The id of the sleep problem. |
| inputValues |  ``` Optional ```  | The sense input values. |


#### Example Usage

```java
try {
    String conditionId = "conditionId";
    Object inputValues = new Object();
    // Invoking the API call with sample inputs
    result.createGetTipsByConditionAndInputValuesAsync(conditionId, inputValues, new APICallBack<List<TipResult>>() {
        public void onSuccess(HttpContext context, List<TipResult> response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="create_get_tip_ids_by_condition_and_input_values_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ResultController.createGetTipIdsByConditionAndInputValuesAsync") createGetTipIdsByConditionAndInputValuesAsync

> Computes and returns the ids of all tips that would be associated with the given condition, based on the given
> 
> input values.


```java
void createGetTipIdsByConditionAndInputValuesAsync(
        final String conditionId,
        final Object inputValues,
        final APICallBack<List<String>> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| conditionId |  ``` Required ```  | The id of the sleep problem. |
| inputValues |  ``` Optional ```  | The sense input values. |


#### Example Usage

```java
try {
    String conditionId = "conditionId";
    Object inputValues = new Object();
    // Invoking the API call with sample inputs
    result.createGetTipIdsByConditionAndInputValuesAsync(conditionId, inputValues, new APICallBack<List<String>>() {
        public void onSuccess(HttpContext context, List<String> response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="create_get_tidbit_ids_by_condition_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ResultController.createGetTidbitIdsByConditionAsync") createGetTidbitIdsByConditionAsync

> Returns the ids of all tidbits that could be associated with the given condition.


```java
void createGetTidbitIdsByConditionAsync(
        final String conditionId,
        final APICallBack<List<String>> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| conditionId |  ``` Required ```  | The id of the condition. |


#### Example Usage

```java
String conditionId = "conditionId";
// Invoking the API call with sample inputs
result.createGetTidbitIdsByConditionAsync(conditionId, new APICallBack<List<String>>() {
    public void onSuccess(HttpContext context, List<String> response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="create_get_tip_ids_by_condition_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ResultController.createGetTipIdsByConditionAsync") createGetTipIdsByConditionAsync

> Returns the ids of all tips that could be associated with the given condition.


```java
void createGetTipIdsByConditionAsync(
        final String conditionId,
        final APICallBack<List<String>> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| conditionId |  ``` Required ```  | The id of the condition. |


#### Example Usage

```java
String conditionId = "conditionId";
// Invoking the API call with sample inputs
result.createGetTipIdsByConditionAsync(conditionId, new APICallBack<List<String>>() {
    public void onSuccess(HttpContext context, List<String> response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="create_get_condition_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ResultController.createGetConditionAsync") createGetConditionAsync

> Returns metadata information about an single condition.


```java
void createGetConditionAsync(
        final String conditionId,
        final APICallBack<ConditionResult> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| conditionId |  ``` Required ```  | The id of the condition. |


#### Example Usage

```java
String conditionId = "conditionId";
// Invoking the API call with sample inputs
result.createGetConditionAsync(conditionId, new APICallBack<ConditionResult>() {
    public void onSuccess(HttpContext context, ConditionResult response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="create_submit_tip_feedback_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ResultController.createSubmitTipFeedbackAsync") createSubmitTipFeedbackAsync

> Submits feedback for an end-user on the indicated tip.


```java
void createSubmitTipFeedbackAsync(
        final UpdateTipFeedbackRequestDTO requestDTO,
        final APICallBack<Object> callBack)
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
    result.createSubmitTipFeedbackAsync(requestDTO, new APICallBack<void>() {
        public void onSuccess(HttpContext context, void response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="get_all_conditions_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ResultController.getAllConditionsAsync") getAllConditionsAsync

> Returns metadata information about all available conditions.


```java
void getAllConditionsAsync(final APICallBack<List<ConditionResult>> callBack)
```

#### Example Usage

```java
// Invoking the API call with sample inputs
result.getAllConditionsAsync(new APICallBack<List<ConditionResult>>() {
    public void onSuccess(HttpContext context, List<ConditionResult> response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="create_submit_condition_feedback_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ResultController.createSubmitConditionFeedbackAsync") createSubmitConditionFeedbackAsync

> Submits feedback for an end-user on the indicated condition.


```java
void createSubmitConditionFeedbackAsync(
        final UpdateConditionFeedbackRequestDTO requestDTO,
        final APICallBack<Object> callBack)
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
    result.createSubmitConditionFeedbackAsync(requestDTO, new APICallBack<void>() {
        public void onSuccess(HttpContext context, void response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="get_compute_result_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.ResultController.getComputeResultAsync") getComputeResultAsync

> Computes Results output for the given survey.


```java
void getComputeResultAsync(
        final String surveyIdentifier,
        final APICallBack<ResultDTO> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| surveyIdentifier |  ``` Required ```  | The identifier of the survey. |


#### Example Usage

```java
String surveyIdentifier = "surveyIdentifier";
// Invoking the API call with sample inputs
result.getComputeResultAsync(surveyIdentifier, new APICallBack<ResultDTO>() {
    public void onSuccess(HttpContext context, ResultDTO response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


[Back to List of Controllers](#list_of_controllers)

## <a name="session_controller"></a>![Class: ](https://apidocs.io/img/class.png "com.philips.ai.controllers.SessionController") SessionController

### Get singleton instance

The singleton instance of the ``` SessionController ``` class can be accessed from the API Client.

```java
SessionController session = client.getSession();
```

### <a name="create_login_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SessionController.createLoginAsync") createLoginAsync

> Activates a session.


```java
void createSessionAsync(
        final SessionDTO sessionDTO,
        final APICallBack<SessionDTO> callBack)
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
    session.createLoginAsync(sessionDTO, new APICallBack<SessionDTO>() {
        public void onSuccess(HttpContext context, SessionDTO response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="retrieve_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SessionController.retrieveAsync") retrieveAsync

> Retrieves the details of the activated session.


```java
void retrieveAsync(final APICallBack<SessionDTO> callBack)
```

#### Example Usage

```java
// Invoking the API call with sample inputs
session.retrieveAsync(new APICallBack<SessionDTO>() {
    public void onSuccess(HttpContext context, SessionDTO response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="get_logout_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SessionController.getLogoutAsync") getLogoutAsync

> Deactivates the current session.


```java
void getLogoutAsync(final APICallBack<Object> callBack)
```

#### Example Usage

```java
// Invoking the API call with sample inputs
session.getLogoutAsync(new APICallBack<void>() {
    public void onSuccess(HttpContext context, void response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="create_activate_session_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SessionController.createRegisterUserAsync") createRegisterUserAsync

> Creates a new session with the provided information.


```java
void createRegisterUserAsync(
        final SessionDTO sessionDTO,
        final APICallBack<SessionDTO> callBack)
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
    session.createRegisterUserAsync(sessionDTO, new APICallBack<SessionDTO>() {
        public void onSuccess(HttpContext context, SessionDTO response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
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

### <a name="get_matched_rules_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SurveyController.getMatchedRulesAsync") getMatchedRulesAsync

> DEVELOPMENT ONLY: Returns all rules which were matched in the computation of the session's survey state. This API is
> 
> only available in development environment. In all other environments it will result in a 404 (not found).


```java
void getMatchedRulesAsync(
        final String identifier,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |


#### Example Usage

```java
String identifier = "identifier";
// Invoking the API call with sample inputs
survey.getMatchedRulesAsync(identifier, new APICallBack<void>() {
    public void onSuccess(HttpContext context, void response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="post_survey_answers_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SurveyController.postSurveyAnswersAsync") postSurveyAnswersAsync

> DEVELOPMENT ONLY: Updates all answers stored for a session for a survey to the given set of answers. This API is only
> 
> available in
> 
> development environment. In all other environments it will result in a 404 (not found). Returns all updated
> 
> answers.


```java
void postSurveyAnswersAsync(
        final String identifier,
        final Object answers,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |
| answers |  ``` Optional ```  | The answer values to apply. Answers are keyed by question identifier. |


#### Example Usage

```java
try {
    String identifier = "identifier";
    Object answers = new Object();
    // Invoking the API call with sample inputs
    survey.postSurveyAnswersAsync(identifier, answers, new APICallBack<void>() {
        public void onSuccess(HttpContext context, void response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


### <a name="get_sense_input_values_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SurveyController.getSenseInputValuesAsync") getSenseInputValuesAsync

> DEVELOPMENT ONLY: Similar to the GET /answers API, but instead returns answers mapped to their corresponding sense
> 
> values. This API is only available in development environment. In all other environments it will result in a 404
> 
> (not found).


```java
void getSenseInputValuesAsync(
        final String identifier,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |


#### Example Usage

```java
String identifier = "identifier";
// Invoking the API call with sample inputs
survey.getSenseInputValuesAsync(identifier, new APICallBack<void>() {
    public void onSuccess(HttpContext context, void response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="create_reset_survey_state_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SurveyController.createResetSurveyStateAsync") createResetSurveyStateAsync

> Resets the state of the survey for the current session. In other words, all the session's answers are removed and the
> 
> survey should start back at the beginning.


```java
void createResetSurveyStateAsync(
        final String identifier,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |


#### Example Usage

```java
String identifier = "identifier";
// Invoking the API call with sample inputs
survey.createResetSurveyStateAsync(identifier, new APICallBack<void>() {
    public void onSuccess(HttpContext context, void response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="get_survey_answers_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SurveyController.getSurveyAnswersAsync") getSurveyAnswersAsync

> DEVELOPMENT ONLY: Gets all answers stored for a session for a given survey. This API is only available in development
> 
> environment. In
> 
> all other environments it will result in a 404 (not found).


```java
void getSurveyAnswersAsync(
        final String identifier,
        final APICallBack<Object> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |


#### Example Usage

```java
String identifier = "identifier";
// Invoking the API call with sample inputs
survey.getSurveyAnswersAsync(identifier, new APICallBack<void>() {
    public void onSuccess(HttpContext context, void response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="get_survey_state_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SurveyController.getSurveyStateAsync") getSurveyStateAsync

> Retrieves the state of a survey for the current session.


```java
void getSurveyStateAsync(
        final String identifier,
        final APICallBack<SurveyStateDTO> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |


#### Example Usage

```java
String identifier = "identifier";
// Invoking the API call with sample inputs
survey.getSurveyStateAsync(identifier, new APICallBack<SurveyStateDTO>() {
    public void onSuccess(HttpContext context, SurveyStateDTO response) {
        // TODO success callback handler
    }
    public void onFailure(HttpContext context, Throwable error) {
        // TODO failure callback handler
    }
});

```


### <a name="update_survey_state_async"></a>![Method: ](https://apidocs.io/img/method.png "com.philips.ai.controllers.SurveyController.updateSurveyStateAsync") updateSurveyStateAsync

> Updates the state of a survey for the current session, and returns the portion of the survey state necessary for the
> 
> client to render the survey based on the update.


```java
void updateSurveyStateAsync(
        final String identifier,
        final UpdateSurveyStateRequestDTO requestDTO,
        final APICallBack<SurveyStateDTO> callBack)
```

#### Parameters

| Parameter | Tags | Description |
|-----------|------|-------------|
| identifier |  ``` Required ```  | The identifier of the survey. |
| requestDTO |  ``` Optional ```  | The update request object. |


#### Example Usage

```java
try {
    String identifier = "identifier";
    UpdateSurveyStateRequestDTO requestDTO = new UpdateSurveyStateRequestDTO();
    // Invoking the API call with sample inputs
    survey.updateSurveyStateAsync(identifier, requestDTO, new APICallBack<SurveyStateDTO>() {
        public void onSuccess(HttpContext context, SurveyStateDTO response) {
            // TODO success callback handler
        }
        public void onFailure(HttpContext context, Throwable error) {
            // TODO failure callback handler
        }
    });
} catch(JsonProcessingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
```


[Back to List of Controllers](#list_of_controllers)



