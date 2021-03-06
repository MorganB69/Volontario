﻿# Volontario

Le projet *Volontario* a pour objectif de créer un site web *OpenSource* permettant de faciliter les mises en relation entre des bénévoles et des associations. 

Le site doit permettre : 

* Aux associations d'exprimer leurs besoins en terme de bénévolat (ex : Type de mission, qualifications necessaires, lieu, durée etc.)
* Aux bénévoles de trouver des associations et missions correspondant à leur profil

## Technologies utilisées

### Back-end

Le back-end est un web-service REST développé en JAVA utilisant les technologies suivantes  :

* JAVA/JAVAEE
* MAVEN
* SPRING
* HIBERNATE
* POSTGRESQL

### Front-end

* HTML/CSS/JS/TS
* ANGULAR7

## Participer au projet

Le projet est ouvert à la participation (amélioration des features/tests/documentation/optimisation/suggestion etc.). Pour participer, il convient d'utiliser le système de Fork/Pull request(PR) de GitHub en respectant les règles suivantes : 
* Il est préférable d'ouvrir une issue avant de commencer à développer une feature
* Les PR doivent être suffisamment expliquées et documentées
* Les commits doivent être clairs et compréhensibles
* Les PR qui incluent de nouvelles fonctionnalités ou logiques doivent être accompagnées de tests d'intégration/tests unitaires.

## Déployer l'application
* L'application peut être déployée à l'aide de divers docker-compose disponibles dans le code source (commande : docker-compose --f nomfichier up)
* Database Test : docker-compose.databaseTest.yml (dossier Volontario)
* Database Prod : docker-compose.databaseProd.yml (dossier databaseProd)
* Back end : docker-compose.back.yml (dossier Volontario)
* Front end : docker-compose.frony.yml (dossier Front) après avoir build le projet via la commande CLI ng build --prod

