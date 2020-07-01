import mysql.connector
from flask import Flask
import json
from flask_jsonpify import jsonify

app = Flask(__name__) # __name__ variável do sistema que indica o nome do módulo ou 'main'

@app.route("/lista_clientes/<pais>")
def lista_clientes(pais=None):
    conn = mysql.connector.connect(host = 'bd-sd2020-1.ckqus7r6k11l.us-east-1.rds.amazonaws.com',user='admin',passwd='gui123456',port='3306',database='chinook')
    cursor = conn.cursor()
    qstr = "select * from customers where country =\'"+pais+"\'"
    query = cursor.execute(qstr)
    row_headers=[x[0] for x in cursor.description]
    records = cursor.fetchall()
    result = [dict(zip(tuple (row_headers) ,i)) for i in records]
    jret = jsonify(result)
    conn.close()
    return jret
    
@app.route("/lista_pedidos/<id>")
def lista_pedidos (id=None):
    conn = mysql.connector.connect(host = 'bd-sd2020-1.ckqus7r6k11l.us-east-1.rds.amazonaws.com',user='admin',passwd='gui123456',port='3306',database='chinook')
    cursor = conn.cursor()
    qstr = "select invoiceid from invoices where customerid =\'"+id+"\'"
    query = cursor.execute(qstr)
    row_headers=[x[0] for x in cursor.description]
    records = cursor.fetchall()
    result = [dict(zip(tuple (row_headers) ,i)) for i in records]
    jret = jsonify(result)
    conn.close()
    return jret

@app.route("/get_valor/<id>")
def get_valor (id=None):
    conn = mysql.connector.connect(host = 'bd-sd2020-1.ckqus7r6k11l.us-east-1.rds.amazonaws.com',user='admin',passwd='gui123456',port='3306',database='chinook')
    cursor = conn.cursor()
    qstr = "select total from invoices where invoiceid=\'"+id+"\'"
    query = cursor.execute(qstr)
    row_headers=[x[0] for x in cursor.description]
    records = cursor.fetchall()
    result = [dict(zip(tuple (row_headers) ,i)) for i in records]
    jret = jsonify(result)
    conn.close()
    return jret
    


app.run(port='8080')