'use strict';

const BaseModel = require('./BaseModel');

/**
 * Creates an instance of UpdateTipFeedbackRequestDTO
 */
class UpdateTipFeedbackRequestDTO extends BaseModel {
    /**
     * @constructor
     * @param   {Object}  obj    The object passed to constructor
     */
    constructor(obj) {
        super(obj);
        if (obj === undefined || obj === null) return;
        this.tipIdentifier = this.constructor.getValue(obj.tipIdentifier);
        this.answer = this.constructor.getValue(obj.answer);
    }

    /**
     * Function containing information about the fields of this model
     * @return   {array}   Array of objects containing information about the fields
     */
    static mappingInfo() {
        return super.mappingInfo().concat([
            { name: 'tipIdentifier', realName: 'tipIdentifier' },
            { name: 'answer', realName: 'answer' },
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

module.exports = UpdateTipFeedbackRequestDTO;
