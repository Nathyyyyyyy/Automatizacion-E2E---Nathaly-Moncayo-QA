@echo off
REM ====================================================
REM Script de Ejecución de Pruebas E2E - SauceDemo
REM ====================================================

echo.
echo ============================================
echo   PRUEBAS E2E - SAUCEDEMO CON SERENITY
echo ============================================
echo.

REM Verificar Java
echo [1/4] Verificando Java...
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERROR] Java no está instalado o no está en el PATH
    echo Por favor instala Java JDK 17 o superior
    echo Descarga: https://www.oracle.com/java/technologies/downloads/
    pause
    exit /b 1
)
echo [OK] Java instalado correctamente
echo.

REM Verificar Maven
echo [2/4] Verificando Maven...
mvn -version >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERROR] Maven no está instalado o no está en el PATH
    echo Por favor instala Apache Maven 3.8 o superior
    echo Descarga: https://maven.apache.org/download.cgi
    pause
    exit /b 1
)
echo [OK] Maven instalado correctamente
echo.

REM Limpiar e instalar dependencias
echo [3/4] Instalando dependencias...
echo Esto puede tardar unos minutos en la primera ejecución...
call mvn clean install -DskipTests
if %errorlevel% neq 0 (
    echo [ERROR] Fallo al instalar dependencias
    pause
    exit /b 1
)
echo [OK] Dependencias instaladas
echo.

REM Ejecutar pruebas
echo [4/4] Ejecutando pruebas E2E...
echo.
call mvn verify
if %errorlevel% neq 0 (
    echo [ADVERTENCIA] Algunas pruebas fallaron
) else (
    echo [OK] Todas las pruebas pasaron exitosamente
)
echo.

REM Abrir reporte
echo ============================================
echo   EJECUCION COMPLETADA
echo ============================================
echo.
echo El reporte se encuentra en:
echo %cd%\target\site\serenity\index.html
echo.
set /p OPEN="¿Deseas abrir el reporte ahora? (S/N): "
if /i "%OPEN%"=="S" (
    start target\site\serenity\index.html
)

echo.
echo Presiona cualquier tecla para salir...
pause >nul

