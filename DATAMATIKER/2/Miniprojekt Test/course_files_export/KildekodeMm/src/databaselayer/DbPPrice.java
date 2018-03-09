package databaselayer;

import modellayer.PPrice;

public interface DbPPrice {

    // Get Price by parking zone id
	public PPrice getPriceByZoneId(int zoneId) throws DatabaseLayerException;
    
}
