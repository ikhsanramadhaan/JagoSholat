package id.duglegir.jagosholat.ImportantMethod;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import id.duglegir.jagosholat.CatatanFragment;

/**
 * Created by Bryan Rafsanzani on 11/03/2018.
 */

public class FunctionHelper {

    // Requirement Random Karakter -----------------------------------
    private char[] chars = "1234567890".toCharArray();
    private StringBuilder stringBuilder = new StringBuilder();
    private Random random = new Random();
    private String randomChar;
    // ---------------------------------------------------------------

    // Requirement Tanggal dan Waktu ---------------------------------
    private String dateToday;
    private Calendar currentTime;
    private String outputStringTime;
    private int systemJam, systemMenit, systemDetik, sumWaktuDetik;
    private String nilai_jam, nilai_menit, nilai_detik;
    private final int jamKeDetik = 3600;
    private final int menitKeDetik = 60;
    private final int detikKeMili = 1000;
    // ---------------------------------------------------------------

    public FunctionHelper() {
        this.currentTime = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
        this.dateToday = simpleDateFormat.format(currentTime.getTime());
        getSystemRealTime();
        getSumRealTime();
        getSumWaktuDetik();
    }


    // Method Random Character -------------------------------------------
    public String getRandomChar() {
        for (int lenght = 0; lenght < 5; lenght++) {
            Character character = chars[random.nextInt(chars.length)];
            stringBuilder.append(character);
        }
        randomChar = stringBuilder.toString();
        stringBuilder.delete(0, 5);
        return randomChar;
    }
    // -------------------------------------------------------------------

    public String getDateToday() {
        return dateToday;
    }

    public String getOutputStringTime() {
        outputStringTime = nilai_jam + ":" + nilai_menit;
        return outputStringTime;
    }

    public void getSkalaWaktu24() {
        // Skala Waktu 24 Jam ---------------------------------------------------------------
        Calendar cal = Calendar.getInstance();
        systemJam = cal.get(Calendar.HOUR_OF_DAY);
        systemMenit = cal.get(Calendar.MINUTE);
        systemDetik = cal.get(Calendar.SECOND);
        // ----------------------------------------------------------------------------------
    }

    public void getSystemTime() {
        getSkalaWaktu24(); // skala waktu 24 Jam

        // Jika waktu itu kurang dari 9 maka akan di tambahkan 0 didepan angkanya -----------
            String nol_jam = "", nol_menit = "",nol_detik = "";
            if(systemJam <= 9)
                nol_jam= "0";
            if(systemMenit <= 9)
                nol_menit= "0";
            if(systemDetik <= 9)
                nol_detik= "0";
        // ----------------------------------------------------------------------------------

        // Tampilan String dari systemJam, systemMenit, systemDetik Ex : 02 , 05 , 15 -------
        nilai_jam = nol_jam + Integer.toString(systemJam);
        nilai_menit = nol_menit + Integer.toString(systemMenit);
        nilai_detik = nol_detik + Integer.toString(systemDetik);
        // ----------------------------------------------------------------------------------
    }

    public void getSystemRealTime(){
        Thread p = new Thread(){
            public void run(){
                for(;;){
                    getSystemTime(); // Panggil waktu dari System
                    getOutputStringTime(); // Panggil String waktu;
                    try {
                        sleep(1000);
                    }catch (InterruptedException ex){
                        Logger.getLogger(CatatanFragment.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        p.start();
    }

    public void getSumRealTime() {
        Thread p = new Thread(){
            public void run(){
                for(;;){
                    getSkalaWaktu24();
                    try {

                        sleep(1000);
                    }catch (InterruptedException ex){
                        Logger.getLogger(CatatanFragment.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        p.start();
    }

    public int getSumWaktuDetik() {
        getSumRealTime();
        sumWaktuDetik = (systemJam * jamKeDetik) + (systemMenit * menitKeDetik) + systemDetik;
        return sumWaktuDetik;
    }

    public String getOutputTime(){
        getSystemRealTime();
        return outputStringTime;
    }

    public int getDetikKeMili() {
        return detikKeMili;
    }
}