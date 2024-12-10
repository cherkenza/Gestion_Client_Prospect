package gestionLog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class FormatterLog extends Formatter {

    @Override
    public String format(LogRecord record) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");// définit un format de date spécifique
        StringBuilder result = new StringBuilder();
        result.append(format.format(new Date()));// pour obtenir la date et l'heure actuelles
        result.append(" Level : " );
        result.append(record.getLevel());// Renvoie le niveau du log ex:info, warning, severe
        result.append(" / Message : ");
        result.append(record.getMessage());// le message fourni lorsque le logger est utilisé
        result.append(" / Classe : ");//Indique le nom de la classe d'où le log a été généré.
        result.append(record.getSourceClassName());
        result.append(" / Méthode : ");//Indique le nom de la méthode d'où le log a été généré.
        result.append(record.getSourceMethodName());
        result.append("\n");
        return result.toString();
    }
}
