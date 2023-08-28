from os import system
import re
import subprocess

def metodo_Mat(expresion):
    expresion = expresion.strip()
    operadores = r"[\=\+\-\*\/]+"
    partes = re.split(operadores, expresion)
    if len(partes) >= 3:
        partes2 = re.split(r"[\(\)\s]+", partes[0])
        if partes2[0] != 'int' and partes2[0] != 'for' and partes2[0] != 'float' and partes2[0] != 'char':
            return True
    return False


def tripetos(linea):
    print("------------------")
    partes = []
    operadores = ['/', '*', '-', '+']
    numero = 1
    myFile = open('Tripetos.txt', 'a')
    for i in range(len(operadores)):
        for j in range(len(linea)):
            if linea[j] == operadores[i]:
                print(operadores[i])
                print("Aux" + str(numero) + "=" + str(linea[j - 1]) + str(operadores[i]) + str(linea[j + 1]))
                myFile.write("Aux" + str(numero) + "=" + str(linea[j - 1]) + str(operadores[i]) + str(linea[j + 1])+"\n")
                numero = numero + 1

def ejecutar_archivo_c(archivo_c):
    comando_compilacion = ['gcc', archivo_c, '-o', 'compilacion']
    proceso_compilacion = subprocess.run(comando_compilacion, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    
    if proceso_compilacion.returncode != 0:
        print('Error de compilacion:')
        print(proceso_compilacion.stderr.decode('utf-8'))
        return
    
    proceso_ejecucion = subprocess.run('./compilacion', stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    
    salida = proceso_ejecucion.stdout.decode('utf-8')
    errores = proceso_ejecucion.stderr.decode('utf-8')
    
    if salida:
        print('\n\n\nEjecucion:')
        print(salida)
    
    if errores:
        print('Errores de ejecución:')
        print(errores)

def traducir_triplo_a_instruccion(triplet):
    if triplet == "+":#Suma
        instruccion = "ADD"
    elif triplet == "-":#Resta
        instruccion = "SUB"
    elif triplet == "*":#Multiplicacion
        instruccion = "MUL"
    elif triplet == "/":#Division
        instruccion = "DIV"

    else:
        instruccion = ""  
    return instruccion

def translate_mnemonicos(line):
    partes = []
    operadores = ['/', '*', '-', '+']
    numero = 1

    expresion = line.strip()
    operadores = r"[\=\+\-\*\/]+"
    partes = re.split(operadores, expresion)
    print(line)

    text =""
    
    text = partes[0]+"="+partes[1]

    for i in range(len(operadores)):
        for j in range(len(expresion)):
            if expresion[j] == operadores[i]:
                aux = traducir_triplo_a_instruccion(expresion[j])
                text2 = text + aux + partes[2]
    
    return text2


system("javac CompiladorC.java")
system("java CompiladorC")

with open("CodigoErrores.txt", "w") as file:
    file.write("")

aux = open('Tripetos.txt', 'w')
aux.write("")
aux.close()


with open("CodigoLimpio.txt") as code:
    for linea in code:
        if metodo_Mat(linea) == True:
            aux2 = open('Tripetos.txt', 'a')
            linea = linea.strip()
            print("\n")
            print("------------------")
            print("Expresion a evaluar: " + linea)
            tripetos(linea)
            aux2.write("\n----------------------------------------------------------------\n")

aux = open('Mneomicos.txt', 'w')
aux.write("")
aux.close()

with open("Tripetos.txt", "r") as trip:
    for line in trip:
        mnemonico = open("Mneomicos.txt","a")
        if metodo_Mat(line) == True:
            print("---->"+line)
            
            r = translate_mnemonicos(line)+"\n"
            mnemonico.write(r)

archivo_c = "prueba.c"
ejecutar_archivo_c(archivo_c)