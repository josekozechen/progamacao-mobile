fun main() {
    val conta1 = ContaBancaria("João Silva", 1000.0, 1234, "0001")
    val conta2 = ContaPoupanca("Maria Souza", 500.0, 5678, "0001")

    conta1.depositar(500.0)
    conta2.depositar(1000.0)
    conta1.retirar(200.0)
    conta2.aplicarJuros()
    conta1.transferir(300.0, conta2)

    println("Extrato da conta 1:")
    conta1.imprimirExtrato()
    println()

    println("Extrato da conta 2:")
    conta2.imprimirExtrato()
    println()
}

class ContaPoupanca(cliente: String, saldo: Double, numero: Int, agencia: String) : ContaBancaria(cliente, saldo, numero, agencia) {

    fun aplicarJuros() {
        val juros = saldo * 0.003 // 0,3% de juros ao dia
        saldo += juros
    }
}

class ContaBancaria (val cliente: String, var saldo: Double = null, var numero: Int, val agencia: Int){
        
    fun depositar(operacao: Double){
        operacao = readLine()!!.toDouble()
        saldo += operacao
    }

    fun retirar(operacao: Double){
        operacao = readLine()!!.toDouble()
        if(saldo < operacao){
            println("Saldo insuficiente")
        } else{
            saldo -= operacao
        }
    }

    fun transferir(operacao: Double, numero.saldo: ContaBancaria){
        operacao = readLine()!!.toDouble()
        numero = readLine()!!.toInt()
        if (saldo < operacao){
            println("Saldo insuficiente")
        } else{
            saldo -= operacao
            numero.saldo += operacao
        }
    }

    fun imprimirExtrato(){
        println("Extrato:")
        println("Cliente: $cliente")
        println("Agência: $agencia")
        println("Número da conta: $numero")
        println("Saldo: R$$saldo")
    }
}