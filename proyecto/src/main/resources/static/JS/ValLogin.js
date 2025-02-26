document.addEventListener("DOMContentLoaded", function () { 
  document.querySelector("form").addEventListener("submit", function (event) {
    let valid = true;

    const email = document.getElementById("email").value.trim();
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
      alert("Ingrese un email válido.");
      valid = false;
    }

    const password = document.getElementById("password").value;
    if (password.length < 8) {
      alert("La contraseña debe tener al menos 8 caracteres.");
      valid = false;
    }

    if (valid) {
      alert("Login correcto");
    } else {
      event.preventDefault();
    }
  });
});
