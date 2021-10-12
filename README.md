# TPJPAWEB2
## Solution de la partie 2 du TP de JPA

### Conception:

Nous avons mis en place la conception UML des modèles de données suivante :

![Alt text](ressources/ClassDiagram.png?raw=true "Diagramme des modèles de données UML")


### Explications

En effet, la conception s'explique de la manière suivante, de la gauche vers la droite:<br>

- Une <b>Categorie</b> et une <b>Marque</b> contiennent plusieurs <b>Article</b>;
- Une <b>Commande</b> est composée de plusieurs <b>Article</b>;
- Un <b>Client</b> peut passer plusieurs <b>Commande</b> et la même <b>Commande</b> ne peut être passée que par le même <b>Client</b>;
- Un <b>Vendeur</b> gère plusieurs <b>Commande</b> et une même <b>Commande</b> est suivie par le même <b>Vendeur</b> (Pour simplifier la conception);
- <b>Client</b> et <b>Vendeur</b> sont des <b>Personne</b> (héritage).

### Description du travail

Dans l'approche pratique du projet, nous avons mis en place:

- Les entités qui découlent du diagramme de modèle de données
- Les façades qui sont en réalités des interfaces génériques qui décrivent le business des EJB qui les implémentent
- Les session Beans qui englobent le business permettant de manipuler les entités crées.