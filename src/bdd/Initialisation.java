package bdd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Initialisation {
	double matrice[][]=new double[150][4];
	
	public Initialisation(){
		File file;
		BufferedReader br=null;
		String token="";
		//le  chemin ou se trouve  la base de données iris
		file = new File("/home/massino/Bureau/iris.data");
		//String str;
		
		int nLingne=0,nColonne=0;
		try {
			br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		String ligne;
		
		try {
			token=br.readLine();
			while((ligne=br.readLine())!=null){
				token=token+","+ligne;
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringTokenizer st = new StringTokenizer(token);
	    String next;
	    
	    try {
	    	while((next=st.nextToken(",")) != null){
		    	if(nColonne<4){
		    		matrice[nLingne][nColonne]=Double.parseDouble(next);
		    		nColonne++;
		    	}
		    	else{
		    		nLingne++;
		    		nColonne=0;
		    	}
		    }
		} catch (NoSuchElementException e) {
			// Ya plus d'autres tokens
		}
		
	}
}