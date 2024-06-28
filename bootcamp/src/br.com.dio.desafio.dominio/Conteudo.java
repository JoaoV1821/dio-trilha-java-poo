public abstract class Conteudo {
    protected static final double XP_PADRAO = 10;

    private String titulo;
    private String descricao;

    public abstract double calcularXp();

    public String getDescricao() {
        return descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public static double getXpPadrao() {
        return XP_PADRAO;
    }
}
