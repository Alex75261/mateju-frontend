# Mateju frontend

Frontend de la primera entrega de Mateju, construido con Kotlin Multiplatform y Compose Multiplatform.

## Incluye

- Pantalla de inicio de sesión.
- Navegación por roles: `STUDENT`, `PROFESSOR` y `ADMIN`.
- Cliente Ktor para consumir el backend local.
- Código compartido para Android y escritorio en `composeApp/src/commonMain`.

## Ejecutar en escritorio

Con el backend iniciado en `http://localhost:8080`, ejecutar desde esta carpeta:

```powershell
.\gradlew.bat :composeApp:run
```

Para Android, abrir esta carpeta con Android Studio y ejecutar la configuración `composeApp`. El emulador se conecta al backend de la computadora mediante `http://10.0.2.2:8080`.

## Web (WASM) y Railway

El proyecto incluye el destino `wasmJs` y el comando de distribución web es:

```powershell
.\gradlew.bat :composeApp:wasmJsBrowserDistribution
```

Railway construye ese paquete mediante el `Dockerfile` y lo sirve con Nginx. Antes de desplegar, reemplacen `https://YOUR-BACKEND.up.railway.app` en los clientes Android y WASM por el dominio HTTPS que Railway genere para el servicio backend.

Las instrucciones completas, cuentas de demostración y enlaces de entrega se encuentran en el documento de entrega compartido por el equipo.
