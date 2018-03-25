package id.duglegir.jagosholat.FeatureFragmentContent;

/**
 * Created by Bryan on 3/12/2018.
 */

public class DoaShalat {
    private int arabDoa, latinDoa, terjemahDoa;

    public DoaShalat(int arabDoa, int latinDoa, int terjemahDoa) {
        this.arabDoa = arabDoa;
        this.latinDoa = latinDoa;
        this.terjemahDoa = terjemahDoa;
    }

    public int getArabDoa() {
        return arabDoa;
    }

    public int getLatinDoa() {
        return latinDoa;
    }

    public int getTerjemahDoa() {
        return terjemahDoa;
    }
}
