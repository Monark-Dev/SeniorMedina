import javax.swing.*;
import java.text.*;
import java.awt.*;
import java.io.*;

public class App {

	public static void main(String args[]) throws IOException {
		final int MAX_PROD = 20;

		int nbProd;
		Produit tabProduits[] = new Produit[MAX_PROD];
		int tabQteTotale[] = new int[MAX_PROD];

		nbProd = tableaux(tabProduits, MAX_PROD);

		clients(tabProduits, tabQteTotale, nbProd);
		resultats(tabProduits, tabQteTotale, nbProd);

		System.exit(0);
	}

	static int tableaux(Produit tabProduits[], int maxProd) throws IOException {

		BufferedReader ficEntree = new BufferedReader(new FileReader("src/produits.txt"));

		String tab[] = new String[2];
		String ligne;

		int i = 0;

		while ((ligne = ficEntree.readLine()) != null && i < maxProd) {
			tab = ligne.split(" ");
			tabProduits[i] = new Produit(Integer.parseInt(tab[0]), Double.parseDouble(tab[1]));
			i++;
		}

		ficEntree.close();

		return i;
	}

	static void clients(Produit tabProduits[], int tabQteTotale[], int nbProd) {

		int numero, qte, posiProd;

		double cout;
		char reponse;

		DecimalFormat cash = new DecimalFormat("0.00 $");

		do {
			numero = Integer.parseInt(JOptionPane.showInputDialog("Entrez le numéro du produit à acheter:"));

			qte = Integer.parseInt(JOptionPane.showInputDialog("Entrez la quantité désirée:"));

			posiProd = rechercher(tabProduits, nbProd, numero);

			if (posiProd != -1) {
				cout = qte * tabProduits[posiProd].getPrixDuProduit();
				JOptionPane.showMessageDialog(null, "Le coût de cet achat est: " + cash.format(cout));
				tabQteTotale[posiProd] += qte;
			} else {
				JOptionPane.showMessageDialog(null, "Produit erroné");
			}

			reponse = JOptionPane.showInputDialog("Avez-vous un autre client à traiter O/N?").toUpperCase().charAt(0);

		} while (reponse == 'O');
	}

	static int rechercher(Produit tabProduits[], int nbEl, int valeurCherchee) {
		int posi = -1;
		boolean trouve = false;

		for (int i = 0; i < nbEl && !trouve; i++) {
			if (tabProduits[i].getNumeroDuProduit() == valeurCherchee) {
				posi = i;
				trouve = true;
			}
		}
		return posi;
	}

	static void resultats(Produit tabProduits[], int tabQteTotale[], int nbProd) {

		JTextArea sortie = new JTextArea();
		int i;
		sortie.append("Numéro du \t\tQuantité \nproduit \t\ttotal\n");

		for (i = 0; i < nbProd; i++) {
			sortie.append("\n" + tabProduits[i].getNumeroDuProduit() + "\t\t\t" + tabQteTotale[i]);
		}
		sortie.setFont(new Font("Courier", Font.PLAIN, 14));

		JOptionPane.showMessageDialog(null, sortie, "RÉSULTATS DE LA JOURNÉE", JOptionPane.PLAIN_MESSAGE);
	}
}