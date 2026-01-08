@echo off
REM ===================================================================
REM Script para Descargar Dependencias y Compilar el Proyecto
REM ===================================================================

echo.
echo ====================================================
echo   DESCARGANDO DEPENDENCIAS DE MAVEN
echo ====================================================
echo.
echo Este script descargara todas las dependencias
echo necesarias de Serenity BDD, Selenium, JUnit, etc.
echo.
echo Puede tardar 5-15 minutos la primera vez...
echo.
pause

echo.
echo [1/3] Limpiando proyecto...
call mvn clean
if %errorlevel% neq 0 (
    echo [ERROR] Fallo al limpiar el proyecto
    pause
    exit /b 1
)

echo.
echo [2/3] Descargando e instalando dependencias...
echo (Esto puede tardar varios minutos)
call mvn dependency:resolve dependency:resolve-plugins -U
if %errorlevel% neq 0 (
    echo [ERROR] Fallo al descargar dependencias
    pause
    exit /b 1
)

echo.
echo [3/3] Compilando el proyecto...
call mvn compile test-compile
if %errorlevel% neq 0 (
    echo [ERROR] Fallo al compilar
    echo.
    echo Los errores de compilacion son normales si IntelliJ
    echo aun no ha sincronizado las dependencias.
    echo.
    echo SOLUCION: Abre IntelliJ y:
    echo 1. Panel Maven (lado derecho)
    echo 2. Click en el icono de Reload (refrescar)
    echo 3. Espera a que termine
    echo.
    pause
    exit /b 1
)

echo.
echo ====================================================
echo   DESCARGA COMPLETADA EXITOSAMENTE
echo ====================================================
echo.
echo Las dependencias se descargaron correctamente.
echo.
echo AHORA EN INTELLIJ:
echo 1. Abre IntelliJ IDEA
echo 2. Ve al panel Maven (lado derecho)
echo 3. Click en el icono Reload/Refresh
echo 4. Espera a que IntelliJ indexe el proyecto
echo 5. Los errores desapareceran
echo.
echo Si persisten errores en IntelliJ:
echo - File -^> Invalidate Caches -^> Invalidate and Restart
echo.
pause

