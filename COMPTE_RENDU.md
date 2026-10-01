# Compte rendu – Application compteur

J'ai créé le projet CompteurAndroid en Kotlin avec le modèle Empty Views Activity (API 24).
L'interface est construite dans `activity_main.xml` avec un LinearLayout vertical centré,
deux TextView et trois boutons. Dans `MainActivity.kt`, une variable `compteur` est modifiée
par les listeners de clic, puis la fonction `actualiserAffichage()` met à jour le TextView,
ce qui garantit que l'affichage correspond toujours à la variable.

## Difficultés rencontrées
[À compléter avec tes propres difficultés]

## Améliorations réalisées
Couleurs selon le signe, Toast à la réinitialisation, conservation de la valeur à la rotation.
