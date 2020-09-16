
const form = document.getElementById('target');

var studentObj = localStorage.getItem('student');
var studentData = JSON.parse(studentObj);

var am = localStorage.getItem('am');
if(am === null)
  location.replace('login.html');

var url = 'http://localhost:8085/Esoteriko/api/applications';
   
form.addEventListener('submit',(e) => {

  e.preventDefault();
  // get the data from the form
  var incomeData = document.getElementById('income').value;
  var brotherssData = document.getElementById('brotherss').value;
  var unemployedData = document.getElementById('unemployed').value;
  var diffCityData = document.getElementById('diffCity').value;

  // create javascript object
  var data = { 
    income:incomeData,   
    brotherss:brotherssData,            
    unemployed:unemployedData,
    diffCity:diffCityData,
    student:{
      id:studentData.id,
      codeNumber:studentData.codeNumber,
      firstName:studentData.firstName,
      lastName:studentData.lastName,
      email:studentData.email,
    }
  }; 
    
  console.log(e);
  //e.preventDefault();
  console.log('Data before axios: '+data.student);
  sendData(data);

})


const sendData = (data) => {
 
  console.log('Data after axios: '+data.income)
  axios
    .post(url,data,{
      'Content-Type': 'application/json'
    }
    )
    .then(response => {
      console.log(response);
    })
    .catch(err => {
      console.log(err, err.response);
    });
};
    
// when you logout
const logOut = () => {
  // clear local storage
  window.localStorage.clear();

  // redirect to login page
  location.replace('login.html');
};
