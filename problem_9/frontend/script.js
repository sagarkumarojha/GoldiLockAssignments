
function showLoginForm() {
           const registerContainer = document.querySelector(".register-form");
           const loginContainer = document.querySelector(".login-form");

           registerContainer.style.display = "none";
           loginContainer.style.display = "block";
       }
       function showRegisterForm() {
           const registerContainer = document.querySelector(".register-form");
           const loginContainer = document.querySelector(".login-form");

           registerContainer.style.display = "block";
           loginContainer.style.display = "none";
       }
  

           const users = [];
   
           function register() {
               const regUsername = document.getElementById("regUsername").value;
               const regPassword = document.getElementById("regPassword").value;
   
               users.push({ username: regUsername, password: regPassword });
   
               alert("Registration successful. You can now log in.");
           }
   
           function login() {
               const loginUsername = document.getElementById("loginUsername").value;
               const loginPassword = document.getElementById("loginPassword").value;
   
               const user = users.find(u => u.username === loginUsername && u.password === loginPassword);
   
               if (user) {
                   alert("Login successful. Welcome, " + loginUsername + "!");
               } else {
                   alert("Login failed. Please check your credentials.");
               }
           }
