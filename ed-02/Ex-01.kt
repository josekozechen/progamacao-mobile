fun main() {

}

class ContaBancaria(val cliente: String, var saldo: Double = 0.0, var numero: Int, val agencia: Int) {

    fun depositar(valorOperacao: Double) {
        val operacao = readLine()!!.toDouble()
        saldo += operacao
    }

    fun retirar(valorOperacao: Double) {
        val operacao = readLine()!!.toDouble()
        if (saldo < operacao) {
            println("Saldo insuficiente")
        } else {
            saldo -= operacao
        }
    }

    fun transferir(valorOperacao: Double, destino: ContaBancaria) {
        val operacao = readLine()!!.toDouble()
        val numeroDestino = readLine()!!.toInt()
        if (saldo < operacao) {
            println("Saldo insuficiente")
        } else {
            saldo -= operacao
            destino.saldo += operacao
        }
    }

    fun imprimirExtrato() {
        println("Extrato:")
        println("Cliente: $cliente")
        println("Agência: $agencia")
        println("Número da conta: $numero")
        println("Saldo: R$$saldo")
    }
}
