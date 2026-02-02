# MyHome — Sistema de Classificados

Projeto em **Java** para um sistema de classificados de imóveis, aplicando **Padrões de Projeto** e princípios de **extensibilidade** (Open/Closed), conforme enunciado da disciplina.

> - Configuração via `.properties` (RF07)
> - Criação extensível de tipos de Imóvel (RF01)
> - Presets clonáveis (Prototype) (RF02)
> - Ciclo de vida de anúncio com **State + Observer** (RF04)
> - Moderação dinâmica com **Chain of Responsibility** (RF03)
> - Notificações multi-canal com **1 canal real** (RF05) — **a ser implementado**
> - Busca com filtros combináveis (RF06) 
> - Novo requisito + novo padrão (RF08) — **a ser implementado**

---

## Tecnologias
- Java 17+
- Maven
- Estruturas em memória (List/Map)
- Logs via `java.util.logging`

---

## Como rodar
#### Opção A
```bash
mvn -q exec:java
```
#### Opção B
1. Abra o projeto no VS Code
2. Abra `src/main/java/myhome/app/Main.java`
3. Clique em **Run** (ou `Ctrl+F5`)


---

## Configuração (.properties) — RF07
Arquivo: `src/main/resources/config.properties`

Exemplos usados:
- `taxa.comissao`
- `limite.upload.fotos`
- `termos.proibidos`

---

## Estrutura de pacotes
- `myhome.app` — bootstrap / `Main`
- `myhome.config` — `ConfigManager` (Singleton)
- `myhome.domain` — entidades (Usuario, Anuncio, Imovel, etc.)
- `myhome.repository` — repositórios em memória
- `myhome.factory` — Factory registrável + presets
- `myhome.state` — State + Observer (mudança de status)
- `myhome.moderation` — Chain of Responsibility (regras de moderação)
- `myhome.busca` - Decorator
(filtros combináveis para anúncios)

---

## Padrões de Projeto Utilizados

O projeto foi desenvolvido com foco em extensibilidade (Open/Closed), aplicando padrões de projeto de forma explícita:

- **Singleton**  
  Utilizado no `ConfigManager` para centralizar o carregamento e o acesso às configurações do sistema via arquivo `.properties` (RF07).

- **Factory (Registry)**  
  Utilizado na criação de tipos de `Imovel`, permitindo adicionar novos tipos sem modificar o código existente (RF01).

- **Prototype**  
  Utilizado para criação de instâncias padrão (presets) de imóveis, que podem ser clonadas conforme necessidade (RF02).

- **State**  
  Utilizado para modelar o ciclo de vida do `Anuncio`, garantindo transições válidas entre estados como Rascunho, Moderação, Ativo, Vendido e Suspenso (RF04).

- **Observer**  
  Integrado ao ciclo de vida do anúncio para registrar e notificar eventos automaticamente sempre que ocorre mudança de estado (RF04).

- **Chain of Responsibility**  
  Utilizado no processo de moderação de anúncios, permitindo combinar regras dinâmicas e extensíveis de validação sem acoplamento ao fluxo principal (RF03).

  **Decorator**
  Utilizado para atribuir comportamentos de filtragem a um objeto dinamicamente (RF06)

---

## Regras e fluxos implementados (resumo)

### RF01 — Tipos de imóvel extensíveis
- Criação de imóveis por tipo através do `ImovelFactoryRegistry`
- Para adicionar um novo tipo:
  1) criar `NovoTipo implements Imovel`
  2) criar `NovoTipoFactory implements ImovelFactory`
  3) registrar no `ImovelFactoryRegistry`

### RF02 — Presets clonáveis
- `ImovelPresetCatalog` guarda modelos padrão
- Ao criar a partir de preset, usa `copiar()` (Prototype)

### RF04 — Ciclo de vida do anúncio
Estados:
- `RASCUNHO` → `MODERACAO` → `ATIVO` → `VENDIDO`
- `SUSPENSO` (reprovado) com possibilidade de voltar para `RASCUNHO`

Mudança de estado dispara evento (`StatusChangeEvent`) para listeners (Observer).

### RF03 — Moderação dinâmica
- Pipeline de regras (Chain):
  - termos proibidos (por config)
  - preço inválido / suspeito
  - título mínimo
- Decisão:
  - `AUTO_APROVAR` → passa para `ATIVO`
  - `AUTO_REPROVAR` → vai para `SUSPENSO`
  - `MANUAL` → permanece em `MODERACAO`

  ### RF06 - Pesquisa e visualização
- Utilizado para permitir a aplicação de vários   filtros de busca ao mesmo tempo
- Filtros disponíveis:
- Localização, preço, área mínima (comuns a todos)
- Quartos
- Quintal
- Elevador
- Finalidade
- Zoneamento 