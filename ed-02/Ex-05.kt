fun main() {
    val conta = ContaBancaria("João Silva", 1000.0, 1234, "0001")
    conta.imprimirBoleto()
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