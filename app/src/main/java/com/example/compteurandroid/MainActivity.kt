package com.example.compteurandroid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    // Variable du compteur, initialisée à 0
    private var compteur: Int = 0

    private lateinit var textViewCompteur: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Récupération des composants par leurs identifiants
        textViewCompteur = findViewById(R.id.textViewCompteur)
        val buttonIncrementer: Button = findViewById(R.id.buttonIncrementer)
        val buttonDecrementer: Button = findViewById(R.id.buttonDecrementer)
        val buttonReinitialiser: Button = findViewById(R.id.buttonReinitialiser)

        // Facultatif : restaurer la valeur après rotation de l'écran
        compteur = savedInstanceState?.getInt(CLE_COMPTEUR) ?: 0

        // Clic sur +
        buttonIncrementer.setOnClickListener {
            compteur++
            actualiserAffichage()
        }

        // Clic sur -
        buttonDecrementer.setOnClickListener {
            compteur--
            actualiserAffichage()
        }

        // Clic sur Réinitialiser
        buttonReinitialiser.setOnClickListener {
            compteur = 0
            actualiserAffichage()
            Toast.makeText(this, R.string.message_reinitialisation, Toast.LENGTH_SHORT).show()
        }

        actualiserAffichage()
    }

    // Met à jour le TextView pour qu'il corresponde toujours à la variable
    private fun actualiserAffichage() {
        textViewCompteur.text = compteur.toString()

        // Facultatif : couleur selon le signe
        val couleur = when {
            compteur > 0 -> R.color.compteur_positif
            compteur < 0 -> R.color.compteur_negatif
            else -> R.color.compteur_nul
        }
        textViewCompteur.setTextColor(ContextCompat.getColor(this, couleur))
    }

    // Facultatif : sauvegarde de la valeur avant la rotation
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(CLE_COMPTEUR, compteur)
    }

    companion object {
        private const val CLE_COMPTEUR = "cle_compteur"
    }
}
