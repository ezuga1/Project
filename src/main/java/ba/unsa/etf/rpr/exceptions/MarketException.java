package ba.unsa.etf.rpr.exceptions;

public class MarketException extends Exception{
    public MarketException(String msg, Exception reason){
        super(msg, reason);
    }
    public MarketException(String msg){
        super(msg);
    }
}
