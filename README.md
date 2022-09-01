# SutomSolver
Motus remake android app solver

## Compilation 

```bash
mvn compile
```

## Run

Exemple de mot a trouver = USINAGE

### 1ier appel
Seule la premiere lettre est connue, on remplace les lettres inconnues par un tiret '-'.
On veut 50 propositions. Les meilleures sont affichées en premier (par ordre de score descendant).

```bash
./SutomSolver U------ 50
```

### 2ieme appel
Lettres A et I mal placées et R et T absents. On veut 20 propositions. On peut aussi omettre ce denier paramètre, dans ce cas 30 propositions sont affichées.

```bash
./SutomSolver U--N--E/AI^RT 20
```
