package gestionLog;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ExoLogger {
    public static final Logger logger = Logger.getLogger(ExoLogger.class.getName());
    public static FileHandler fileHandler = null;
    public static void initFichierLog () throws IOException
    {
        fileHandler = new FileHandler("LogAppli",true);
        logger.setUseParentHandlers(false);
        logger.addHandler(fileHandler);
        fileHandler.setFormatter(new gestionLog.FormatterLog());
    }}
