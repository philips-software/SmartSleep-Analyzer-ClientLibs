'use strict';

const BaseModel = require('./BaseModel');

/**
 * Creates an instance of SenseDTO
 */
class SenseDTO extends BaseModel {
    /**
     * @constructor
     * @param   {Object}  obj    The object passed to constructor
     */
    constructor(obj) {
        super(obj);
        if (obj === undefined || obj === null) return;
        this.id = this.constructor.getValue(obj.id);
        this.type = this.constructor.getValue(obj.type);
        this.computed = this.constructor.getValue(obj.computed);
        this.sleepProblem = this.constructor.getValue(obj.sleepProblem);
        this.dependencies = this.constructor.getValue(obj.dependencies);
        this.questionText = this.constructor.getValue(obj.questionText);
        this.answerInfo = this.constructor.getValue(obj.answerInfo);
    }

    /**
     * Function containing information about the fields of this model
     * @return   {array}   Array of objects containing information about the fields
     */
    static mappingInfo() {
        return super.mappingInfo().concat([
            { name: 'id', realName: 'id' },
            { name: 'type', realName: 'type' },
            { name: 'computed', realName: 'computed' },
            { name: 'sleepProblem', realName: 'sleepProblem' },
            {
                name: 'dependencies',
                realName: 'dependencies',
                array: true,
                type: 'SenseDependencyDTO',
            },
            { name: 'questionText', realName: 'questionText' },
            { name: 'answerInfo', realName: 'answerInfo', type: 'AnswerInfoDTO' },
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

module.exports = SenseDTO;
