/**
  * @module smartsleep-analyzer
 */

'use strict';

const Configuration = require('./configuration');
const ScoringController = require('./Controllers/ScoringController');
const ResultController = require('./Controllers/ResultController');
const SessionController = require('./Controllers/SessionController');
const SurveyController = require('./Controllers/SurveyController');
const SessionDTO = require('./Models/SessionDTO');
const SectionStateDTO = require('./Models/SectionStateDTO');
const UpdateSurveyStateRequestDTO = require('./Models/UpdateSurveyStateRequestDTO');
const OptionDTO = require('./Models/OptionDTO');
const StepStateDTO = require('./Models/StepStateDTO');
const SenseDependencyDTO = require('./Models/SenseDependencyDTO');
const TipResult = require('./Models/TipResult');
const SurveyStateDTO = require('./Models/SurveyStateDTO');
const UpdateTipFeedbackRequestDTO = require('./Models/UpdateTipFeedbackRequestDTO');
const UpdateConditionFeedbackRequestDTO = require('./Models/UpdateConditionFeedbackRequestDTO');
const TidbitDTO = require('./Models/TidbitDTO');
const SenseDTO = require('./Models/SenseDTO');
const TipDTO = require('./Models/TipDTO');
const ResultDTO = require('./Models/ResultDTO');
const QuestionDTO = require('./Models/QuestionDTO');
const ConditionDTO = require('./Models/ConditionDTO');
const ConditionResult = require('./Models/ConditionResult');
const APIException = require('./Exceptions/APIException');
const AccessController = require('./Controllers/AccessController');

const initializer = {
  // controllers of smartsleep-analyzer
  ScoringController,
  ResultController,
  SessionController,
  SurveyController,
  AccessController,
  // models of smartsleep-analyzer
  SessionDTO,
  SectionStateDTO,
  UpdateSurveyStateRequestDTO,
  OptionDTO,
  StepStateDTO,
  SenseDependencyDTO,
  TipResult,
  SurveyStateDTO,
  UpdateTipFeedbackRequestDTO,
  UpdateConditionFeedbackRequestDTO,
  TidbitDTO,
  SenseDTO,
  TipDTO,
  ResultDTO,
  QuestionDTO,
  ConditionDTO,
  ConditionResult,
  // exceptions of smartsleep-analyzer
  APIException,
};

module.exports = (clientid, clientsecret, callback) => {
  // create empty callback if absent
  const _callback = typeof callback === 'function' ? callback : () => undefined;

  initializer;
  Configuration.secretkey = clientsecret;
  Configuration.clientid = clientid;


  AccessController.getAccessToken().then(function (result) {
    if (result.length == 0) {
      _callback(false);
    }
    else {
      Configuration.AccessToken = result;
      _callback(true);
    }
  });

  return initializer;
};
