package org.anderes.edu.calc;

/**
 * Taschenrechner mit Primzahlberechnung
 *
 * @author Ren� Anderes
 */
public interface CalcIfc {
	
	/**
     * Gibt zur�ck, ob es sich bei der Zahl um eine Primzahl handelt
     *
     * @param number Zahl
     * @return {@code true}, Primzahl sonst {@code false}
     */
    public boolean isPrimeNumber(int number);
    
    /**
     * Zwei Werte Multiplizieren
     * 
     * @param x Wert
     * @param y Wert
     * @return x mit y multipliziert
     */
    public double multiply(double x, double y);
    
    /**
     * Einen Wert um die Schrittwert erh�hen.
     * 
     * @param value Wert
     * @param step Erh�hung
     * @return Neuert Wert
     */
    public int incremental(int value, int step);
    
    /**
     * Entfernt einen Wert vom Stack (LIFO) und liefert diesen zur�ck.
     * 
     * @return Wert vom Stack
     */
    public double popFromStack();
    
    /**
     * Legt einen Wert im Stack (LIFO) des Taschenrechners ab.
     * 
     * @param value Wert f�r den Stack
     */
    public void pushToStack(double value);
}
