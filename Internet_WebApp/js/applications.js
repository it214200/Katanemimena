var am = localStorage.getItem('am');

if(am === null)
  location.replace('login.html');
  
var url = 'http://localhost:8085/Esoteriko/api/students/';
var finalUrl = url.concat(am);

var node = document.getElementById('p-id');

const getApplications = () => {
    axios.get(finalUrl).then(response => {
  
        response.data.applications.forEach((element, index, array) => {
          node.innerHTML += '<h3>'+'Application '+(index+1)+'</h3>'+'<br>'
              +'<li>'+'Created:'+element.created+'</li>'+'<br>'
              +'<li>'+'Brothers:'+element.income+'</li>'+'<br>'
              +'<li>'+'Unemployed:'+element.unemployed+'</li>'+'<br>'
              +'<li>'+'Differrent City:'+element.diffCity+'</li>'+'<br>'
              +'<li>'+'Points:'+element.points+'</li>'+'<br>'
              +'<li>'+'Validated:'+element.validated+'</li>'+'<br>'
      });  
        
      console.log(response);
    })
  };
  
setTimeout(function(){
  getApplications();
},100);

// when you logout
const logOut = () => {
  // clear local storage
  window.localStorage.clear();
  
  // redirect to login page
  location.replace('login.html');
};