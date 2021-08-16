package com.recepcaohotel.controller.context;

public class AdminContext {
    // ---- Padrão Singleton ---------------------------------------------------
    private static AdminContext instance;

    /**
     *
     * @return Context singleton instance.
     */
    public static AdminContext getInstance() {
        if (instance == null) {
            instance = new AdminContext();
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
    // -------------------------------------------------------------------------

    // ---- Campos -------------------------------------------------------------
    // TODO: definir campos.
    // -------------------------------------------------------------------------

    public AdminContext() {
        // TODO: definir valores iniciais para os campos.
    }
}
