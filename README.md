# Docker
Ir a la ruta del proyecto y ejecutar en una terminal

  docker build -t "idemsoft-docker" .
  
Luego creamos el container con: 

  docker run --name idemsoft-container 8080:8080 idemsoft-docker:latest

# Swagger
La ruta de swagger es http://localhost:8080/swagger-ui.html

# Endpoint
El endpoint para consultar los datos por comuna es : http://localhost:8080/comuna/(nombre)
