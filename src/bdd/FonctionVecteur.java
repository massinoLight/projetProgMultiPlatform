package bdd;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FonctionVecteur {
	

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

	
	
	
	
	
	 //afficher un vecteur
    public static void afficherVecteur(double monTab2[]) {
   	 
   	     for(int j = 0; j< monTab2.length; j++){   
   	    	 System.out.print(monTab2[j]+" | "); 
   	     }  
   	
   	 }  
    

	
	

}
