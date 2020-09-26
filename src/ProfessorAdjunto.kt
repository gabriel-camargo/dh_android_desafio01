class ProfessorAdjunto(
    id: Int,
    nome: String,
    sobrenome: String,
    private val qtdHorasMonitoria: Int
) : Professor(id, nome, sobrenome) {
}