package bdd;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class NormalisationLongeur {

	 double matriceNormalise[][]=new double[149][4];
	 double tableaDeLongeur[]=new double[149];


	public NormalisationLongeur(double matr[][]) {
		
		matriceNormalise=normalisationVecteur(matr);
		 
}
	
	//fonction pour normaliser un vecteur 
	public static double[][] normalisationVecteur(double matr[][]) {
   	 
   	 
   	 double longeur[]=calculeLongeurVecteur(matr);
   	 double matriceDestination[][]=new double[149][4];
   	  	   
 	 for (int j = 0; j < 149; j++) {
 		
   	  for (int j2 = 0; j2 < 4; j2++) {
   		  
   		  matriceDestination[j][j2]=matr[j][j2]/longeur[j];
   	  }
   		  
		}
 	   return matriceDestination;
   	 } 
	
	
	
	//fonction pour calculer la longeur d'un vecteur  ------
	//utiliser et on garde la longeur de chaque vecteur dans un tableau
	public static double[] calculeLongeurVecteur(double monTab2[][]) {
    	double longeurVecteur=0.0;
  	   double lesLongeur[]=new double[149];
  	   for (int i = 0; i < lesLongeur.length; i++) {
  		 longeurVecteur=0.0;
		for (int j = 0; j < 4; j++) {
  		   
  		   longeurVecteur=longeurVecteur+Math.pow(monTab2[i][j],2);
  		   //System.out.println(longeurVecteur);
  	       }
  	   lesLongeur[i]=Math.sqrt(longeurVecteur);
  	   
  	   }
  	  
    	 return lesLongeur;
    	 } 
	
	
	/**
	 * Calcule du vecteur moyen
	 * comme résultat on aura 
	 * un tableau de 4 cases qui va représenter 
	 * la moyenne des valeurs colléctées dans la BDD
	 * 
	 * ***/
	
	
	public static double[] vecteurMoyen(double matrice[][]) {
		double vecteurMoy[]=new double[4];
		double v=0.0;
		int j ;
		
			for (int i = 0; i < 4; i++) {
				
			
			for ( j = 0; j < 149; j++) {
				
				v=v+matrice[j][i];
			}
			vecteurMoy[i]=v/j;
		
			}
		
		return vecteurMoy;
		
	}
	
	/**
	 * Calcule des vecteurs Min et Max 
	 * autours de la Moyenne
	 * et les garder dans des tableaux
	 * ***/
	public static void vminVmax(double vmoyen[],double vmin[],double vmax[]) {
		
		for(int a=0;a<vmoyen.length;a++) {
			vmin[a]=vmoyen[a]-0.005;
			vmax[a]=vmoyen[a]+0.005;
			
		}
		
		
	}
	
	/**
	 * Génération d'un tableau aléatoire 
	 * centré autours de la moyenne 
	 * comme retours on  aura un tableau de 150 cases 
	 * qui va contenir pour chaque case une valeur généré aléatoirement 
	 * entre (VecteurMin,VecteurMax)
	 * 
	 * 
	 * ***/
	
	
	public static void tableAleatoireAutourDeLaMoyenne(double vAleatoire[],double vmin[],double vmax[]) {
		
		double random=0.0;
		int h=0;
		for(int a=0;a<vAleatoire.length;a++) {
			
			
				if (h==4) {
					h=0;
				}
				random = ThreadLocalRandom.current().nextDouble(vmin[h], vmax[h]);
				vAleatoire[a]=random;
			h++;
			
			
		}
		
		
	}
	
	/**
	 * generation d'un tableau aleatoire
	 * shuffle table 
	 * 
	 * ***/
	
	public static int[] shuffle_table() {
		
		int tableau[] = new int[150];
		//remplire le tableau
		for (int i = 0; i < tableau.length; i++) {
			tableau[i]=i;
		}
		
		
			Random c=new Random();
			int al=c.nextInt(149);
			System.out.println(al);
			int prov=0;
			//mettre le tableau de magniére aleatoire 
			for (int i = 0; i < tableau.length; i++) {
				prov=tableau[i];
				tableau[i]=tableau[al];
				tableau[al]=prov;
				c=new Random();
				 al=c.nextInt(149);
			}
			
		return tableau;
		
		
		
	}

	
	/**
	 * une fonction qui retourne une nvlle bdd
	 * aléatoire a partir d'un tableau suffle table
	 *  
	 * **/
	
public static double[][] Bdd_aléatoire(int tableau[],double matBdd[][]) {
		
	double matrRetour[][]=new double[150][4];;
		
	for (int i = 0; i < matBdd.length; i++) {
		
		matrRetour[i][0]=matBdd[tableau[i]][0];
		matrRetour[i][1]=matBdd[tableau[i]][1];
		matrRetour[i][2]=matBdd[tableau[i]][2];
		matrRetour[i][3]=matBdd[tableau[i]][3];
		
	}
			
		
	
		return matrRetour;
		
		
	}
	
	

/**
 * une fonction qui retourn une valeurs
 * de la base de données passé en paramétre de façon 
 * aléatoire a partir d'un indice du tableau de suffle
 *  
 * **/

     public static double[] Vecteur_aleatoire_deLaBdd(int tableau[],double matBdd[][]) {
	
       double matrRetour[]=new double[4];
	
       
	
	matrRetour[0]=matBdd[tableau[0]][0];
	matrRetour[1]=matBdd[tableau[0]][1];
	matrRetour[2]=matBdd[tableau[0]][2];
	matrRetour[3]=matBdd[tableau[0]][3];
	

	return matrRetour;
	
	
}
     
     /**
      * cette fonction retourn les distances euclidiennes d'un 
      * vecteur passé en paramétre 
      * et d'une matrice 
      * 
      * **/
	
	public static double distance_euclidienne(double t1[],double t2[]) {
		
		
		double somme=0.0;
		
		for (int i = 0; i < t1.length; i++) {
			
			somme=somme+Math.pow(t1[i]-t2[i],2);
			
		}
	
		return Math.sqrt(somme);
	}
	
	/**
	 * 
	 * une fonction qui retourn un vecteur de la bdd qui a la plus petite 
	 * distance Euclidienne entre le vecteur passé
	 * en paramétre 
	 * ****/
	
	
public static double[] plus_petite_distance_euclidienne(double t1[],double t2[][],int ind) {
		
	double meilleurVecteur[]=new double[4];
	double distance=0.0;
	double petite=0.0;
	distance=distance_euclidienne(t1,t2[0]);
	petite=distance;
	
	for (int i = 0; i < ind; i++) {
		distance=distance_euclidienne(t1,t2[i]);
		
		if (distance<petite) {
			petite=distance;
			meilleurVecteur=t2[i];
			
		}
		
	}
	for (int i =ind+1; i < t2.length; i++) {
		distance=distance_euclidienne(t1,t2[i]);
		
		if (distance<petite) {
			petite=distance;
			meilleurVecteur=t2[i];
			
		}
		
	}
	
	
	
		return meilleurVecteur;
	}
	
	
}
