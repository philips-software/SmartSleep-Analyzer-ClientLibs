'use strict';

const AnswerInfoDTO = require('../lib/Models/AnswerInfoDTO');
const QuestionsDTO = require('../lib/Models/QuestionsDTO');
const SurveyStateSummaryDTO = require('../lib/Models/SurveyStateSummaryDTO');
const SessionDTO = require('../lib/Models/SessionDTO');
const SectionStateDTO = require('../lib/Models/SectionStateDTO');
const UpdateSurveyStateRequestDTO = require('../lib/Models/UpdateSurveyStateRequestDTO');
const OptionDTO = require('../lib/Models/OptionDTO');
const StepStateDTO = require('../lib/Models/StepStateDTO');
const SenseDependencyDTO = require('../lib/Models/SenseDependencyDTO');
const TipResult = require('../lib/Models/TipResult');
const SurveyStateDTO = require('../lib/Models/SurveyStateDTO');
const UpdateTipFeedbackRequestDTO = require('../lib/Models/UpdateTipFeedbackRequestDTO');
const UpdateConditionFeedbackRequestDTO = require('../lib/Models/UpdateConditionFeedbackRequestDTO');
const TidbitDTO = require('../lib/Models/TidbitDTO');
const SenseDTO = require('../lib/Models/SenseDTO');
const TipDTO = require('../lib/Models/TipDTO');
const ResultDTO = require('../lib/Models/ResultDTO');
const QuestionDTO = require('../lib/Models/QuestionDTO');
const ConditionDTO = require('../lib/Models/ConditionDTO');
const ConditionResult = require('../lib/Models/ConditionResult');

const classMap = {
    AnswerInfoDTO,
    QuestionsDTO,
    SurveyStateSummaryDTO,
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
};

/**
 * Factory class to create instances of models and exception classes
 */
class ModelFactory {
    /**
     * Creates instance of a model class
     * @param  modelName  {string}  Name of class to instantiate
     * @returns  {object} Instance of the model class
     */
    static getInstance(modelName) {
        return new classMap[modelName]();
    }
}

module.exports = ModelFactory;
