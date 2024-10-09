package tuc.isse.mvp.model;
// E-MAIL: steve.leonel.yomi.mbiakop@tu-clausthal.de
//E-MAIL: dominique.blanche.djene.okeng@tu-clausthal.de

/**
 * @author STEVE LEONEL YOMI MBIAKOP, DOMINIQUE BLANCHE DJENE OKENG
 *
 *  Die Cell-Klasse dient dazu, das Zellen zu erstellen
 *
 */
public class Cell extends GameObjekt {
    private Token token;

    public Cell() {
        this.token = null;

    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    /**
     * @return eine String-Repräsentation der Zelle
     */
    public String toString() {
        if (token == null) {
            return "( )";
        }return "("+token.toString() +")";
    }
}
