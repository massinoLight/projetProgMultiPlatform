package bdd;

import java.io.IOException;

public class Main {

	 
	
	public static void main(String[] args) throws IOException {
		
		double matrice[][]=new double[149][4];
		double matriceNormalise[][]=new double[149][4];
		double vecteurMoyen[]=new double[4];
		double vecteurMin[]=new double[4];
		double vecteurMax[]=new double[4];
		
		Initialisation init=new Initialisation();
		matrice=init.matrice;
		System.out.println("---------------Donnée Brute--------------------------");
        afficherMatrice(matrice);
		NormalisationLongeur normal=new NormalisationLongeur(matrice);
		matriceNormalise=normal.matriceNormalise;
		vecteurMoyen=NormalisationLongeur.vecteurMoyen(matriceNormalise);
		NormalisationLongeur.vminVmax(vecteurMoyen, vecteurMin, vecteurMax);
		System.out.println("---------------Matrice Normalisé--------------------------");

	      afficherMatrice(matriceNormalise);
		System.out.println("---------------Vecteur Max--------------------------");
		afficherTableau(vecteurMax);
		System.out.println("---------------Vecteur Moyen-------------------------");
		afficherTableau(vecteurMoyen);
		System.out.println("---------------Vecteur Min---------------------------");
		afficherTableau(vecteurMin);
	       
	      }  
	    
	
	
	//afficher une matrice
	     public static void afficherMatrice(double monTab2[][]) {
	    	 for(int i = 0 ; i < monTab2.length; i++ ){  
	    	     for(int j = 0; j< monTab2[i].length; j++){   
	    	         System.out.print(monTab2[i][j]+","); 
	    	     } 
	    	System.out.println(); 
	    	}   
	    	 }  
	    	 
	     //afficher un tableau
	     public static void afficherTableau(double monTab2[]) {
	    	 
	    	     for(int j = 0; j< monTab2.length; j++){   
	    	         System.out.println(monTab2[j]); 
	    	     }  
	    	
	    	 }      



}
       

	


