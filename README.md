#Projet courrier
Bellamy Matthieu / Dubois Yann
20/11/15

##Introduction

Cette application simule l'envoie et la réception de courrier entre une centaine d'habitant dans une même ville.

##Usage

Pour lancer l'application :</br>
<code>java -jar courrier_dubois_bellamy.jar</code>

##Architecture
- Letter : Classe abstraite générique, le type générique correspond au contenu de la lettre
- Content : Interface représentant le contenu d'une lettre

Letter est une classe decorator qui permet d'avoir une superposition de lettre, en soit, une lettre peut contenir une lettre

##Code samples

TestLetter : Test abstrait pour toute les lettres


	@Before
	public void init() {
		City city = new City("Lille");
		Inhabitant sender = new Inhabitant(city, "timoleon");
		Inhabitant receiver = new Inhabitant(city, "yoda");
		this.letter = this.createLetter(sender, receiver);
	}

	protected abstract Letter<?> createLetter(Inhabitant sender, Inhabitant receiver);
	protected abstract void testDoActionForThisLetter();

	@Test
	public void testDoAction() {
		testDoActionForThisLetter();
	}

TestRegisteredLetter : Mook class


	class MookLetter extends Letter<MookContent> {
		
		private boolean actionDone;
		
		public MookLetter(Inhabitant sender, Inhabitant receiver, MookContent content) {
			super(sender, receiver, content);
			this.actionDone = false;
		}

		@Override
		public String getDescription() {
			return this.content.getDescription();
		}

		@Override
		public void doAction() {
			this.actionDone = true;
			this.getDescription();
		}
		
	}

