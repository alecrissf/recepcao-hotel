package com.recepcaohotel.model.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Permanencia {
    public static <K, V> Map<K, V> recuperarDados(String caminho) {
        // Map<K, V> dados = new HashMap<>();
        Map<K, V> dados = null;
        // Abrir o arquivo.
        File arq = new File(caminho);
        if (!arq.exists()) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arq));
                dados = new HashMap<>();
                out.writeObject(dados);
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(arq));
            // Percorrer o arquivo.
            Object obj = in.readObject();
            if (obj instanceof HashMap) {
                dados = (HashMap<K, V>) obj;
            } else {
                dados = new HashMap<>();
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Retornar uma lista de linhas do arquivo.
        return dados;
    }

    public static <K, V> void salvarDados(String caminho, Map<K, V> dados) {
        // Abrir o arquivo.
        File arq = new File(caminho);
        // Percorrer a lista de linhas e grvá-las no arquivo.
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arq));
            out.writeObject(dados);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
