const lib = require('../lib/index.js');
const expect = require('chai').expect;
const _config = require('./Configuration');
const _apiHelper = require('../lib/APIHelper');

let SSA_ClientLib = null
const defaultErrorMessage = '00000:Please verify the provided information is correct.';

describe('Result Controller Test Cases', function(){
  it('GetAllConditions Test case', function(done){
    SSA_ClientLib = lib(_config.clientid,_config.secretKey,function(success){
      SSA_ClientLib.ResultController.getAllConditions().then(function(result) {
        expect(result.length).to.equal(6);
        done();
      }).catch(done);
    })
  })

  it('GetCondition Test case', function(done){
    SSA_ClientLib.ResultController.getCondition('osa').then(function(result) {
      expect(result.tidbitIdentifiers.length).to.equal(2);
      done();
    }).catch(done);
  })

  it('GetCondition Invalid Test case', function(done){
    SSA_ClientLib.ResultController.getCondition('o11sa').then(function(result) {
      let errorMessage = _apiHelper.jsonDeserialize(result.errorMessage);
      expect(errorMessage.faultCode).to.equal("3113");
      done();
    }).catch(done);
  })

  it('ComputeResult Test case', function(done){
    // get a valid sessionId from getSurveyState first, then ensure computeResult returns "none" condition
    var sessionId = null;
    SSA_ClientLib.SurveyController.getSurveyState('sleep', null).then(function(result) {
      sessionId = result.sessionId;

      SSA_ClientLib.ResultController.computeResult('sleep', sessionId).then(function(result) {
        expect(result.conditions[0].identifier).to.equal('none');
        done();
      }).catch(done);
    }).catch(done);
  })

  // =============================
  // ==== Private API methods ====
  // =============================

  // var Tipsbycondition = {
  //   'identifier': 'Obstructive sleep apnea with snoring',
  //   'title': 'osa',
  //   'detail': null,
  //   'icon': null
  // }
  // it('GetTipsByConditionAndInputValues Test case', function(done){
  //   SSA_ClientLib.ResultController.getTipsByConditionAndInputValues('osa',Tipsbycondition).then(function(result) {
  //     expect(result[0]==null).to.equal(true);
  //     done();
  //   }).catch(done);
  // })
  //
  // it('GetTipsByConditionAndInputValues Invalid Test case', function(done){
  //   SSA_ClientLib.ResultController.getTipsByConditionAndInputValues('','').then(function(result) {
  //     expect(result.errorMessage).to.equal(defaultErrorMessage);
  //     done();
  //   }).catch(done);
  // })
  //
  // it('GetTipIdsByConditionAndInputValues Test case', function(done){
  //   SSA_ClientLib.ResultController.getTipIdsByConditionAndInputValues('osa',Tipsbycondition).then(function(result) {
  //     expect(result.length).to.equal(5);
  //     done();
  //   }).catch(done);
  // })
  //
  // var Invalid_Tipsbycondition = {
  //   'identifier': 'Obstructive sleep apnea with snoring',
  //   'title': 'osa',
  //   'detail': null,
  //   'icon': null
  // }
  //
  // it('GetTipIdsByConditionAndInputValues invalid Test case', function(done){
  //   SSA_ClientLib.ResultController.getTipIdsByConditionAndInputValues('o11sa',Invalid_Tipsbycondition).then(function(result) {
  //     expect(result.errorMessage).to.equal(defaultErrorMessage);
  //     done();
  //   }).catch(done);
  // })
  //
  // it('GetTidbitIdsByCondition Test case', function(done){
  //   SSA_ClientLib.ResultController.getTidbitIdsByCondition('osa').then(function(result) {
  //     expect(result.length).to.equal(2);
  //     done();
  //   }).catch(done);
  // })
  //
  // it('GetTidbitIdsByCondition Invalid Test case', function(done){
  //   SSA_ClientLib.ResultController.getTidbitIdsByCondition('o11sa').then(function(result) {
  //     expect(result.errorMessage).to.equal(defaultErrorMessage);
  //     done();
  //   }).catch(done);
  // })
  //
  // it('GetTipIdsByCondition Test case', function(done){
  //   SSA_ClientLib.ResultController.getTipIdsByCondition('osa').then(function(result) {
  //     expect(result.length).to.equal(5);
  //     done();
  //   }).catch(done);
  // })
  //
  // it('GetTipIdsByCondition Invalid Test case', function(done){
  //   SSA_ClientLib.ResultController.getTipIdsByCondition('o11sa').then(function(result) {
  //     expect(result.errorMessage).to.equal(defaultErrorMessage);
  //     done();
  //   }).catch(done);
  // })
});
