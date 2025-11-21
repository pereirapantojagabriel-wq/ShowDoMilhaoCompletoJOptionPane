import javax.swing.JOptionPane;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class ShowDoMilhaoCompletoJOptionPane {
    private static Random random = new Random();
    private static int premioAtual = 0;
    private static String nomeJogador = "";
    private static List<String> ranking = new ArrayList<>();

    // Estrutura das perguntas
    private static class Pergunta {
        String pergunta;
        String[] alternativas;
        int respostaCorreta;
        int nivel;
        String categoria;

        public Pergunta(String pergunta, String[] alternativas, int respostaCorreta, int nivel, String categoria) {
            this.pergunta = pergunta;
            this.alternativas = alternativas;
            this.respostaCorreta = respostaCorreta;
            this.nivel = nivel;
            this.categoria = categoria;
        }
    }

    // Premios por nível (16 níveis)
    private static final int[] PREMIOS = {
        1000, 2000, 3000, 4000, 5000,
        10000, 20000, 30000, 40000, 50000,
        100000, 200000, 300000, 400000, 500000,
        1000000  // PRÊMIO MÁXIMO
    };

    // BANCO DE DADOS COMPLETO COM TODAS AS PERGUNTAS
    private static Pergunta[] perguntas = {
        // ========== NÍVEL 1 - R$ 1.000 ==========
        new Pergunta("Qual é o sinônimo da palavra 'feliz'?", 
            new String[]{"A) Triste", "B) Alegre", "C) Nervoso", "D) Bravo"}, 
            1, 1, "Português"),
        
        new Pergunta("Quantas sílabas tem a palavra 'abacaxi'?", 
            new String[]{"A) Duas", "B) Três", "C) Quatro", "D) Cinco"}, 
            1, 1, "Português"),
        
        new Pergunta("O que acontece com a água ao atingir 100°C ao nível do mar?", 
            new String[]{"A) Congela", "B) Evapora", "C) Derrete", "D) Fica sólida"}, 
            1, 1, "Ciências"),
        
        new Pergunta("Qual é o plural correto da palavra 'papel'?", 
            new String[]{"A) Papéis", "B) Papéus", "C) Papelz", "D) Papels"}, 
            0, 1, "Português"),
        
        new Pergunta("Em qual continente fica o Egito?", 
            new String[]{"A) Europa", "B) Ásia", "C) América", "D) África"}, 
            3, 1, "Geografia"),

        // ========== NÍVEL 2 - R$ 2.000 ==========
        new Pergunta("Qual é o principal gás responsável pela respiração humana?", 
            new String[]{"A) Gás carbônico", "B) Oxigênio", "C) Hidrogênio", "D) Nitrogênio"}, 
            1, 2, "Ciências"),
        
        new Pergunta("Quem foi o primeiro presidente do Brasil?", 
            new String[]{"A) Getúlio Vargas", "B) Deodoro da Fonseca", "C) Dom Pedro II", "D) Juscelino Kubitschek"}, 
            1, 2, "História"),
        
        new Pergunta("Qual é o resultado da expressão: 5 × (2 + 3)?", 
            new String[]{"A) 25", "B) 15", "C) 10", "D) 30"}, 
            0, 2, "Matemática"),
        
        new Pergunta("Em que país se localiza a Torre Eiffel?", 
            new String[]{"A) Itália", "B) Alemanha", "C) França", "D) Espanha"}, 
            2, 2, "Geografia"),
        
        new Pergunta("Que tipo de palavra é 'rapidamente'?", 
            new String[]{"A) Verbo", "B) Adjetivo", "C) Substantivo", "D) Advérbio"}, 
            3, 2, "Português"),

        // ========== NÍVEL 3 - R$ 3.000 ==========
        new Pergunta("Quem foi o autor da obra 'Os Lusíadas'?", 
            new String[]{"A) Fernando Pessoa", "B) Luís de Camões", "C) Machado de Assis", "D) José Saramago"}, 
            1, 3, "Literatura"),
        
        new Pergunta("Qual é a capital do estado de Pernambuco?", 
            new String[]{"A) João Pessoa", "B) Maceió", "C) Recife", "D) Natal"}, 
            2, 3, "Geografia"),
        
        new Pergunta("Qual é o nome do processo em que a planta produz seu próprio alimento com a luz do sol?", 
            new String[]{"A) Fotossíntese", "B) Germinação", "C) Respiração", "D) Transpiração"}, 
            0, 3, "Ciências"),
        
        new Pergunta("Qual destas figuras geométricas tem todos os lados e ângulos iguais?", 
            new String[]{"A) Retângulo", "B) Trapézio", "C) Quadrado", "D) Losango"}, 
            2, 3, "Matemática"),
        
        new Pergunta("Qual é o tempo verbal da frase: 'Eu viajarei amanhã'?", 
            new String[]{"A) Pretérito perfeito", "B) Futuro do presente", "C) Presente do indicativo", "D) Futuro do pretérito"}, 
            1, 3, "Português"),

        // ========== NÍVEL 4 - R$ 4.000 ==========
        new Pergunta("Qual é o menor país do mundo em território?", 
            new String[]{"A) Mônaco", "B) Vaticano", "C) San Marino", "D) Liechtenstein"}, 
            1, 4, "Geografia"),
        
        new Pergunta("Quem foi o cientista que desenvolveu a Teoria da Relatividade?", 
            new String[]{"A) Isaac Newton", "B) Albert Einstein", "C) Galileu Galilei", "D) Nikola Tesla"}, 
            1, 4, "Ciências"),
        
        new Pergunta("Qual é a função principal do fígado no corpo humano?", 
            new String[]{"A) Bombear o sangue", "B) Produzir hormônios", "C) Filtrar toxinas e produzir bile", "D) Controlar o batimento cardíaco"}, 
            2, 4, "Biologia"),
        
        new Pergunta("Qual é o nome do autor da obra 'A Hora da Estrela'?", 
            new String[]{"A) Jorge Amado", "B) Graciliano Ramos", "C) Clarice Lispector", "D) Lygia Fagundes Telles"}, 
            2, 4, "Literatura"),
        
        new Pergunta("Quantos segundos tem uma hora?", 
            new String[]{"A) 3.600", "B) 1.200", "C) 6.000", "D) 360"}, 
            0, 4, "Matemática"),

        // ========== NÍVEL 5 - R$ 5.000 ==========
        new Pergunta("Qual foi a principal causa da Primeira Guerra Mundial?", 
            new String[]{"A) Revolução Russa", "B) Assassinato do arquiduque Franz Ferdinand", "C) Tratado de Versalhes", "D) Guerra Franco-Prussiana"}, 
            1, 5, "História"),
        
        new Pergunta("Qual é o nome da célula responsável pela produção de insulina no corpo humano?", 
            new String[]{"A) Neurônio", "B) Célula beta do pâncreas", "C) Hemácia", "D) Célula epitelial"}, 
            1, 5, "Biologia"),
        
        new Pergunta("Qual o valor aproximado do número π (pi) até duas casas decimais?", 
            new String[]{"A) 3,14", "B) 3,41", "C) 2,14", "D) 3,04"}, 
            0, 5, "Matemática"),
        
        new Pergunta("Em que país nasceu o pintor Vincent van Gogh?", 
            new String[]{"A) França", "B) Holanda", "C) Bélgica", "D) Alemanha"}, 
            1, 5, "Arte"),
        
        new Pergunta("Qual é o nome do processo em que o corpo converte alimentos em energia?", 
            new String[]{"A) Digestão", "B) Metabolismo", "C) Circulação", "D) Excreção"}, 
            1, 5, "Biologia"),

        // ========== NÍVEL 6 - R$ 10.000 ==========
        new Pergunta("Qual é o nome do tratado que encerrou a Primeira Guerra Mundial?", 
            new String[]{"A) Tratado de Roma", "B) Tratado de Versalhes", "C) Tratado de Paris", "D) Tratado de Tordesilhas"}, 
            1, 6, "História"),
        
        new Pergunta("Qual é o nome do metal líquido em temperatura ambiente?", 
            new String[]{"A) Ferro", "B) Mercúrio", "C) Ouro", "D) Cobre"}, 
            1, 6, "Química"),
        
        new Pergunta("Qual é o símbolo químico do elemento ouro na tabela periódica?", 
            new String[]{"A) Au", "B) Ag", "C) O", "D) Go"}, 
            0, 6, "Química"),
        
        new Pergunta("Qual foi o primeiro país a conceder o direito ao voto para as mulheres?", 
            new String[]{"A) Brasil", "B) Estados Unidos", "C) Nova Zelândia", "D) Reino Unido"}, 
            2, 6, "História"),
        
        new Pergunta("Quem compôs a famosa obra musical 'O Carnaval dos Animais'?", 
            new String[]{"A) Ludwig van Beethoven", "B) Camille Saint-Saëns", "C) Johann Sebastian Bach", "D) Wolfgang Amadeus Mozart"}, 
            1, 6, "Música"),

        // ========== NÍVEL 7 - R$ 20.000 ==========
        new Pergunta("Qual é o nome do processo pelo qual as plantas liberam vapor d'água pelas folhas?", 
            new String[]{"A) Transpiração", "B) Fotossíntese", "C) Germinação", "D) Evaporação"}, 
            0, 7, "Biologia"),
        
        new Pergunta("Quem foi o líder da Revolução Cubana de 1959?", 
            new String[]{"A) Che Guevara", "B) Fidel Castro", "C) Hugo Chávez", "D) Augusto Pinochet"}, 
            1, 7, "História"),
        
        new Pergunta("Qual o nome do matemático que desenvolveu o cálculo diferencial e integral?", 
            new String[]{"A) Isaac Newton", "B) Euclides", "C) René Descartes", "D) Ptolomeu"}, 
            0, 7, "Matemática"),
        
        new Pergunta("Qual desses escritores é autor do romance 'Cem Anos de Solidão'?", 
            new String[]{"A) Pablo Neruda", "B) Gabriel García Márquez", "C) Mario Vargas Llosa", "D) Julio Cortázar"}, 
            1, 7, "Literatura"),
        
        new Pergunta("Qual é a unidade básica da vida?", 
            new String[]{"A) Molécula", "B) Átomo", "C) Célula", "D) Organismo"}, 
            2, 7, "Biologia"),

        // ========== NÍVEL 8 - R$ 30.000 ==========
        new Pergunta("Qual é o principal objetivo do Tratado de Kyoto, assinado em 1997?", 
            new String[]{"A) Regular o comércio internacional", "B) Reduzir a emissão de gases do efeito estufa", "C) Proteger os direitos humanos", "D) Estabelecer zonas de livre comércio"}, 
            1, 8, "Geografia/Política"),
        
        new Pergunta("Quem escreveu a obra 'O Príncipe', que discute estratégias políticas?", 
            new String[]{"A) Maquiavel", "B) Montesquieu", "C) Rousseau", "D) Hobbes"}, 
            0, 8, "Filosofia/Política"),
        
        new Pergunta("Qual é o nome do processo celular que produz células filhas geneticamente idênticas à célula mãe?", 
            new String[]{"A) Meiose", "B) Mitose", "C) Fissão binária", "D) Transcrição"}, 
            1, 8, "Biologia"),
        
        new Pergunta("Em qual ano foi proclamada a independência do Brasil?", 
            new String[]{"A) 1808", "B) 1822", "C) 1889", "D) 1831"}, 
            1, 8, "História"),
        
        new Pergunta("Qual filósofo grego é conhecido por sua contribuição à lógica e à metafísica, e foi tutor de Alexandre, o Grande?", 
            new String[]{"A) Sócrates", "B) Platão", "C) Aristóteles", "D) Epicuro"}, 
            2, 8, "Filosofia"),

        // ========== NÍVEL 9 - R$ 40.000 ==========
        new Pergunta("Qual foi o movimento literário que teve como um dos principais autores Luís de Camões?", 
            new String[]{"A) Barroco", "B) Romantismo", "C) Classicismo", "D) Modernismo"}, 
            2, 9, "Literatura"),
        
        new Pergunta("Qual destes elementos químicos é um gás nobre?", 
            new String[]{"A) Oxigênio", "B) Nitrogênio", "C) Argônio", "D) Carbono"}, 
            2, 9, "Química"),
        
        new Pergunta("Qual a capital da Mongólia?", 
            new String[]{"A) Ulaanbaatar", "B) Astana", "C) Tashkent", "D) Bishkek"}, 
            0, 9, "Geografia"),
        
        new Pergunta("Em qual obra de Shakespeare aparece a frase 'Ser ou não ser, eis a questão'?", 
            new String[]{"A) Macbeth", "B) Hamlet", "C) Otelo", "D) Rei Lear"}, 
            1, 9, "Literatura"),
        
        new Pergunta("Qual é a unidade de medida usada para a intensidade da corrente elétrica?", 
            new String[]{"A) Volt", "B) Ampère", "C) Ohm", "D) Watt"}, 
            1, 9, "Física"),

        // ========== NÍVEL 10 - R$ 50.000 ==========
        new Pergunta("Qual é a fórmula química da água?", 
            new String[]{"A) CO₂", "B) H₂O", "C) O₂", "D) NaCl"}, 
            1, 10, "Química"),
        
        new Pergunta("Quem foi o líder do movimento conhecido como 'Primavera Árabe' na Tunísia?", 
            new String[]{"A) Muammar Gaddafi", "B) Mohamed Bouazizi", "C) Hosni Mubarak", "D) Bashar al-Assad"}, 
            1, 10, "História"),
        
        new Pergunta("Qual o nome do físico que formulou as leis do movimento e da gravitação universal?", 
            new String[]{"A) Galileo Galilei", "B) Isaac Newton", "C) Albert Einstein", "D) Nikola Tesla"}, 
            1, 10, "Física"),
        
        new Pergunta("Qual o nome da capital da Austrália?", 
            new String[]{"A) Sydney", "B) Melbourne", "C) Canberra", "D) Brisbane"}, 
            2, 10, "Geografia"),
        
        new Pergunta("Em que continente está localizada a Cordilheira dos Andes?", 
            new String[]{"A) América do Norte", "B) América do Sul", "C) África", "D) Europa"}, 
            1, 10, "Geografia"),

        // ========== NÍVEL 11 - R$ 100.000 ==========
        new Pergunta("Qual foi o objetivo principal do movimento Iluminista no século XVIII?", 
            new String[]{"A) Defender o absolutismo monárquico", "B) Promover a razão, ciência e direitos humanos", "C) Apoiar a Igreja Católica", "D) Incentivar a colonização das Américas"}, 
            1, 11, "Filosofia/História"),
        
        new Pergunta("Qual é o nome do pintor responsável pela obra 'Guernica', que retrata os horrores da guerra?", 
            new String[]{"A) Pablo Picasso", "B) Salvador Dalí", "C) Diego Rivera", "D) Frida Kahlo"}, 
            0, 11, "Arte"),
        
        new Pergunta("Qual é a teoria que explica a origem do universo?", 
            new String[]{"A) Teoria da Evolução", "B) Teoria da Relatividade", "C) Teoria do Big Bang", "D) Teoria das Cordas"}, 
            2, 11, "Astronomia"),
        
        new Pergunta("Qual é o nome do maior satélite natural da Terra?", 
            new String[]{"A) Fobos", "B) Europa", "C) Lua", "D) Titã"}, 
            2, 11, "Astronomia"),
        
        new Pergunta("Quem escreveu 'A República', obra que trata da justiça e da organização política?", 
            new String[]{"A) Sócrates", "B) Platão", "C) Aristóteles", "D) Tucídides"}, 
            1, 11, "Filosofia"),

        // ========== NÍVEL 12 - R$ 200.000 ==========
        new Pergunta("Qual filósofo é conhecido por sua obra 'Discurso do Método', fundamental para a filosofia moderna?", 
            new String[]{"A) René Descartes", "B) Immanuel Kant", "C) Friedrich Nietzsche", "D) Jean-Jacques Rousseau"}, 
            0, 12, "Filosofia"),
        
        new Pergunta("Em qual país ocorreu a Revolução dos Cravos em 1974, que pôs fim à ditadura?", 
            new String[]{"A) Espanha", "B) Portugal", "C) Grécia", "D) Itália"}, 
            1, 12, "História"),
        
        new Pergunta("Qual é o nome do processo pelo qual uma célula obtém energia na ausência de oxigênio?", 
            new String[]{"A) Respiração aeróbica", "B) Fermentação", "C) Fotossíntese", "D) Osmose"}, 
            1, 12, "Biologia"),
        
        new Pergunta("Qual é a teoria que propõe a existência de múltiplos universos paralelos?", 
            new String[]{"A) Teoria do Big Bang", "B) Teoria das Cordas", "C) Teoria do Multiverso", "D) Teoria da Relatividade Geral"}, 
            2, 12, "Física"),
        
        new Pergunta("Quem foi o principal autor da 'Teoria da Evolução por Seleção Natural'?", 
            new String[]{"A) Gregor Mendel", "B) Charles Darwin", "C) Louis Pasteur", "D) Alfred Wallace"}, 
            1, 12, "Biologia"),

        // ========== NÍVEL 13 - R$ 300.000 ==========
        new Pergunta("Qual foi a capital do Império Bizantino?", 
            new String[]{"A) Roma", "B) Atenas", "C) Constantinopla", "D) Alexandria"}, 
            2, 13, "História"),
        
        new Pergunta("Qual físico propôs o conceito de 'buraco negro' a partir das soluções da relatividade geral?", 
            new String[]{"A) Albert Einstein", "B) Karl Schwarzschild", "C) Stephen Hawking", "D) Roger Penrose"}, 
            1, 13, "Física"),
        
        new Pergunta("Qual é o nome da obra em que Dante Alighieri descreve sua jornada pelo Inferno, Purgatório e Paraíso?", 
            new String[]{"A) A Divina Comédia", "B) O Paraíso Perdido", "C) Inferno", "D) Épico de Gilgamesh"}, 
            0, 13, "Literatura"),
        
        new Pergunta("Qual imperador romano oficializou o cristianismo como religião do Império?", 
            new String[]{"A) Nero", "B) Augusto", "C) Constantino", "D) Teodósio"}, 
            3, 13, "História"),
        
        new Pergunta("Na física, o que descreve a 2ª Lei de Newton?", 
            new String[]{"A) A conservação da energia", "B) A força centrípeta", "C) A relação entre força, massa e aceleração", "D) A ação e reação"}, 
            2, 13, "Física"),

        // ========== NÍVEL 14 - R$ 400.000 ==========
        new Pergunta("Qual livro é considerado a obra fundadora do pensamento econômico moderno, escrito por Adam Smith?", 
            new String[]{"A) O Capital", "B) A Riqueza das Nações", "C) Manifesto Comunista", "D) Teoria Geral do Emprego, do Juro e da Moeda"}, 
            1, 14, "Economia"),
        
        new Pergunta("Em astronomia, qual é o nome do ponto em que a Terra está mais próxima do Sol?", 
            new String[]{"A) Apogeu", "B) Perigeu", "C) Afélio", "D) Periélio"}, 
            3, 14, "Astronomia"),
        
        new Pergunta("Qual compositor é conhecido como o 'pai da sinfonia'?", 
            new String[]{"A) Johann Sebastian Bach", "B) Ludwig van Beethoven", "C) Joseph Haydn", "D) Wolfgang Amadeus Mozart"}, 
            2, 14, "Música"),
        
        new Pergunta("Qual país possui o maior número de fusos horários no mundo?", 
            new String[]{"A) Rússia", "B) Canadá", "C) Estados Unidos", "D) França"}, 
            3, 14, "Geografia"),
        
        new Pergunta("Qual é o nome da corrente filosófica que defende que só é possível conhecer aquilo que se pode experimentar com os sentidos?", 
            new String[]{"A) Idealismo", "B) Empirismo", "C) Racionalismo", "D) Existencialismo"}, 
            1, 14, "Filosofia"),

        // ========== NÍVEL 15 - R$ 500.000 ==========
        new Pergunta("Qual foi o nome do navio no qual Charles Darwin realizou a viagem que resultou na Teoria da Evolução?", 
            new String[]{"A) Endeavour", "B) Discovery", "C) Beagle", "D) Victoria"}, 
            2, 15, "História"),
        
        new Pergunta("Qual é a equação de Euler que relaciona os cinco números matemáticos fundamentais?", 
            new String[]{"A) a² + b² = c²", "B) F = ma", "C) e^(iπ) + 1 = 0", "D) E = mc²"}, 
            2, 15, "Matemática"),
        
        new Pergunta("Qual obra do filósofo francês Michel Foucault analisa a relação entre saber e poder nas instituições disciplinares?", 
            new String[]{"A) As Palavras e as Coisas", "B) Vigiar e Punir", "C) A Ordem do Discurso", "D) História da Loucura"}, 
            1, 15, "Filosofia"),
        
        new Pergunta("Em que país nasceu a física teórica conhecida como 'mecânica quântica'?", 
            new String[]{"A) Reino Unido", "B) Alemanha", "C) Suíça", "D) Áustria"}, 
            1, 15, "Física"),
        
        new Pergunta("Qual é o nome da primeira mulher a ganhar um Prêmio Nobel, e também a única a ganhar em duas categorias diferentes (Física e Química)?", 
            new String[]{"A) Rosalind Franklin", "B) Lise Meitner", "C) Marie Curie", "D) Ada Lovelace"}, 
            2, 15, "Ciências"),

        // ========== PERGUNTA DO MILHÃO ==========
        new Pergunta("Qual destas obras literárias é considerada uma das primeiras manifestações do existencialismo na literatura ocidental?", 
            new String[]{"A) A Montanha Mágica -- Thomas Mann", "B) Crime e Castigo -- Fiódor Dostoiévski", "C) O Estrangeiro -- Albert Camus", "D) Em Busca do Tempo Perdido -- Marcel Proust"}, 
            2, 16, "Literatura/Filosofia")
    };

    public static void main(String[] args) {
        exibirMenuPrincipal();
    }

    // MENU PRINCIPAL
    public static void exibirMenuPrincipal() {
        while (true) {
            String[] opcoes = {"🎮 Iniciar Jogo", "📊 Ver Ranking", "ℹ️ Instruções", "🚪 Sair"};
            
            int escolha = JOptionPane.showOptionDialog(
                null,
                "🎉 SHOW DO MILHÃO - VERSÃO COMPLETA 🎉\n===================================",
                "Show do Milhão",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            switch (escolha) {
                case 0:
                    iniciarJogo();
                    break;
                case 1:
                    exibirRanking();
                    break;
                case 2:
                    exibirInstrucoes();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Obrigado por jogar! Até a próxima! 👋");
                    return;
                default:
                    return;
            }
        }
    }

    // INICIAR JOGO
    public static void iniciarJogo() {
        nomeJogador = JOptionPane.showInputDialog("Digite seu nome:");
        
        if (nomeJogador == null || nomeJogador.trim().isEmpty()) {
            nomeJogador = "Jogador";
        }

        JOptionPane.showMessageDialog(null, 
            "🎮 INICIANDO JOGO PARA: " + nomeJogador + "\n================================",
            "Show do Milhão", 
            JOptionPane.INFORMATION_MESSAGE);

        premioAtual = 0;
        int nivelAtual = 1;
        boolean jogoAtivo = true;

        while (jogoAtivo && nivelAtual <= 16) {
            if (nivelAtual == 16) {
                JOptionPane.showMessageDialog(null, 
                    "🏆 PERGUNTA FINAL - R$ 1.000.000 🏆\n===================================",
                    "Pergunta Final", 
                    JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, 
                    "🎯 NÍVEL " + nivelAtual + " - PRÊMIO: R$ " + PREMIOS[nivelAtual-1] + "\n================================",
                    "Nível " + nivelAtual, 
                    JOptionPane.INFORMATION_MESSAGE);
            }

            Pergunta pergunta = obterPerguntaAleatoria(nivelAtual);
            if (pergunta == null) {
                JOptionPane.showMessageDialog(null, "Não há perguntas disponíveis para este nível.");
                break;
            }

            boolean acertou = fazerPergunta(pergunta);
            
            if (acertou) {
                if (nivelAtual < 16) {
                    premioAtual = PREMIOS[nivelAtual-1];
                } else {
                    premioAtual = 1000000;
                }
                
                String mensagem = "✅ RESPOSTA CORRETA!\n\n💰 Você ganhou: R$ " + premioAtual;
                
                if (nivelAtual == 16) {
                    mensagem += "\n\n🎊🎊🎊 PARABÉNS! VOCÊ GANHOU O SHOW DO MILHÃO! 🎊🎊🎊";
                    adicionarAoRanking(nomeJogador, premioAtual);
                    JOptionPane.showMessageDialog(null, mensagem, "PARABÉNS!", JOptionPane.INFORMATION_MESSAGE);
                    jogoAtivo = false;
                } else {
                    JOptionPane.showMessageDialog(null, mensagem, "Resposta Correta!", JOptionPane.INFORMATION_MESSAGE);
                    
                    int continuar = JOptionPane.showConfirmDialog(null,
                        "Deseja continuar para a próxima pergunta?\n\nPróximo nível: " + (nivelAtual + 1) + 
                        "\nPróximo prêmio: R$ " + PREMIOS[nivelAtual],
                        "Continuar?",
                        JOptionPane.YES_NO_OPTION);
                    
                    if (continuar != JOptionPane.YES_OPTION) {
                        jogoAtivo = false;
                        JOptionPane.showMessageDialog(null, "💰 Você saiu com: R$ " + premioAtual);
                        adicionarAoRanking(nomeJogador, premioAtual);
                    }
                }
                nivelAtual++;
            } else {
                String respostaCorreta = pergunta.alternativas[pergunta.respostaCorreta];
                JOptionPane.showMessageDialog(null, 
                    "❌ RESPOSTA ERRADA!\n\n💸 Você perdeu tudo!\n\n📝 A resposta correta era:\n" + respostaCorreta,
                    "Resposta Errada", 
                    JOptionPane.ERROR_MESSAGE);
                adicionarAoRanking(nomeJogador, 0);
                jogoAtivo = false;
            }
        }

        if (nivelAtual > 16) {
            JOptionPane.showMessageDialog(null, 
                "🏆 VOCÊ É UM CAMPEÃO ABSOLUTO!\nCONQUISTOU R$ 1.000.000!",
                "Campeão!", 
                JOptionPane.INFORMATION_MESSAGE);
        }

        exibirMenuPosJogo();
    }

    // FAZER PERGUNTA
    private static boolean fazerPergunta(Pergunta pergunta) {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("📝 ").append(pergunta.categoria).append("\n");
        mensagem.append("====================\n\n");
        mensagem.append(pergunta.pergunta).append("\n\n");
        
        for (String alternativa : pergunta.alternativas) {
            mensagem.append(alternativa).append("\n");
        }

        String[] opcoesResposta = {"A", "B", "C", "D"};
        
        String resposta = (String) JOptionPane.showInputDialog(
            null,
            mensagem.toString(),
            "Show do Milhão - Responda",
            JOptionPane.QUESTION_MESSAGE,
            null,
            opcoesResposta,
            opcoesResposta[0]
        );

        if (resposta == null) {
            return false; // Usuario cancelou
        }

        int respostaIndex = -1;
        switch (resposta) {
            case "A": respostaIndex = 0; break;
            case "B": respostaIndex = 1; break;
            case "C": respostaIndex = 2; break;
            case "D": respostaIndex = 3; break;
            default: return false;
        }

        return respostaIndex == pergunta.respostaCorreta;
    }

    // RANKING
    public static void exibirRanking() {
        StringBuilder rankingMsg = new StringBuilder();
        rankingMsg.append("🏆 RANKING - SHOW DO MILHÃO\n");
        rankingMsg.append("==========================\n\n");
        
        if (ranking.isEmpty()) {
            rankingMsg.append("Nenhum jogador ainda...\n\nSeja o primeiro a jogar!");
        } else {
            for (int i = 0; i < ranking.size(); i++) {
                rankingMsg.append((i + 1)).append(". ").append(ranking.get(i)).append("\n");
            }
        }
        
        JOptionPane.showMessageDialog(null, rankingMsg.toString(), "Ranking", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void adicionarAoRanking(String nome, int premio) {
        String entrada = nome + " - R$ " + premio;
        ranking.add(entrada);
    }

    // INSTRUÇÕES
    public static void exibirInstrucoes() {
        String instrucoes = """
            📖 INSTRUÇÕES DO SHOW DO MILHÃO
            ================================
            
            🎯 OBJETIVO: 
            Chegar ao prêmio máximo de R$ 1.000.000
            
            📈 NÍVEIS: 
            16 níveis de dificuldade crescente
            Cada nível tem 5 perguntas diferentes
            
            🎮 COMO JOGAR:
            • Escolha a alternativa correta (A, B, C ou D)
            • A cada nível, o prêmio aumenta
            • Você pode parar a qualquer momento e ficar com o prêmio
            
            💰 SISTEMA DE PRÊMIOS:
            Nível 01: R$ 1.000      Nível 09: R$ 40.000
            Nível 02: R$ 2.000      Nível 10: R$ 50.000
            Nível 03: R$ 3.000      Nível 11: R$ 100.000
            Nível 04: R$ 4.000      Nível 12: R$ 200.000
            Nível 05: R$ 5.000      Nível 13: R$ 300.000
            Nível 06: R$ 10.000     Nível 14: R$ 400.000
            Nível 07: R$ 20.000     Nível 15: R$ 500.000
            Nível 08: R$ 30.000     Nível 16: R$ 1.000.000
            
            ⚠️  ATENÇÃO:
            • Resposta errada = Você perde tudo!
            • Pense bem antes de responder
            • Boa sorte!
            """;
            
        JOptionPane.showMessageDialog(null, instrucoes, "Instruções do Jogo", JOptionPane.INFORMATION_MESSAGE);
    }

    // MENU PÓS-JOGO
    public static void exibirMenuPosJogo() {
        String[] opcoes = {"🎮 Jogar Novamente", "📊 Ver Ranking", "🏠 Menu Principal"};
        
        int escolha = JOptionPane.showOptionDialog(
            null,
            "📋 O que você deseja fazer?",
            "Menu Pós-Jogo",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opcoes,
            opcoes[0]
        );

        switch (escolha) {
            case 0:
                iniciarJogo();
                break;
            case 1:
                exibirRanking();
                exibirMenuPosJogo();
                break;
            case 2:
                exibirMenuPrincipal();
                break;
            default:
                exibirMenuPrincipal();
        }
    }

    // OBTER PERGUNTA ALEATÓRIA
    private static Pergunta obterPerguntaAleatoria(int nivel) {
        List<Pergunta> perguntasNivel = new ArrayList<>();
        for (Pergunta p : perguntas) {
            if (p.nivel == nivel) {
                perguntasNivel.add(p);
            }
        }
        
        if (perguntasNivel.isEmpty()) return null;
        
        return perguntasNivel.get(random.nextInt(perguntasNivel.size()));
    }
}