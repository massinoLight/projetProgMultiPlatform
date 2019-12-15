package bdd;

import java.util.List;

public class Node extends FonctionVecteur{
	double vacteurB[];
	String Etiquette;
	double Euqlidenne;
	double vacteurP[];
	
	//un constructeur vide
	public Node() {
	}

	/***
	 * le constructeur des Nodes 
	 * qui va prendre en paramétres un vecteur une etiquette 
	 * une distance euqulidienne
	 * et le vecteur en question 
	 * 
	 * **/
	
	public Node(double vecteur[],String etiquette,double distance,double proche[]) {
		this.vacteurB=vecteur;
		this.Etiquette=etiquette;
		this.Euqlidenne=distance;
		this.vacteurP=proche;
		
		
	}
	

	/**
	 * une fonction qui permet 
	 * d'afficher les nodes d'une liste 
	 * passé en paramétre 
	 * **/
	
	public void afficheNode(List<Node> list) {
		Node prov=new Node();
		double v1[],v2[];
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println();
			System.out.println("----------------Node"+i+"--------------------");
			prov=list.get(i);
			v1=prov.vacteurB;
			v2=prov.vacteurP;
			afficherVecteur(v1);
			System.out.println(prov.Etiquette+"|");
			afficherVecteur(v2);System.out.print("           |");
		}
		
	}
	


}
