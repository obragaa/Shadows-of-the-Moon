
# Shadows of the Moon 🕵️🌔

## 🧑‍💻 **Integrantes do Projeto**

- **Nome:** Felipe Braga Duarte — **RA:** 1252322416
- **Nome:** Gabriel Ribeiro Marques Pedroso — **RA:** 12523210106
---

## 📝 **Descrição do Projeto**

**Shadows of the Moon** é um jogo de investigação em Java onde você assume o papel de um detetive em uma estação lunar. Sua missão é explorar cenários, coletar pistas, interrogar suspeitos e descobrir o assassino.

Este projeto foi desenvolvido para refletir conceitos de Programação Orientada a Objetos (POO), incluindo:

- **Encapsulamento**
- **Herança**
- **Polimorfismo**
- **Sobrescrita de Métodos**

---

## 📂 **Estrutura do Projeto**

```
Shadows-of-the-Moon/
│
├── src/
│   ├── shadows/
│   │   ├── main/
│   │   │   └── Main.java          # Classe principal
│   │   ├── scenes/
│   │   │   └── SceneManager.java  # Gerencia as cenas e o fluxo do jogo
│   │   ├── characters/
│   │   │   └── Detective.java     # Representa o detetive
│   │   └── items/
│   │       ├── Item.java          # Classe base para itens
│   │       └── SpecialItem.java   # Item especial com métodos sobrescritos
│
├── bin/                           # Diretório de saída dos arquivos compilados
│
└── assets/                        # Recursos adicionais (pistas, cenas, descrições)
    ├── characters/
    ├── items/
    └── scenes/
```

---

## 🛠️ **Compilação e Execução**

### **1. Compilação**

Para compilar o projeto, execute o seguinte comando no terminal (dentro da pasta `Shadows-of-the-Moon`):

```bash
javac -d bin src/shadows/items/Item.java src/shadows/items/SpecialItem.java src/shadows/scenes/SceneManager.java src/shadows/main/Main.java src/shadows/characters/Detective.java
```

### **2. Execução**

Após compilar, execute o jogo com o comando:

```bash
java -cp bin shadows.main.Main
```

---

## 💡 **Funcionalidades Principais**

- **Exploração de Setores**: O jogador pode explorar até 3 setores diferentes.
- **Interrogatório**: Interrogue suspeitos para descobrir inconsistências em seus álibis.
- **Coleta de Pistas**: Encontre e analise pistas para solucionar o mistério.
- **Acusação**: Com base nas pistas e interrogatórios, acuse o suspeito que você acredita ser o culpado.

---

## 📌 **Conceitos de POO Aplicados**

1. **Encapsulamento**:
   - Atributos privados e métodos públicos para acesso controlado.

2. **Herança**:
   - `SpecialItem` herda de `Item`.

3. **Polimorfismo e Sobrescrita**:
   - `SpecialItem` sobrescreve os métodos `inspect()` e `getDescription()`.

---

## ✅ **Requisitos Atendidos**

- Reflete a realidade ao simular uma investigação de assassinato.
- Utiliza encapsulamento, herança e polimorfismo.
- Possui pelo menos 2 métodos sobrescritos.

---

**Divirta-se solucionando o mistério! 🕵️‍♂️🌕**
