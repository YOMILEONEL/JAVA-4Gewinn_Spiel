package tuc.isse.mvp.model;
// E-MAIL: steve.leonel.yomi.mbiakop@tu-clausthal.de
//E-MAIL: dominique.blanche.djene.okeng@tu-clausthal.de

/**
 *@author STEVE LEONEL YOMI MBIAKOP, DOMINIQUE BLANCHE DJENE OKENG
 *
 * Die ColumnFullException-Klasse ist eine selbst_erstellte Exception, die von der Klasse Exception erbt,
 * und dient zur Überprüfung, ob es noch Plätze in einer gegebenen Spalte gibt
 *
 */
public class  ColumnFullException extends Exception {
    public ColumnFullException(String message) {
        super(message);
    }
}
