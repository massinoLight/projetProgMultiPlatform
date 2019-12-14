package bdd;

public class FonctionMatrice {
	
	
	//afficher une matrice
    public static void afficherMatrice(double monTab2[][]) {
   	 for(int i = 0 ; i < monTab2.length; i++ ){  
   		 System.out.println(monTab2[i][0]+"  "+monTab2[i][1]+"  "+monTab2[i][2]+"  "+monTab2[i][3]);
   	 
   	}   
   	 }  
   	 
    //afficher un tableau
    public static void afficherTableau(double monTab2[]) {
   	 
   	     for(int j = 0; j< monTab2.length; j++){   
   	    	 System.out.print(monTab2[j]+" | "); 
   	     }  
   	
   	 }  
    
    //afficher un tableau
    public static void afficherTableauInt(int monTab2[]) {
   	 
   	     for(int j = 0; j< monTab2.length; j++){   
   	         System.out.print(monTab2[j]+"|"); 
   	     }  
   	
   	 } 

	

}
