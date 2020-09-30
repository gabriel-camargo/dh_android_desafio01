class ProfessorAdjunto(
    id: Int,
    nome: String,
    sobrenome: String,
    private val qtdHorasMonitoria: Int
) : Professor(id, nome, sobrenome) {
    override fun toString(): String {
        return "ProfessorAdjunto(id=$id, nome='$nome', sobrenome='$sobrenome', tempoDeCasa=$tempoDeCasa, qtdHorasMonitoria=$qtdHorasMonitoria)"
    }
}