@echo off
chcp 65001 >nul
setlocal EnableDelayedExpansion

REM ############################################################
REM # CONFIGURATION
REM ############################################################
set TOMCAT_HOME=C:\Program Files\Apache Software Foundation\Tomcat 10.1
set WAR_NAME=ETU003317_spring.war
set APP_NAME=ETU003317_spring

REM ############################################################
REM # NETTOYAGE
REM ############################################################
echo [1/7] Nettoyage des anciens fichiers...
rmdir /s /q out 2>nul
mkdir out\WEB-INF
mkdir out\WEB-INF\classes
mkdir out\WEB-INF\lib
mkdir out\WEB-INF\views

echo [2/7] Nettoyage de Tomcat...
del /q "%TOMCAT_HOME%\webapps\%WAR_NAME%" 2>nul
rmdir /s /q "%TOMCAT_HOME%\webapps\%APP_NAME%" 2>nul
rmdir /s /q "%TOMCAT_HOME%\work\Catalina\localhost\%APP_NAME%" 2>nul

REM ############################################################
REM # COPIE DES DEPENDANCES
REM ############################################################
echo [3/7] Copie des dependances...
xcopy /y /q lib\*.jar out\WEB-INF\lib\ >nul

REM ############################################################
REM # COMPILATION (PAR ORDRE DE DEPENDANCES)
REM ############################################################
echo [4/7] Compilation des sources...
set CLASSPATH=out\WEB-INF\lib\*;src\main\resources

echo    - Compilation des utils...
javac -d out\WEB-INF\classes -cp "%CLASSPATH%" src\main\java\mg\itu\spring\utils\*.java

echo    - Compilation des entities...
javac -d out\WEB-INF\classes -cp "%CLASSPATH%;out\WEB-INF\classes" src\main\java\mg\itu\spring\entity\*.java

echo    - Compilation des repositories...
javac -d out\WEB-INF\classes -cp "%CLASSPATH%;out\WEB-INF\classes" src\main\java\mg\itu\spring\repository\*.java

echo    - Compilation des controllers...
javac -d out\WEB-INF\classes -cp "%CLASSPATH%;out\WEB-INF\classes" src\main\java\mg\itu\spring\controller\*.java

if %ERRORLEVEL% neq 0 (
    echo ERREUR: Compilation echouee. Verifiez:
    echo 1. Les noms de packages (mg.itu.spring)
    echo 2. Que tous les fichiers existent
    echo 3. Les dependances dans lib/
)

REM ############################################################
REM # COPIE DES RESSOURCES
REM ############################################################
echo [5/7] Copie des ressources...
xcopy /s /y src\main\resources\* out\WEB-INF\classes\ >nul
xcopy /s /y src\main\webapp\WEB-INF\views\*.jsp out\WEB-INF\views\ >nul
xcopy /y src\main\webapp\WEB-INF\web.xml out\WEB-INF\ >nul
xcopy /y "src\main\webapp\WEB-INF\dispatcher-servlet.xml" "out\WEB-INF\" >nul


REM ############################################################
REM # CREATION DU FICHIER WAR
REM ############################################################
echo [6/7] Creation du fichier WAR...
cd out
jar -cvf ..\%WAR_NAME% * >nul
jar tf ..\%WAR_NAME% | findstr dispatcher-servlet.xml


cd ..

REM ############################################################
REM # DEPLOIEMENT
REM ############################################################
echo [7/7] Deploiement...
copy /y %WAR_NAME% "%TOMCAT_HOME%\webapps\" >nul

REM ############################################################
REM # FIN
REM ############################################################
echo.
echo [SUCCES] Deploiement termine avec succes!
echo.
echo URL de l'application:
echo http://localhost:8080/%APP_NAME%/departements
echo.
pause