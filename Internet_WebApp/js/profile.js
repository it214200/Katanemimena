// get the elements from html
const code_number = document.getElementById('codeNumber');
const first_name = document.getElementById('fname');
const last_name = document.getElementById('lname');
const email = document.getElementById('email');
const semester = document.getElementById('semester');
const status = document.getElementById('status');
const active = document.getElementById('active');
const from = document.getElementById('from');
const mName = document.getElementById('mName');
const fName = document.getElementById('fName');
const date = document.getElementById('date');
const phone = document.getElementById('phone');

// retrieve localstorage and create url
var am = localStorage.getItem('am');

if(am === null)
  location.replace('login.html');

var url = 'http://localhost:8085/Esoteriko/api/students/';
var finalUrl = url.concat(am);

// call api to get data
const getData = () => {
  axios.get(finalUrl).then(response => {

    code_number.innerHTML = response.data.codeNumber;
    first_name.innerHTML = response.data.firstName;
    last_name.innerHTML = response.data.lastName;
    email.innerHTML = response.data.email;
    semester.innerHTML = response.data.studentProfile.currentSemester;
    status.innerHTML = response.data.studentProfile.status;
    active.innerHTML = response.data.studentProfile.active;
    from.innerHTML = response.data.studentProfile.registeredFrom;
    mName.innerHTML = response.data.studentProfile.mName;
    fName.innerHTML = response.data.studentProfile.fName;
    date.innerHTML = response.data.studentProfile.birthDate;
    phone.innerHTML = response.data.studentProfile.phone;


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