package id.duglegir.jagosholat.ImportantMethod;

import android.provider.BaseColumns;

/**
 * Created by Faisal Amir on 24/03/2018.
 */

public class DataContract {

    private DataContract() {
    }

    public static final class DataEntry implements BaseColumns {
        public static final String TABLE_NAME = "data_ibadah";
        public static final String _ID  = BaseColumns._ID;
        public static final String COLUMN_TANGGAL = "tanggal";
        public static final String COLUMN_SHALAT = "shalat";
        public static final String COLUMN_WAKTU = "waktu";
        public static final String COLUMN_STATUS = "status";
    }


}
