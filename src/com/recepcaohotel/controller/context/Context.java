package com.recepcaohotel.controller.context;

/**
 * Contexto para compartilhar informações temporárias entre Controllers
 * relacionados.
 */
public class Context {
    // Padrão Singleton
    private static Context instance;

    /**
     *
     * @return Context singleton instance.
     */
    public static Context getInstance() {
        if (instance == null) {
            instance = new Context();
        }
        return instance;
    }

    /**
     * Finaliza o contexto para não manter dados de uma utilização anterior do
     * contexto.
     */
    public static void finishContext() {
        instance = null;
    }
}
