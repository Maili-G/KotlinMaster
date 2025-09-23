package org.example.monstre

import org.example.joueur

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

    fun gameOver() : Boolean{
        var perdu = 0

        for (monstre in joueur.equipeMonstre){

            if (monstre.pv == 0) perdu += 1
        }
        if (perdu == 6){
            println("Aucun monstre de l'équipe du joueur n'a de PV > 0")
            return true
        }
        else {
            return false
        }
    }

    fun joueurGagne() : Boolean{

        if (monstreSauvage.pv <= 0){
            println("${joueur.nom} a gagné !")
            val gainExp = monstreSauvage.exp * 0.2
            monstreJoueur.exp += gainExp
            println("$monstreJoueur.nom gagne $gainExp exp")
            return true
        }
        else{
            if (monstreSauvage.entraineur == joueur){
                println("${monstreSauvage.nom } a été capturé !")
                return true
            }
            else{
                return false
            }
        }
    }

    fun actionAdversaire(){

        if (monstreSauvage.pv > 0) monstreSauvage.attaquer(monstreJoueur)
    }
}