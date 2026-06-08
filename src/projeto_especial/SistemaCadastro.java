package projeto_especial;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo cadastro dinâmico de componentes espaciais (Planetas e Asteroides).
 */
public class SistemaCadastro {

    private List<Planeta> planetas = new ArrayList<>();
    private static int proximoId = 100;

    /**
     * Adiciona um novo planeta ao cadastro.
     */
    public void adicionarPlaneta(String nome, double temperatura, double distancia, String composicao, boolean exploravel) {
        Planeta novo = new Planeta(proximoId++, nome, temperatura, distancia, composicao, exploravel);
        planetas.add(novo);
        System.out.println("Planeta '" + nome + "' cadastrado com sucesso (ID: " + novo.id + ")");
    }

    /**
     * Lista todos os planetas cadastrados.
     */
    public void listarPlanetas() {
        if (planetas.isEmpty()) {
            System.out.println("Nenhum planeta cadastrado.");
            return;
        }
        System.out.println("\n=== PLANETAS CADASTRADOS ===");
        for (Planeta p : planetas) {
            System.out.println("ID: " + p.id + " | Nome: " + p.nome + " | Tipo: " + p.getComposicao() + " | Explorável: " + p.isExploravel());
        }
    }

    /**
     * Retorna um planeta pelo ID.
     */
    public Planeta obterPlanetaPorId(int id) {
        for (Planeta p : planetas) {
            if (p.id == id) return p;
        }
        return null;
    }

    /**
     * Retorna a quantidade de planetas cadastrados.
     */
    public int getTotalPlanetas() {
        return planetas.size();
    }

    /**
     * Altera o status explorável de um planeta.
     */
    public void alterarExplorabilidade(int id, boolean novoStatus) {
        Planeta p = obterPlanetaPorId(id);
        if (p != null) {
            p.setExploravel(novoStatus);
            System.out.println("Planeta '" + p.nome + "' agora " + (novoStatus ? "explorável" : "não explorável"));
        } else {
            System.out.println("Planeta com ID " + id + " não encontrado.");
        }
    }
}

