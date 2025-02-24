document.addEventListener("DOMContentLoaded", function () {
    document.querySelector("form").addEventListener("submit", function (event) {
      let valid = true;
  
      const titulo = document.getElementById("titulo").value.trim();
      if (titulo === "") {
        alert("Ingrese un título.");
        valid = false;
      }
  
      const autor = document.getElementById("autor").value.trim();
      if (autor === "") {
        alert("Ingrese un autor.");
        valid = false;
      }
  
      const categoria = document.getElementById("categoria").value;
      if (categoria === "") {
        alert("Seleccione una categoría.");
        valid = false;
      }
  
      const cantidad = document.getElementById("cantidad").value;
      if (cantidad === "" || isNaN(cantidad) || cantidad <= 0) {
        alert("Ingrese una cantidad válida mayor a 0.");
        valid = false;
      }
  
      const precio = document.getElementById("precio").value;
      if (precio === "" || isNaN(precio) || precio <= 0) {
        alert("Ingrese un precio mayor a 0.");
        valid = false;
      }
  
      if (!valid) {
        event.preventDefault();
      }
    });
  });
  