@echo off
REM ====================================================
REM Script para Ejecutar una Sola Prueba Específica
REM ====================================================

echo.
echo ============================================
echo   EJECUTAR PRUEBA ESPECIFICA
echo ============================================
echo.

echo Selecciona la prueba a ejecutar:
echo.
echo 1. Flujo Completo E2E
echo 2. Validar Autenticacion
echo 3. Agregar Productos al Carrito
echo 4. Visualizar Carrito
echo 5. Ejecutar Todas
echo.

set /p OPCION="Ingresa el número (1-5): "

if "%OPCION%"=="1" (
    set TEST=completarFlujoDeCompraE2E
) else if "%OPCION%"=="2" (
    set TEST=validarAutenticacionExitosa
) else if "%OPCION%"=="3" (
    set TEST=agregarProductosAlCarrito
) else if "%OPCION%"=="4" (
    set TEST=visualizarCarrito
) else if "%OPCION%"=="5" (
    echo.
    echo Ejecutando todas las pruebas...
    call mvn clean verify
    goto :REPORT
) else (
    echo Opción inválida
    pause
    exit /b 1
)

echo.
echo Ejecutando prueba: %TEST%
echo.
call mvn clean verify -Dtest=SauceDemoPurchaseFlowTest#%TEST%

:REPORT
echo.
echo ============================================
echo   EJECUCION COMPLETADA
echo ============================================
echo.
set /p OPEN="¿Deseas abrir el reporte? (S/N): "
if /i "%OPEN%"=="S" (
    start target\site\serenity\index.html
)

pause

