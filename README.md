# SmartInfra FloodAlert

## Descrição do Projeto

O **SmartInfra FloodAlert** é uma aplicação Java desenvolvida como proposta para o tema **SmartInfra — Plataforma Inteligente de Serviços e Infraestrutura**, alinhada ao **ODS 9 — Indústria, Inovação e Infraestrutura**.

O sistema simula uma plataforma inteligente de monitoramento de enchentes, utilizando sensores para acompanhar o nível da água e o volume de chuva em regiões urbanas. A partir das medições cadastradas pelo usuário, o sistema identifica o nível de risco e permite a emissão de alertas.

A proposta representa uma solução tecnológica aplicada a um problema real: o monitoramento de áreas vulneráveis a enchentes e desastres naturais.

---

## Objetivo

O objetivo do projeto é desenvolver uma aplicação em Java que utilize os principais conceitos de **Programação Orientada a Objetos**, simulando uma solução de infraestrutura inteligente.

O sistema permite:

* cadastrar sensores de água;
* cadastrar sensores de chuva;
* registrar medições;
* consultar sensores cadastrados;
* verificar o nível de risco;
* emitir alertas operacionais.

---

## Relação com o ODS 9

O projeto está relacionado ao **ODS 9 — Indústria, Inovação e Infraestrutura**, pois propõe uma solução baseada em tecnologia, automação e sistemas digitais para melhorar o monitoramento da infraestrutura urbana.

A aplicação utiliza sensores simulados e alertas para apoiar a tomada de decisão em situações de risco, contribuindo para cidades mais inteligentes, seguras e preparadas.

---

## Tecnologias Utilizadas

* Java
* Programação Orientada a Objetos
* Scanner para interação com o usuário
* Organização em pacotes
* Git e GitHub

---

## Estrutura do Projeto

```text
src/
├── app
│   └── Main.java
├── abstracts
│   └── Sensor.java
├── interfaces
│   ├── Monitoravel.java
│   └── Notificavel.java
├── model
│   ├── Alerta.java
│   ├── SensorAgua.java
│   └── SensorChuva.java
├── service
│   └── SistemaMonitoramento.java
└── util
    └── NivelRisco.java
```

---

## Principais Classes

### Sensor

Classe abstrata que representa um sensor genérico do sistema.

Ela possui atributos comuns, como:

* id;
* localização;
* status ativo.

As classes `SensorAgua` e `SensorChuva` herdam dessa classe.

---

### SensorAgua

Classe responsável por representar sensores que monitoram o nível da água.

Ela registra medições em centímetros e calcula o nível de risco com base no valor informado.

---

### SensorChuva

Classe responsável por representar sensores que monitoram o volume de chuva.

Ela registra medições em milímetros e calcula o nível de risco com base no volume registrado.

---

### Alerta

Classe responsável por representar os alertas do sistema.

Ela implementa a interface `Notificavel` e permite o envio de notificações com base no nível de risco.

---

### SistemaMonitoramento

Classe de serviço responsável por gerenciar os sensores cadastrados.

Ela permite:

* adicionar sensores;
* listar sensores;
* buscar sensor por ID.

---

### NivelRisco

Enum utilizado para padronizar os níveis de risco do sistema.

Os níveis disponíveis são:

* BAIXO;
* MODERADO;
* ALTO;
* EMERGENCIA.

---

## Conceitos de Programação Orientada a Objetos Utilizados

### Encapsulamento

Os atributos das classes são privados e acessados por métodos públicos, como getters e setters.

Exemplo:

```java
private int id;
private String localizacao;
```

---

### Herança

As classes `SensorAgua` e `SensorChuva` herdam da classe abstrata `Sensor`.

Exemplo:

```java
public class SensorAgua extends Sensor
```

---

### Classe Abstrata

A classe `Sensor` é abstrata e representa um conceito geral de sensor.

Ela possui o método abstrato:

```java
public abstract void exibirDados();
```

---

### Interface

O projeto utiliza interfaces para representar comportamentos.

Interfaces utilizadas:

```java
Monitoravel
Notificavel
```

---

### Sobrescrita de Métodos

O projeto utiliza sobrescrita de métodos com `@Override`.

Exemplo:

```java
@Override
public void exibirDados()
```

---

### Sobrecarga de Métodos

A classe `Alerta` possui sobrecarga no método `enviarNotificacao`.

Exemplo:

```java
public void enviarNotificacao()

public void enviarNotificacao(String destinatario)
```

---

## Funcionalidades do Sistema

Ao executar o sistema, o usuário pode acessar um menu no console com as seguintes opções:

```text
1 - Cadastrar sensor de água
2 - Cadastrar sensor de chuva
3 - Registrar medição
4 - Listar sensores
5 - Emitir alerta
0 - Encerrar
```

---

## Como Executar o Projeto

1. Abra o projeto em uma IDE Java, como IntelliJ IDEA, Eclipse ou VS Code.

2. Verifique se o JDK está instalado corretamente.

3. Execute a classe principal:

```text
Main.java
```

Localizada no pacote:

```text
src/app
```

4. Utilize o menu exibido no console para interagir com o sistema.

---

## Exemplo de Uso

```text
=== SmartInfra FloodAlert ===
1 - Cadastrar sensor de água
2 - Cadastrar sensor de chuva
3 - Registrar medição
4 - Listar sensores
5 - Emitir alerta
0 - Encerrar
Escolha uma opção: 1

ID do sensor: 101
Localização: Zona Norte
Sensor de água cadastrado com sucesso.
```

Depois, o usuário pode registrar uma medição:

```text
Informe o ID do sensor: 101
Digite o valor da medição: 85
Medição registrada.
Status: Risco alto
```

---

## Justificativa Técnica

O SmartInfra FloodAlert foi desenvolvido com foco na aplicação prática dos conceitos de Programação Orientada a Objetos.

A classe abstrata `Sensor` permite reutilizar atributos e comportamentos comuns entre diferentes tipos de sensores. As classes `SensorAgua` e `SensorChuva` especializam esse comportamento por meio de herança e sobrescrita de métodos.

As interfaces `Monitoravel` e `Notificavel` tornam o sistema mais organizado, pois representam comportamentos específicos que podem ser implementados por diferentes classes.

O uso do enum `NivelRisco` melhora a padronização dos dados, evitando erros de digitação e facilitando a manutenção do código.

---

## Integrantes

* Nome: Bruno Bagattini RM: 562863
* Nome: Nathalia Cordeiro RM: 563072
* Nome: Pedro Henrique RM: 563281
* Nome: Rafael Felix RM: 565855
* Nome: Matheus Brasil RM: 561456

---

## Conclusão

O projeto SmartInfra FloodAlert demonstra como a tecnologia pode ser aplicada ao monitoramento de infraestrutura urbana, contribuindo para soluções mais inteligentes, automatizadas e conectadas.

Além disso, o sistema atende aos requisitos de modelagem orientada a objetos, utilizando classes, encapsulamento, herança, classe abstrata, interfaces, sobrescrita, sobrecarga e interação com o usuário.
