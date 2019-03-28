<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Inscription à une de vos missions</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


</head>
<body style="margin: 0; padding: 0;">


<p>Bonjour ${nomAsso}</p>
<p>Le bénévole ${identifiant} s'est inscrit à la mission suivante : </p>

    <p>
        Nom de la mission : ${mission.getNom()} <br />
        Adresse : ${adresse} <br />
        Début : ${debut} <br />
        Fin prévue : ${fin} <br />
    </p>

<p>
   Si des consignes particulières doivent lui être envoyées, veuillez le contacter via son adresse mail :  <br/>
    ${mailbene}
</p>
<p>Merci</p>
<p>Cordialement <br />
    Volontario
</p>


</body>
</html>
