# Mostrar mensaje de confirmación
$confirm = Read-Host "¿Estás seguro de que deseas borrar todas las imágenes de neort2/fitpocketdb y contenedores de fitpocketdb? Escribe 'fitpocketdb' para confirmar."

if ($confirm -eq "fitpocketdb") {
# Eliminar todos los contenedores con el nombre "oracledbproyecto"
docker container rm -f $(docker container ls -aq --filter "name=fitpocketdb")

# Eliminar todas las imágenes con el nombre "neort2/oracledbproyecto"
docker rmi -f $(docker images --format "{{.Repository}}:{{.Tag}}" | where {$_ -like "neort2/fitpocketdb:*" })
    Write-Host "Se han eliminado todas las imágenes y contenedores de neort2/fitpocketdb."
    Read-Host "Intro para salir"
}
else {
    Write-Host "Operación cancelada."
    Read-Host "Intro para salir"
}