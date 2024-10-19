// Nome: Michel Lutegar D'Orsi Pereira
// Matrícula: 202208385192

fun main() {
    // PARTE 1 - DECLARAÇÃO DE HERÓIS (var e val)
    // Inicializando os heróis
    val heroi1 = Heroi("Superman", "Clark Kent", "Super Força", 100, 95)
    val heroi2 = Heroi("Batman", "Bruce Wayne", "Inteligência", 50, 80)
    var heroi3 = Heroi("Mulher Maravilha", "Diana Prince", "Super Força", 90, 95)

    // Alterando o poder do herói 3
    heroi3.poder = "Voo"

    // PARTE 2: EQUIPE DE SUPER-HERÓIS (LISTAS MUTÁVEIS E IMUTÁVEIS)
    println("Iniciando a equipe de super-heróis...")
    val equipe = Equipe(listOf(heroi1, heroi2, heroi3))
    equipe.mostrarHerois()

    // Adicionando mais heróis à equipe
    val heroi4 = Heroi("Capitão América", "Steve Rogers", "Super Força", 80, 90)
    val heroi5 = Heroi("Lanterna Verde", "Hal Jordan", "Anel de Poder", 70, 40)

    equipe.adicionarHeroi(heroi4)
    equipe.adicionarHeroi(heroi5)
    equipe.mostrarHerois()

    // Removendo um herói da equipe
    equipe.removerHeroi(heroi1)
    equipe.mostrarHerois()

    println("-----------------------------------")

    // PARTE 3: CLASSES E HERANÇA
    // Criando instâncias das subclasses de heróis
    val heroiVoador = HeroiVoador("Falcão", "Sam Wilson", "Voo", 70, 40)
    val heroiForca = HeroiForca("Hulk", "Bruce Banner", "Super Força", 90, 100)
    val heroiTecnologico = HeroiTecnologico("Homem de Ferro", "Tony Stark", "Tecnologia", 80, 20)

    // Apresentando os heróis
    println("Apresentando os heróis...")
    heroi1.apresentar()
    heroi2.apresentar()
    heroi3.apresentar()
    heroi4.apresentar()
    heroi5.apresentar()
    heroiVoador.apresentar()
    heroiForca.apresentar()
    heroiTecnologico.apresentar()

    println("-----------------------------------")
    // Lutando com os heróis
    println("Lutando com os heróis...")
    heroi1.lutar()
    heroi2.lutar()
    heroi3.lutar()
    heroi4.lutar()
    heroi5.lutar()
    heroiVoador.lutar()
    heroiForca.lutar()
    heroiTecnologico.lutar()
}

open class Heroi(val nome: String, val identidadeSecreta: String, var poder: String, var forca: Int, var resistencia: Int) {
    fun apresentar() {
        println("Oi, eu sou $nome e meu poder é $poder.")
    }

    open fun lutar() {
        println("Herói lutando com poder: $poder")
    }
}

class HeroiVoador(nome: String, identidadeSecreta: String, poder: String, forca: Int, resistencia: Int) : Heroi(nome, identidadeSecreta, poder, forca, resistencia) {
    override fun lutar() {
        println("Herói voa e luta usando o seu poder: $poder")
        resistencia -= (resistencia * 0.1).toInt()
        println("Resistência atual: $resistencia")
    }
}

class HeroiForca(nome: String, identidadeSecreta: String, poder: String, forca: Int, resistencia: Int) : Heroi(nome, identidadeSecreta, poder, forca, resistencia) {
    override fun lutar() {
        println("Herói, usando força bruta, lutando com poder: $poder")
        resistencia = (resistencia * 1.2).toInt()
        println("Resistência atual: $resistencia")
    }
}

class HeroiTecnologico(nome: String, identidadeSecreta: String, poder: String, forca: Int, resistencia: Int) : Heroi(nome, identidadeSecreta, poder, forca, resistencia) {
    override fun lutar() {
        println("Herói, usando gadgets tecnológicos, luta com o seu poder: $poder")
        resistencia = (resistencia * 1.05).toInt()
        println("Resistência atual: $resistencia")
    }
}

class Equipe(val heroisIniciais: List<Heroi>) {
    private val heroisAtuais: MutableList<Heroi> = heroisIniciais.toMutableList()

    init {
        require(heroisIniciais.size == 3) { "A equipe inicial deve ter exatamente 3 heróis." }
    }

    fun adicionarHeroi(heroi: Heroi) {
        heroisAtuais.add(heroi)
    }

    fun removerHeroi(heroi: Heroi) {
        heroisAtuais.remove(heroi)
    }

    fun mostrarHerois() {
        print("Heróis na equipe: ")
        for (heroi in heroisAtuais) {
            print("${heroi.nome}, ")
        }
        println()
    }
}