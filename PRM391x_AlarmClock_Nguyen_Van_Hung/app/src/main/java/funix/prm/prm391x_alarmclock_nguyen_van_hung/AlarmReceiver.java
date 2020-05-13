package funix.prm.prm391x_alarmclock_nguyen_van_hung;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

public class AlarmReceiver extends BroadcastReceiver {

    // this hold pendingIntend id if one pendingIntend trigger. The PendingIntent'id is alarm'id
    public static int sPendingId;

    // TODO: This method is called when the BroadcastReceiver is receiving
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Intent intentToService = new Intent(context, AlarmService.class);
            try {
                // getting intent key "intentType"
                String intentType = Objects.requireNonNull(intent.getExtras()).getString("intentType");
                assert intentType != null;
                switch (intentType) {
                    case Constants.ADD_INTENT:
                        // assign pendingId
                        sPendingId = intent.getExtras().getInt("PendingId");
                        intentToService.putExtra("ON_OFF", Constants.ADD_INTENT);
                        context.startService(intentToService);
                        break;
                    case Constants.OFF_INTENT:
                        // get alarm'id from extras
                        int alarmId = intent.getExtras().getInt("AlarmId");
                        intentToService.putExtra("ON_OFF", Constants.OFF_INTENT);
                        intentToService.putExtra("AlarmId", alarmId);
                        context.startService(intentToService);
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
