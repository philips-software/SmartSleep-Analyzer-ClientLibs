'use strict';

const BaseModel = require('./BaseModel');

/**
 * Creates an instance of SectionStateDTO
 */
class SectionStateDTO extends BaseModel {
    /**
     * @constructor
     * @param   {Object}  obj    The object passed to constructor
     */
    constructor(obj) {
        super(obj);
        if (obj === undefined || obj === null) return;
        this.identifier = this.constructor.getValue(obj.identifier);
        this.name = this.constructor.getValue(obj.name);
        this.stepsCompleted = this.constructor.getValue(obj.stepsCompleted);
        this.stepsRemaining = this.constructor.getValue(obj.stepsRemaining);
    }

    /**
     * Function containing information about the fields of this model
     * @return   {array}   Array of objects containing information about the fields
     */
    static mappingInfo() {
        return super.mappingInfo().concat([
            { name: 'identifier', realName: 'identifier' },
            { name: 'name', realName: 'name' },
            { name: 'stepsCompleted', realName: 'stepsCompleted' },
            { name: 'stepsRemaining', realName: 'stepsRemaining' },
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

module.exports = SectionStateDTO;
