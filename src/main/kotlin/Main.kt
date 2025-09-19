package org.example

import org.example.dresseur.Entraineur
import org.example.monstre.EspeceMonstre

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

var joueur = Entraineur(1,"Sacha",100)
var rival = Entraineur(2,"Regis",200)
var springleaf = EspeceMonstre(1,"Springleaf","graine", 9, 11,10,12,14,60,6.5,9.0,8.0,7.0,10.0,34.0,"Petit monstre espiègle rond comme une graine, adore le soleil","Sa feuille sur sa tête indique son humeur","curieux, amical, timide")
var flamkip = EspeceMonstre(4,"Flamkip","Animal",12,8,13,16,7,50,10.0,5.5,9.5,9.5,6.5,22.0,"Petit animal entouré de flammes, déteste le froid","Sa flamme change d'intensité selon son énergie","Impulsif, joeur, loyal")
var aquamy = EspeceMonstre(7,"Aquamy","Meteo", 10,11,9,14,14,55,9.0,10.0,7.5, 12.0,12.0,27.0,"Créature vaporeuse semblable à un nuage, produit des gouttes pures.","Fait baisser la température en s’endormant.","Calme, rêveur, mystérieux")

fun main() {
    //val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    //println("Hello, " + name + "!")

    //for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        //println("i = $i")
    //}

//    println(changeCouleur("Hello","rouge"))
//    println(changeCouleur("World","bleu"))
//    println("Hello ${changeCouleur("my","jaune")} World")
//    println(changeCouleur("Truc","marron"))

    //val pokemon = EspeceMonstre(1,"draco","feu", 10, 10,10,10,10,10,10.0,10.0,10.0,10.0,10.0,10.0,"'c'est un dragon","il crache du feu","colèrique")
    println(springleaf.afficheArt())

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
        else -> "" // pas de couleur si non reconnu
    }
    return "$codeCouleur$message$reset"

}