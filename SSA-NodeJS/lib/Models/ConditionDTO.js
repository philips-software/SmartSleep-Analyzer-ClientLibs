'use strict';

const BaseModel = require('./BaseModel');

/**
 * Creates an instance of ConditionDTO
 */
class ConditionDTO extends BaseModel {
    /**
     * @constructor
     * @param   {Object}  obj    The object passed to constructor
     */
    constructor(obj) {
        super(obj);
        if (obj === undefined || obj === null) return;
        this.identifier = this.constructor.getValue(obj.identifier);
        this.title = this.constructor.getValue(obj.title);
        this.riskRating = this.constructor.getValue(obj.riskRating);
        this.diagnosis = this.constructor.getValue(obj.diagnosis);
        this.explanation = this.constructor.getValue(obj.explanation);
        this.description = this.constructor.getValue(obj.description);
        this.living = this.constructor.getValue(obj.living);
        this.videoLiving = this.constructor.getValue(obj.videoLiving);
        this.iconAbout = this.constructor.getValue(obj.iconAbout);
        this.iconRisks = this.constructor.getValue(obj.iconRisks);
        this.iconWhatYouCanDo = this.constructor.getValue(obj.iconWhatYouCanDo);
        this.videoWhatYouCanDo = this.constructor.getValue(obj.videoWhatYouCanDo);
        this.recommendation = this.constructor.getValue(obj.recommendation);
        this.risksHeader = this.constructor.getValue(obj.risksHeader);
        this.risks = this.constructor.getValue(obj.risks);
        this.benefitsHeader = this.constructor.getValue(obj.benefitsHeader);
        this.benefits = this.constructor.getValue(obj.benefits);
        this.tipIdentifiers = this.constructor.getValue(obj.tipIdentifiers);
        this.tidbitIdentifiers = this.constructor.getValue(obj.tidbitIdentifiers);
        this.whileWaiting = this.constructor.getValue(obj.whileWaiting);
        this.conditionFeedback = this.constructor.getValue(obj.conditionFeedback);
    }

    /**
     * Function containing information about the fields of this model
     * @return   {array}   Array of objects containing information about the fields
     */
    static mappingInfo() {
        return super.mappingInfo().concat([
            { name: 'identifier', realName: 'identifier' },
            { name: 'title', realName: 'title' },
            { name: 'riskRating', realName: 'riskRating' },
            { name: 'diagnosis', realName: 'diagnosis' },
            { name: 'explanation', realName: 'explanation' },
            { name: 'description', realName: 'description' },
            { name: 'living', realName: 'living' },
            { name: 'videoLiving', realName: 'videoLiving' },
            { name: 'iconAbout', realName: 'iconAbout' },
            { name: 'iconRisks', realName: 'iconRisks' },
            { name: 'iconWhatYouCanDo', realName: 'iconWhatYouCanDo' },
            { name: 'videoWhatYouCanDo', realName: 'videoWhatYouCanDo' },
            { name: 'recommendation', realName: 'recommendation' },
            { name: 'risksHeader', realName: 'risksHeader' },
            { name: 'risks', realName: 'risks', array: true },
            { name: 'benefitsHeader', realName: 'benefitsHeader' },
            { name: 'benefits', realName: 'benefits', array: true },
            { name: 'tipIdentifiers', realName: 'tipIdentifiers', array: true },
            { name: 'tidbitIdentifiers', realName: 'tidbitIdentifiers', array: true },
            { name: 'whileWaiting', realName: 'whileWaiting' },
            { name: 'conditionFeedback', realName: 'conditionFeedback' },
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

module.exports = ConditionDTO;
