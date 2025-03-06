document.addEventListener("DOMContentLoaded", function () {
  document.querySelector("form").addEventListener("submit", function (event) {
    let valid = true;

    const nombreInput = document.getElementById("nombre");
    const nombre = nombreInput.value.trim();
    const nombreRegex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/;
    if (nombre === "" || !nombreRegex.test(nombre)) {
      alert("Ingrese un nombre válido.");
      nombreInput.style.border = "2px solid red";
      nombreInput.focus();
      valid = false;
    } else {
      nombreInput.style.border = "";
    }

    const emailInput = document.getElementById("email");
    const email = emailInput.value.trim();
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (email === "") {
      alert("El email no puede estar vacío.");
      emailInput.style.border = "2px solid red";
      emailInput.focus();
      valid = false;
    } else if (!emailRegex.test(email)) {
      alert("Ingrese un correo válido.");
      emailInput.style.border = "2px solid red";
      emailInput.focus();
      valid = false;
    } else {
      emailInput.style.border = "";
    }

    const direccionInput = document.getElementById("direccion");
    const direccion = direccionInput.value.trim();
    if (direccion === "") {
      alert("La dirección no puede estar vacía.");
      direccionInput.style.border = "2px solid red";
      direccionInput.focus();
      valid = false;
    } else {
      direccionInput.style.border = "";
    }

    const passwordInput = document.getElementById("password");
    const password = passwordInput.value;
    const passwordPatron = /^(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
    if (password === "") {
      alert("La contraseña no puede estar vacía.");
      passwordInput.style.border = "2px solid red";
      passwordInput.focus();
      valid = false;
    } else if (!passwordPatron.test(password)) {
      alert("La contraseña debe tener al menos 8 caracteres con una letra mayúscula y una minúscula.");
      passwordInput.style.border = "2px solid red";
      passwordInput.focus();
      valid = false;
    } else {
      passwordInput.style.border = "";
    }

    if (valid) {
      alert("Registro correcto");
    } else {
      event.preventDefault();
    }
  });
});
