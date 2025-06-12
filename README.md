# Rapport de Qualité du Projet

Dans le cadre d'un TP, nous avons essayer de mettre en place une chaine d'outils combinants GitHub avec SonarCloud et Jenkins pour analysé la qualité de notre code à chaque push sur la branche master.

Nous avons créer un projet de 0 avec un front Angular, un back Java et une base de données PostgreSql. 

---

Utilisation d'outils de vérification du code:
- Tests unitaires (JUnit, Jasmine)
- SonarCloud
- Jenkins

---

Pour ce qui est de SonarCloud, nous avons connecter l'interface directement avec le repository GitHub

![image](https://github.com/user-attachments/assets/cd633bf9-69e6-44d7-b34b-73b9d3ec67b9)

Ensuite, il a fallu configurer comme ci-dessous le projet SonarCloud

![image](https://github.com/user-attachments/assets/807e701c-397c-48c9-9ac9-af62fec74939)

Enfin une première analyse a été réalisé par SonarCloud

![image](https://github.com/user-attachments/assets/97bd58a3-6fb9-4a50-bdab-65a058b2f786)

![image](https://github.com/user-attachments/assets/0a80796f-0162-45d0-b6d8-e43592ec05e6)

### Echec du Quality Gate
La première analyse nous revèle un échec à cause de 3 conditions qui ont échoués
- Fiabilité non évaluée (Rating A requis)
- 0% des Security Hotspots revus (objectif 100%)
- 23.6% de lignes dupliquées sur le nouveau code (objectif ≤ 3%)

Après analyse, beaucoup des erreurs de duplications provenait de fichiers "coverage" généré par Angular/Karma. Nous les avons alors exclu du projet via le fichier sonar-config.properties

![image](https://github.com/user-attachments/assets/7b67b34f-4d99-4ab5-9590-9f5856d9ad70)

---

![image](https://github.com/user-attachments/assets/9b56cdbb-ae82-446e-9610-b991184cb863)

### Détails des Problèmes Détectés

- **Total d'anomalies :** 152
  - Fiabilité : 7
  - Maintenabilité : 145
- **Gravité :**
  - High : 1
  - Medium : 147
  - Low : 4

![image](https://github.com/user-attachments/assets/b1a52913-9402-4447-80cf-0a2d023c03f2)

![image](https://github.com/user-attachments/assets/c49f7c17-71d0-4b44-a1d8-1f2de6988185)

![image](https://github.com/user-attachments/assets/dee47ecf-440f-4975-95de-8c4537bf451b)

### Lignes dupliquées
- `biblioflex-ui/coverage` contient **815 lignes dupliquées**, soit **24%** du nouveau code.

---

![image](https://github.com/user-attachments/assets/f71a3f85-ef28-408b-a078-0763ddece4d6)

### Problème de sécurité : Code Injection
Un hotspot critique a été identifié : une potentielle injection via la chaîne `"javascript:"` dans un champ simulant du code javascript.

---

Nous avons tenté d'utiliser Jenkins pour unifier les cycles de build, de tests et d'analyse de qualité. 

Sur jenkins, nous avons installé des plugins comme pipeline, SonarQube scanner, github integration et OWASP Dependency-Check.

Dans les tools, nous avons pu configurer ces plugins.
![image](https://github.com/user-attachments/assets/273be259-b572-49af-bc5e-207583f09b36)

![image](https://github.com/user-attachments/assets/a95cb7c2-b5ce-459f-bcc9-930a0d258295)

Nous avons créé des credentials et un Jenkinsfile
![image](https://github.com/user-attachments/assets/939a5a91-862b-4057-958c-139a4a0f2910)

Et une pipeline sur jenkins.

![image](https://github.com/user-attachments/assets/ea51511e-f4f7-4945-8958-0de23e87510b)

Mais nous n'arrivons pas à faire fonctionner jenkins, le build présente toujours des erreurs dans les logs, nous avons pu en résoudre plusieurs mais nous avons encore des problèmes.

![image](https://github.com/user-attachments/assets/d9d6a55a-9473-4984-8d41-bb88db9735e0)

Nous avons alors effectué nos différents tests à la main

Tests unitaires JUnit

![image](https://github.com/user-attachments/assets/215201c7-013b-4d6e-91bc-3c77407a9069)

Tests unitaires Jasmine + Karma effectué a la main avec
"ng test"

![image](https://github.com/user-attachments/assets/fdea1e03-8953-4d17-a245-86a0aecf3000)

Tentative de lier le coverage de Karma avec SonarCloud avec
"npx ng test --code-coverage --watch=false"

![image](https://github.com/user-attachments/assets/30e6eac3-6a51-4fcd-bac7-9f6a490bad8a)

![image](https://github.com/user-attachments/assets/cc70d3d0-ce9f-4912-bde3-13d0b3c9c060)

---

Cette analyse nous montre plusiuers faiblesses importantes, comme des problèmes de duplication de code, de comformité HTML et de sécurité.

Dans les axes d'amélioration, nous devrions :
- Corriger les problèmes de duplication de code, en excluant les fichiers de couverture générés par Angular/Karma
- Sécuriser les failles de sécurité (rf Injection RCE)
- Corriger les problèmes de conformité HTML, (ex: attributs `name` obsolètes)
- Réussier à mettre en place une intégration continue avec Jenkins pour automatiser les builds, tests et analyses de qualité.

