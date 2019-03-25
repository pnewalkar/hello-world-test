onst AWS = require('aws-sdk')

exports.handler = async (event) => {
    
    var params = {
      Key: {
       "username": {
         S: 'Parag'
        }
      }, 
      TableName: "Users"
    };
    
    // var dynamodb = new AWS.DynamoDB({apiVersion: '2012-08-10'});
    var dynamodb = new AWS.DynamoDB.DocumentClient();
     
    var dbResp
    console.log('I\'m here')
    //console.log(dynamodb)
    dynamodb.scan(params, function(err, data) {
         
        if (err) 
            console.log(err, err.stack); // an error occurred
        else {
            console.log(data.Items)
            dbResp = data;
        }
                       // successful response

     });
    // TODO implement
    const response = {
        statusCode: 200,
        body: JSON.stringify(dbResp),
    };
    return response;
};