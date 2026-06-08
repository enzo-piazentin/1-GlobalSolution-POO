package projeto_especial;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo rastreamento e gerenciamento de asteroides.
 * Monitora status de risco de colisão e fornece operações de alteração.
 */
public class SistemaRastreamento {

    private List<Asteroide> asteroides = new ArrayList<>();
    private static int proximoId = 1;

    /**
     * Adiciona um novo asteroide ao sistema de rastreamento.
     */
    public void adicionarAsteroide(String nome, double temperatura, double distancia, double velocidade, String statusRisco, boolean exploravel) {
        Asteroide novo = new Asteroide(proximoId++, nome, temperatura, distancia, velocidade, statusRisco, exploravel);
        asteroides.add(novo);
        System.out.println("Asteroide '" + nome + "' adicionado ao rastreamento com ID " + novo.id);
    }

    /**
     * Lista todos os asteroides rastreados.
     */
    public void listarAsteroides() {
        if (asteroides.isEmpty()) {
            System.out.println("Nenhum asteroide rastreado.");
            return;
        }
        System.out.println("\n=== ASTEROIDES RASTREADOS ===");
        for (Asteroide a : asteroides) {
            a.monitorar();
        }
    }

    /**
     * Altera o status de risco de um asteroide por ID.
     */
    public void alterarStatusRisco(int id, String novoStatus) {
        for (Asteroide a : asteroides) {
            if (a.id == id) {
                String statusAntigo = a.getStatusRisco();
                a.setStatusRisco(novoStatus);
                System.out.println("Asteroide '" + a.nome + "': status alterado de '" + statusAntigo + "' para '" + novoStatus + "'");
                return;
            }
        }
        System.out.println("Asteroide com ID " + id + " não encontrado.");
    }

    /**
     * Retorna a quantidade de asteroides rastreados.
     */
    public int getTotalAsteroides() {
        return asteroides.size();
    }

    /**
     * Retorna um asteroide pelo ID.
     */
    public Asteroide obterAsteroidePorid(int id) {
        for (Asteroide a : asteroides) {
            if (a.id == id) return a;
        }
        return null;
    }
}

