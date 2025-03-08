document.addEventListener("DOMContentLoaded", function () {
  const form = document.querySelector("form");

  if (form) {
    form.addEventListener("submit", function (event) {
      let valid = true;

      const emailInput = document.getElementById("username"); 
      const email = emailInput.value.trim();
      const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      if (!emailRegex.test(email)) {
        alert("Ingrese un email válido.");
        emailInput.style.border = "2px solid red";
        emailInput.focus();
        valid = false;
      } else {
        emailInput.style.border = "";
      }

      const passwordInput = document.getElementById("password");
      const password = passwordInput.value;
      if (password.length < 8) {
        alert("La contraseña debe tener al menos 8 caracteres.");
        passwordInput.style.border = "2px solid red";
        passwordInput.focus();
        valid = false;
      } else {
        passwordInput.style.border = "";
      }

      if (!valid) {
        event.preventDefault();
      } else {
        alert("Login correcto");
      }
    });
  } 
  
});
