abstract class Professor(
    val codigo: Int,
    protected val nome: String,
    protected val sobrenome: String
) {
    val tempoDeCasa = 0
    override fun toString(): String {
        return "Professor(id=$codigo, nome='$nome', sobrenome='$sobrenome', tempoDeCasa=$tempoDeCasa)"
    }
}