package org.example.jeu

import org.example.dresseur.Entraineur
import org.example.especeAquamy
import org.example.especeFlamkip
import org.example.especeSpringleaf
import org.example.monde.Zone
import org.example.monstre.IndividuMonstre

class Partie(
    val id : Int,
    var joueur : Entraineur,
    val zone : Zone
) {
    fun choixStarter(){
        val monstre1 = IndividuMonstre(1,"Springleaf", especeSpringleaf,null, 1500.0)
        val monstre2 = IndividuMonstre(2, "Flamkip", especeFlamkip, null, 1500.0)
        val monstre3 = IndividuMonstre(3, "Aquamy", especeAquamy, null, 1500.0)
    }
}