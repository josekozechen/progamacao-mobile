fun main(){
    var conta1 = ContaBancaria(cliente, saldo, numero, agencia)
    var conta2 = ContaBancaria(cliente, saldo, numero, agencia)

    conta1.imprimirExtrato()
    conta2.imprimirExtrato()

    conta1.depositar(7000.0)
    conta2.retirar(3000.0)

    conta1.transferir(170.0, conta2)

    conta1.imprimirExtrato()
    conta2.imprimirExtrato()

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

mantenha o mesmmo codigo so altere os nome de variaveis