'use strict';

const BaseModel = require('./BaseModel');

/**
 * Creates an instance of StepStateDTO
 */
class StepStateDTO extends BaseModel {
    /**
     * @constructor
     * @param   {Object}  obj    The object passed to constructor
     */
    constructor(obj) {
        super(obj);
        if (obj === undefined || obj === null) return;
        this.identifier = this.constructor.getValue(obj.identifier);
        this.sectionRef = this.constructor.getValue(obj.sectionRef);
        this.questionRefs = this.constructor.getValue(obj.questionRefs);
        this.heading = this.constructor.getValue(obj.heading);
    }

    /**
     * Function containing information about the fields of this model
     * @return   {array}   Array of objects containing information about the fields
     */
    static mappingInfo() {
        return super.mappingInfo().concat([
            { name: 'identifier', realName: 'identifier' },
            { name: 'sectionRef', realName: 'sectionRef' },
            { name: 'questionRefs', realName: 'questionRefs', array: true },
            { name: 'heading', realName: 'heading' },
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

module.exports = StepStateDTO;
