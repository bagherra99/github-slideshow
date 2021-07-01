import java.util.Arrays;
import java.util.Scanner;
public class ConstructeurMatrice
{
	private int [][] matrice;
	private int ligne;
	private int colonne;
	private boolean random;
	private Scanner input = new Scanner(System.in);

	// le constructeur 

	public ConstructeurMatrice (int ligne, int colonne, boolean random)
	{
		this.ligne = ligne;
		this.colonne = colonne;
		this.random = random;
		matrice = new int [ligne][colonne];

		if (random) 
		{
			for (int i=0; i<ligne; i++) 
			{
				for (int j=0; j<colonne; j++) 
				{
					matrice[i][j] = (int) (Math.random()*20);	
				}
			}
			//System.out.println("matrice 1");
		}
		else
		{
			System.out.println("Entrez : "+(ligne*colonne)+" valeurs");
			for (int i=0; i<ligne; i++) 
			{
				for (int j=0; j<colonne; j++) 
				{
					Scanner input = new Scanner(System.in);
					matrice[i][j] = input.nextInt();	
				}
			}
			//System.out.println("matrice 2");
		}

	}

	//Affichage

	public void _Afficher()
	{
		for (int i=0; i<ligne; i++) 
		{
			for (int j=0; j<colonne; j++) 
			{
				System.out.print(matrice[i][j]+"  ");	
			}
			System.out.println();
		}
		//System.out.println(Arrays.toString(matrice));
	}


	// somme de deux matrices 

	public ConstructeurMatrice addition (ConstructeurMatrice m)
	{
		ConstructeurMatrice somme = new ConstructeurMatrice(ligne, colonne, random);
		if (ligne == m.getLigne() && colonne == m.getColonne()) 
		{
			for (int i=0; i<ligne; i++) 
			{
				for (int j=0; j<colonne; j++) 
				{
					somme.matrice[i][j] = matrice[i][j] + m.matrice[i][j]; 	
				}
			}
			System.out.println("Matrice somme");
		}
		else 
		{
			System.out.println("on ne peut pas effectuer l'addiition");
			System.exit(1);
		}
		return somme;
	}

	//produit avec nombre

	public ConstructeurMatrice produitNombre(int nombre)
	{
		ConstructeurMatrice k = new ConstructeurMatrice(ligne, colonne,random);
		for (int i=0; i<ligne; i++) 
		{
			for (int j=0; j<colonne; j++) 
			{
				k.matrice[i][j] = nombre*matrice[i][j];
			}
		}
		return k;
	}

	//transposee

	public ConstructeurMatrice transposee()
	{
		ConstructeurMatrice trans = new ConstructeurMatrice(colonne, ligne,random);
		for (int i=0; i<colonne; i++) 
		{
			for (int j=0; j<ligne; j++) 
			{
				trans.matrice[i][j] = matrice[j][i];
			}
		}
		return trans;
	}

	//produit de deux matrices 

	public ConstructeurMatrice produit(ConstructeurMatrice m)
	{
		ConstructeurMatrice product = new ConstructeurMatrice(ligne, colonne,random);
		if (ligne == m.getColonne()) 
		{
			for (int i=0; i<ligne; i++) 
			{
				for (int j=0; j<colonne; j++) 
				{
					product.matrice[i][j] = 0;
					for (int k=0; k<ligne; k++) 
					{
						product.matrice[i][j] += matrice[i][k] * m.matrice[k][j];
					}
				}
			}
			System.out.println("matrice produit");
		}
		else
			{
				System.out.println("cette operation ne peut pas se faire");
				System.exit(1);
			}
		return product;
	}



	// Getters and Setters

	public int getLigne()
	{
		return ligne;
	}
	public void setLigne(int ligne)
	{
		this.ligne = ligne;
	}

	public int getColonne()
	{
		return colonne;
	}
	public void setColonne(int colonne)
	{
		this.colonne = colonne;
	}

	public boolean getRandom()
	{
		return random;
	}
	public void setRandom(boolean random)
	{
		this.random = random;
	}

	public int[][] getMatrice()
	{
		return matrice;
	}
	public void setMatrice(int[][] matrice)
	{
		this.matrice = matrice;
	}
}