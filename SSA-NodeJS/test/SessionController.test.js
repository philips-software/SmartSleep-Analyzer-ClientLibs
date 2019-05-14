// var lib = require('smartsleep-analyzer');
// var _expect = require('chai').expect;
// var _config = require('./Configuration');

// var _defaultErrorMessage = '00000:Please verify the provided information is correct.';
// var _ssaClientLib = null;

// var _tempSessionKey = 'testSession' + String(Date.now());

// var _createSession = {
//   'sessionKey': _tempSessionKey,
//   'dataKey': 'test2DataKey'
// };

// var _activateSessionPara = {
//   'sessionKey': _tempSessionKey,
//   'dataKey': 'test2DataKey'
// };

// var _activateSessionParaInvalid = {
//   'sessionKey': _tempSessionKey + 'invalid',
//   'dataKey': 'test2DataKey'
// };

// describe('Session Controller Test Cases', function () {
//   it('createSession(new) passes with valid input', function (done) {
//     _ssaClientLib = lib(_config._clientId, _config._secretKey, function (success) {
//       _ssaClientLib.SessionController.createSession(_createSession).then(function (result) {
//         _expect(result.id).to.not.equal('');
//         done();
//       }).catch(done);
//     });
//   });

//   it('createSession (existing) fails with invalid session', function (done) {
//     _ssaClientLib.SessionController.createSession(_createSession).then(function (result) {
//       _expect(result.errorMessage).to.equal('{"faultCode":"4101","message":"SessionKey \\"' + _tempSessionKey + '\\" is already taken"}');
//       done();
//     }).catch(done);
//   });

//   it('createSession fails with bad input value', function (done) {
//     _ssaClientLib.SessionController.createSession('').then(function (result) {
//       _expect(result.errorMessage).to.equal(_defaultErrorMessage);
//       done();
//     }).catch(done);
//   });

//   it('activateSession fails with invalid session', function (done) {
//     _ssaClientLib.SessionController.activateSession(_activateSessionParaInvalid).then(function (result) {
//       _expect(result.errorMessage).to.equal('{"faultCode":"4201","message":"SessionKey and/or DataKey is incorrect."}');
//       done();
//     }).catch(done);
//   });

//   it('activateSession ', function (done) {
//     _ssaClientLib.SessionController.activateSession('').then(function (result) {
//       _expect(result.errorMessage).to.equal(_defaultErrorMessage);
//       done();
//     }).catch(done);
//   });

//   it('retrieveActivatedSession fails when attempted to retrieve activatedSession', function (done) {
//     _ssaClientLib.SessionController.retrieveActivatedSession().then(function (result) {
//       _expect(result.errorMessage).to.equal(_defaultErrorMessage);
//       done();
//     }).catch(done);
//   });

//   it('deactivateSession ', function (done) {
//     _ssaClientLib.SessionController.deactivateSession().then(function (result) {
//       _expect(result).to.equal(undefined);
//       done();
//     }).catch(done);
//   });
// });
