# Rapport de Qualité du Projet

Utilisation d'outils de vérification du code:
- Tests unitaires (JUnit, Jasmine)
- SonarCloud
- Jenkins


![image](https://github.com/user-attachments/assets/0a80796f-0162-45d0-b6d8-e43592ec05e6)

### Echec du Quality Gate
**3 conditions échouées** :
- Fiabilité non évaluée (Rating A requis).
- 0% des Security Hotspots revus (objectif 100%).
- 23.6% de lignes dupliquées sur le nouveau code (objectif ≤ 3%).

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

![image](https://github.com/user-attachments/assets/dee47ecf-440f-4975-95de-8c4537bf451b)

### Lignes dupliquées
- `biblioflex-ui` contient **815 lignes dupliquées**, soit **24%** du nouveau code.

![image](https://github.com/user-attachments/assets/f71a3f85-ef28-408b-a078-0763ddece4d6)

### Problème de sécurité : Code Injection
Un hotspot critique a été identifié : une potentielle injection via la chaîne `"javascript:"` dans un champ simulant du code javascript.

---

Jenkins

Tests unitaires JUnit

![image](https://github.com/user-attachments/assets/215201c7-013b-4d6e-91bc-3c77407a9069)

