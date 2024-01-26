package com.productmapper.constants;

public enum MassUnits {
    KG("kg"), LBS("lbs");

    private String abbrv;
    MassUnits(String abbrv) {
        this.abbrv = abbrv;
    }

    public String getAbbrv(){
        return this.abbrv;
    }

    public Double convert(Double mass){
        if(this.abbrv == MassUnits.KG.getAbbrv()){
            return mass * MassUnitExchangeRate.rate;
        }
        if(this.abbrv == MassUnits.LBS.getAbbrv()){
            return mass / MassUnitExchangeRate.rate;
        }
        return null;
    }

    private static class MassUnitExchangeRate{
        public static final Double rate = 2.20462262;
    }
}
