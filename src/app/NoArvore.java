package app;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NoArvore {
    int info;
    NoArvore direita = null;
    NoArvore esquerda = null;


    List<Integer> transformarArvoreEmLista(NoArvore arvore) {
        List<Integer> lista = new ArrayList<>();
        transformarArvoreEmListaRecursivo(arvore, lista);

        return lista;
    }

    //passo 1 DSW
    void transformarArvoreEmListaRecursivo(NoArvore arvore, List<Integer> lista) {
        if (arvore != null) {
            transformarArvoreEmListaRecursivo(arvore.esquerda, lista);
            lista.add(arvore.info);
            transformarArvoreEmListaRecursivo(arvore.direita, lista);
        }
    }

    //passo 2 DSW
    void realizarRotacoesParaEquilibrar(List<Integer> lista) {
        LinkedList<Integer> novaLista = new LinkedList<>();
        while (!lista.isEmpty()) {
            if (lista.size() > 1) {
                int no1 = lista.removeFirst();
                int no2 = lista.removeFirst();
                novaLista.addLast(no2);
                novaLista.addLast(no1);
            }
        }
        lista.addAll(novaLista);
    }

    //passo 3 DSW
    NoArvore reconstruirArvore(List<Integer> lista) {
        if (lista.isEmpty()) {
            return null;
        }
        int raizValor = lista.removeFirst();
        NoArvore arvore = new NoArvore();
        arvore.info = raizValor;

        while (!lista.isEmpty()) {
            int valor = lista.removeFirst();
            arvore = insere(arvore, valor);
        }

        return arvore;
    }

    void preOrdem(NoArvore tree) {
        if (tree != null) {
            System.out.println(tree.info);
            this.preOrdem(tree.esquerda);
            this.preOrdem(tree.direita);
        }

    }

    void inOrdem(NoArvore tree) {
        if (tree != null) {
            this.inOrdem(tree.esquerda);
            System.out.println(tree.info);
            this.inOrdem(tree.direita);
        }

    }

    void posOrdem(NoArvore tree) {
        if (tree != null) {
            this.posOrdem(tree.direita);
            this.posOrdem(tree.esquerda);
            System.out.println(tree.info);
        }

    }

    void emNivel(NoArvore tree) {
        if (tree != null) {
            Queue<NoArvore> fila = new LinkedList();
            fila.add(tree);

            while (!fila.isEmpty()) {
                NoArvore noAtual = fila.poll();
                System.out.println(noAtual.info);
                if (noAtual.esquerda != null) {
                    fila.add(noAtual.esquerda);
                }

                if (noAtual.direita != null) {
                    fila.add(noAtual.direita);
                }
            }

        }
    }

    NoArvore search(NoArvore tree, int valor) {
        if (tree == null) {
            return null;
        } else if (tree.info > valor) {
            return (search(tree.esquerda, valor));
        } else if (tree.info < valor) {
            return (search(tree.direita, valor));
        } else return (tree);
    }

    NoArvore insereRaiz(NoArvore tree, int valor) {
        tree.info = valor;
        tree.direita = null;
        tree.esquerda = null;
        return tree;
    }

    NoArvore insere(NoArvore tree, int valor) {
        if (tree == null) {
            tree = new NoArvore();
            tree.info = valor;
            tree.direita = null;
            tree.esquerda = null;
        } else if (valor < tree.info) {
            tree.esquerda = this.insere(tree.esquerda, valor);
        } else {
            tree.direita = this.insere(tree.direita, valor);
        }

        return tree;
    }

    NoArvore retira(NoArvore tree, int valor) {
        if (tree == null) {
            System.out.println("Elemento não encontrado..: " + valor);
            return null;
        } else {
            if (tree.info > valor) {
                tree.esquerda = this.retira(tree.esquerda, valor);
            } else if (tree.info < valor) {
                tree.direita = this.retira(tree.direita, valor);
            } else if (tree.esquerda == null && tree.direita == null) {
                tree = null;
            } else if (tree.esquerda == null) {
                tree = tree.direita;
            } else if (tree.direita == null) {
                tree = tree.esquerda;
            } else {
                NoArvore novo = this.encontraMenor(tree.direita);
                tree.info = novo.info;
                tree.direita = this.retira(tree.direita, novo.info);
            }

            return tree;
        }
    }

    NoArvore encontraMenor(NoArvore tree) {
        while (tree.esquerda != null) {
            tree = tree.esquerda;
        }

        return tree;
    }
}
