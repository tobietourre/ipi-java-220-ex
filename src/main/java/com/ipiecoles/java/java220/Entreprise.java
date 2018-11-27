package com.ipiecoles.java.java220;

import org.joda.*;
import org.joda.time.LocalDate;
/*
SALAIRE_BASE de type Double et de valeur 1480.27
- NB_CONGES_BASE de type Integer et de valeur 25
- INDICE_MANAGER de type Double et de valeur 1.3
- PRIME_MANAGER_PAR_TECHNICIEN de type Double et de valeur 250
- PRIME_ANCIENNETE de type Double et de valeur 100

## Déclarer au niveau de la classe Entreprise, une méthode primeAnnuelleBase, publique et statique calculant la prime de base pour tous les employés de l'entreprise de la manière suivante :

Utiliser la classe LocalDate (de joda time) pour obtenir l'année courante.
Prime = 50% de l'année en cours. Ex : 2017 : 2017 / 2 = 1008.5
 */

public class Entreprise {
    public static final Double SALAIRE_BASE = 1480.27;
    public static final Integer NB_CONGES_BASE = 25;
    public static final Double INDICE_MANAGER = 1.3;
    public static final Double PRIME_MANAGER_PAR_TECHNICIEN = 250d;
    public static final Double PRIME_ANCIENNETE = 100d;

    public static Double primeAnnuelleBase(){
        return LocalDate.now().getYear() / 2d ;
    }

}
