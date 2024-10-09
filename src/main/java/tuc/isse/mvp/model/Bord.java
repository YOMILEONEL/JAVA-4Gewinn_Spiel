package tuc.isse.mvp.model;
// E-MAIL: steve.leonel.yomi.mbiakop@tu-clausthal.de
//E-MAIL: dominique.blanche.djene.okeng@tu-clausthal.de

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author STEVE LEONEL YOMI MBIAKOP, DOMINIQUE BLANCHE DJENE OKENG
 *
 *  Die Bord-Klasse dient dazu, das Spielbrett mit einer festen Anzahl an Zellen zu erstellen
 *
 */
public class Bord extends GameObjekt {
    private List<List<Cell>> cell;

    private HashMap<Token.Color,List<Token> > tokenLager= new HashMap<>();


    public Bord() {

        List<Token> redtokens= new ArrayList<>();
        List<Token> bluetokens= new ArrayList<>();

        for( int i=0; i<=20; i++){
            Token t1= new Token(Token.Color.RED);
            Token t2 = new Token(Token.Color.BLUE);

            redtokens.add(t1);
            bluetokens.add(t2);
        }

        tokenLager.put(Token.Color.RED,redtokens);
        tokenLager.put(Token.Color.BLUE,bluetokens);


        // Erstelle ein 6x7-Spielbrett
        this.cell = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            List<Cell> cel = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                cel.add(new Cell());
            }
            this.cell.add(cel);
        }
    }

    public List<List<Cell>> getCell() {
        return cell;
    }

    /**
     * @param row
     * @param column
     * @return
     */
    public Token.Color getTokenColor(int row , int column){
        boolean b= cell.get(row).get(column).getToken() !=null;
        if(b){
            return null;
        }
        else{
            return cell.get(row).get(column).getToken().getColor();
        }
    }

    public HashMap<Token.Color, List<Token>> getTokenLager() {
        return tokenLager;
    }

    /**
     *
     * @param color, um ein token mit der eingegebenen Farbe zu finden
     * @return ein token des tokenLagers, das entfernt wurde
     */
    public Token getToken(Token.Color color){

        Token tmpToken= tokenLager.get(color).get(tokenLager.get(color).size()-1);
        tokenLager.get(color).remove(tokenLager.get(color).size()-1);
        return tmpToken;
    }

    /**
     *
     * @param color zur Überprüfung ob es noch Token mit der Farbe color gibt
     * @return true wenn es noch Token mit der angegebenen Farbe im Lager gibt, sonst false
     */
    public Boolean hasToken(Token.Color color){
        return !tokenLager.get(color).isEmpty();
    }

    /**
     * @return true, wenn es kein Token mehr sowohl in bleuen Lagerkisten als auch in roten Lagerkisten.
     * In diesem Fall haben alle Spieler alle ihre Token geworfen, ohne einen Sieg zu erreichen
     */
    private Boolean isTie(){
        return (tokenLager.get(Token.Color.RED).isEmpty() && tokenLager.get(Token.Color.BLUE).isEmpty());
    }


    private Token getToken(int i, int j) {
        if(i>0 && i<6 && j>0 && j<7){
            return cell.get(i).get(j).getToken();
        }
        return null;
    }

    /**
     *
     * @param color zur Überprüfung ob die eingegebene Farbe gewonnen hat
     * @return True wenn die Farbe color gewonnen hat, sonst false
     */
    public boolean isRowVictory(Token.Color color){
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j+3 < 7; j++){
                    //Siegebedingung 4
                if (getToken(i, j) != null &&
                            getToken(i, j).getColor().equals(color) &&
                            getToken(i - 1, j + 1) != null &&
                            getToken(i - 1, j + 1).getColor().equals(color) &&
                            getToken(i, j + 2) != null &&
                            getToken(i, j + 2).getColor().equals(color) &&
                            getToken(i - 1, j + 3) != null &&
                            getToken(i - 1, j + 3).getColor().equals(color)) {
                        return true;
                }

                //Siegebedingung 5
                else if (getToken(i - 1, j) != null &&
                        getToken(i - 1, j).getColor().equals(color) &&
                        getToken(i , j + 1) != null &&
                        getToken(i , j + 1).getColor().equals(color) &&
                        getToken(i - 1, j + 2) != null &&
                        getToken(i - 1, j + 2).getColor().equals(color) &&
                        getToken(i, j + 3) != null &&
                        getToken(i, j + 3).getColor().equals(color)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param color zur Überprüfung ob die eingegebene Farbe gewonnen hat
     * @return True wenn die Farbe color gewonnen hat, sonst false
     */
    public boolean isColumnVictory(Token.Color color){
        for (int i = 5; i-3 >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                //Siegebedingung 6
                if     (getToken(i,j)!=null &&
                        getToken(i,j).getColor().equals(color)&&
                        getToken(i - 1, j + 1) != null &&
                        getToken(i - 1, j + 1).getColor().equals(color) &&
                        getToken(i-2,j)!=null &&
                        getToken(i-2,j).getColor().equals(color)&&
                        getToken(i-3,j+1)!=null &&
                        getToken(i-3,j+1).getColor().equals(color)){
                    return true;
                }
                //Siegebedingung 7
                else if(getToken(i-1,j)!=null&&
                        getToken(i-1,j).getColor().equals(color)&&
                        getToken(i,j+1)!=null&&
                        getToken(i,j+1).getColor().equals(color)&&
                        getToken(i-3,j)!=null &&
                        getToken(i-3,j).getColor().equals(color)&&
                        getToken(i-2,j+1)!=null &&
                        getToken(i-2,j+1).getColor().equals(color)){
                    return true;
                }
            }
        }
        return false;
    }




    /**
     *
     * @return BLUE (beziehungsweise RED ) wenn das bleue Token (beziehungsweise das rote Token ) gewonnnen hat, und NONE wenn niemand gewonnen hat
     */
    public Token.Winner testVictory(){
        if(isRowVictory(Token.Color.BLUE) ||  isColumnVictory(Token.Color.BLUE)){
            return Token.Winner.BLUE;
        }
        else if(isRowVictory(Token.Color.RED) ||  isColumnVictory(Token.Color.RED)){
            return Token.Winner.RED;
        }

        else if(isTie()) {
            return Token.Winner.TIE;
        }
        else{
            return Token.Winner.NONE;
        }

    }

    /**
     * Überprüft, ob ein Token in einer bestimmten Spalte abgelegt werden kann
     *
     * @param columnIndex der Index der Spalte, in der der Token abgelegt werden soll
     * @return true, wenn ein Token in dieser Spalte abgelegt werden kann, false sonst
     */

    public boolean canDrop(int columnIndex) {
        //Überprüge ob der Spalteindex existiert
        if (columnIndex < 0 || columnIndex >= 7){
            return false;
        }

        //Überprüfe ob es leere Zelle noch gibt
        for (int i = 0; i < 6; i++) {
            if (cell.get(i).get(columnIndex).getToken() == null) return true; // es gibt noch welche
        }
        return false; // es gibt keine mehr
    }

    /**
     * Legt ein Token in einer bestimmten Spalte ab
     *
     * @param token       die Farbe des Tokens, das abgelegt werden soll
     * @param columnIndex der Index der Spalte, in der der Token abgelegt werden soll
     * @return true, wenn das Token erfolgreich abgelegt wurde, false sonst
     */

    public boolean dropToken(Token token, int columnIndex)  throws ColumnFullException, IllegalMoveException {

        if (!canDrop(columnIndex)) {
            throw new ColumnFullException("Es gibt  keinen Platz mehr in der Spalte "+ columnIndex);
        }
        if(testVictory().equals(Token.Winner.BLUE ) || testVictory().equals(Token.Winner.RED)){
            throw new IllegalMoveException();
        }

        for (int i = 5; i >= 0; i--) {
            if (cell.get(i).get(columnIndex).getToken() == null) {
                // Lege das Token in die erste freie Zelle in dieser Spalte ab

                cell.get(i).get(columnIndex).setToken(token);
                return true; // Token wurde hinzugefügt
            }

        }

        return false;

    }

    /**
     * Gibt eine String-Repräsentation des Spielbretts zurück
     *
     * @return eine String-Repräsentation des Spielbretts
     */
    public String toString() {
        StringBuilder board = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                // Füge jede Zelle des Spielbretts in einem String zusammen
                board.append(cell.get(i).get(j).toString());
            }
            board.append("\n");
        }
        return board.toString();
    }

}


