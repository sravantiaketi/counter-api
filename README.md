
This is a Springboot RESTful service for reading data from a file to achieve following tasks:

  
  RUNNIG THE APPLICATION:
  Step1: Clone the repository using URL:
         https://github.com/sravantiaketi/counter-api.git
  
  Step2: Go to application directory and run below command to start the application:
  mvn spring-boot:run
  Note : Single User "user" is configured to invoke the services and authorization "dXNlcjpzcmF2YW50aQ" should be same
  for all requests.
  
  Step3: Using curl GET command on terminal send  requests to the application as shown in belwo example.
  >curl http://localhost:8080/counter-api/top/20 -H"Authorization: Basic dXNlcjpzcmF2YW50aQ==" -H"Accept: text/csv"
  
  Output: 
  eget|17
  vel|17
  sed|16
  in|15
  et|14
  eu|13
  ut|13
  ac|12
  amet|12
  id|12
  metus|12
  nulla|12
  sit|12
  at|11
  duis|11
  ipsum|11
  nec|11
  vitae|11
  aliquam|10
  dolor|10
  
  data.json mentioned below is already uploaded in git repository under project directory.Please refer the same.
  
  Step 4:Step3: Using curl POST command on terminal send  requests to the application as shown in belwo example.
  Open Command prompt at /counter-api> and type below command, make sure data.json exists in the folder where this command is executed.
  >curl -X POST  http://localhost:8080/counter-api/search -H"Authorization: Basic dXNlcjpzcmF2YW50aQ==" -H"cache-control:no-cache" -       H"content-type:application/json" -d"@data.json"
  
  Output:
  {"counts":[{"Duise":0},{"Se":0},{"Donec":8},{"Augue":7},{"Pellentesque":6},{"123":0}]}
