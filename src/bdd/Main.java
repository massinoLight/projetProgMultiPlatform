package bdd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		String EtiquetteFleur="";
		
		//une collection de Nodes 
		 List<Node> listDesNodes = new ArrayList<Node>();
		
		
		/**
		 * les instances des classes 
		 * **/
		Initialisation init=new Initialisation();
		matrice=init.matrice;
		NormalisationLongeur normal=new NormalisationLongeur(matrice);
		FonctionVecteur traitementVecteur =new FonctionVecteur();
		FonctionMatrice traitementMatrice=new FonctionMatrice();
		
		
		matriceNormalise=normal.matriceNormalise;
		
		vecteurMoyen=traitementVecteur.vecteurMoyen(matriceNormalise);
		traitementVecteur.vminVmax(vecteurMoyen, vecteurMin, vecteurMax);
		
		traitementVecteur.tableAleatoireAutourDeLaMoyenne(vecteurAleatoire, vecteurMin, vecteurMax);
		
		
		//un tableau de shuffle 
		shuffleTable=traitementVecteur.shuffle_table();
		
		/***
		 * on créer les Nodes avec 60 vecteurs
		 * 
		 * 
		 * ***/
 
		
  /**
   * affichage sur la console
   * 
   * **/
		
		matriceAléatoire=FonctionMatrice.Bdd_aléatoire(shuffleTable, matrice);
		System.out.println("---------------Données Brute--------------------------");
        afficherMatrice(matrice);
		
		System.out.println("---------------Matrice Normalisé--------------------------");
		afficherMatrice(matriceNormalise);
		System.out.println("---------------Vecteur Max= Vecteur Moyen+0.005--------------------------");
		afficherTableau(vecteurMax);
		System.out.println();
		System.out.println("---------------Vecteur Moyen----------------------------------------------");
		afficherTableau(vecteurMoyen);
		System.out.println();
		System.out.println("---------------Vecteur Min= Vecteur Moyen-0.005--------------------------");
		afficherTableau(vecteurMin);
		System.out.println();
		System.out.println("---------------Vecteur Aléatoire autours de la moyenne--------------------------");
		afficherTableau(vecteurAleatoire);
		System.out.println();
		
		System.out.println("---------------Un Shuffle Table--------------------------");
		afficherTableauInt(shuffleTable);
		System.out.println();
		
		System.out.println("---------------matrice Aléatoire--------------------------");
        afficherMatrice(matriceAléatoire);
        
        
		
		
		 for (int i = 0; i < 61; i++) {
				
				//on colle une etiquette selon l'appartenance de la fleur
				if (shuffleTable[i]<=50) {
					EtiquetteFleur="Iris-setosa";
				} else {
					if (shuffleTable[i]<=100) {
						EtiquetteFleur="Iris-versicolor";
					} else {

						EtiquetteFleur="Iris-virginica";
					}

				}
				//on instancie un nouveau node avec les valeurs récupérées
				Node n=new Node(traitementMatrice.Vecteur_aleatoire_deLaBdd(shuffleTable[i], matrice)
						, EtiquetteFleur,
						traitementMatrice.distance_euclidienne(valeurMatriceAleatoire,meilleurVecteur),
						traitementMatrice.plus_petite_distance_euclidienne(valeurMatriceAleatoire,matrice,shuffleTable[i]));
				//on ajoute le node a la liste des nodes
				listDesNodes.add(n);
				}	
			  
			  Node affiche=new Node();
			  affiche.afficheNode(listDesNodes);
	       
	      }  
	    
	
	
	


}
       

	


