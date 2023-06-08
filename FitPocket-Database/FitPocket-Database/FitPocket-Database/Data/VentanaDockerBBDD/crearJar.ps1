$path = pwd
cd $path
javac *.java
jar cvfm FitPocketDatabase.jar META-INF/MANIFEST.MF *.class
if(Test-Path -Path "./../../FitPocketDatabase.jar"){
ri ./../../FitPocketDatabase.jar
}
mi ./FitPocketDatabase.jar ./../..
Read-Host "Pulsa intro para salir"