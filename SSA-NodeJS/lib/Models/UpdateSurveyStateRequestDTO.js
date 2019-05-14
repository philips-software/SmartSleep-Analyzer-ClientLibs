'use strict';

const BaseModel = require('./BaseModel');

/**
 * Creates an instance of UpdateSurveyStateRequestDTO
 */
class UpdateSurveyStateRequestDTO extends BaseModel {
    /**
     * @constructor
     * @param   {Object}  obj    The object passed to constructor
     */
    constructor(obj) {
        super(obj);
        if (obj === undefined || obj === null) return;
        this.stepRef = this.constructor.getValue(obj.stepRef);
        this.answers = this.constructor.getValue(obj.answers);
    }

    /**
     * Function containing information about the fields of this model
     * @return   {array}   Array of objects containing information about the fields
     */
    static mappingInfo() {
        return super.mappingInfo().concat([
            { name: 'stepRef', realName: 'stepRef' },
            { name: 'answers', realName: 'answers' },
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

module.exports = UpdateSurveyStateRequestDTO;
