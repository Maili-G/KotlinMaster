package org.example

import org.example.dresseur.Entraineur
import org.example.item.Badge
import org.example.item.MonsterKube
import org.example.jeu.CombatMonstre
import org.example.monde.Zone
import org.example.monstre.EspeceMonstre
import org.example.monstre.IndividuMonstre

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

var joueur = Entraineur(1,"Sacha",100)
var rival = Entraineur(2,"Regis",200)
var especeSpringleaf = EspeceMonstre(1,"Springleaf","graine", 9, 11,10,12,14,60,6.5,9.0,8.0,7.0,10.0,34.0,"Petit monstre espiègle rond comme une graine, adore le soleil","Sa feuille sur sa tête indique son humeur","curieux, amical, timide")
var especeFlamkip = EspeceMonstre(4,"Flamkip","Animal",12,8,13,16,7,50,10.0,5.5,9.5,9.5,6.5,22.0,"Petit animal entouré de flammes, déteste le froid","Sa flamme change d'intensité selon son énergie","Impulsif, joeur, loyal")
var especeAquamy = EspeceMonstre(7,"Aquamy","Meteo", 10,11,9,14,14,55,9.0,10.0,7.5, 12.0,12.0,27.0,"Créature vaporeuse semblable à un nuage, produit des gouttes pures.","Fait baisser la température en s’endormant.","Calme, rêveur, mystérieux")
var route1 = Zone(1,"Prairie",1500,mutableListOf(especeSpringleaf),null, null)
var route2 = Zone (2,"Forêt", 1500, mutableListOf(especeFlamkip), null,null)
var route3 = Zone (3,"Mer", 1500, mutableListOf(especeAquamy), null,null)



fun main() {
    route1.zoneSuivante = route2
    route2.zonePrecedente = route1

    val monstre1 = IndividuMonstre(1,"Springleaf", especeSpringleaf,null, 1500.0)
    val monstre2 = IndividuMonstre(2, "Flamkip", especeFlamkip, null, 1500.0)
    val monstre3 = IndividuMonstre(3, "Aquamy", especeAquamy, null, 1500.0)
    //monstre1.afficheDetail()
    //val badgePierre = Badge(1,"Badge Roche", "Badge gagné lorsque le joueur a atteint l'arène de pierre.")
    val MonsterKube1 = MonsterKube(1,"Kube1","Le Kube permet de capturer un monstre",60.0)
    println(MonsterKube1.utiliser(monstre1))
    val combat = CombatMonstre(monstre1,monstre2)
    println(combat.jouer())

}
/**
 * Change la couleur du message donné selon le nom de la couleur spécifié.
 * Cette fonction utilise les codes d'échappement ANSI pour appliquer une couleur à la sortie console. Si un nom de couleur
 * non reconnu ou une chaîne vide est fourni, aucune couleur n'est appliquée.
 *
 * @param message Le message auquel la couleur sera appliquée.
 * @param couleur Le nom de la couleur à appliquer (ex: "rouge", "vert", "bleu"). Par défaut c'est une chaîne vide, ce qui n'applique aucune couleur.
 * @return Le message coloré sous forme de chaîne, ou le même message si aucune couleur n'est appliquée.
 */

fun changeCouleur(message: String, couleur: String=""): String {
    val reset = "\u001B[0m"
    val codeCouleur = when (couleur.lowercase()) {
        "rouge" -> "\u001B[31m"
        "vert" -> "\u001B[32m"
        "jaune" -> "\u001B[33m"
        "bleu" -> "\u001B[34m"
        "magenta" -> "\u001B[35m"
        "cyan" -> "\u001B[36m"
        "blanc" -> "\u001B[37m"
        "marron" -> "\u001B[38;5;94m"
        else -> "" // pas de couleur si non reconnue
    }
    return "$codeCouleur$message$reset"

}