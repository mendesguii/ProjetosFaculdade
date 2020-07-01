from socket import *
import random, time
from threading import Thread

servidor = "127.0.0.1"
porta = 8792
numThreads = 0
threads =[]


def novoCliente(numClientes):
    numPedidos = 0
    s = socket()
    s.connect((servidor, porta))
    total = random.randint(100, 1000)
    totalPedidos = 0
    print('Consumidor ' + str(numClientes) + ': Pedido total é de ' + str(total) + '.')
    while totalPedidos <= total:
        pedido = int(total / 10)##pedido = int(total / random.randinit(1,10))
        if (totalPedidos + pedido >= total ):
            pedido = total - totalPedidos
            if pedido == 0: break

        stringEnvio = str(numClientes) + '||' + str(pedido)
        envDados = str.encode(stringEnvio, "UTF-8")
        s.send(envDados)
        data = s.recv(1024)
        if data.decode("utf-8") == 'OK':
            numPedidos += 1
            totalPedidos += pedido
            print('Consumidor ' + str(numClientes) + ': ' + 'Pedido ' + str(numPedidos) + ' de ' + str(
                pedido) + ' produtos realizado com sucesso.')

        time.sleep(5)
    print('Consumidor ' + str(numClientes) + ': ' + 'Todos os pedidos concluídos')
    envDados = str.encode('FIM', "UTF-8")
    s.send(envDados)
    s.close()


def Main():
    global numThreads, numClientes
    strCMD = input('Digite o numero de consumidores: ')
    numeroThread = int(strCMD)

    for i in range(numeroThread):
        print('Disparando Consumidor ' + str(i))
        threads.append(Thread(target=novoCliente, args=(i,)))
        threads[-1].start()

    for i in range(numeroThread):
        print("Aguardando thread " + str(i))
        threads[i].join()




Main()