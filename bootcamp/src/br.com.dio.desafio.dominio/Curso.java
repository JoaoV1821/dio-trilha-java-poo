public class Curso extends Conteudo{
   
    private int cargaHoraria;


    @Override
    public double calcularXp() {
        // TODO Auto-generated method stub
        return XP_PADRAO * cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

}
