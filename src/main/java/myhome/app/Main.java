package myhome.app;

import myhome.domain.*;
import myhome.factory.*;
import myhome.moderation.*;
import myhome.repository.AnuncioRepository;
import myhome.state.*;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var repo = new AnuncioRepository();

        var registry = new ImovelFactoryRegistry();
        registry.registrar(new ApartamentoFactory());
        registry.registrar(new CasaFactory());

        var dispatcher = new StatusChangeDispatcher();
        dispatcher.registrar(new StatusChangeLogListener());
        dispatcher.registrar(new StatusChangeNotifyListener());

        var chain = new ModerationChain()
                .adicionar(new ProhibitedTermsRule())
                .adicionar(new PriceRule())
                .adicionar(new MinTitleLengthRule(10));

        var moderationService = new ModerationService(chain);

        var anunciante = new Anunciante("Corretor João");
        Imovel ap = registry.criar(new ImovelSpec("APARTAMENTO", Map.of("andar","8","elevador","true")));

        var a1 = new Anuncio("Apartamento perto da praia", 250000.0, ap, anunciante);
        repo.salvar(a1);
        var ctx1 = new AnuncioContext(a1, dispatcher);
        var r1 = moderationService.submeterParaModeracao(ctx1);

        var a2 = new Anuncio("Apto barato", 500.0, ap, anunciante);
        repo.salvar(a2);
        var ctx2 = new AnuncioContext(a2, dispatcher);
        var r2 = moderationService.submeterParaModeracao(ctx2);

        var a3 = new Anuncio("Golpe imperdível de apartamento", 200000.0, ap, anunciante);
        repo.salvar(a3);
        var ctx3 = new AnuncioContext(a3, dispatcher);
        var r3 = moderationService.submeterParaModeracao(ctx3);

        System.out.println("\n=== RESULTADOS MODERACAO ===");
        System.out.println("A1: " + r1.decision() + " motivos=" + r1.motivos());
        System.out.println("A2: " + r2.decision() + " motivos=" + r2.motivos());
        System.out.println("A3: " + r3.decision() + " motivos=" + r3.motivos());

        System.out.println("\n=== STATUS FINAIS ===");
        repo.listarTodos().forEach(System.out::println);
    }
}
