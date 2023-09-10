// Definição da interface Extrato
interface Extrato {
    fun imprimirExtrato()
}

// Classe abstrata Conta implementando a interface Extrato
abstract class Conta(val cliente: String, var saldo: Double, val numero: String, val agencia: String) : Extrato {
    abstract fun depositar(valor: Double)
    abstract fun retirar(valor: Double)
    abstract fun transferir(contaDestino: Conta, valor: Double)
}

// Classe ContaPoupanca que herda de Conta
class ContaPoupanca(cliente: String, saldo: Double, numero: String, agencia: String) : Conta(cliente, saldo, numero, agencia) {
    fun aplicarJuros(dias: Int) {
        val juros = saldo * 0.003 * dias // 0.3% de juros ao dia
        saldo += juros
    }

    override fun depositar(valor: Double) {
        saldo += valor
    }

    override fun retirar(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        } else {
            println("Saldo insuficiente.")
        }
    }

    override fun transferir(contaDestino: Conta, valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
            contaDestino.depositar(valor)
        } else {
            println("Saldo insuficiente.")
        }
    }

    override fun imprimirExtrato() {
        println("** Conta Poupança **")
        println("Conta/Agencia..: $numero/$agencia")
        println("Cliente........: $cliente")
        println("Saldo..........: R$ $saldo")
    }
}

// Classe ContaCorrente que herda de Conta
class ContaCorrente(cliente: String, saldo: Double, numero: String, agencia: String) : Conta(cliente, saldo, numero, agencia) {
    fun aplicarJuros() {
        val juros = saldo * 0.008 // 0.8% de juros ao dia
        saldo += juros
    }

    override fun depositar(valor: Double) {
        saldo += valor
    }

    override fun retirar(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        } else {
            println("Saldo insuficiente.")
        }
    }

    override fun transferir(contaDestino: Conta, valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
            contaDestino.depositar(valor)
        } else {
            println("Saldo insuficiente.")
        }
    }

    override fun imprimirExtrato() {
        println("== Conta Corrente ==")
        println("Conta/Agencia..: $numero/$agencia")
        println("Cliente........: $cliente")
        println("Saldo..........: R$ $saldo")
    }
}

fun main() {
    val contaCorrente1 = ContaCorrente("Cliente1", 2000.0, "123456", "001")
    val contaCorrente2 = ContaCorrente("Cliente2", 3000.0, "654321", "001")
    val contaPoupanca = ContaPoupanca("Cliente3", 2000.0, "789012", "001")

    val contas: List<Extrato> = listOf(contaCorrente1, contaCorrente2, contaPoupanca)

    for (conta in contas) {
        conta.imprimirExtrato()
        println()
    }
}