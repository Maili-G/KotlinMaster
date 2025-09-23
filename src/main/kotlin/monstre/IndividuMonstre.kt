package org.example.monstre

import org.example.dresseur.Entraineur
import kotlin.random.Random
import kotlin.math.*

/**
 *  @property pv  Points de vie actuels.
 * Ne peut pas être inférieur à 0 ni supérieur à [pvMax].
 */


class IndividuMonstre (
    val id : Int,
    var nom : String,
    val espece : EspeceMonstre,
    var entraineur : Entraineur?,
    expInit : Double
) {
    var niveau : Int = 1
    val attaque : Int = espece.baseAttaque + Random.nextInt(-2,2) // demande d'aide à un camarade et recherche pour le random
    val defense : Int = espece.baseDefense + Random.nextInt(-2,2)
    val vitesse : Int = espece.baseVitesse + Random.nextInt(-2,2)
    val attaqueSpe : Int = espece.baseAttaqueSpe + Random.nextInt(-2,2)
    val defenseSpe : Int = espece.baseDefenseSpe + Random.nextInt(-2,2)
    val pvMax : Int = espece.basePv + Random.nextInt(-5,5)
    val potentiel : Double = Random.nextDouble(0.5,2.0)
    var exp : Double = 0.0
        get() = field
        set(value) {
            field = value
            var estNiveau1 = (niveau == 1)
            while(field >= palierExp(niveau)){
                levelUp()
                if (estNiveau1==false) println("Le monstre $nom est maintenant de niveau $niveau !")
            }


        }
    var pv : Int = pvMax
        get() = field
        set(nouveauPv) {
            field= nouveauPv.coerceIn(0,pvMax) // aide par un camarade et syntax internet

        }

    /**
     * Calcule l'expérience totale nécessaire pour atteindre un niveau donné.
     *
     * @param niveau Niveau cible.
     * @return Expérience cumulée nécessaire pour atteindre ce niveau.
     */

    fun palierExp(niveau : Int) : Double {

        return 100.0*(niveau-1).toDouble().pow(2.0)
    }

    fun levelUp(){
        niveau +=1
        round(espece.modVitesse*potentiel) + Random.nextInt(-2,2)
        round(espece.modAttaque*potentiel) + Random.nextInt(-2,2)
        round(espece.modDefense*potentiel) + Random.nextInt(-2,2)
        round(espece.modDefenseSpe*potentiel) + Random.nextInt(-2,2)
        round(espece.modAttaqueSpe*potentiel) + Random.nextInt(-2,2)
        round(espece.modPv*potentiel) + Random.nextInt(-5,5)
    }

    init {
        this.exp = expInit // applique le setter et déclenche un éventuel level-up
    }

    /**
     * Attaque un autre [IndividuMonstre] et inflige des dégâts.
     *
     * Les dégâts sont calculés de manière très simple pour le moment :
     * `dégâts = attaque - (défense / 2)` (minimum 1 dégât).
     *
     * @param cible Monstre cible de l'attaque.
     */

    fun attaquer(cible : IndividuMonstre){
        var degatBrut = this.attaque
        var degatTotal  = degatBrut - (this.defense/2)
        if (degatTotal<1) degatTotal = 1
        val pvAvant = cible.pv
        cible.pv -= degatTotal
        var pvApres = cible.pv
        println("$nom inflige ${pvAvant-pvApres} dégâts à ${cible.nom}")
    }

    /**
     * Demande au joueur de renommer le monstre.
     * Si l'utilisateur entre un texte vide, le nom n'est pas modifié.
     */

     fun renommer(){
        println("Renommer $nom ?")
        val nouveauNom = readln()

        if (nouveauNom != "")
            nom = nouveauNom
            println("Le nouveau nom est $nom")
    }

    fun afficheDetail(){
        println(espece.afficheArt())
        println("======================")
        println("Nom : $nom     Niveau : $niveau")
        println("Exp : $exp")
        println("PV : $pv / $pvMax")
        println("======================")
        println("Atq : $attaque     Def : $defense      Vitesse : $vitesse")
        println("AtqSpe : $attaqueSpe       DefSpe : $defenseSpe")
        println("======================")
    }

}