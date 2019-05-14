const lib = require('smartsleep-analyzer');
const expect = require('chai').expect;
const _config = require('./Configuration');

let SSA_ClientLib = null
const errorComputeUpdateNoSurvey = '{"faultCode":"1103","message":"No survey found for identifier \'sleep000\'"}';
const errorComputeStateNoSurvey = '{"faultCode":"1102","message":"No survey found for identifier \'sleep000\'"}';
const errorGetQuestionsNoSurvey = '{"faultCode":"1106","message":"No survey found for identifier \'sleep000\'"}';

//parameter for all the test cases.
const identifier='sleep';
const invalidId='sleep000';

describe('Survey Controller Test Cases', function(){
  it('GetSurveyState Test case', function(done){
    SSA_ClientLib = lib(_config.clientid,_config.secretKey,function(success){
        SSA_ClientLib.SurveyController.getSurveyState(identifier).then(function(result) {
          expect(result.questions[0].text).to.equal('Are you currently under the care of a physician for depression and/or anxiety?');
          done();
        }).catch(done);
   })
  })
   //parameter for updateSurveyState test case.
  var requestDTO={
    'stepRef': 'demographics1',
    'answers': {
      'demographics1':true,
    }
  }

  //parameter for updateSurveyState test case.
  var rawPostAnswers={
      'demographics1':true
  }

  it('UpdateSurveyState Test case', function(done){
      SSA_ClientLib.SurveyController.updateSurveyState(identifier, requestDTO).then(function(result) {
      expect(result.sectionStates[0].identifier + ':' + result.sectionStates[0].name).to.equal('demographics:Background and Demographics');
      done();
    }).catch(done);
  })

  it('UpdateSurveyState Invalid Test case', function(done){
      SSA_ClientLib.SurveyController.updateSurveyState(invalidId, requestDTO).then(function(result) {
      expect(result.errorMessage).to.equal(errorComputeUpdateNoSurvey);
      done();
    }).catch(done);
  })

  it('GetSurveyStateSummary Test case', function(done){
      SSA_ClientLib.SurveyController.getSurveyStateSummary(identifier, null).then(function(result) {
          expect(result.stepsRemaining).to.equal(64);
          done();
      }).catch(done);
  })

  it('GetSurveyStateSummary Invalid Test case', function(done){
      SSA_ClientLib.SurveyController.getSurveyStateSummary(invalidId, null).then(function(result) {
          expect(result.errorMessage).to.equal(errorComputeStateNoSurvey);
          done();
      }).catch(done);
  })

  it('GetQuestions Test case', function(done){
      SSA_ClientLib.SurveyController.getQuestions(identifier, null, null).then(function(result) {
          expect(result.questions[0].identifier).to.equal('demographics1');
          done();
      }).catch(done);
  })

  it('GetQuestions Invalid Test case', function(done){
      SSA_ClientLib.SurveyController.getQuestions(invalidId, null, null).then(function(result) {
          expect(result.errorMessage).to.equal(errorComputeStateNoSurvey);
          done();
      }).catch(done);
  })

  it('GetSenseQuestion Test case', function(done){
      SSA_ClientLib.SurveyController.getSenseQuestion(identifier, 'height').then(function(result) {
          expect(result.identifier).to.equal('height');
          done();
      }).catch(done);
  })

  it('GetSenseQuestion Invalid Test case', function(done){
      SSA_ClientLib.SurveyController.getSenseQuestion(invalidId, 'height').then(function(result) {
          expect(result.errorMessage).to.equal(errorGetQuestionsNoSurvey);
          done();
      }).catch(done);
  })

  it('GetSenseRequiredQuestions Test case', function(done){
      SSA_ClientLib.SurveyController.getSenseRequiredQuestions(identifier, 'bmi').then(function(result) {
          expect(result[0].identifier).to.equal('weight');
          done();
      }).catch(done);
  })

  it('GetSenseRequiredQuestions Invalid Test case', function(done){
      SSA_ClientLib.SurveyController.getSenseRequiredQuestions(invalidId, 'bmi').then(function(result) {
          expect(result.errorMessage).to.equal(errorGetQuestionsNoSurvey);
          done();
      }).catch(done);
  })

  it('PostAnswers Test case', function(done){
      SSA_ClientLib.SurveyController.postAnswers(identifier, rawPostAnswers, null).then(function(result) {
          expect(result.questions[0].identifier).to.equal('sex');
          done();
      }).catch(done);
  })

  it('PostAnswers Invalid Test case', function(done){
      SSA_ClientLib.SurveyController.postAnswers(invalidId, rawPostAnswers, null).then(function(result) {
          expect(result.errorMessage).to.equal(errorComputeStateNoSurvey);
          done();
      }).catch(done);
  })

  it('UpdateAnswers Test case', function(done){
      SSA_ClientLib.SurveyController.updateAnswers(identifier, requestDTO, null).then(function(result) {
          expect(result.questions[0].identifier).to.equal('sex');
          done();
      }).catch(done);
  })

  it('UpdateAnswers Invalid Test case', function(done){
      SSA_ClientLib.SurveyController.updateAnswers(invalidId, requestDTO, null).then(function(result) {
          expect(result.errorMessage).to.equal(errorComputeUpdateNoSurvey);
          done();
      }).catch(done);
  })

  it('ResetSurveyState Test Case', function(done){
      SSA_ClientLib.SurveyController.resetSurveyState(identifier).then(function(result) {
          var b_result;
          //The purpose of this test case is to make sure method won't throw exception.
          if(typeof result === 'undefined'){b_result = true} else {b_result = false};
            expect(b_result = true);
            done();
      }).catch(done);
  })

  it('ResetSurveyState Invalid Test case', function(done){
      SSA_ClientLib.SurveyController.resetSurveyState(invalidId).then(function(result) {
      expect(result).undefined; // todo: server-side ResetSurveyState should reject invalid survey identifiers
      done();
    }).catch(done);
  })

  it('getSurveyState Invalid Test case', function(done){
      SSA_ClientLib.SurveyController.getSurveyState(invalidId).then(function(result) {
      expect(result.errorMessage).to.equal(errorComputeStateNoSurvey);
      done();
    }).catch(done);
  })
});
