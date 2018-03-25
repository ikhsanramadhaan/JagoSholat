package id.duglegir.jagosholat.StatistikFragmentContent;

/**
 * Created by Faisal Amir on 13/03/2018.
 */

public class StatistikDataWord {

    private int img_resID;
    private String no, sholat, waktu, tanggal, status;


    public StatistikDataWord(int img_resID, String sholat, String waktu) {
        this.img_resID = img_resID;
        this.sholat = sholat;
        this.waktu = waktu;
    }

    public StatistikDataWord(String no,  String tanggal, String waktu, String sholat, String status) {
        this.no = no;
        this.sholat = sholat;
        this.waktu = waktu;
        this.tanggal = tanggal;
        this.status = status;
    }

    public String getNo() {
        return no;
    }

    public int getImg_resID() {
        return img_resID;
    }

    public String getSholat() {
        return sholat;
    }

    public String getWaktu() {
        return waktu;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getStatus() {
        return status;
    }
}
