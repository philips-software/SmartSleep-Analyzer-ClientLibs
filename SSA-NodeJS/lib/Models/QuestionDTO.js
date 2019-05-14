'use strict';

const BaseModel = require('./BaseModel');

/**
 * Creates an instance of QuestionDTO
 */
class QuestionDTO extends BaseModel {
    /**
     * @constructor
     * @param   {Object}  obj    The object passed to constructor
     */
    constructor(obj) {
        super(obj);
        if (obj === undefined || obj === null) return;
        this.identifier = this.constructor.getValue(obj.identifier);
        this.text = this.constructor.getValue(obj.text);
        this.content = this.constructor.getValue(obj.content);
        this.type = this.constructor.getValue(obj.type);
        this.initialValue = this.constructor.getValue(obj.initialValue);
        this.min = this.constructor.getValue(obj.min);
        this.minValidationMessage = this.constructor.getValue(obj.minValidationMessage);
        this.max = this.constructor.getValue(obj.max);
        this.maxValidationMessage = this.constructor.getValue(obj.maxValidationMessage);
        this.formatValidationMessage = this.constructor.getValue(obj.formatValidationMessage);
        this.conversion = this.constructor.getValue(obj.conversion);
        this.unitsText = this.constructor.getValue(obj.unitsText);
        this.standalone = this.constructor.getValue(obj.standalone);
        this.options = this.constructor.getValue(obj.options);
        this.placeholder = this.constructor.getValue(obj.placeholder);
        this.optional = this.constructor.getValue(obj.optional);
        this.likertTextLow = this.constructor.getValue(obj.likertTextLow);
        this.likertTextHigh = this.constructor.getValue(obj.likertTextHigh);
    }

    /**
     * Function containing information about the fields of this model
     * @return   {array}   Array of objects containing information about the fields
     */
    static mappingInfo() {
        return super.mappingInfo().concat([
            { name: 'identifier', realName: 'identifier' },
            { name: 'text', realName: 'text' },
            { name: 'content', realName: 'content' },
            { name: 'type', realName: 'type' },
            { name: 'initialValue', realName: 'initialValue' },
            { name: 'min', realName: 'min' },
            { name: 'minValidationMessage', realName: 'minValidationMessage' },
            { name: 'max', realName: 'max' },
            { name: 'maxValidationMessage', realName: 'maxValidationMessage' },
            { name: 'formatValidationMessage', realName: 'formatValidationMessage' },
            { name: 'conversion', realName: 'conversion' },
            { name: 'unitsText', realName: 'unitsText' },
            { name: 'standalone', realName: 'standalone' },
            { name: 'options', realName: 'options', array: true, type: 'OptionDTO' },
            { name: 'placeholder', realName: 'placeholder' },
            { name: 'optional', realName: 'optional' },
            { name: 'likertTextLow', realName: 'likertTextLow' },
            { name: 'likertTextHigh', realName: 'likertTextHigh' },
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

module.exports = QuestionDTO;
