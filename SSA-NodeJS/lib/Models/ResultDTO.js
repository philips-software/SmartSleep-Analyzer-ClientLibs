'use strict';

const BaseModel = require('./BaseModel');

/**
 * Creates an instance of ResultDTO
 */
class ResultDTO extends BaseModel {
    /**
     * @constructor
     * @param   {Object}  obj    The object passed to constructor
     */
    constructor(obj) {
        super(obj);
        if (obj === undefined || obj === null) return;
        this.conditions = this.constructor.getValue(obj.conditions);
        this.tips = this.constructor.getValue(obj.tips);
        this.tidbits = this.constructor.getValue(obj.tidbits);
        this.products = this.constructor.getValue(obj.products);
        this.calculations = this.constructor.getValue(obj.calculations);
        this.senseValues = this.constructor.getValue(obj.senseValues);
        this.sessionId = this.constructor.getValue(obj.sessionId);
    }

    /**
     * Function containing information about the fields of this model
     * @return   {array}   Array of objects containing information about the fields
     */
    static mappingInfo() {
        return super.mappingInfo().concat([
            { name: 'conditions', realName: 'conditions', array: true, type: 'ConditionDTO' },
            { name: 'tips', realName: 'tips', array: true, type: 'TipDTO' },
            { name: 'tidbits', realName: 'tidbits', array: true, type: 'TidbitDTO' },
            { name: 'products', realName: 'products', array: true, type: 'ProductDTO' },
            { name: 'calculations', realName: 'calculations' },
            { name: 'senseValues', realName: 'senseValues' },
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

module.exports = ResultDTO;
