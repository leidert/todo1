var request = require("request");

var options = { method: 'POST',
  url: 'https://dev-nsj34csi.auth0.com/oauth/token',
  headers: { 'content-type': 'application/json' },
  body: '{"client_id":"kU5xAiQN0qUjtZzUSWR8RIfSfgQkTCWB","client_secret":"MYs_ylDlDdaFSAmImaLHcPHg_MaxMkYQ8w-LzDM4kDUDtFzINyRrRI9Zz_qLarXw","audience":"https://co.com.sofka","grant_type":"client_credentials"}' };

request(options, function (error, response, body) {
  if (error) throw new Error(error);

  console.log(body);
});