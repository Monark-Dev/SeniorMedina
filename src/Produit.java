public class Produit {

    // Attribut de la classe
    public static int nombreDeProduits = 0;

    // Attributs des objets
    private int numeroDuProduit;
    // private String nomDuProduit;
    private double prixDuProduit;
    private int quantiteTotaleDuProduit;

    Produit(int numeroDuProduit, double prixDuProduit) {
        setNumeroDuProduit(numeroDuProduit);
        setPrixDuProduit(prixDuProduit);
        ++nombreDeProduits;
    }

    // Les get (accesseurs)
    public int getNumeroDuProduit() {
        return numeroDuProduit;
    }

    public double getPrixDuProduit() {
        return prixDuProduit;
    }

    public int getQuantiteTotaleDuProduit() {
        return quantiteTotaleDuProduit;
    }

    // Les set (mutateurs)
    void setNumeroDuProduit(int numeroDuProduit) {
        if (numeroDuProduit > 0) {
            this.numeroDuProduit = numeroDuProduit;
        } else {
            System.out.println("Numéro du produit invalide");
        }
    }

    void setPrixDuProduit(double prixDuProduit) {
        if (prixDuProduit > 0) {
            this.prixDuProduit = prixDuProduit;
        } else {
            System.out.println("Prix du produit invalide");
        }
    }

    // Autres méthodes utilitaires

    public String toString() {
        String affichage = "\nNUMÉRO DU PRODUIT : " + this.numeroDuProduit + "\nPRIX : " + this.prixDuProduit;
        return affichage;
    }
}
