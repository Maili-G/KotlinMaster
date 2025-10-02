package org.example.jeu

import org.example.dresseur.Entraineur
import org.example.especeAquamy
import org.example.especeFlamkip
import org.example.especeSpringleaf
import org.example.monde.Zone
import org.example.monstre.IndividuMonstre
import org.example.monstre1
import org.example.monstre2
import org.example.monstre3

class Partie(
    val id : Int,
    var joueur : Entraineur,
    val zone : Zone
) {
    fun choixStarter(){

        monstre1.afficheDetail()
        monstre2.afficheDetail()
        monstre3.afficheDetail()

        println("Quel est votre choix ? : 1, 2, 3")
        val choix = readln().toInt()

        var starter = monstre1

        if (choix == 2) starter = monstre2 else starter = monstre3

        starter.renommer()
        joueur.equipeMonstre.add(starter)
        starter.entraineur = joueur
    }

    
}