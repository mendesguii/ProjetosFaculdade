from socket import *
from threading import Thread
import threading

userNum = []
totalPedidosUser = []
totalPedidos = 1000
mutex = threading.Lock()


def atende(conn, cliente):
    global userNum, totalPedidos, mutex, val
    conn.settimeout(10.00)
    while True:
        try:
            data = conn.recv(4096)
        except:
            break

        if data == b'':
            continue
        dadosRecebidos = data.decode("utf-8")
        if dadosRecebidos == 'FIM':
            break
        dadosRecebidos = dadosRecebidos.split('||')
        usuario = dadosRecebidos[0]
        valorTransacao = int(dadosRecebidos[1])
        mutex.acquire()

        if usuario not in userNum:
            userNum.append(usuario)
            totalPedidosUser.append(valorTransacao)
            totalPedidos -= int(valorTransacao)
            try:
                conn.send(str.encode("OK", "UTF-8"))
            except:
                break
        else:
            if totalPedidos < 100:
                try:
                    conn.send(str.encode("NOK", "UTF-8"))
                except:
                    break
                print('Consumidor       Produto')
                totalPedidos += 1000
                for user in range(len(userNum)):
                    print(userNum[user] + '                   ' + str(totalPedidosUser[int(user)]))
            else:
                totalPedidos -= int(valorTransacao)
                totalPedidosUser[userNum.index(usuario)] += valorTransacao
                try:
                    conn.send(str.encode("OK", "UTF-8"))
                except:
                    break

        print('Consumidor ' + dadosRecebidos[0] + " está solicitando " + dadosRecebidos[1] + ' produtos')
        mutex.release()
    conn.close()
    print("Fim da conexao com " + str(usuario))
    # Removendo dados dos usuarios apos sair do servidor
    idRemover = userNum.index(usuario)
    del totalPedidosUser[idRemover]
    del userNum[idRemover]


s = socket()
host = "127.0.0.1"
porta = 8792
s.bind((host, porta))
s.listen(100)

while True:
    (conn, cliente) = s.accept()
    print("Recebi a conexao de " + str(cliente))
    t = Thread(target=atende, args=(conn, cliente,))
    t.start()
