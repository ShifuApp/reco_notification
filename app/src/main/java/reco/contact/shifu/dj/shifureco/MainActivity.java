package reco.contact.shifu.dj.shifureco;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import reco.contact.shifu.dj.shifureco.DO.RecotypeDO;
import reco.contact.shifu.dj.shifureco.Notification.NotificationUtil;

/**
 * @author deepanshjain
 *         <p/>
 *         This class peform the main launcher
 *         Notification has been designed for sdk 20+
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowNotification(View v) {
        NotificationUtil notificationUtil = new NotificationUtil();

        List<RecotypeDO> content = new ArrayList<>();
        RecotypeDO recotypeDO1 = new RecotypeDO();
        recotypeDO1.setActionUpon("_NUMBER_");
        recotypeDO1.setName("Deepansh");
        recotypeDO1.setType(1);
        content.add(recotypeDO1);

        RecotypeDO recotypeDO2 = new RecotypeDO();
        recotypeDO2.setName("James");
        recotypeDO2.setActionUpon("_NUMBER_");
        recotypeDO2.setType(0);
        content.add(recotypeDO2);

        RecotypeDO recotypeDO3 = new RecotypeDO();
        recotypeDO3.setActionUpon("_APPNAME_");
        recotypeDO3.setName("Instagram");
        recotypeDO3.setType(2);
        content.add(recotypeDO3);

        notificationUtil.showSuggestNotification(this, content);
    }

    public void onClickCancelNotification(View v) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(1);
    }
}
