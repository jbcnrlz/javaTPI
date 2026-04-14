package sistema;

import dados.Jogo;
import dao.JogoDAO;
public class Principal {

	public static void main(String[] args) {
		
		Jogo j = new Jogo("Sem regra nenhum", "FATEC the Card Game");
		JogoDAO jd = new JogoDAO();
		jd.salvar(j);		
		j.setRegras("Aqui está uma proposta de regras para o FATEC: The Card Game, um jogo de cartas temático focado na sobrevivência, estratégia e no caos da vida de um estudante de tecnologia.\n"
				+ "\n"
				+ "🎓 FATEC: The Card Game - Livro de Regras\n"
				+ "🎯 Objetivo do Jogo\n"
				+ "Sobreviver aos semestres da FATEC e ser o primeiro jogador a acumular 40 Créditos Acadêmicos (CA) para conseguir o tão sonhado Diploma. Se os seus Pontos de Sanidade (PS) chegarem a zero, você \"tranca o curso\" e é eliminado da partida.\n"
				+ "\n"
				+ "👥 Jogadores\n"
				+ "Quantidade: 2 a 4 jogadores.\n"
				+ "\n"
				+ "Duração: 30 a 45 minutos.\n"
				+ "\n"
				+ "🃏 Tipos de Cartas\n"
				+ "O baralho é composto por 4 tipos principais de cartas:\n"
				+ "\n"
				+ "Estudantes (Personagens): Cada jogador escolhe (ou compra) um no início do jogo. Eles possuem habilidades únicas e atributos base de Inteligência e Energia.\n"
				+ "\n"
				+ "Exemplo: \"O Veterano\" (Pode ignorar uma DP por jogo), \"O Zumbi do Café\" (Ganha bônus de Energia, mas perde Sanidade todo turno).\n"
				+ "\n"
				+ "Disciplinas (Desafios): Ficam no centro da mesa. Elas exigem um número específico de Inteligência ou Energia para serem vencidas. Ao derrotá-las, o jogador ganha Créditos Acadêmicos. Falhar resulta em pegar uma DP (Dependência) e perder Sanidade.\n"
				+ "\n"
				+ "Exemplo: \"Cálculo Diferencial\", \"Estrutura de Dados\", \"Inglês I\".\n"
				+ "\n"
				+ "Itens (Equipamentos): Cartas que ficam na sua mesa (\"Mochila\") e dão bônus passivos ou ativos.\n"
				+ "\n"
				+ "Exemplo: \"Garrafa Térmica de Café\" (+2 de Energia), \"Pen Drive de 128GB\" (Permite segurar mais cartas na mão).\n"
				+ "\n"
				+ "Eventos / Ação: Cartas de efeito instantâneo que podem te ajudar ou sabotar os colegas.\n"
				+ "\n"
				+ "Exemplo: \"Semana de Provas\" (Todos perdem 2 de Sanidade), \"Xerox Quebrada\" (Oponente não pode usar Itens neste turno), \"Passe Livre\" (Compre 2 cartas).\n"
				+ "\n"
				+ "⚙️ Preparação (Setup)\n"
				+ "Cada jogador começa com 20 Pontos de Sanidade (PS) (use dados ou fichas para marcar).\n"
				+ "\n"
				+ "Separe as cartas de Estudante e distribua uma aleatoriamente para cada jogador.\n"
				+ "\n"
				+ "Embaralhe o deck principal (Disciplinas, Itens e Eventos) e coloque-o no centro da mesa.\n"
				+ "\n"
				+ "Cada jogador saca 5 cartas do deck principal.\n"
				+ "\n"
				+ "O jogador que tomou café mais recentemente começa a partida.\n"
				+ "\n"
				+ "🔄 Estrutura do Turno\n"
				+ "O turno de cada jogador é dividido em 4 fases:\n"
				+ "\n"
				+ "1. Fase de Matrícula (Compra)\n"
				+ "Compre 1 carta do deck principal. Se o deck acabar, embaralhe a pilha de descarte para formar um novo deck.\n"
				+ "\n"
				+ "2. Fase de Estudos (Ação)\n"
				+ "Você pode jogar quantas cartas de Item quiser na sua \"Mochila\" (mesa).\n"
				+ "\n"
				+ "Você pode jogar cartas de Evento para se ajudar ou atrapalhar os outros.\n"
				+ "\n"
				+ "Você pode baixar 1 Disciplina da sua mão para o centro da mesa para tentar resolvê-la na próxima fase (ou jogar uma Disciplina na mesa de um oponente para atrapalhá-lo!).\n"
				+ "\n"
				+ "3. Fase de Prova (Resolução)\n"
				+ "Você deve enfrentar uma Disciplina que esteja na sua área de jogo.\n"
				+ "\n"
				+ "Some os pontos de Inteligência e Energia do seu Estudante com os bônus dos seus Itens.\n"
				+ "\n"
				+ "Se o total for maior ou igual à dificuldade da Disciplina: Você foi aprovado! Coloque a carta na sua \"Pilha de Conclusão\" e some os Créditos Acadêmicos (CA).\n"
				+ "\n"
				+ "Se o total for menor: Você pegou DP! A carta vai para o descarte, você não ganha créditos e perde a quantidade de Sanidade (PS) indicada na carta.\n"
				+ "\n"
				+ "4. Fase do Bar (Fim de Turno)\n"
				+ "Seu limite de mão é de 7 cartas. Se tiver mais do que isso, descarte até ficar com 7.\n"
				+ "\n"
				+ "Passe a vez para o jogador à esquerda.\n"
				+ "\n"
				+ "⚠️ Regras Especiais\n"
				+ "TCC (Trabalho de Conclusão de Curso): Quando um jogador atinge 35 Créditos Acadêmicos, ele entra na \"Fase de TCC\". Qualquer oponente pode jogar cartas de Evento diretamente contra ele fora de turno (representando o orientador e os bugs de última hora). Ele só vence se sobreviver a uma rodada completa com 40 CA ou mais.\n"
				+ "\n"
				+ "Trancar o Curso: Se sua Sanidade chegar a 0, você está eliminado do jogo. Suas cartas de Item e Evento na mão vão para a pilha de descarte. As Disciplinas concluídas (Créditos) são perdidas.\n"
				+ "\n"
				+ "🏆 Fim de Jogo\n"
				+ "O jogo termina imediatamente quando um jogador acumula 40 Créditos Acadêmicos e sobrevive à sua defesa de TCC, tornando-se o mais novo Tecnólogo da FATEC. Ou, caso todos os outros jogadores percam sua Sanidade, o último estudante de pé é o vencedor!"
			);
		jd.salvar(j);
		if (jd.excluir(j.getId())) {
			j.setId(-1);
		}
		
	}
	
}
