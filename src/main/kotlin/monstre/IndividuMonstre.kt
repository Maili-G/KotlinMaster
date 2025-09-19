package org.example.monstre

import org.example.dresseur.Entraineur
import kotlin.random.Random
import kotlin.math.*

/**
 *  @property pv  Points de vie actuels.
 * Ne peut pas être inférieur à 0 ni supérieur à [pvMax].
 */


class IndividuMonstre (
    val id : Int,
    val nom : String,
    val espece : EspeceMonstre,
    val entraineur : Entraineur?,
    expInit : Double
) {
    val niveau : Int = 1
    val attaque : Int = espece.baseAttaque + Random.nextInt(-2,2) // demande d'aide à un camarade et recherche pour le random
    val defense : Int = espece.baseDefense + Random.nextInt(-2,2)
    val vitesse : Int = espece.baseVitesse + Random.nextInt(-2,2)
    val attaqueSpe : Int = espece.baseAttaqueSpe + Random.nextInt(-2,2)
    val defenseSpe : Int = espece.baseDefenseSpe + Random.nextInt(-2,2)
    val pvMax : Int = espece.basePv + Random.nextInt(-5,5)
    val potentiel : Double = Random.nextDouble(0.5,2.0)
    val exp : Double = 0.0
    var pv : Int = pvMax
        get() = field
        set(nouveauPv) {
            field= nouveauPv.coerceIn(0,pvMax) // aide par un camarade et syntax internet

        }

    /**
     * Calcule l'expérience totale nécessaire pour atteindre un niveau donné.
     *
     * @param niveau Niveau cible.
     * @return Expérience cumulée nécessaire pour atteindre ce niveau.
     */

    fun palierExp(niveau : Int) : Double {

        return (100.0*(niveau-1)).pow(2.0)
    }

    fun levelUp(){
        round(espece.modVitesse*potentiel) + Random.nextInt(-2,2)
        round(espece.modAttaque*potentiel) + Random.nextInt(-2,2)
        round(espece.modDefense*potentiel) + Random.nextInt(-2,2)
        round(espece.modDefenseSpe*potentiel) + Random.nextInt(-2,2)
        round(espece.modAttaqueSpe*potentiel) + Random.nextInt(-2,2)
        round(espece.modPv*potentiel) + Random.nextInt(-5,5)
    }
}