package sorteio;

import java.util.Random;

public class SorteioNumeros {
    private static final Random random = new Random();
    private int qtdNumeros;
    private int[] numerosSorteados;

    public SorteioNumeros(int qtdNumeros) {
        this.qtdNumeros = qtdNumeros;
        numerosSorteados = new int[qtdNumeros];
        sortearNumeros();
    }

    private void sortearNumeros() {
        for (int i = 0; i < numerosSorteados.length; i++) {
            int numero = random.nextInt(101);
            numerosSorteados[i] = numero;
        }
    }

    public int[] getNumerosSorteados() {
        return numerosSorteados;
    }
}