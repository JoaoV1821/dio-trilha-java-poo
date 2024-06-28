import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Bootcamp {
        private String nome;
        private String descricao;
        private final dataInicial = LocalDate.now();
        private final LocalDate dataFinal = dataInicial.plusDays(65);

        private Set<Dev> devsInscricao = new HashSet<>();

        private Set<Conteudo> conteudos = new LinkedHashSet<>();


}
