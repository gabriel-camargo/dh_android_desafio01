class ProfessorTitular(
    codigo: Int,
    nome: String,
    sobrenome: String,
    private val especialidade: String
) : Professor(codigo, nome, sobrenome) {
    override fun toString(): String {
        return "ProfessorTitular(id=$codigo, nome='$nome', sobrenome='$sobrenome', tempoDeCasa=$tempoDeCasa, especialidade='$especialidade')"
    }
}