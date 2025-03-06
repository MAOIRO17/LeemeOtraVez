document.addEventListener("DOMContentLoaded", function () {
  document.querySelector("form").addEventListener("submit", function (event) {
    let valid = true;

    const emailInput = document.getElementById("email");
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

    if (valid) {
      alert("Login correcto");
    } else {
      event.preventDefault();
    }
  });
});
