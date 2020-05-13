package funix.prm.prm391x_alarmclock_nguyen_van_hung;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

import java.util.Objects;

public class AlarmService extends Service {
    // this object to manage media
    private MediaPlayer mMediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    //TODO: processing on and off ringtone
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // get string from intent
        String on_off = Objects.requireNonNull(intent.getExtras()).getString("ON_OFF");
        assert on_off != null;
        switch (on_off) {
            case Constants.ADD_INTENT:
                // this is system default alarm alert uri
                Uri uri = Settings.System.DEFAULT_ALARM_ALERT_URI;
                mMediaPlayer = MediaPlayer.create(this, uri);
                mMediaPlayer.start();
                break;
            case Constants.OFF_INTENT:
                int alarmId = intent.getExtras().getInt("AlarmId");
                if (mMediaPlayer != null && mMediaPlayer.isPlaying() && alarmId == AlarmReceiver.sPendingId) {
                    mMediaPlayer.stop();
                    mMediaPlayer.reset();
                }
                break;
        }
        return START_STICKY;
    }

    // TODO: Logic processing to turn off the ringtone
    @Override
    public void onDestroy() {
        super.onDestroy();
        mMediaPlayer.stop();
        mMediaPlayer.reset();
    }
}
