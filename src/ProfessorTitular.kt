class ProfessorTitular(
    id: Int,
    nome: String,
    sobrenome: String,
    private val especialidade: String
) : Professor(id, nome, sobrenome) {
}