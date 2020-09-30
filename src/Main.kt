val manager = DigitalHouseManager()

fun main() {
    menuPrincipal()
}

fun menuPrincipal() {
    do {
        println("--- MENU PRINCIPAL ---")
        println(
            "1- Cursos \n" +
                    "2- Professores \n" +
                    "3- Alunos \n" +
                    "0 - Sair"
        )
        print("Digite: ")
        val opcao = readLine()!!.toInt()
        when (opcao) {
            1 -> menuCursos()
            2 -> menuProfessores()
            3 -> menuAlunos()
            0 -> break
            else -> println("Opção inválida!")
        }
    } while (true)
}

fun menuCursos() {
    do {
        println("--- MENU DE CURSOS ---")
        println(
            "1- Cadastrar curso \n" +
                    "2- Excluir curso \n" +
                    "3- Listar cursos \n" +
                    "4- Alocar professor\n" +
                    "5- Matricular aluno \n" +
                    "0- Voltar ao menu inicial"
        )
        print("Digite: ")
        val opcao = readLine()!!.toInt()

        when (opcao) {
            1 -> {
                print("Informe o codigo do curso: ")
                val id = readLine()!!.toInt()

                print("Informe o nome do curso: ")
                val nome = readLine()!!

                print("Informe a quantidade máxima de alunos permitidos no curso: ")
                val qtdMaxAlunos = readLine()!!.toInt()

                manager.registrarCurso(id, nome, qtdMaxAlunos)
            }
            2 -> {
                print("Digite o id do curso que será deletado, ou digite -1 para cancelar:")
                val id = readLine()!!.toInt()

                if (id < 0) continue

                manager.excluirCurso(id)
            }
            3 -> {
                manager.listaCursos.forEach {
                    println(it)
                }
            }
            4 -> {
                print("Informe o código do curso: ")
                val idCurso = readLine()!!.toInt()

                print("Informe o código do professor titular: ")
                val idTitular = readLine()!!.toInt()

                print("Informe o código do professor adjunto: ")
                val idAdjunto = readLine()!!.toInt()

                manager.alocarProfessores(idCurso, idTitular, idAdjunto)
            }
            5 -> {
                print("Informe o código do curso: ")
                val idCurso = readLine()!!.toInt()

                print("Informe o código do aluno: ")
                val idAluno = readLine()!!.toInt()

                manager.matricularAluno(idAluno, idCurso)
            }
            0 -> break
            else -> println("Opção inválida!")

        }
    } while (true)
}

fun menuProfessores() {
    do {
        println("--- MENU DOS PROFESSORES ---")
        println(
            "1- Cadastrar professor adjunto\n" +
                    "2- Cadastrar professor titular\n" +
                    "3- Excluir professor\n" +
                    "4- Listar professores\n" +
                    "0- Voltar ao menu inicial"
        )

        print("Digite: ")
        when (readLine()!!.toInt()) {
            1 -> {
                print("Informe o código do professor: ")
                val id = readLine()!!.toInt()

                print("Informe o nome do professor: ")
                val nome = readLine()!!

                print("Informe o sobrenome do professor: ")
                val sobrenome = readLine()!!

                print("Informe a quantidade de horas do professor: ")
                val qtdHoras = readLine()!!.toInt()

                manager.registrarProfessorAdjunto(id, nome, sobrenome, qtdHoras)
            }
            2 -> {
                print("Informe o código do professor: ")
                val id = readLine()!!.toInt()

                print("Informe o nome do professor: ")
                val nome = readLine()!!

                print("Informe o sobrenome do professor: ")
                val sobrenome = readLine()!!

                print("Informe a especialidade do professor: ")
                val especialidade = readLine()!!

                manager.registrarProfessorTitular(id, nome, sobrenome, especialidade)
            }
            3 -> {
                print("Informe o código do professor, ou -1 para cancelar: ")
                val id = readLine()!!.toInt()

                if (id < 0) continue
                manager.excluirProfessor(id)
            }
            4 -> {
                manager.listaProfessores.forEach {
                    println(it)
                }            }
            0 -> break

            else -> println("Opção inválida!")
        }
    } while (true)
}

fun menuAlunos() {
    do {
        println("--- MENU DOS ALUNOS ---")
        println(
            "1- Registrar um novo aluno \n" +
                    "2 - Listar alunos \n" +
                    "0 - Voltar ao menu inicial"
        )

        print("Digite: ")
        val opcao = readLine()!!.toInt()

        when (opcao) {
            1 -> {
                print("Informe o codigo do aluno: ")
                val id = readLine()!!.toInt()

                print("Informe o nome do aluno: ")
                val nome = readLine()!!

                print("Informe o sobrenome do aluno: ")
                val sobrenome = readLine()!!

                manager.registrarAluno(id, nome, sobrenome)
            }
            2 -> {
                manager.listaAlunos.forEach {
                    println(it)
                }            }
            0 -> break
            else -> println("Opção inválida!")
        }
    } while (true)
}