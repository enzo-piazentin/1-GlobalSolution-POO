TESTES E CENÁRIOS (como validar manualmente cada requisito)

Este arquivo descreve passos para testar as funcionalidades solicitadas no enunciado.

Pré-requisito: compilar e executar conforme README

1) Testar leitura de sensores e alertas
- Execute o sistema e selecione a opção 1 (Ler Sensores e checar alertas).
- Esperado: o programa imprime os valores de Temperatura, Pressão e Radiação e mostra alertas caso os valores ultrapassem os limites.

2) Testar verificação de combustível
- No menu principal, selecione opção 2 (Ver Combustível).
- Esperado: exibe o nível de combustível e mensagem de alerta se estiver abaixo de 35% (ou crítico abaixo de 20%).

3) Testar acesso a coordenadas (encapsulamento / proteção por senha)
- No menu principal, selecione opção 3.
- Quando solicitado, digite uma senha incorreta (ex.: `0000`) → Esperado: `Acesso negado`.
- Digite a senha correta (padrão no código: `1234`) → Esperado: exibe coordenadas.

4) Testar controle de propulsão
- No menu principal, selecione opção 4 (Controlar Propulsão).
- No submenu:
  - Teste ligar/desligar propulsão química e elétrica (opções 1 e 2) e observe a mensagem de status.
  - Teste definir potência inválida (<0 ou >100) e observe a mensagem de erro.
  - Defina potência válida e selecione acelerar (opções 5/6) para ver a mensagem de aceleração.
  - Se desejar, veja empuxo (opção 7).

5) Testar exibição de status completo
- No menu principal, selecione opção 6.
- Esperado: exibe leituras dos sensores (com verificação de alertas), estado das propulsões (ligado, potência, empuxo) e dados da missão.

6) Testar loop e saída
- No menu principal, escolha 0 para sair. O programa deve encerrar corretamente.

Notas
- As leituras dos sensores são aleatórias; repita os testes várias vezes para observar diferentes níveis de alerta.
- Para testes de limite, você pode temporariamente modificar os limites em `SistemaAlertas.java` ou alterar a implementação dos sensores para retornar valores fixos.

