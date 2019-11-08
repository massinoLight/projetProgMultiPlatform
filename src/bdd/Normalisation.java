package bdd;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;

public class Normalisation {
	
	public static void main(String[] args) throws IOException {

		int i=0;
		BufferedReader lecteurAvecBuffer = null;
		String ligne;
		String token="";
		int boucle=0;
		double result;
		 String BDD[] = new String[150];
		 double matrice[][]=new double[149][4];
		 double matriceNormalise[][]=new double[149][4];
		 //double tablong[]=new double[149];
		 
	       try{
	    	   //ouverture de la BDD au forma data
	    	   lecteurAvecBuffer = new BufferedReader(new FileReader("/home/massino/Bureau/iris.data"));
	     
	       }
	        catch(FileNotFoundException exc){
	        	
		          System.out.println("Erreur d'ouverture");
	      }
	       //lire la BDD ligne par ligne et la placer dans un tableau de String et  dans une chaine pour l'utiliser dans  un tokenizer
	      
	       
	       
	       while (((ligne = lecteurAvecBuffer.readLine()) != null)) {
	           BDD[i]=ligne;
	           token=token+" "+ligne;
	 	     i++;
	 	    
	    	
	        }
	       lecteurAvecBuffer.close();
	      
	       StringTokenizer st = new StringTokenizer(token);
	       String next;
	       
	       
	     
	       //Insertion des 50 premiéres lignes -------"Iris-setosa"----- dans le tableau de doubles
	       
	       //le traitement pour la premiére ligne différt mais le reste du ficher sera simple
	       next=st.nextToken(", ");
	       for (int ii = 0; ii < 4; ii++) {
		    	result = Double.parseDouble(next);
		 	   matrice[boucle][ii]=result;
		 	   //System.out.println(result);
		 	   if(ii<3) {
		 	  next=st.nextToken();
		 	   }
	      }
	       
	     while (boucle<49) {
			
		
	       next=st.nextToken(",Iris-setosa");
	       boucle++;
	       for (int ii = 0; ii < 4; ii++) {
		    	result = Double.parseDouble(next);
		 	   matrice[boucle][ii]=result;
		 	   //System.out.println(result);
		 	   if(ii<3) {
		 	  next=st.nextToken();
		 	   }  
	      }
	       
	      }  
	     
	      
	     next=st.nextToken(",Iris-setosa ");
	     for (int ii = 0; ii < 4; ii++) {
		    	result = Double.parseDouble(next);
		 	   matrice[boucle][ii]=result;
		 	   //System.out.println(result);
		 	   if(ii<3) {
		 	  next=st.nextToken();
		 	   }
	      }
	     //insertion des 50 lignes suivantes -------"Iris-versicolor"-------
	     
	     while (boucle<99) {
				
	 		
		       next=st.nextToken(",Iris-versicolor");
		       boucle++;
		       for (int ii = 0; ii < 4; ii++) {
			    	result = Double.parseDouble(next);
			 	   matrice[boucle][ii]=result;
			 	   //System.out.println(result);
			 	   if(ii<3) {
			 	  next=st.nextToken();
			 	   }  
		      }
		       
		      } 
	     
	   //insertion des 50 lignes suivante -------"Iris-virginica"-------
	     
	     while (boucle<148) {
				
		 		
		       next=st.nextToken(",Iris-virginica");
		       boucle++;
		       for (int ii = 0; ii < 4; ii++) {
			    	result = Double.parseDouble(next);
			 	   matrice[boucle][ii]=result;
			 	   //System.out.println(result);
			 	   if(ii<3) {
			 	  next=st.nextToken();
			 	   }  
		      }
		       
		      } 
	     
	     
	     
	      afficherMatrice(matrice);
	     
	   matriceNormalise=normalisationVecteur(matrice);
	  
	  afficherMatrice(matriceNormalise);
	      //tablong=calculeLongeurVecteur(matrice);
	      
	     
	      }  
	       

	     
//fonction pour normaliser un vecteur 
public static double[][] normalisationVecteur(double matr[][]) {
	    	 
	    	// double longeurVecteur=0.0;
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
	     
//fonction pour afficher les matrices et les tableaux 
public static void afficheTableau(double tab[]) {
    	for (int j = 0; j < tab.length; j++) {
    		System.out.println(tab[j]);
    	}
           
          } 
public static void afficherMatrice(double monTab2[][]) {
	 for(int i = 0 ; i < monTab2.length; i++ ){  
	     for(int j = 0; j< monTab2[i].length; j++){   
	         System.out.print(monTab2[i][j]+","); 
	     } 
	System.out.println(); 
	}
	 }  	 
	     

}
       

	


