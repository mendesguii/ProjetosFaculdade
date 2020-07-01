import requests
import urllib.parse
import json
customersids = []
total =    []
contries = ['Brazil','USA','Canada','France']
enderecos = {
    'Brazil':'Av. José de Souza Campos, 44, Campinas - SP',
    'USA':'213 Madison St, New York - NY',
    'Canada':'385 Ontario St, St. Catharines, ON',
    'France':'282 Avenue Daumesnil, Paris'
}
origem = {"Latitude": 0, "Longitude": 0}
destino = {"Latitude": 0, "Longitude": 0}
api = "http://127.0.0.1:8080"

def GetLL(endereco, dict):
    api = "https://geocoder.ls.hereapi.com/search/6.2/geocode.json?"
    apiKey = 'buYDktleGBznSEBx5P1II2_aur8jb6Vv2Ia40sS5HZE'
    url = api + urllib.parse.urlencode({"apiKey": apiKey, "searchtext": endereco})
    dados = requests.get(url).json()
    dict['Latitude'] = dados['Response']['View'][0]['Result'][0]['Location']['NavigationPosition'][0]['Latitude']
    dict['Longitude'] = dados['Response']['View'][0]['Result'][0]['Location']['NavigationPosition'][0]['Longitude']

def GetRoute(origem,destino):
    api = "https://router.hereapi.com/v8/routes?"
    apiKey = 'buYDktleGBznSEBx5P1II2_aur8jb6Vv2Ia40sS5HZE'
    origin = str(origem['Latitude'])+','+str(origem['Longitude'])
    destination = str(destino['Latitude'])+','+str(destino['Longitude'])
    url = api + urllib.parse.urlencode({"apiKey": apiKey, "transportMode": 'car','origin': origin, 'destination': destination,'return':'summary'})
    dados = requests.get(url).json()
    duration = dados['routes'][0]['sections'][0]['summary']['duration']
    length = dados['routes'][0]['sections'][0]['summary']['length']
    baseDuration = dados['routes'][0]['sections'][0]['summary']['baseDuration']
    print('Distância: '+str(round(length/1000,2)).replace('.',',') +'km')
    print('Preço total do envio: U$'+str(round(((length/1000) * 0.01),2)))

def getCliente():
    global total,customersids,origem,destino
    for country in contries:
        print('=========== '+country+' ===========')
        customers=requests.get(api+'/lista_clientes/'+country).json()
        for customer in customers:
           customersids.append(customer['CustomerId'])
           invoices = requests.get(api+'/lista_pedidos/'+str(customer['CustomerId'])).json()
           for invoice in invoices:
               valores = requests.get(api+'/get_valor/'+str(invoice['invoiceid'])).json()
               for valor in valores:
                if len(customersids) != len(total):
                    total.append(valor['total'])
                else:
                   total[customersids.index(customer['CustomerId'])] += valor['total']
        ##### FIM PAIS  ##### 
        for cs in customers:
            if cs['CustomerId'] == customersids[total.index(max(total))]:
                print('Nome: '+cs['FirstName'] +' '+ cs['LastName'])
                print('Total Gasto: $'+str(round(max(total),2)))
                addr= cs['Address'] +' '+ cs['City'] + ' '+ cs['Country']
                print('End: '+addr)
                GetLL(addr,destino)
                GetLL(enderecos[country],origem)
                GetRoute(origem,destino)
        customersids.clear()
        total.clear()
                
                        


def main():
    getCliente()




if __name__ == '__main__':
    main()
