package org.example.monstre

import java.io.File
/**
* Représente les différentes espèces de monstre présent dans le jeu.
*
* Une espèce se bat avec son entraineur. Ses statistiques de base,
* ses multiplicateurs de croissances varient selon l'espèce.
*
* @property id L'identifiant unique de l'espèce.
* @property nom Le nom de l'espèce.
* @property type Le type de l'espèce.
* @property baseAttaque L'attaque de base de l'espèce.
* @property baseDefense La défense de base de l'espèce.
* @property baseVitesse La vitesse de base de l'espèce.
* @property baseAttaqueSpe L'attaque Spéciale de base de l'espèce.
* @property baseDefenseSpe La défense Spéciale de base de l'espèce.
* @property basePv Les points de vie de base de l'espèce.
* @property modAttaque Le modificateur de croissance de l'attaque de l'espèce, appliqué lors des montées de niveau.
* @property modDefense Le modificateur de croissance de défense de l'espèce, appliqué lors des montées de niveau.
* @property modVitesse Le modificateur de croissance de vitesse de l'espèce, appliqué lors des montées de niveau.
* @property modAttaqueSpe Le modificateur de croissance de l'attaque Spéciale de l'espèce, appliqué lors des montées de niveau.
* @property modDefenseSpe Le modificateur de croissance de la défense Spéciale de l'espèce, appliqué lors des montées de niveau.
* @property modPv Le modificateur de croissance de points de vie de l'espèce, appliqué lors des montées de niveau.
* @property description La description de l'espèce.
* @property particularites Les particularités de l'espèce.
* @property caractères Les caractères de l'espèce.
*
*/
class EspeceMonstre(
    var id : Int,
    var nom: String,
    var type: String,
    val baseAttaque: Int,
    val baseDefense: Int,
    val baseVitesse: Int,
    val baseAttaqueSpe: Int,
    val baseDefenseSpe: Int,
    val basePv: Int,
    val modAttaque: Double,
    val modDefense: Double,
    val modVitesse: Double,
    val modAttaqueSpe: Double,
    val modDefenseSpe: Double,
    val modPv: Double,
    val description: String = "",
    val particularites: String = "",
    val caractères: String = ""){

    /**
     * Affiche la représentation artistique ASCII du monstre.
     *
     * @param deFace Détermine si l'art affiché est de face (true) ou de dos (false).
     *               La valeur par défaut est true.
     * @return Une chaîne de caractères contenant l'art ASCII du monstre avec les codes couleur ANSI.
     *         L'art est lu à partir d'un fichier texte dans le dossier resources/art.
     */
    fun afficheArt(deFace: Boolean=true): String{
        val nomFichier = if(deFace) "front" else "back";
        val art = File("src/main/resources/art/${this.nom.lowercase()}/$nomFichier.txt").readText()
        val safeArt = art.replace("/", "∕")
        return safeArt.replace("\\u001B", "\u001B")
    }

}