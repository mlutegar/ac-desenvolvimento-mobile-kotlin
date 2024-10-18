// Nome: Michel Lutegar D'Orsi Pereira
// Matrícula: 202208385192

/*
DESCRIÇÃO
Objetivo:
Neste trabalho prático, você irá desenvolver um sistema simples para gerenciar heróis, suas habilidades e
suas equipes. O projeto abordará conceitos fundamentais de Kotlin, incluindo a declaração de variáveis
com var e val, manipulação de listas mutáveis e imutáveis, e uso de classes, herança e sobrecarga de
funções. Você terá a oportunidade de aplicar os conceitos aprendidos de maneira criativa, criando
personagens fictícios baseados no universo dos super-heróis.
Descrição do Trabalho
Você será responsável por criar um sistema que gerencie heróis e suas equipes de combate. Cada herói tem
habilidades e pode pertencer a uma equipe de super-heróis. As equipes podem ser atualizadas ao longo do
tempo, e cada herói possui características específicas que devem ser programadas.
Parte 1: Declaração de Heróis (var e val)
1. Crie dois heróis usando val (imutáveis) e um herói usando var (mutável). As características desses
heróis são:
o nome (val): o nome do herói.
o identidadeSecreta (val): nome civil do herói.
o poder (var): o poder principal que pode mudar ao longo do tempo.
o forca (var): o nível de força do herói (1 a 100), que pode ser alterado durante batalhas.
2. Faça a inicialização dos heróis e altere o poder de um deles (usando o var) ao longo do
desenvolvimento do trabalho.
Parte 2: Equipe de Super-Heróis (Listas Mutáveis e Imutáveis)
1. Crie uma classe Equipe que possui uma lista de heróis. A equipe deve ser inicializada com uma lista
imutável de 3 heróis.
2. Adicione métodos à classe Equipe para permitir:
o Adicionar um herói (a equipe cresce ao longo do tempo).
o Remover um herói (quando o herói abandona ou é substituído).
o Utilize uma lista mutável para fazer essas atualizações dinâmicas.
3. Crie uma equipe de heróis e adicione mais dois heróis à equipe usando a função de adição, além de
remover um herói em outro momento.
Parte 3: Classes e Herança
1. Crie uma classe base chamada Heroi, que contém:
o Atributos como nome, identidadeSecreta, poder e forca.
o Um método apresentar() que imprime uma breve descrição do herói (nome e poder).
o Um método lutar() que imprime "Herói lutando com poder: X", onde X é o nome do poder do
herói.
2. Crie três subclasses de heróis que herdam de Heroi:
o HeróiVoador: herói com a habilidade de voar. Sobrescreva o método lutar() para indicar que ele
está voando enquanto luta.
HeróiForça: herói que possui superforça. Sobrescreva o método lutar() para imprimir que ele usa
força bruta.
o HeróiTecnológico: herói que usa tecnologia. Sobrescreva o método lutar() para indicar que ele usa
gadgets tecnológicos.
3. Crie instâncias de cada uma dessas subclasses, utilize o método apresentar() e faça os heróis lutarem
com suas habilidades específicas.
Parte 4: Sobrecarregando Propriedades e Funções
1. Modifique a classe Heroi para incluir uma propriedade resistencia (um número de 1 a 100) e
sobrescreva nas subclasses:
o Para o HeróiForça, a resistência deve aumentar em 20% após cada luta.
o Para o HeróiVoador, a resistência diminui em 10% após cada voo.
o Para o HeróiTecnológico, a resistência é ajustada dependendo do uso dos gadgets, aumentando
em 5%.
2. Sobrescreva a função lutar() em cada subclasse para que ela também mostre o valor atual da
resistência do herói.
Requisitos
• O código deve ser escrito em Kotlin e executado sem erros.
• Cada classe e método deve estar corretamente implementado de acordo com os requisitos
especificados.
• As listas devem ser manipuladas conforme solicitado (imutáveis e mutáveis).
• A herança e a sobrecarga de métodos e propriedades devem ser devidamente aplicadas

 */

fun main() {
    // Inicializando os heróis
    val heroi1 = HeroiForca("Superman", "Clark Kent", "Super Força", 100)
    val heroi2 = HeroiTecnologico("Batman", "Bruce Wayne", "Inteligência", 50)
    var heroi3 = HeroiVoador("Mulher Maravilha", "Diana Prince", "Super Força", 90)

    // Alterando o poder do herói 3
    heroi3.poder = "Voo"

    // Inicializando a equipe
    val equipe = Equipe(listOf(heroi1, heroi2, heroi3))

    // Adicionando mais heróis à equipe
    val heroi4 = HeroiForca("Capitão América", "Steve Rogers", "Super Força", 80)
    val heroi5 = HeroiVoador("Lanterna Verde", "Hal Jordan", "Anel de Poder", 70)

    equipe.adicionarHeroi(heroi4)
    equipe.adicionarHeroi(heroi5)

    // Removendo um herói da equipe
    equipe.removerHeroi(heroi1)

    // Apresentando os heróis
    heroi1.apresentar()
    heroi2.apresentar()
    heroi3.apresentar()
    heroi4.apresentar()
    heroi5.apresentar()

    // Lutando com os heróis
    heroi1.lutar()
    heroi2.lutar()
    heroi3.lutar()
    heroi4.lutar()
    heroi5.lutar()
}

open class Heroi(val nome: String, val identidadeSecreta: String, var poder: String, var forca: Int){
    fun apresentar() {
        println("Oi, eu sou $nome e meu poder é $poder.")
    }

    open fun lutar() {
        println("Herói lutando com poder: $poder")
    }
}

class HeroiVoador(nome: String, identidadeSecreta: String, poder: String, forca: Int) : Heroi(nome, identidadeSecreta, poder, forca) {
    override fun lutar() {
        println("Herói, enquanto voa, lutando com poder: $poder")
    }
}

class HeroiForca(nome: String, identidadeSecreta: String, poder: String, forca: Int) : Heroi(nome, identidadeSecreta, poder, forca) {
    override fun lutar() {
        println("Herói, usando força bruta, lutando com poder: $poder")
    }
}

class HeroiTecnologico(nome: String, identidadeSecreta: String, poder: String, forca: Int) : Heroi(nome, identidadeSecreta, poder, forca) {
    override fun lutar() {
        println("Herói, usando gadgets tecnológicos, lutando com poder: $poder")
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
}