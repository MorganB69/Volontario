<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Consignes de mission</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


</head>
<body style="margin: 0; padding: 0;">


<p>Bonjour ${identifiant}</p>
<p>Veuillez trouver ci-dessous les consignes concernant la mission pour laquelle vous vous êtes inscrit</p>
   <h4>Informations générales</h4>
    <p>
        Nom de la mission : ${mission.getNom()} <br />
        Adresse : ${adresse} <br />
        Début : ${debut} <br />
        Fin prévue : ${fin} <br />
    </p>
    <h4>Description</h4>
    <p>
       ${mission.getDescription()}
    </p>
    <h4>Consignes particulières</h4>
    <p>
        ${inscription.getConsigne()}
    </p>

<p>
    Vous pouvez contacter l'association en cas de besoin à l'adresse mail suivante <br/>
    ${mailasso}
</p>
<p>Merci pour votre inscription</p>
<p>Cordialement <br />
    Volontario
</p>


</body>
</html>
