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
    var zone : Zone
) {
    fun choixStarter(){

       /** var monstreBis = zone.genereMonstre()
        var monstre2Bis = zone.genereMonstre()*/

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

    fun modifierOdreEquipe(){
        println("Entrez la position du monstre que vous voulez déplacer : ")
        var position1 = readln().toInt()

        println("Entrez la nouvelle position du monstre : ")
        var position2 = readln().toInt()

        var firstPokemon = joueur.equipeMonstre[position1]
        var secondPokemon = joueur.equipeMonstre[position2]

        joueur.equipeMonstre[position1] = secondPokemon
        joueur.equipeMonstre[position2] = firstPokemon

        println(joueur.equipeMonstre)
    }

    fun examineEquipe(){

        for (monstres in joueur.equipeMonstre){
            print(joueur.equipeMonstre.indexOf(monstres))
            monstres.afficheDetail()
        }
        println()
        println("Menu principal : q \n " +
                "Modifier l'ordre des monstres : m \n " +
                "Tapez le numéro du monstre pour voir les détails :")

        var choix = readln()
        if(choix.lowercase() == "q") return
        else if(choix.lowercase() == "m") modifierOdreEquipe()
        else if(choix.toInt() in 1..6){
            var monstre = joueur.equipeMonstre[choix.toInt()-1]
            monstre.afficheDetail()
        } else {
            println("Numero de montre inexistant")
            examineEquipe()
        }
    }

    fun jouer() {
        println("Vous ete actuellement dans la zone : ${zone.nom}. Vous pouvez :\n" +
                "1. Rencontrer un monstre sauvage\n" +
                "2. Examiner l'equipe de monstres\n")
        if (zone.zoneSuivante != null ) println("3. Aller a la zone suivante")
        if (zone.zonePrecedente != null ) println("3. Retourner a la zone precedente")

        var action = readln().toInt()

        when (action){
            1 -> jouer()
            2 -> examineEquipe()
            3 -> zone = zone.zoneSuivante!!
            4 -> zone = zone.zonePrecedente!!

            else -> println("entré invalide")
        }
    }
}