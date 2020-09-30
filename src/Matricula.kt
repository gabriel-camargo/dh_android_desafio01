import java.time.LocalDateTime

data class Matricula(private val aluno: Aluno, private val curso: Curso) {
    private val date = LocalDateTime.now()
}