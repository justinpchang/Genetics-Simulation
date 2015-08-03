package com.colonw.GeneticsSimulation;

public class Parent {

	private Genotype cards;
	
	// mating variables
	private String myCard; // card picked from my stack
	private String mateCard; // card picked from mate's stack
	
	public Parent(Genotype cardsIn) {
		cards = cardsIn;
	}
	
	public Genotype getCards() {
		return cards;
	}
	
	public Genotype mate(Parent mate) {
		myCard = cards.getRandom();
		mateCard = mate.getCards().getRandom();
		
		if(myCard.equals("P")) {
			if(mateCard.equals("P"))
				return new Genotype("dominant");
			else // if(mateCard.equals("Q"))
				return new Genotype("heterozygous");
		}
		else if(myCard.equals("Q")) {
			if(mateCard.equals("Q"))
				return new Genotype("recessive");
			else // if(mateCard.equals("P"))
				return new Genotype("heterozygous");
		}
		else {
			System.out.println("SOMETHING WENT WRONG DURING MATING! ignore following genotype error message");
			return new Genotype("error");
		}
		
		/* 
		if(cards.getSimplifiedType().equals("heterozygous")) {
			switch(mate.getCards().getSimplifiedType()) {
				case "heterozygous":
					switch((int)(Math.random() * 4)) {
						case 1:
							return new Genotype("dominant");
						case 2:
						case 3:
							return new Genotype("heterozygous");
						case 4:
							return new Genotype("recessive");
					}
					break;
				case "dominant":
					switch((int)(Math.random() * 4)) {
						case 1:
						case 2:
							return new Genotype("dominant");
						case 3:
						case 4:
							return new Genotype("heterozygous");
					}
					break;
				case "recessive":
					switch((int)(Math.random() * 4)) {
						case 1:
						case 2:
							return new Genotype("heterozygous");
						case 3:
						case 4:
							return new Genotype("recessive");
					}
					break;
			}
		}
		else if(cards.getSimplifiedType().equals("dominant")) {
			switch(mate.getCards().getSimplifiedType()) {
				case "heterozygous":
					switch((int)(Math.random() * 4)) {
						case 1:
						case 2:
							return new Genotype("dominant");
						case 3:
						case 4:
							return new Genotype("heterozygous");
					}
					break;
				case "dominant":
					return new Genotype("dominant");
				case "recessive":
					return new Genotype("heterozygous");
			}
		}
		else { // recessive
			switch(mate.getCards().getSimplifiedType()) {
				case "heterozygous":
					switch((int)(Math.random() * 4)) {
						case 1:
						case 2:
							return new Genotype("heterozygous");
						case 3:
						case 4:
							return new Genotype("recessive");
					}
					break;
				case "dominant":
					return new Genotype("heterozygous");
				case "recessive":
					return new Genotype("recessive");
			}
		}
		System.out.println("SOMETHING WENT WRONG DURING MATING! ignore following genotype error message");
		return new Genotype("error");
		*/
	}
	
}
