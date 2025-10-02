package org.example.monde

import org.example.jeu.CombatMonstre
import org.example.joueur
import org.example.monstre.EspeceMonstre
import org.example.monstre.IndividuMonstre
import kotlin.random.Random

/**
 * Un objet de la Zone peut représenter une route, une caverne, une mer…
 *
 * Une zone est un endroit où on peut chercher un monstre sauvage et où
 * on peut se déplacer à la zone suivante ou la zone précédente s'il y en a une.
 *
 * @property id
 * @property nom
 * @property expZone
 * @property especesMonstres
 * @property zoneSuivante
 * @property zonePrecedente
 *
 */

class Zone (
    val id : Int,
    val nom : String,
    val expZone: Int,
    val especesMonstres : MutableList<EspeceMonstre> = mutableListOf< EspeceMonstre>(),
    var zoneSuivante : Zone?,
    var zonePrecedente : Zone?

){
    fun genereMonstre(): IndividuMonstre {
        require(especesMonstres.isNotEmpty()) { "Aucune espèce disponible dans cette zone." }
        println(especesMonstres)
        // Choisir une espèce au hasard
        val especeAleatoire : EspeceMonstre = especesMonstres.random()

        // Générer une variation de +/- 20%
        val variation : Double = Random.nextDouble(0.8, 1.2)
        val experienceMonstre : Double = expZone * variation

        // Retourner le monstre généré (monstre sauvage sans entraineur, id 0 et nom de l'espèce par défaut)
        return IndividuMonstre(
            id = 0,
            nom = especeAleatoire.nom,
            espece = especeAleatoire,
            entraineur = null,
            expInit = experienceMonstre
        )
    }

    fun rencontreMonstre(){
        genereMonstre()
        val monstreSauvage = genereMonstre()
        var premierMonstre: IndividuMonstre? = null

        for (monstre in joueur.equipeMonstre){
            if (monstre.pv > 0) {
                premierMonstre = monstre
                break
            }
        }
        if (premierMonstre == null) {
            println("Aucun monstre disponible pour combattre !")
            return
        }

        val combat = CombatMonstre(premierMonstre,monstreSauvage)
        combat.lancerCombat()
    }
}

