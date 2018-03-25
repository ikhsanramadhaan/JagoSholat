package id.duglegir.jagosholat.FeatureFragmentContent;

/**
 * Created by Bryan on 3/3/2018.
 */

public class NiatShalat {

    private int rakaat, shalat, arab, latin, terjemah;

    public NiatShalat(int rakaat, int shalat, int arab, int latin, int terjemah) {
        this.rakaat = rakaat;
        this.shalat = shalat;
        this.arab = arab;
        this.latin = latin;
        this.terjemah = terjemah;
    }

    public int getRakaat() {
        return rakaat;
    }

    public int getShalat() {
        return shalat;
    }

    public int getArab() {
        return arab;
    }

    public int getLatin() {
        return latin;
    }

    public int getTerjemah() {
        return terjemah;
    }
}
