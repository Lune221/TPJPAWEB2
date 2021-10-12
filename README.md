# TPJPAWEB2
## Solution de la partie 2 du TP de JPA

### Conception:

Nous avons mis en place la conception UML des mod�les de donn�es suivante :

![Alt text](ressources/ClassDiagram.png?raw=true "Diagramme des mod�les de donn�es UML")


### Explications

En effet, la conception s'explique de la mani�re suivante, de la gauche vers la droite:<br>

- Une <b>Categorie</b> et une <b>Marque</b> contiennent plusieurs <b>Article</b>;
- Une <b>Commande</b> est compos�e de plusieurs <b>Article</b>;
- Un <b>Client</b> peut passer plusieurs <b>Commande</b> et la m�me <b>Commande</b> ne peut �tre pass�e que par le m�me <b>Client</b>;
- Un <b>Vendeur</b> g�re plusieurs <b>Commande</b> et une m�me <b>Commande</b> est suivie par le m�me <b>Vendeur</b> (Pour simplifier la conception);
- <b>Client</b> et <b>Vendeur</b> sont des <b>Personne</b> (h�ritage).

### Description du travail

Dans l'approche pratique du projet, nous avons mis en place:

- Les entit�s qui d�coulent du diagramme de mod�le de donn�es
- Les fa�ades qui sont en r�alit�s des interfaces g�n�riques qui d�crivent le business des EJB qui les impl�mentent
- Les session Beans qui englobent le business permettant de manipuler les entit�s cr�es.