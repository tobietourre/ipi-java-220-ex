package com.ipiecoles.java.java220;
//https://classroom.github.com/a/H1_NdrHs

import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 * - nom : String
 * - prenom : String
 * - matricule : String
 * - dateEmbauche : LocalDate
 * - salaire : Double
 */
public abstract class Employe {
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        // this.setdateEmbauche(dateEmbauche);
        this.salaire = salaire;
    }

    public Employe() {
    }

    public String getNom() { return nom; }

    public String getPrenom() {
        return prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        if (dateEmbauche != null && dateEmbauche.isAfter(LocalDate.now())) {
            throw new ExceptionSetDateEmbauche("La date d'embauche ne peut être postérieure à la date courante");
        }
        this.dateEmbauche = dateEmbauche;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public final Integer getNombreAnneeAnciennete() {
        return LocalDate.now().getYear() - this.dateEmbauche.getYear();
    }

    public final Integer getNbConges() {
        return Entreprise.NB_CONGES_BASE;
    }

    public String toString() {
        return "Employe{nom='" + this.nom + "', prenom='" + this.prenom + "', matricule='" + this.matricule + "', dateEmbauche=" + this.dateEmbauche + ", salaire=" + this.salaire + "}";
    }


    @Override
    public boolean equals(Object employe) {
        if (employe instanceof Employe) {
            Employe employeAComparer = (Employe) employe;
            return (Objects.equals(this.nom, employeAComparer.getNom())
                    && Objects.equals(this.prenom, employeAComparer.getPrenom())
                    && Objects.equals(this.matricule, employeAComparer.getMatricule())
                    && Objects.equals(this.dateEmbauche, employeAComparer.getDateEmbauche())
                    && Objects.equals(this.salaire, employeAComparer.getSalaire())
            );
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
    }

    public void augmenterSalaire(Double taux){
        this.salaire += this.salaire * taux;
    }

    public abstract Double getPrimeAnnuelle();
}
