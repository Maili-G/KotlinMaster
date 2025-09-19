package org.example.monde

import org.example.monstre.EspeceMonstre

/**
 * Un objet de la Zone peut représenter une route, une caverne, une mer …
 *
 * Une zone est un endroit où on peut chercher un monstre sauvage et ou
 * on peut se déplacer à la zone suivante ou la zone précédente si il y en a une.
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
    // TODO methode genereMonstre()
    // TODO methode rencontreMonstre()
}

