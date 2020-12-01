# M2_EAI Système d'applications JEE - Editeur de presse numérique
Voici notre système d'application pour le projet d'EAI en M2 MIAGE. 

Collaborateurs : 
- Maxime BERTROU
- Astrid GASCARD
- Aymeric MILLAN

Voici un tutoriel de mise en route du projet.

#### Prerequis
- SoapUI (Ou tout autre logiciel de la sorte)
- NetBeans 8.2
- GlassFish 4.1.1
- POSTMAN (ou autre)



## 1. Installer toutes les app
Une fois le repo git cloné, il faut faire un "Build with Dependencies" sur les projet **Shared**, puis sur tous les projets **ear**.

## 2. Creer les ressources JMS et la base de données 
Via la commande asadmin de glassfish, lancer les commandes suivantes : 
- Création de la connextion factory

**create-jms-resource --restype javax.jms.ConnectionFactory CONNECTION_FACTORY_M2_EAI**

- Création des queues et topics

**create-jms-resource --restype javax.jms.Queue ARTICLE_INIT**

**create-jms-resource --restype javax.jms.Queue PRESSE_NOTIF_REDAC**

**create-jms-resource --restype javax.jms.Queue PUBINIT**

**create-jms-resource --restype javax.jms.Queue PRESSE_TRANSFERT_DISTRIB**

**create-jms-resource --restype javax.jms.Queue PRESSE_TRANSFERT_ARCHIVE**

**create-jms-resource --restype javax.jms.Queue TRANSFERT_CONTRAT**

**create-jms-resource --restype javax.jms.Queue ARCHIVE_TRANSFERT_SRVWEB**

**create-jms-resource --restype javax.jms.Topic DIFFUSION_DISTRIB**

**create-jms-resource --restype javax.jms.Topic DIFFUSION_TITRES**



- Création de la base de données du serveur archivage 
Créer une nouvelle JDBC sur le port 1527 comme URL jdbc:derby://localhost:1527/DB_M2_EAI_ARCHIVE
User : dragon
password : dragon
Schema : DRAGON


## 3. Deployez les ear
Clic droit > Run sur tous les projets ear

## 4. Créer les projets sur SOAP UI
Voici les adresses des différents wsdl à entrer dans un nouveau projet sur SOAP UI une fois les applications déployées :
- AppGestionPub
  - http://localhost:8080/PubliciteRemote/PubliciteRemote?wsdl
  
- AppRedaction
  - http://localhost:8080/RedactionRemote/RedactionRemote?wsdl
  
- AppMiseSousPress
  - http://localhost:8080/ServiceAssemblageRem/ServiceAssemblageRem?wsdl
  - http://localhost:8080/ServicePresseRemote/ServicePresseRemote?wsdl
  
- ServeurArchive
  - http://localhost:8080/ServicaArchivageDiffusionRemote/ServicaArchivageDiffusionRemote?wsdl
  
- AppDistributeur
  - http://localhost:8080/WSDistrib/WSDistrib?wsdl


## 5. Scénario d'utilisation 
Voici un scénario d'utilisation type de l'application, une fois toutes les étapes préalables terminées, vous pouvez par exemple suivre ce processus pour tester le système dans son intégralité :

- Créer + envoyer une/des publicité(s) à l'application de mise sous presse (via PubliciteRemote)
- Créer + envoyer un/des article(s) à l'application de mise sous presse (via RedactionRemote)
- Assembler un volume (via ServiceAssemblageRem)
- Assembler un titre (via ServiceAssemblageRem)
- Diffuser un titre de l'application mise sous presse vers le topic (via ServicePresseRemote)
  - Regarder dans la base de données du serveur archive (les titres ont été enregistrés)
  - Regarder dans la console Glassfish un message de l'application distribution qui a bien reçu les titres
- Envoyer les titres présent dans la base de données archive vers le serveur web recherche (via ServicaArchivageDiffusionRemote)
- Effectuer une recherche REST via le ServeurWeb 
  - Récupérer tous les titres
    - http://localhost:8080/ServeurWeb-web/webresources/titre
  - Récupérer les volumes contenant des articles contenant un certain mot clé (remplacer "motClef")
    - http://localhost:8080/ServeurWeb-web/webresources/titre/titreParMotClef/motclef
  - Toutes les méthodes sont disponibles via le lien de l’API Swagger : https://app.swaggerhub.com/apis/eai9/EditeurPresse/1.0.0


Enjoy !
