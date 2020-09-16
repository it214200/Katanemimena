// get elements from html
const email = document.getElementById('email1');
const password = document.getElementById('password1');
const form = document.getElementById('form');
const errorElement = document.getElementById('error');

// get the data from api
const getData = () => {
    var emailInput = document.getElementById('email1').value;
    const url = 'http://localhost:8085/Esoteriko/api/students/';
    var spli_string1 = email.value.split(/(\d+)/);
    var num1 = spli_string1[1];

    var urlFinal = url.concat(num1);
    console.log(urlFinal)
    axios.get(urlFinal).then(response => {
  
        console.log(response);
        if(response.status === 200){
            errorElement.innerText = '';
            window.localStorage.clear();
            // Store AM in local storage
            localStorage.setItem('am', num1);

        }
        
    }) 
    .catch(err => {
        errorElement.innerText = 'Error: Email doesnt exist';
        console.log(err, err.response);
      });
  };

// Event submit form
form.addEventListener('submit',(e) => {
    let messages = []
    
    var spli_string1 = email.value.split(/(\d+)/);
    var num1 = spli_string1[1];

    var spli_string2 = password.value.split(/(\d+)/);
    var num2 = spli_string2[1];

    // check the length of fields
    if(password.value.length < 5){
        e.preventDefault()
        messages.push('Password must be longer than 4 characters ')
    }

    if(email.value.length < 4){
        e.preventDefault()
        messages.push('Email must be longer than 4 characters ')
    }
    
    if(num1 !== num2){
        e.preventDefault()
        messages.push('Login failed wrong user credentials')
    }
    // print messages
    if(messages.length > 0){
        e.preventDefault()
        errorElement.innerText = messages.join(', ')
    }

})