package ufg.inf.si.estagio.model;

public class ApplicationInfo {

    private String nome;
    private String versao;

    public ApplicationInfo(String nome, String versao) {
        this.nome = nome;
        this.versao = versao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object target) {
        if (this == target) {
            return true;
        }
        if (target == null || getClass() != target.getClass()) {
            return false;
        }

        ApplicationInfo that = (ApplicationInfo) target;

        if (nome != null ? !nome.equals(that.nome) : that.nome != null) {
            return false;
        }
        return versao != null ? versao.equals(that.versao) : that.versao == null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (versao != null ? versao.hashCode() : 0);
        return result;
    }

    /**
     * Retorna a informação de nome da aplicação
     *
     * @return Nome da aplicação.
     */
    public String getNome() {
        return nome;
    }


    /**
     * Altera a informação de nome da aplicação.
     *
     * @param nome Nome a ser setado como informação da aplicação.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a informação de versão da aplicação.
     *
     * @return Versão da aplicação.
     */
    public String getVersao() {
        return versao;
    }

    /**
     * Altera a versão do objeto da classe Objeto.
     *
     * @param versao Versão a ser setada como versão da aplicação.
     */
    public void setVersao(String versao) {
        this.versao = versao;
    }
}
