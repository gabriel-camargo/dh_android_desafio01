class ProfessorTitular(
    id: Int,
    nome: String,
    sobrenome: String,
    private val especialidade: String
) : Professor(id, nome, sobrenome) {
    override fun toString(): String {
        return "ProfessorTitular(id=$id, nome='$nome', sobrenome='$sobrenome', tempoDeCasa=$tempoDeCasa, especialidade='$especialidade')"
    }
}