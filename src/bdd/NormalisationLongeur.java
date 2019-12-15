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
	
	
	

}
