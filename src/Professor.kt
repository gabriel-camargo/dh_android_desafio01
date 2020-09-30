abstract class Professor(
    val id: Int,
    protected val nome: String,
    protected val sobrenome: String
) {
    val tempoDeCasa = 0
    override fun toString(): String {
        return "Professor(id=$id, nome='$nome', sobrenome='$sobrenome', tempoDeCasa=$tempoDeCasa)"
    }
}