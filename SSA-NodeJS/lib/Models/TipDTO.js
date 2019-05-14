'use strict';

const BaseModel = require('./BaseModel');

/**
 * Creates an instance of TipDTO
 */
class TipDTO extends BaseModel {
    /**
     * @constructor
     * @param   {Object}  obj    The object passed to constructor
     */
    constructor(obj) {
        super(obj);
        if (obj === undefined || obj === null) return;
        this.identifier = this.constructor.getValue(obj.identifier);
        this.title = this.constructor.getValue(obj.title);
        this.detail = this.constructor.getValue(obj.detail);
        this.icon = this.constructor.getValue(obj.icon);
        this.tipFeedback = this.constructor.getValue(obj.tipFeedback);
    }

    /**
     * Function containing information about the fields of this model
     * @return   {array}   Array of objects containing information about the fields
     */
    static mappingInfo() {
        return super.mappingInfo().concat([
            { name: 'identifier', realName: 'identifier' },
            { name: 'title', realName: 'title' },
            { name: 'detail', realName: 'detail' },
            { name: 'icon', realName: 'icon' },
            { name: 'tipFeedback', realName: 'tipFeedback' },
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

module.exports = TipDTO;
