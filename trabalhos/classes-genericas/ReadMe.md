# Projeto 2 | Generics e Coleções 

**Data de entrega:** 19/10/2025

Você receberá uma classe Repositorio implementada de forma simples, que ainda não utiliza Generics e trabalha apenas com Object.

Sua tarefa será transformar essa classe em uma classe genérica Repositorio<T>, aplicando corretamente o conceito de Generics e utilizando coleções (ArrayList e/ou HashMap) para armazenar os dados.

## Requisitos mínimos:
- Criar a classe genérica Repositorio<T> com os métodos:
	- void adicionar(T obj)
	- void remover(T obj)
	- T buscar(String chave)
- Utilizar coleções (ArrayList<T> ou HashMap<String, T>) na implementação.
- Testar a classe com pelo menos dois tipos diferentes:
	- String
	- Uma classe Aluno (já fornecida).
- Demonstrar os testes em uma classe Main, exibindo os resultados no console.

## Critérios de Avaliação 
- 0,25 pt → Definiu corretamente class Repositorio<T> e aplicou Generics.
- 0,25 pt → Implementou adicionar e remover corretamente usando coleções.
- 0,25 pt → Implementou buscar(String chave) de forma funcional.
- 0,25 pt → Testou com String e com Aluno no programa principal.