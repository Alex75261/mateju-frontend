package com.mateju.frontend.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mateju.frontend.data.LoginResponse

@Composable
fun StudentDashboard(session: LoginResponse, onLogout: () -> Unit) {
    DashboardScaffold(
        eyebrow = "ESPACIO DEL ESTUDIANTE",
        title = "¡Hola, ${session.displayName}!",
        subtitle = "Tu siguiente paso está listo.",
        onLogout = onLogout,
    ) {
        DashboardCard("Racha actual", "4 días de práctica", Color(0xFFFFF1D6))
        DashboardCard("Probabilidad y estadística", "Lección 3: distribuciones y muestras", Color(0xFFE5F7EC))
        DashboardCard("Progreso semanal", "120 XP · meta de 200 XP", Color(0xFFEAF3FF))
        Button(onClick = {}) {
            Text("Continuar lección")
        }
    }
}

@Composable
fun ProfessorDashboard(session: LoginResponse, onLogout: () -> Unit) {
    DashboardScaffold(
        eyebrow = "PANEL DEL DOCENTE",
        title = "Hola, ${session.displayName}",
        subtitle = "Revisa la actividad de tus grupos.",
        onLogout = onLogout,
    ) {
        DashboardCard("Cursos activos", "3 materias en seguimiento", Color(0xFFEAF3FF))
        DashboardCard("Actividad hoy", "28 estudiantes completaron una práctica", Color(0xFFE5F7EC))
        DashboardCard("Por revisar", "8 respuestas abiertas", Color(0xFFFFF1D6))
        Button(onClick = {}) {
            Text("Ver grupos")
        }
    }
}

@Composable
fun AdminDashboard(session: LoginResponse, onLogout: () -> Unit) {
    DashboardScaffold(
        eyebrow = "ADMINISTRACIÓN",
        title = "Bienvenida, ${session.displayName}",
        subtitle = "Resumen operativo de Mateju.",
        onLogout = onLogout,
    ) {
        DashboardCard("Usuarios", "146 cuentas activas", Color(0xFFE5F7EC))
        DashboardCard("Materias", "12 rutas de aprendizaje disponibles", Color(0xFFEAF3FF))
        DashboardCard("Solicitudes", "3 revisiones pendientes", Color(0xFFFFF1D6))
        Button(onClick = {}) {
            Text("Gestionar catálogo")
        }
    }
}

@Composable
private fun DashboardScaffold(
    eyebrow: String,
    title: String,
    subtitle: String,
    onLogout: () -> Unit,
    body: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = "mateju",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF168A4A),
        )
        Text(text = eyebrow, style = MaterialTheme.typography.labelLarge, color = Color(0xFF168A4A))
        Text(text = title, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Text(text = subtitle, style = MaterialTheme.typography.bodyLarge)
        body()
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Button(onClick = onLogout) {
                Text("Cerrar sesión")
            }
        }
    }
}

@Composable
private fun DashboardCard(title: String, detail: String, color: Color) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = color),
    ) {
        Column(modifier = Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(text = title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text(text = detail, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
