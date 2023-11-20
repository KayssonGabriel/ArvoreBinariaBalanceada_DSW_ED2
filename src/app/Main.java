package app;

import java.util.Arrays;
import java.util.List;

import sorteio.SorteioNumeros;

public class Main {

    public static void main(String[] args) {
        SorteioNumeros sorteio1 = new SorteioNumeros(100);
        int[] numerosSorteados1 = sorteio1.getNumerosSorteados();
        NoArvore arvore = new NoArvore();
        System.out.println("Números sorteados: " + Arrays.toString(numerosSorteados1));
        System.out.println();
        System.out.println("Inserindo " + numerosSorteados1.length + " números na árvore...");
        System.out.println();


        for (int i = 0; i < numerosSorteados1.length; ++i) {
            if (i == 0) {
                arvore.insereRaiz(arvore, numerosSorteados1[i]);
            } else {
                arvore.insere(arvore, numerosSorteados1[i]);
            }
        }

        System.out.println("Árvore construída!");
        System.out.println();
        System.out.println("Usando o algoritmo DSW para contruir uma árvore binária balanceada...");

        //passo 1 DSW
        List<Integer> lista = arvore.transformarArvoreEmLista(arvore);
        System.out.println("Lista antes das rotações: " + lista);

        //passo 2 DSW
        arvore.realizarRotacoesParaEquilibrar(lista);
        System.out.println("Lista após as rotações: " + lista);

        //passo 3 DSW
        NoArvore arvoreReconstruida = arvore.reconstruirArvore(lista);
        System.out.println("Árvore reconstruída:");
        arvoreReconstruida.emNivel(arvoreReconstruida);
        System.out.println();

        SorteioNumeros sorteio2 = new SorteioNumeros(20);
        int[] numerosSorteados2 = sorteio2.getNumerosSorteados();
        System.out.println("Números sorteados: " + Arrays.toString(numerosSorteados2));
        System.out.println();
        System.out.println("Inserindo " + numerosSorteados2.length + " números na árvore...");
        System.out.println();


        for (int i = 0; i < numerosSorteados2.length; ++i) {
            arvore.insere(arvore, numerosSorteados2[i]);
        }

        System.out.println("Usando o algoritmo DSW para contruir uma árvore binária balanceada...");


        //passo 1 DSW
        List<Integer> lista2 = arvore.transformarArvoreEmLista(arvore);
        System.out.println("Lista antes das rotações: " + lista2);

        //passo 2 DSW
        arvore.realizarRotacoesParaEquilibrar(lista2);
        System.out.println("Lista após as rotações: " + lista2);

        //passo 3 DSW
        NoArvore arvoreReconstruida2 = arvore.reconstruirArvore(lista2);
        System.out.println("Árvore reconstruída:");
        arvoreReconstruida.emNivel(arvoreReconstruida2);
    }

}
