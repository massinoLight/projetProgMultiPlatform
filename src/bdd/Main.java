package bdd;

import java.io.IOException;

public class Main extends FonctionMatrice {

	 
	
	public static void main(String[] args) throws IOException {
		
		double matrice[][]=new double[150][4];
		double matriceNormalise[][]=new double[150][4];
		double matriceAléatoire[][]=new double[150][4];
		double vecteurMoyen[]=new double[4];
		double vecteurMin[]=new double[4];
		double vecteurMax[]=new double[4];
		double vecteurAleatoire[]=new double[150];
		int shuffleTable[]=new int[150];
		double valeurMatriceAleatoire[]=new double[4];
		double meilleurVecteur[]=new double[4];
		
		int valeurAlindiceUnDuTableau_de_shuffle=0;
		
		Initialisation init=new Initialisation();
		matrice=init.matrice;
		
		NormalisationLongeur normal=new NormalisationLongeur(matrice);
		matriceNormalise=normal.matriceNormalise;
		vecteurMoyen=NormalisationLongeur.vecteurMoyen(matriceNormalise);
		NormalisationLongeur.vminVmax(vecteurMoyen, vecteurMin, vecteurMax);
		
		NormalisationLongeur.tableAleatoireAutourDeLaMoyenne(vecteurAleatoire, vecteurMin, vecteurMax);
		shuffleTable=NormalisationLongeur.shuffle_table();
		
		matriceAléatoire=NormalisationLongeur.Bdd_aléatoire(shuffleTable, matrice);
		
		valeurAlindiceUnDuTableau_de_shuffle=shuffleTable[0];
		
		valeurMatriceAleatoire=NormalisationLongeur.Vecteur_aleatoire_deLaBdd(shuffleTable, matrice);
		
		meilleurVecteur=NormalisationLongeur.plus_petite_distance_euclidienne(valeurMatriceAleatoire,matrice,shuffleTable[0]);
		
		
		System.out.println("---------------Donnée Brute--------------------------");
        afficherMatrice(matrice);
		
		System.out.println("---------------Matrice Normalisé--------------------------");
		afficherMatrice(matriceNormalise);
		System.out.println("---------------Vecteur Max= Vecteur Moyen+0.005--------------------------");
		afficherTableau(vecteurMax);
		System.out.println("---------------Vecteur Moyen----------------------------------------------");
		afficherTableau(vecteurMoyen);
		System.out.println("---------------Vecteur Min= Vecteur Moyen-0.005--------------------------");
		afficherTableau(vecteurMin);
		System.out.println("---------------Vecteur Aléatoire autours de la moyenne--------------------------");
		afficherTableau(vecteurAleatoire);
		
		System.out.println("---------------Un Shuffle Table--------------------------");
		afficherTableauInt(shuffleTable);
		System.out.println();
		
		System.out.println("---------------matrice Aléatoire--------------------------");
        afficherMatrice(matriceAléatoire);
        
        System.out.println("---------------Un vecteur aléatoire de la matrice--------------------------");
        afficherTableau(valeurMatriceAleatoire);
		System.out.println();
		
		 System.out.println("---------------le vecteur avec la plus petite distance E du vecteur précedant est----------");
	        afficherTableau(meilleurVecteur);
			System.out.println();
	       
	      }  
	    
	
	
	


}
       

	


