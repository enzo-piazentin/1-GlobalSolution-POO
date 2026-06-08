DOCUMENTAÇÃO DO PROJETO: Mapeamento de requisitos e implementação

Este documento relaciona, item a item, os requisitos das imagens do enunciado com os arquivos do projeto e o estado atual (Implementado / Parcial / Não implementado), incluindo observações sobre correções aplicadas.

1) Classe Abstrata (`ComponenteEspacial`)
- Arquivo: `src/projeto_especial/ComponenteEspacial.java`
- Status: Implementado (OK)
- Observações: classe `abstract` com atributos `id, nome, status, temperatura`, métodos concretos `ligar()` e `desligar()` e método abstrato `monitorar()`.

2) Interface (`Sensor`)
- Arquivo: `src/projeto_especial/Sensor.java`
- Status: Implementado (OK)
- Observações: define `lerValor()`, `verificarFuncionamento()` e `retornarTipo()`; implementada por 3 sensores.

3) Implementações de Sensor
- Arquivos: `SensorTemperatura.java`, `SensorPressao.java`, `SensorRadiacao.java`
- Status: Implementado (OK)
- Observações: cada sensor estende `ComponenteEspacial` e implementa `Sensor`. Corrigida geração de valores aleatórios (antes usavam `Random.nextDouble(x)` inválido) para `new Random().nextDouble() * limite`.

4) Encapsulamento (`DadosMissao`)
- Arquivo: `src/projeto_especial/DadosMissao.java`
- Status: Implementado (Parcial -> agora OK)
- Observações:
  - Atributos privados: `coordenadas`, `codigoAcesso`, `combustivel`, `trajetoria`, `tripulantes` — OK.
  - Autenticação por senha: `acessarCoordenadas(String senha)` — OK.
  - Validações: `setCombustivel(double)` agora valida 0–100 e emite alerta se <20%; adicionado `setTripulantes(int)` com validação >=0.

5) Herança (`SistemaPropulsao` e subclasses)
- Arquivos: `SistemaPropulsao.java`, `PropulsaoQuimica.java`, `PropulsaoEletrica.java`
- Status: Implementado (OK)
- Observações:
  - `SistemaPropulsao` é abstrata, possui `ligarMotor()`, `desligarMotor()`, validação em `setPotencia()` e métodos abstratos `acelerar()` e `calcularEmpuxo()`.
  - Adicionados getters `getPotencia()` e `isLigado()` e overload `acelerar(double)`.
  - Subclasses implementam `acelerar()` e `calcularEmpuxo()` e agora usam `super.ligarMotor()` caso o motor esteja desligado (demonstra uso de `super()`).

6) Sistema de Sensores
- Implementação: leituras simuladas nos sensores; `SistemaAlertas` verifica valores.
- Status: Implementado (Parcial)
- Observações: leituras aleatórias OK; `verificarFuncionamento()` ainda retorna sempre `true` (poderíamos simular falhas aleatórias se desejado).

7) Sistema de Propulsão (funcionalidades)
- Implementação: `setPotencia()` com validação, `ligarMotor()` / `desligarMotor()`, `acelerar()` nas subclasses, `calcularEmpuxo()` implementado nas subclasses.
- Status: Implementado (OK)
- Observações: menu no `SistemaMonitoramento` agora permite ligar/desligar, definir potência, acelerar e exibir empuxo.

8) Sistema de Monitoramento (menu principal)
- Arquivo: `src/projeto_especial/SistemaMonitoramento.java`
- Status: Implementado (Parcial -> ampliado)
- Observações: menu principal com opções:
  - Ler sensores + checar alertas
  - Ver combustível
  - Ver coordenadas (com senha)
  - Controlar propulsão (submenu)
  - Simular/ver alertas
  - Exibir status completo

9) Sistema de Alertas
- Arquivo: `src/projeto_especial/SistemaAlertas.java` (novo)
- Status: Implementado (OK)
- Observações: limites padrão (temperatura 80, pressão 150, radiação 70) e classificação de níveis: ATENÇÃO / ALERTA / CRÍTICO; verificação de combustível também disponível.

Erros corrigidos / decisões de implementação relevantes
- Corrigi o uso de `Random.nextDouble(arg)` que causava erro de compilação; substituído por `new Random().nextDouble() * limite`.
- Mantive leituras simuladas; `verificarFuncionamento()` poderia ser estendido para simular falhas.
- `acelerar()` foi mantido como método sem parâmetro (existe overload `acelerar(double)`); a interface de propulsão é suficiente para os requisitos, e o menu permite definir potência antes de acelerar.

Recomendações finais
- Incluir no repositório as capturas de tela pedidas pelo enunciado (`evidence/`).
- Se desejar, posso implementar configurabilidade dos limites via menu e simulação de falhas de sensores.

