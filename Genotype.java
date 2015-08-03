package com.colonw.GeneticsSimulation;

public class Genotype {
	
	private String[] type;
	private String typeSimple;
	
	public Genotype(String typeIn){
		type = new String[4];
		typeSimple = typeIn;
		switch(typeIn) {
			case "dominant":
				type[0] = "P";
				type[1] = "P";
				type[2] = "P";
				type[3] = "P";
				break;
			case "heterozygous":
				type[0] = "P";
				type[1] = "P";
				type[2] = "Q";
				type[3] = "Q";
				break;
			case "recessive":
				type[0] = "Q";
				type[1] = "Q";
				type[2] = "Q";
				type[3] = "Q";
				break;
			default:
				System.out.println("Invalid genotype type");
				break;
		}
	}
	
	public String getRandom() {
		return type[(int)(Math.random() * 4)];
	}
	
	public String[] getType() {
		return type;
	}
	
	public String getSimplifiedType() {
		return typeSimple;
	}
	
}
