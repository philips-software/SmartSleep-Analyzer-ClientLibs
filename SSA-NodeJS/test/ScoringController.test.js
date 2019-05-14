const lib = require('smartsleep-analyzer');
const expect = require('chai').expect;
const _config = require('./Configuration');

let SSA_ClientLib = null
const defaultErrorMessage = '00000:Please verify the provided information is correct.!';

var computeSensepara = {
  'height': 135,
  'weight': 120
}

describe('Scoring Controller Test Cases', function(){
  it('ComputeSense Test case', function(done){
    SSA_ClientLib = lib(_config.clientid,_config.secretKey,function(success){
        SSA_ClientLib.ScoringController.computeSense('bmi', computeSensepara).then(function(result) {
          expect(result.bmi).to.equal(65.84362139917695);
          done();
        }).catch(done);
    })
   })

   it('ComputeSense Negative Test case', function(done){
    SSA_ClientLib.ScoringController.computeSense('bmi', computeSensepara).then(function(result) {
      expect(result.bmi).to.not.equal(64.84362139917695);
      done();
    }).catch(done);
  })

  it('ComputeSense Negative Test case', function(done){
    SSA_ClientLib.ScoringController.computeSense('bmi1', computeSensepara).then(function(result) {
      expect(result.errorMessage).to.equal(defaultErrorMessage);
      done();
    }).catch(done);
  })

  var computeSensepara_Invalid = {
    'height': 135,
    'weight': 'xyz'
  }

  it('ComputeSense Invalid Test case', function(done){
    SSA_ClientLib.ScoringController.computeSense('bmi', computeSensepara_Invalid).then(function(result) {
      expect(result.errorResponse).to.equal('{"faultCode":"2102","message":"Invalid value \'xyz\' for sense \'weight\' of type \'DoubleSenseValue\'"}');
      done();
    }).catch(done);
  })

  it('getAllSenses Test case', function(done){
    SSA_ClientLib.ScoringController.getAllSenses().then(function(result) {
      expect(result[8].id).to.equal('highBloodPressure');
      done();
    }).catch(done);
  })

  it('getSense Test case', function(done){
    SSA_ClientLib.ScoringController.getSense('bmi').then(function(result) {
      expect(result.dependencies[0].senseId + result.dependencies[1].senseId).to.equal('heightweight');
      done();
    }).catch(done);
  })

  it('getSense Invalid Test case', function(done){
    SSA_ClientLib.ScoringController.getSense('123').then(function(result) {
      expect(result.errorResponse).to.equal('{"faultCode":"2121","message":"Unable to find the sense with id \'123\'"}');
      done();
    }).catch(done);
  })

  it('getSense Invalid Test case', function(done){
    SSA_ClientLib.ScoringController.getSense('').then(function(result) {
      expect(result.errorMessage).to.equal(defaultErrorMessage);
      done();
    }).catch(done);
  })

  it('GetRequiredQuestionSenses Test case', function(done){
    SSA_ClientLib.ScoringController.getRequiredQuestionSenses('bmi').then(function(result) {
      expect(result[0].id + result[1].id).to.equal('heightweight');
      done();
    }).catch(done);
  })

  it('GetRequiredQuestionSenses Invalid Test case', function(done){
    SSA_ClientLib.ScoringController.getRequiredQuestionSenses('osa1').then(function(result) {
      expect(result.errorMessage).to.equal(defaultErrorMessage);
      done();
    }).catch(done);
  })

  it('GetComputedSenses Test case', function(done){
    SSA_ClientLib.ScoringController.getComputedSenses('bmi').then(function(result) {
      expect(result[2].id).to.equal('insomnia');
      done();
    }).catch(done);
  })

  it('GetSleepProblemSenses Test case', function(done){
    SSA_ClientLib.ScoringController.getSleepProblemSenses('bmi').then(function(result) {
      expect(result[5].id).to.equal('snoring');
      done();
    }).catch(done);
  })

  it('GetQuestionSenses Test case', function(done){
    SSA_ClientLib.ScoringController.getQuestionSenses('bmi').then(function(result) {
      expect(result[2].id).to.equal('highBloodPressure');
      done();
    }).catch(done);
  })

  var css_para = {
    'height': 160, 'weight': 75, 'bedTime': '20:30', 'riseTime': '7:00', 'sex': 'male', 'age': '42', 'occupation': 'professional', 'workHoursPerWeek': '45', 'bedPartner': true,
    'shiftWorker': false, 'problemSleeping': 0, 'problemSleepiness': 0, 'problemSnoring': 10, 'problemPartnerSnoring': 0, 'problemOther': '', 'weight': '87', 'height': '180',
    'snoringBotherOthers': 'yes', 'breathingStopped': 'no', 'highBloodPressure': 'no', 'snoringOnBack': 'yes', 'noseOftenBlocked': 'no', 'snoringFrequency': 'nightssome',
    'snoringDuration': 'nightmostof', 'snoringLoudness': 'snoringheardnextroom', 'snoringAnnoying': 'very', 'ess1': 'dozeslight', 'ess2': 'dozeslight', 'ess3': 'dozenever',
    'ess4': 'dozeslight', 'ess5': 'dozehigh', 'ess6': 'dozenever', 'ess7': 'dozeslight', 'ess8': 'dozeslight', 'fss1': 4, 'fss2': 4, 'fss3': 4, 'fss4': 4, 'fss5': 4,
    'fss6': 4, 'fss7': 4, 'fss8': 4, 'fss9': 4, 'sleepInitiation1': 'difficultsomewhat', 'accidentRisk': true, 'alcoholFrequency': 'n2to4permonth',
    'caffeinatedDrinksPerDay': 'none', 'smokingFrequency': 'notatall', 'difficultyDuration': 'months3to6', 'difficultyFallingAsleep': 'none',
    'difficultyStayingAsleep': 'none', 'difficultyWakingEarly': 'none',  'sleepPatternDissatisfaction': 'satisfied', 'impactNoticeable': 'noticeablebarely',
    'impactWorrying': 'worrieddistressedbarely', 'impactInterfering': 'interferingbarely'
  } 
  
  it('computeIntermediateAndSleepProblemSenses Test case', function(done){
    SSA_ClientLib.ScoringController.computeIntermediateAndSleepProblemSenses(css_para).then(function(result) {
      expect(result.bmi).to.equal(26.85185185185185);
      done();
    }).catch(done);
  })

  var css_para_invalid = {
    'height': 160, 'abc': 75, 'bedTime': '20:30', 'riseTime': '7:00', 'sex': 'male', 'age': '42', 'occupation': 'professional', 'workHoursPerWeek': '45', 'bedPartner': true,
    'shiftWorker': false, 'problemSleeping': 0, 'problemSleepiness': 0, 'problemSnoring': 10, 'problemPartnerSnoring': 0, 'problemOther': '', 'weight': '87', 'height': '180',
    'snoringBotherOthers': 'yes', 'breathingStopped': 'no', 'highBloodPressure': 'no', 'snoringOnBack': 'yes', 'noseOftenBlocked': 'no', 'snoringFrequency': 'nightssome',
    'snoringDuration': 'nightmostof', 'snoringLoudness': 'snoringheardnextroom', 'snoringAnnoying': 'very', 'ess1': 'dozeslight', 'ess2': 'dozeslight', 'ess3': 'dozenever',
    'ess4': 'dozeslight', 'ess5': 'dozehigh', 'ess6': 'dozenever', 'ess7': 'dozeslight', 'ess8': 'dozeslight', 'fss1': 4, 'fss2': 4, 'fss3': 4, 'fss4': 4, 'fss5': 4,
    'fss6': 4, 'fss7': 4, 'fss8': 4, 'fss9': 4, 'sleepInitiation1': 'difficultsomewhat', 'accidentRisk': true, 'alcoholFrequency': 'n2to4permonth',
    'caffeinatedDrinksPerDay': 'none', 'smokingFrequency': 'notatall', 'difficultyDuration': 'months3to6', 'difficultyFallingAsleep': 'none',
    'difficultyStayingAsleep': 'none', 'difficultyWakingEarly': 'none',  'sleepPatternDissatisfaction': 'satisfied', 'impactNoticeable': 'noticeablebarely',
    'impactWorrying': 'worrieddistressedbarely', 'impactInterfering': 'interferingbarely'
  }

  it('computeIntermediateAndSleepProblemSenses Invalid Test case', function(done){
    SSA_ClientLib.ScoringController.computeIntermediateAndSleepProblemSenses(css_para_invalid).then(function(result) {
      expect(result.errorMessage).to.equal('{"faultCode":"2124","message":"Invalid sense id \'abc\'"}');
      done();
    }).catch(done);
  })

  it('computeIntermediateAndSleepProblemSenses Invalid Test case', function(done){
    SSA_ClientLib.ScoringController.computeIntermediateAndSleepProblemSenses('').then(function(result) {
      expect(result.errorMessage).to.equal(defaultErrorMessage);
      done();
    }).catch(done);
  })

  it('computeSleepProblemSenses Test case', function(done){
    SSA_ClientLib.ScoringController.computeSleepProblemSenses (css_para).then(function(result) {
      expect(result.snoring.classification).to.equal('Occasional Snoring');
      done();
    }).catch(done);
  })

  it('computeSleepProblemSenses Test case', function(done){
    SSA_ClientLib.ScoringController.computeSleepProblemSenses (css_para_invalid).then(function(result) {
      expect(result.errorMessage).to.equal('{"faultCode":"2124","message":"Invalid sense id \'abc\'"}');
      done();
    }).catch(done);
  })

  it('computeSleepProblemSenses Invalid Test case', function(done){
    SSA_ClientLib.ScoringController.computeSleepProblemSenses ('').then(function(result) {
      expect(result.errorMessage).to.equal(defaultErrorMessage);
      done();
    }).catch(done);
  })

  var sleepProbsenseid = ['osa', 'sss', 'problemSleeping', 'problemSleepiness', 'difficultyDuration', 'isi', 'sleepInitiation']
  
  it('getcomputableSleepProblemSenses Test case', function(done){
    SSA_ClientLib.ScoringController.getcomputableSleepProblemSenses (sleepProbsenseid).then(function(result) {
      expect(result[0].id).to.equal('snoring');
      done();
    }).catch(done);
  })

  var sleepProbsenseid_Invalid = ['osa1', 'sss1', 'problemSleeping1', 'problemSleepiness1', 'difficultyDuration1', 'isi1', 'sleepInitiation1']
  
  it('getcomputableSleepProblemSenses Invalid Test case', function(done){
    SSA_ClientLib.ScoringController.getcomputableSleepProblemSenses (sleepProbsenseid_Invalid).then(function(result) {
      expect(result.length).to.equal(0);
      done();
    }).catch(done);
  })
  
  it('getcomputableSleepProblemSenses Invalid Test case', function(done){
    SSA_ClientLib.ScoringController.getcomputableSleepProblemSenses ('').then(function(result) {
      expect(result.errorMessage).to.equal(defaultErrorMessage);
      done();
    }).catch(done);
  })

  it('getComputableSenses Test case', function(done){
    SSA_ClientLib.ScoringController.getComputableSenses (sleepProbsenseid).then(function(result) {
      expect(result[0].id).to.equal('snoring');
      done();
    }).catch(done);
  })

  it('getComputableSenses Invalid Test case', function(done){
    SSA_ClientLib.ScoringController.getComputableSenses (sleepProbsenseid_Invalid).then(function(result) {
      expect(result.length).to.equal(0);
      done();
    }).catch(done);
  })

  it('getComputableSenses Invalid Test case', function(done){
    SSA_ClientLib.ScoringController.getComputableSenses ('').then(function(result) {
      expect(result.errorMessage).to.equal(defaultErrorMessage);
      done();
    }).catch(done);
  })

  var computeAllSensepara = {
    'height': 160,
    'weight': 75,
    'bedTime': '20:30',
    'riseTime': '7:00'
  }

  it('computeAllSenses Test case', function(done){
    SSA_ClientLib.ScoringController.computeAllSenses (computeAllSensepara).then(function(result) {
      expect(result.bmi).to.equal(29.296874999999993);
      done();
    }).catch(done);
  })

  var computeAllSensepara_Invalid = {
    'height': 'test',
    'weight': 75,
    'bedTime': '20:30',
    'riseTime': '7:00'
  }

  it('computeAllSenses Test case', function(done){
    SSA_ClientLib.ScoringController.computeAllSenses (computeAllSensepara_Invalid).then(function(result) {
      expect(result.errorMessage).to.equal('{"faultCode":"2102","message":"Invalid value \'test\' for sense \'height\' of type \'DoubleSenseValue\'"}');
      done();
    }).catch(done);
  })

  it('computeAllSenses Test case', function(done){
    SSA_ClientLib.ScoringController.computeAllSenses ('').then(function(result) {
      expect(result.errorMessage).to.equal(defaultErrorMessage);
      done();
    }).catch(done);
  })
});
 