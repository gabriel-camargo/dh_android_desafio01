class ProfessorAdjunto(
    codigo: Int,
    nome: String,
    sobrenome: String,
    private val qtdHorasMonitoria: Int
) : Professor(codigo, nome, sobrenome) {
    override fun toString(): String {
        return "ProfessorAdjunto(id=$codigo, nome='$nome', sobrenome='$sobrenome', tempoDeCasa=$tempoDeCasa, qtdHorasMonitoria=$qtdHorasMonitoria)"
    }
}