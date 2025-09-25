package org.example.jeu

import org.example.item.Utilisable
import org.example.joueur
import org.example.monstre.IndividuMonstre

class CombatMonstre(
    var monstreJoueur : IndividuMonstre,
    var monstreSauvage : IndividuMonstre
) {
    var round = 1

    /**
     * Vérifie si le joueur a perdu le combat.
     *
     * Condition de défaite :
     * - Aucun monstre de l'équipe du joueur n'a de PV > 0.
     *
     * @return `true` si le joueur a perdu, sinon `false`.
     */

    fun gameOver(): Boolean {
        var perdu = 0

        for (monstre in joueur.equipeMonstre) {

            if (monstre.pv == 0) perdu += 1
        }
        if (perdu == 6) {
            println("Aucun monstre de l'équipe du joueur n'a de PV > 0")
            return true
        } else {
            return false
        }
    }

    fun joueurGagne(): Boolean {

        if (monstreSauvage.pv <= 0) {
            println("${joueur.nom} a gagné !")
            val gainExp = monstreSauvage.exp * 0.2
            monstreJoueur.exp += gainExp
            println("$monstreJoueur.nom gagne $gainExp exp")
            return true
        } else {
            if (monstreSauvage.entraineur == joueur) {
                println("${monstreSauvage.nom} a été capturé !")
                return true
            } else {
                return false
            }
        }
    }

    fun actionAdversaire() {

        if (monstreSauvage.pv > 0) monstreSauvage.attaquer(monstreJoueur)
    }

    fun actionJoueur(): Boolean {

        if (gameOver() == true) {
            return false
        } else {
            println("Quel action voulez vous faire ? : \n 1 -> attaque \n 2 -> item \n 3 -> changement de monstre")
            val action = readln().toInt()

            if (action == 1) {
                monstreJoueur.attaquer(monstreSauvage)
            } else if (action == 2) {
                println(joueur.sacAItems)
                println("Faites votre choix : ")
                val indexChoix = readln().toInt()
                val objetChoisi = joueur.sacAItems[indexChoix]
                if (objetChoisi is Utilisable) {
                    val captureReussi = objetChoisi.utiliser(monstreSauvage)
                    if (captureReussi) return false else return true
                } else {
                    println("Objet non utilisable")
                    return true
                }
            } else if (action == 3) {
                for (monstres in joueur.equipeMonstre) {
                    if (monstres.pv > 0) {
                        println(monstres.afficheDetail())
                    }
                }
                val indexChoix = readln().toInt()
                val choixMonstre = joueur.equipeMonstre[indexChoix]
                if (choixMonstre.pv <= 0) {
                    println("${choixMonstre} remplace ${monstreJoueur}")
                    monstreJoueur = choixMonstre
                } else {
                    println("Impossible ! Ce montres est KO")
                }
            }
            return true
        }
    }


}