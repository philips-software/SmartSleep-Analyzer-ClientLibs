'use strict';

const BaseModel = require('./BaseModel');

/**
 * Creates an instance of SenseDependencyDTO
 */
class SenseDependencyDTO extends BaseModel {
    /**
     * @constructor
     * @param   {Object}  obj    The object passed to constructor
     */
    constructor(obj) {
        super(obj);
        if (obj === undefined || obj === null) return;
        this.senseId = this.constructor.getValue(obj.senseId);
        this.required = this.constructor.getValue(obj.required);
    }

    /**
     * Function containing information about the fields of this model
     * @return   {array}   Array of objects containing information about the fields
     */
    static mappingInfo() {
        return super.mappingInfo().concat([
            { name: 'senseId', realName: 'senseId' },
            { name: 'required', realName: 'required' },
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

module.exports = SenseDependencyDTO;
