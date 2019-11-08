package bdd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Initialisation {
	
	double matrice[][]=new double[149][4];
	
	public Initialisation() throws IOException {
		
		int i=0;
		BufferedReader lecteurAvecBuffer = null;
		String ligne;
		String token="";
		int boucle=0;
		double result;
		 String BDD[] = new String[150];
		 
		 
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
	       
	       //le traitement pour la premiére ligne différt mais le reste du 
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
	     
	   //insertion des 50 lignes suivantes -------"Iris-virginica"-------
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
}
}
