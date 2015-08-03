package com.colonw.GeneticsSimulation;

import java.util.ArrayList;
import java.util.Scanner;

public class GeneticsSimulation {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int popSize, popSizeOriginal, gens;
		ArrayList<Parent> population = new ArrayList<Parent>();
		ArrayList<Parent> offspring = new ArrayList<Parent>();
		Parent curParent, curMate;
		int curParentNum, curMateNum; // holds indeces of parents
		
		// inputs
		System.out.print("Population size: ");
		popSizeOriginal = input.nextInt();
		if(popSizeOriginal % 2 == 1) {
			System.out.println("POPULATION SIZE NOT EVEN");
			return;
		} else {
			popSize = popSizeOriginal;
		}
		System.out.print("Number of generations: ");
		gens = input.nextInt();
		
		// fill population AL with all heterozygous
		for(int i = 0; i < popSize; i++) {
			population.add(new Parent(new Genotype("heterozygous")));
		}
		
		// generation sequence
		for(int i = 0; i < gens; i++) { // repeat for each generation
			System.out.println("\nGeneration " + i + ":");
			for(int j = 0; j < popSizeOriginal/2; j++) { // repeat for all pairs of parents
				// get a random parent
				curParentNum = (int)(Math.random()*popSize);
				curParent = population.get(curParentNum);
				population.remove(curParentNum);
				popSize--;
				// get a random mate
				curMateNum = (int)(Math.random()*popSize); 
				curMate = population.get(curMateNum);
				population.remove(curMate);
				popSize--;
				// add two offspring into offspring AL
				offspring.add(new Parent(curParent.mate(curMate)));
				offspring.add(new Parent(curMate.mate(curParent)));
			}
			// reset popSize
			popSize = offspring.size(); 
			// print offspring genotypes
			for(int j = 0; j < popSize; j++) {
				System.out.println("\t" + offspring.get(j).getCards().getType()[0]
										+ offspring.get(j).getCards().getType()[1]
										+ offspring.get(j).getCards().getType()[2]
										+ offspring.get(j).getCards().getType()[3]
										+ "\t" + offspring.get(j).getCards().getSimplifiedType());
			}
			// clear the population AL and fill it with offspring AL data
			population.clear(); // redundancy
			for(int j = 0; j < popSize; j++) {
				population.add(offspring.get(j));
			}
			offspring.clear();
		}
		
		int dominant = 0;
		int recessive = 0;
		int heterozygous = 0;
		
		for(int i = 0; i < popSize; i++) {
			if(population.get(i).getCards().getSimplifiedType().equals("dominant"))
				dominant++;
			if(population.get(i).getCards().getSimplifiedType().equals("recessive"))
				recessive++;
			if(population.get(i).getCards().getSimplifiedType().equals("heterozygous"))
				heterozygous++;
		}
		
		System.out.println("\nGenotypes:");
		System.out.println("\tDominant: " + dominant);
		System.out.println("\tRecessive: " + recessive);
		System.out.println("\tHeterozygous: " + heterozygous);
		
	}
}
