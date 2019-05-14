/**
 * SmartSleepAnalyzer
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */

'use strict';

const BaseModel = require('./BaseModel');

/**
 * Creates an instance of SurveyStateSummaryDTO
 */
class SurveyStateSummaryDTO extends BaseModel {
    /**
     * @constructor
     * @param   {Object}  obj    The object passed to constructor
     */
    constructor(obj) {
        super(obj);
        if (obj === undefined || obj === null) return;
        this.finished = this.constructor.getValue(obj.finished);
        this.currentSection = this.constructor.getValue(obj.currentSection);
        this.currentStep = this.constructor.getValue(obj.currentStep);
        this.stepsRemaining = this.constructor.getValue(obj.stepsRemaining);
        this.completedSections = this.constructor.getValue(obj.completedSections);
    }

    /**
     * Function containing information about the fields of this model
     * @return   {array}   Array of objects containing information about the fields
     */
    static mappingInfo() {
        return super.mappingInfo().concat([
            { name: 'finished', realName: 'finished' },
            { name: 'currentSection', realName: 'currentSection', type: 'SectionStateDTO' },
            { name: 'currentStep', realName: 'currentStep', type: 'StepStateDTO' },
            { name: 'stepsRemaining', realName: 'stepsRemaining' },
            { name: 'completedSections', realName: 'completedSections' },
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

module.exports = SurveyStateSummaryDTO;
