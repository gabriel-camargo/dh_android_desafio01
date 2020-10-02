import kotlin.math.max

class DigitalHouseManager {
    val listaAlunos = mutableListOf<Aluno>()
    val listaProfessores = mutableListOf<Professor>()
    val listaCursos = mutableListOf<Curso>()
    val listaMatriculas = mutableListOf<Matricula>()

    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaAlunos: Int) {
        this.listaCursos.add(Curso(codigoCurso, nome, max(quantidadeMaximaAlunos, 0)))

        println("Curso cadastrado com sucesso!")
    }

    fun excluirCurso(codigoCurso: Int) {
        val curso = listaCursos.find { it.codigo == codigoCurso }
        this.listaCursos.remove(curso)

        println("Curso removido com sucesso!")
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {
        this.listaProfessores.add(ProfessorAdjunto(codigoProfessor, nome, sobrenome, quantidadeDeHoras))

        println("Professor Adjunto cadastrado com sucesso!")
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        this.listaProfessores.add(ProfessorTitular(codigoProfessor, nome, sobrenome, especialidade))

        println("Professor Titular cadastrado com sucesso!")

    }

    fun excluirProfessor(codigoProfessor: Int) {
        val professor = listaProfessores.find { codigoProfessor == it.codigo }
        this.listaProfessores.remove(professor)

        println("Professor excluído com sucesso!")
    }

    fun matricularAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        this.listaAlunos.add(Aluno(codigoAluno, nome, sobrenome))

        println("Aluno registrado com sucesso!")
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        val aluno = this.listaAlunos.find { it.codigo == codigoAluno }
        val curso = this.listaCursos.find { it.codigo == codigoCurso }

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

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {
        val profTitular = this.listaProfessores.find { it.codigo == codigoProfessorTitular }
        val profAdjunto = this.listaProfessores.find { it.codigo == codigoProfessorAdjunto }

        if (profTitular !is ProfessorTitular?) {
            println("O código informado para o professor titular é de um professor adjunto!")

            return
        }
        if (profAdjunto !is ProfessorAdjunto?) {
            println("O código informado para o professor adjunto é de um professor titular!")

            return
        }


        this.listaCursos.find { it.codigo == codigoCurso }!!.professorAdjunto = profAdjunto
        this.listaCursos.find { it.codigo == codigoCurso }!!.professorTitular = profTitular

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