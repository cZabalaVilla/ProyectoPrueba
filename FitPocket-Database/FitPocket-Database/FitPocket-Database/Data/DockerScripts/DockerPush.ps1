#Obtener el tag actual
$actualTag = docker inspect -f '{{.Config.Image}}' fitpocketdb

# Generar el nuevo tag
$nuevoTag = "1.0.$([int]$actualTag.split('.')[1] + 1)"

# Detener el contenedor Docker
docker stop fitpocketdb

# Construir la imagen
docker commit fitpocketdb neort2/fitpocketdb

# Cambiar el tag de la imagen
docker tag neort2/fitpocketdb neort2/fitpocketdb:$nuevoTag
docker tag neort2/fitpocketdb neort2/fitpocketdb:latest

# Subir la imagen
docker push neort2/fitpocketdb:$nuevoTag
docker push neort2/fitpocketdb neort2/fitpocketdb:latest

# Salida
$confirm = Read-Host "Desea borrar los contenedores e imagenes locales de fitpocketdb?(S/N)"
if($confirm.ToUpper() -eq "S"){
& ".\DockerClean.ps1"
}