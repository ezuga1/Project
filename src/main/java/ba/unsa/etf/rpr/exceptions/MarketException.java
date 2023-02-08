package ba.unsa.etf.rpr.exceptions;

/**
 * MarketException for Project usage, extends Exception class
 * @author Ernad Zuga
 */
public class MarketException extends Exception{
    public MarketException(String msg, Exception reason){
        super(msg, reason);
    }
    public MarketException(String msg){
        super(msg);
    }
}
