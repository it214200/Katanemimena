// Element from html
const first_name = document.getElementById('fname');

// retrieve localStorage
var am = localStorage.getItem('am');

if(am === null)
  location.replace('login.html');

// create url, finalUrl = url + am
var url = 'http://localhost:8085/Esoteriko/api/students/';
var finalUrl = url.concat(am);

var link = window.location.href;
linkFinal = new URL(link);
console.log(linkFinal.host); 

// get the data from api
const getData = () => {
  axios.get(finalUrl).then(response => {

      // Student object
      var idData = response.data.id;
      var codeNumberData = response.data.codeNumber;
      var firstNameData = response.data.firstName; 
      var lastNameData = response.data.lastName;
      var emailData = response.data.email;
      
      // Student Profile object
      var idProfile = response.data.studentProfile.id;
      var semesterData = response.data.studentProfile.currentSemester;
      var statusData = response.data.studentProfile.status;
      var activeData = response.data.studentProfile.active;
      var fromData = response.data.studentProfile.registeredFrom;
      var mNameData = response.data.studentProfile.mName;
      var fNameData = response.data.studentProfile.fName;
      var dateData = response.data.studentProfile.birthDate;
      var phoneData = response.data.studentProfile.phone;

      // create javascript object
      var student = {
        id:idData,
        codeNumber:codeNumberData,
        firstName:firstNameData,
        lastName:lastNameData,
        email:emailData,
        studentProfile : {
          id:idProfile,
          currentSemester:semesterData,
          status:statusData,
          active:activeData,
          registeredFrom:fromData,
          mName:mNameData,
          fName:fNameData,
          birthDate:dateData,
          phone:phoneData
        }
      }
   
      // store the object in the localstorage
      localStorage.setItem('student', JSON.stringify(student));
      
      //console.log('Saved Student: '+student.codeNumber);
   
    
    first_name.innerHTML = response.data.firstName;
    console.log(response);
  });
};

// trigger getData() function in 100ms
setTimeout(function(){
  getData();
},100);

// when you logout
const logOut = () => {
  // clear local storage
  window.localStorage.clear();

  // redirect to login page
  location.replace('login.html');
};