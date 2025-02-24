document.addEventListener("DOMContentLoaded", function () {
  document.querySelector("form").addEventListener("submit", function (event) {
    let valid = true;

    const nombre = document.getElementById("nombre").value.trim();
    const nombreRegex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/;
    if (nombre === "" || !nombreRegex.test(nombre)) {
      alert("Ingrese un nombre válido.");
      valid = false;
    }

    const email = document.getElementById("email").value.trim();
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (email === "") {
      alert("El email no puede estar vacío.");
      valid = false;
    } else if (!emailRegex.test(email)) {
      alert("Ingrese un correo válido.");
      valid = false;
    }

    const direccion = document.getElementById("direccion").value.trim();
    if (direccion === "") {
      alert("La dirección no puede estar vacía.");
      valid = false;
    }

    const password = document.getElementById("password").value;
    const passwordPatron = /^(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
    if (password === "") {
      alert("La contraseña no puede estar vacía.");
      valid = false;
    } else if (!passwordPatron.test(password)) {
      alert(
        "La contraseña debe tener al menos 8 caracteres con una letra mayúscula y una minúscula ."
      );
      valid = false;
    }

    if (!valid) {
      event.preventDefault();
    }
  });
  alert("Registro correcto");
});
