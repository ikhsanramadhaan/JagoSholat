package id.duglegir.jagosholat.ImportantMethod;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by Faisal Amir on 18/03/2018.
 */

public class JadwalHelper {

    // Deklarasi Method Helper -------------------------------------------------
    FunctionHelper functionHelper = new FunctionHelper();
    // -------------------------------------------------------------------------

    // Deklarasi Requirement Kebutuhan -----------------------------------------
    private int jmlWaktuShubuh, jmlWaktuTerbit, jmlWaktuDzuhur, jmlWaktuAshar;
    private int jmlWaktuMaghrib, jmlWaktuIsya, jmlBeMidnight, jmlAftMidnight;
    private final int jamKeDetik = 3600;
    private final int menitKeDetik = 60;
    private String mJadwalShalat, txtCountDown;
    private final String bukanWaktuSholat = "Belum Masuk Waktu Sholat";
    private static final String FORMATCOUNTDOWN = "%02d:%02d:%02d";
    private int realTime;
    private int countTime, tempNextTime;
    private String arrayTemp[] = {"Shalat Shubuh", "Shalat Dzuhur", "Shalat Ashar","Shalat Maghrib", "Shalat Isya", bukanWaktuSholat};
    // -------------------------------------------------------------------------

    public JadwalHelper() {
        this.jmlWaktuShubuh = (4 * jamKeDetik) + (39 * menitKeDetik); // 16.740
        this.jmlWaktuTerbit = (5 * jamKeDetik) + (52 * menitKeDetik); // 21.120
        this.jmlWaktuDzuhur = (12 * jamKeDetik) + (2 * menitKeDetik); // 43.320
        this.jmlWaktuAshar = (15 * jamKeDetik) + (9 * menitKeDetik); // 54.540
        this.jmlWaktuMaghrib = (18 * jamKeDetik) + (6 * menitKeDetik); // 65.160
        this.jmlWaktuIsya = (19 * jamKeDetik) + (16 * menitKeDetik); // 69.360
        this.jmlBeMidnight = (23 * jamKeDetik) + (59 * menitKeDetik); // 86.340
        this.jmlAftMidnight = (0 * jamKeDetik) + (0 * menitKeDetik);
        functionHelper.getSystemRealTime();
        this.realTime = functionHelper.getSumWaktuDetik();
    }


    public int getJmlWaktuShubuh() {
        return jmlWaktuShubuh;
    }

    public int getJmlWaktuTerbit() {
        return jmlWaktuTerbit;
    }

    public int getJmlWaktuDzuhur() {
        return jmlWaktuDzuhur;
    }

    public int getJmlWaktuAshar() {
        return jmlWaktuAshar;
    }

    public int getJmlWaktuMaghrib() {
        return jmlWaktuMaghrib;
    }

    public int getJmlWaktuIsya() {
        return jmlWaktuIsya;
    }

    public int getJmlBeMidnight() {
        return jmlBeMidnight;
    }

    public int getJmlAftMidnight() {
        return jmlAftMidnight;
    }

    public void setJadwalShalat(TextView txt){
        if ((realTime == jmlWaktuShubuh) || (realTime < jmlWaktuTerbit)) {
            txt.setText(arrayTemp[0]);
        } else if (realTime == jmlWaktuTerbit || realTime < jmlWaktuDzuhur) {
            txt.setText(arrayTemp[5]);
            txt.setTextSize(20);
        } else if ((realTime == jmlWaktuDzuhur) || (realTime < jmlWaktuAshar)) {
            txt.setText(arrayTemp[1]);
        } else if ((realTime == jmlWaktuAshar) || (realTime < jmlWaktuMaghrib)) {
            txt.setText(arrayTemp[2]);
        } else if ((realTime == jmlWaktuMaghrib) || (realTime < jmlWaktuIsya)) {
            txt.setText(arrayTemp[3]);
        } else if ((realTime == jmlWaktuIsya) || (realTime <= jmlBeMidnight) || (realTime >= jmlAftMidnight) || (realTime < jmlWaktuShubuh) ) {
            txt.setText(arrayTemp[4]);
        } else {
            txt.setText(arrayTemp[5]);
            txt.setTextSize(20);
        }
    }

    public String getMJadwalShalat() {
        if ((realTime == jmlWaktuShubuh) || (realTime < jmlWaktuTerbit)) {
            return mJadwalShalat = "Shalat Shubuh";
        }else if (realTime == jmlWaktuTerbit || realTime < jmlWaktuDzuhur) {
            return mJadwalShalat = bukanWaktuSholat;
        } else if ((realTime == jmlWaktuDzuhur) || (realTime < jmlWaktuAshar)) {
            return mJadwalShalat = "Shalat Dzuhur";
        } else if ((realTime == jmlWaktuAshar) || (realTime < jmlWaktuMaghrib)) {
            return mJadwalShalat = "Shalat Ashar";
        } else if ((realTime == jmlWaktuMaghrib) || (realTime < jmlWaktuIsya)) {
            return mJadwalShalat = "Shalat Maghrib";
        } else if ((realTime == jmlWaktuIsya) || (realTime <= jmlBeMidnight) || (realTime >= jmlAftMidnight) || (realTime < jmlWaktuShubuh)) {
            return mJadwalShalat = "Shalat Isya";
        } else {
            return mJadwalShalat = bukanWaktuSholat;
        }
    }


    public void CoundownTime(int waktu){
        new CountDownTimer(waktu, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
                txtCountDown = ""+String.format(FORMATCOUNTDOWN,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            }

            public void onFinish() {
                txtCountDown = "Saatnya Shalat";
            }

        }.start();
    }

    public String getTxtCountDown() {
        return txtCountDown;
    }

    
}
