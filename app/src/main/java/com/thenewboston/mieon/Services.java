package com.thenewboston.mieon;

/**
 * Created by rahul on 05/11/15.
 */
public class Services {
    String service;
    String amount;

    public Services( String service,String amount) {
        this.amount = amount;
        this.service = service;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
