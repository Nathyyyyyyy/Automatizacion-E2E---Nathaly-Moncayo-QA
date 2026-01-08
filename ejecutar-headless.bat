@echo off
REM ====================================================
REM Script para Ejecutar Pruebas en Modo Headless
REM ====================================================

echo.
echo ============================================
echo   PRUEBAS E2E - MODO HEADLESS
echo ============================================
echo.
echo Ejecutando pruebas sin interfaz gráfica...
echo.

call mvn clean verify -Denvironments=headless

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

