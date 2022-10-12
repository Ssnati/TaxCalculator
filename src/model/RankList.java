package model;

import java.io.*;
import java.util.Properties;

class RankList {

    private Properties p;
    private double firsRankDiscount;
    private double secondRankDiscount;
    private double thirdRankDiscount;
    private int timelyPaymentDiscount;
    private int publicTransportDiscount;
    private int registeredInBoyacaDiscount;
    private int minimunValue;
    private int maximunValue;

    public RankList() throws IOException {
        this.p = new Properties();
        p.load(new FileReader("src/resources/config.properties"));
        this.firsRankDiscount = Double.parseDouble(p.getProperty("rank1"));
        this.secondRankDiscount = Double.parseDouble(p.getProperty("rank2"));
        this.thirdRankDiscount = Double.parseDouble(p.getProperty("rank3"));
        this.timelyPaymentDiscount = Integer.parseInt(p.getProperty("payment"));
        this.publicTransportDiscount = Integer.parseInt(p.getProperty("public"));
        this.registeredInBoyacaDiscount = Integer.parseInt(p.getProperty("boyaca"));
        this.minimunValue = Integer.parseInt(p.getProperty("minim"));
        this.maximunValue = Integer.parseInt(p.getProperty("maxim"));
    }

    public double getFirsRankDiscount() {
        return firsRankDiscount;
    }

    public int getPublicTransportDiscount() {
        return publicTransportDiscount;
    }

    public int getRegisteredInBoyacaDiscount() {
        return registeredInBoyacaDiscount;
    }

    public double getSecondRankDiscount() {
        return secondRankDiscount;
    }

    public double getThirdRankDiscount() {
        return thirdRankDiscount;
    }

    public int getTimelyPaymentDiscount() {
        return timelyPaymentDiscount;
    }

    public int getMaximunValue() {
        return maximunValue;
    }

    public int getMinimunValue() {
        return minimunValue;
    }
}
