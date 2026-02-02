package myhome.app;

import java.util.Map;

import myhome.busca.BuscadorAnuncio;
import myhome.busca.BuscadorPadrao;
import myhome.busca.FiltroLocalizacaoDecorator;
import myhome.busca.FiltroQuartosDecorator;
import myhome.domain.Anunciante;
import myhome.domain.Anuncio;
import myhome.domain.Imovel;
import myhome.factory.ApartamentoFactory;
import myhome.factory.CasaFactory;
import myhome.factory.ImovelComercialFactory;
import myhome.factory.ImovelFactoryRegistry;
import myhome.factory.ImovelSpec;
import myhome.factory.TerrenoFactory;
import myhome.moderation.MinTitleLengthRule;
import myhome.moderation.ModerationChain;
import myhome.moderation.ModerationService;
import myhome.moderation.PriceRule;
import myhome.moderation.ProhibitedTermsRule;
import myhome.prototype.ImovelRegistry;
import myhome.proxy.ImagemProxy;
import myhome.repository.AnuncioRepository;
import myhome.state.AnuncioContext;
import myhome.state.StatusChangeDispatcher;
import myhome.state.StatusChangeLogListener;
import myhome.state.StatusChangeNotifyListener;

public class Main {
        public static void main(String[] args) {
                var repo = new AnuncioRepository();
                var prototipoRegistry = new ImovelRegistry();

                var registry = new ImovelFactoryRegistry();
                registry.registrar(new ApartamentoFactory());
                registry.registrar(new CasaFactory());
                registry.registrar(new ImovelComercialFactory());
                registry.registrar(new TerrenoFactory());

                var dispatcher = new StatusChangeDispatcher();
                dispatcher.registrar(new StatusChangeLogListener());
                dispatcher.registrar(new StatusChangeNotifyListener());

                var chain = new ModerationChain()
                                .adicionar(new ProhibitedTermsRule())
                                .adicionar(new PriceRule())
                                .adicionar(new MinTitleLengthRule(10));

                var moderationService = new ModerationService(chain);

                var anunciante = new Anunciante("Corretor João", "730122453", "TELEGRAM");

                Imovel ap = registry.criar(new ImovelSpec("APARTAMENTO", Map.of("area", "70.0", "preco", "250000.0",
                                "localizacao", "altiplano", "andar", "8", "elevador", "true", "quartos", "3")));

                var a1 = new Anuncio("Apartamento perto da praia", ap, anunciante);
                repo.salvar(a1);
                var ctx1 = new AnuncioContext(a1, dispatcher);
                var r1 = moderationService.submeterParaModeracao(ctx1);

                Imovel ap2 = registry.criar(new ImovelSpec("APARTAMENTO", Map.of("area", "40.0", "preco", "5000.0",
                                "localizacao", "centro", "andar", "3", "elevador", "false", "quartos", "2")));

                var a2 = new Anuncio("Apto barato", ap2, anunciante);
                repo.salvar(a2);
                var ctx2 = new AnuncioContext(a2, dispatcher);
                var r2 = moderationService.submeterParaModeracao(ctx2);

                Imovel ap3 = registry.criar(new ImovelSpec("APARTAMENTO", Map.of("area", "55.0", "preco", "200000.0",
                                "localizacao", "bancários", "andar", "5", "elevador", "true", "quartos", "3")));
                var a3 = new Anuncio("Golpe imperdível de apartamento", ap3, anunciante);
                repo.salvar(a3);
                var ctx3 = new AnuncioContext(a3, dispatcher);
                var r3 = moderationService.submeterParaModeracao(ctx3);

                Imovel casa1 = registry.criar(
                                new ImovelSpec("CASA", Map.of("area", "120.0", "preco", "300000.0", "localizacao",
                                                "mangabeira", "quintal", "true", "quartos", "4")));
                var a4 = new Anuncio("Casa com quintal grande", casa1, anunciante);
                repo.salvar(a4);
                var ctx4 = new AnuncioContext(a4, dispatcher);
                var r4 = moderationService.submeterParaModeracao(ctx4);

                Imovel terreno1 = registry.criar(new ImovelSpec("TERRENO",
                                Map.of("area", "500.0", "preco", "150000.0", "localizacao", "tabatinga", "zoneamento",
                                                "residencial")));
                var a5 = new Anuncio("Terreno espaçoso", terreno1, anunciante);
                repo.salvar(a5);
                var ctx5 = new AnuncioContext(a5, dispatcher);
                var r5 = moderationService.submeterParaModeracao(ctx5);

                Imovel imovelComercial1 = registry.criar(new ImovelSpec("IMOVEL_COMERCIAL",
                                Map.of("area", "300.0", "preco", "800000.0", "localizacao", "centro", "finalidade",
                                                "comercial")));
                var a6 = new Anuncio("Ponto comercial no centro", imovelComercial1, anunciante);
                repo.salvar(a6);
                var ctx6 = new AnuncioContext(a6, dispatcher);
                var r6 = moderationService.submeterParaModeracao(ctx6);

                Imovel apPrototipo = prototipoRegistry.criarNovo("APARTAMENTO_PADRAO");
                var a7 = new Anuncio("Apto Padrão Minha Casa", apPrototipo, anunciante);
                repo.salvar(a7);
                var ctx7 = new AnuncioContext(a7, dispatcher);
                var r7 = moderationService.submeterParaModeracao(ctx7);

                
var a8 = new Anuncio("Apartamento perto da praia", ap, anunciante);


a8.setFoto(new ImagemProxy("apto_praia_01.jpg")); 

repo.salvar(a8);


System.out.println("\n=== TESTE PROXY VIRTUAL (RF08) ===");
System.out.println("Acessando foto do anúncio A8...");

a8.getFoto().exibir();


System.out.println("\nAcessando foto do anúncio A8 novamente...");
a8.getFoto().exibir();

                System.out.println("\n=== RESULTADOS MODERACAO ===");
                System.out.println("A1: " + r1.decision() + " motivos=" + r1.motivos());
                System.out.println("A2: " + r2.decision() + " motivos=" + r2.motivos());
                System.out.println("A3: " + r3.decision() + " motivos=" + r3.motivos());
                System.out.println("A4: " + r4.decision() + " motivos=" + r4.motivos());
                System.out.println("A5: " + r5.decision() + " motivos=" + r5.motivos());
                System.out.println("A6: " + r6.decision() + " motivos=" + r6.motivos());
                System.out.println("A7: " + r7.decision() + " motivos=" + r7.motivos());
                a7.setFoto(new ImagemProxy("casa_luxo.jpg"));
                System.out.println(a7.getTitulo());
                a7.getFoto().exibir();

                System.out.println("\n=== STATUS FINAIS ===");
                repo.listarTodos().forEach(System.out::println);

                BuscadorAnuncio buscador = new BuscadorPadrao();
                System.out.println("\n=== BUSCA PERSONALIZADA ===");
                
                
                buscador = new FiltroLocalizacaoDecorator(buscador, "mangabeira");

                
                
                buscador = new FiltroQuartosDecorator(buscador, 2);

                var resultados = buscador.buscar(repo.listarTodos());

                if (resultados.isEmpty()) {
                        System.out.println("Nenhum anúncio encontrado com os filtros aplicados.");
                } else {
                        resultados.forEach(System.out::println);
                }
        }
}
