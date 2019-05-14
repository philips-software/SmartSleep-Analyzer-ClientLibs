'use strict';

const BaseModel = require('./BaseModel');

/**
 * Creates an instance of SurveyStateDTO
 */
class SurveyStateDTO extends BaseModel {
    /**
     * @constructor
     * @param   {Object}  obj    The object passed to constructor
     */
    constructor(obj) {
        super(obj);
        if (obj === undefined || obj === null) return;
        this.sectionStates = this.constructor.getValue(obj.sectionStates);
        this.steps = this.constructor.getValue(obj.steps);
        this.currentStepRef = this.constructor.getValue(obj.currentStepRef);
        this.stepsRemaining = this.constructor.getValue(obj.stepsRemaining);
        this.finished = this.constructor.getValue(obj.finished);
        this.questions = this.constructor.getValue(obj.questions);
        this.answers = this.constructor.getValue(obj.answers);
        this.sessionId = this.constructor.getValue(obj.sessionId);
    }

    /**
     * Function containing information about the fields of this model
     * @return   {array}   Array of objects containing information about the fields
     */
    static mappingInfo() {
        return super.mappingInfo().concat([
            {
                name: 'sectionStates',
                realName: 'sectionStates',
                array: true,
                type: 'SectionStateDTO',
            },
            { name: 'steps', realName: 'steps', array: true, type: 'StepStateDTO' },
            { name: 'currentStepRef', realName: 'currentStepRef' },
            { name: 'stepsRemaining', realName: 'stepsRemaining' },
            { name: 'finished', realName: 'finished' },
            { name: 'questions', realName: 'questions', array: true, type: 'QuestionDTO' },
            { name: 'answers', realName: 'answers' },
            { name: 'sessionId', realName: 'sessionId' },
        ]);
    }

    /**
     * Function containing information about discriminator values
     * mapped with their corresponding model class names
     *
     * @return   {object}  Object containing Key-Value pairs mapping discriminator
     *                     values with their corresponding model classes
     */
    static discriminatorMap() {
        return {};
    }
}

module.exports = SurveyStateDTO;
