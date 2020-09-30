import kotlin.math.max

class DigitalHouseManager {
    val listaAlunos = mutableListOf<Aluno>()
    val listaProfessores = mutableListOf<Professor>()
    val listaCursos = mutableListOf<Curso>()
    val listaMatriculas = mutableListOf<Matricula>()

    fun registrarCurso(id: Int, nome: String, qtdMaxAlunos: Int) {
        this.listaCursos.add(Curso(id, nome, max(qtdMaxAlunos, 0)))

        println("Curso cadastrado com sucesso!")
    }

    fun excluirCurso(idCurso: Int) {
        val curso = listaCursos.find { it.id == idCurso }
        this.listaCursos.remove(curso)

        println("Curso removido com sucesso!")
    }

    fun registrarProfessorAdjunto(id: Int, nome: String, sobrenome: String, qtdHoras: Int) {
        this.listaProfessores.add(ProfessorAdjunto(id, nome, sobrenome, qtdHoras))

        println("Professor Adjunto cadastrado com sucesso!")
    }

    fun registrarProfessorTitular(id: Int, nome: String, sobrenome: String, especialidade: String) {
        this.listaProfessores.add(ProfessorTitular(id, nome, sobrenome, especialidade))

        println("Professor Titular cadastrado com sucesso!")

    }

    fun excluirProfessor(idProfessor: Int) {
        val professor = listaProfessores.find { idProfessor == it.id }
        this.listaProfessores.remove(professor)

        println("Professor excluído com sucesso!")
    }

    fun registrarAluno(id: Int, nome: String, sobrenome: String) {
        this.listaAlunos.add(Aluno(id, nome, sobrenome))

        println("Aluno registrado com sucesso!")
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

        if(profTitular !is ProfessorTitular?) {
            println("O código informado para o professor titular é de um professor adjunto!")

            return
        }
        if(profAdjunto !is ProfessorAdjunto?) {
            println("O código informado para o professor adjunto é de um professor titular!")

            return
        }


        this.listaCursos.find { it.id == idCurso }!!.professorAdjunto = profAdjunto
        this.listaCursos.find { it.id == idCurso }!!.professorTitular = profTitular

        println("Professores alocados com sucesso!")
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