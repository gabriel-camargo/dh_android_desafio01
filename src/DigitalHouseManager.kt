class DigitalHouseManager {
    private val listaAlunos = mutableListOf<Aluno>()
    private val listaProfessores = mutableListOf<Professor>()
    private val listaCursos = mutableListOf<Curso>()
    private val listaMatriculas = mutableListOf<Matricula>()

    fun registrarCurso(id: Int, nome: String, qtdMaxAlunos: Int) {
        this.listaCursos.add(Curso(id, nome, qtdMaxAlunos))
    }

    fun excluirCurso(idCurso: Int) {
        val curso = listaCursos.find { it.id == idCurso }
        this.listaCursos.remove(curso)
    }

    fun registrarProfessorAdjunto(id: Int, nome: String, sobrenome: String, qtdHoras: Int) {
        this.listaProfessores.add(ProfessorAdjunto(id, nome, sobrenome, qtdHoras))
    }

    fun registrarProfessorTitular(id: Int, nome: String, sobrenome: String, especialidade: String) {
        this.listaProfessores.add(ProfessorTitular(id, nome, sobrenome, especialidade))
    }

    fun excluirProfessor(idProfessor: Int) {
        val professor = listaProfessores.find { it.id === idProfessor }
        this.listaProfessores.remove(professor)
    }

    fun registrarAluno(id: Int, nome: String, sobrenome: String) {
        this.listaAlunos.add(Aluno(id, nome, sobrenome))
    }

    fun matricularAluno(idAluno: Int, idCurso: Int) {
        val aluno = this.listaAlunos.find { it.id == idAluno }
        val curso = this.listaCursos.find { it.id == idCurso }

        if (curso != null) {
            if (aluno != null) {
                val matriculou = curso.adicionarAluno(aluno)
                if (matriculou) {
                    this.listaMatriculas.add(Matricula(aluno, curso))
                    println("Matricúla realizada com sucesso!")
                } else {
                    println("Este curso atingiu o limite de vagas :/")
                }
            } else {
                println("Aluno não encontrado.")
            }
        } else {
            println("Curso não encontrado.")
        }
    }

    fun alocarProfessores(idCurso: Int, idTitular: Int, idAdjunto: Int) {
        val profTitular = this.listaProfessores.find { it.id == idTitular }
        val profAdjunto = this.listaProfessores.find { it.id == idAdjunto }

        this.listaCursos.find { it.id == idCurso }!!.professorAdjunto = profAdjunto as ProfessorAdjunto?
        this.listaCursos.find { it.id == idCurso }!!.professorTitular = profTitular as ProfessorTitular?
    }

    override fun toString(): String {
        return "DigitalHouseManager( \n " +
                "listaAlunos=$listaAlunos, \n " +
                "listaProfessores=$listaProfessores, \n " +
                "listaCursos=$listaCursos, \n " +
                " listaMatriculas=$listaMatriculas \n " +
                ")"
    }
}