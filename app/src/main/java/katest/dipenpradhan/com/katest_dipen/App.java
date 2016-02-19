package katest.dipenpradhan.com.katest_dipen;

import android.app.Application;

import com.squareup.otto.Bus;

import katest.dipenpradhan.com.katest_dipen.database.DBManager;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by dipenpradhan on 12/29/15.
 */
public class App extends Application {

    private static Bus mBus = new Bus();
    private static DBManager mDBManager;
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(getString(R.string.font_prox_nova_reg))
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        getBus();
        mDBManager = new DBManager(this);
    }


    public Bus getBus() {
        if(mBus==null){
            mBus=new Bus();
        }
        return mBus;
    }

    public static DBManager getDBManager() {
        return mDBManager;
    }
}
