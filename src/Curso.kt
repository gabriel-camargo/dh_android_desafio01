class Curso(
    val id: Int,
    val nome: String,
    val qtdMaxAlunos: Int
){
    val alunosMatriculados = mutableListOf<Aluno>()
    var professorTitular: ProfessorTitular? = null
    var professorAdjunto: ProfessorAdjunto? = null

    fun adicionarAluno(aluno: Aluno): Boolean{
        if(this.alunosMatriculados.size >= this.qtdMaxAlunos) {
            return false
        }

        this.alunosMatriculados.add(aluno)
        return true
    }

    fun excluirAluno(aluno: Aluno) {
        this.alunosMatriculados.remove(aluno)
    }
}