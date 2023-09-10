fun main() {
    val contas = listOf(
        Conta("João Silva", 1000.0, 1234, "0001"),
        Conta("Maria Souza", 500.0, 5678, "0001"),
        Conta("Pedro Santos", 2000.0, 2468, "0002"),
        Conta("Ana Almeida", 1500.0, 1357, "0002"),
        Conta("Carlos Oliveira", 750.0, 7890, "0003")
    )

    println("Contas em ordem crescente do menor para o maior saldo:")
    contas.sortedBy { it.saldo }.forEach {
        it.exibirExtrato()
        println()
    }

    println("Contas em ordem alfabética pelo nome do cliente:")
    contas.sortedBy { it.cliente }.forEach {
        it.exibirExtrato()
        println()
    }
}

class Conta(val cliente: String, var saldo: Double = 0.0, val numero: Int, val agencia: String) {
    
    fun depositar(valorOperacao: Double) {
        val entrada = readLine()!!.toDouble()
        saldo += entrada
    }

    fun retirar(valorOperacao: Double) {
        val entrada = readLine()!!.toDouble()
        if (saldo < entrada) {
            println("Saldo insuficiente")
        } else {
            saldo -= entrada
        }
    }

    fun transferir(valorOperacao: Double, destino: Conta) {
        val entrada = readLine()!!.toDouble()
        val numeroDestino = readLine()!!.toInt()
        if (saldo < entrada) {
            println("Saldo insuficiente")
        } else {
            saldo -= entrada
            destino.saldo += entrada
        }
    }

    fun exibirExtrato() {
        println("Extrato:")
        println("Cliente: $cliente")
        println("Agência: $agencia")
        println("Número da conta: $numero")
        println("Saldo: R$$saldo")
    }
}
