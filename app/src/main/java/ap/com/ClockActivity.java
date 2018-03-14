package ap.com;

import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

import ap.com.base.BaseActivity;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class ClockActivity extends BaseActivity implements Chronometer.OnChronometerTickListener {

    @Override
    public int getLayout() {
        return R.layout.activity_clock;
    }

    Chronometer chronometer;

    @Override
    public void onCreate() {
        chronometer = findViewById(R.id.chronometer);
        chronometer.setOnChronometerTickListener(this);
    }

    @Override
    public void onChronometerTick(Chronometer chronometer) {
        String time = chronometer.getText().toString();
        if (time.equals("00:00")) {
            Toast.makeText(ClockActivity.this, "时间到了~", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                chronometer.start();// 开始计时
                break;
            case R.id.btnStop:
                chronometer.stop();// 停止计时
                break;
            case R.id.btnReset:
                chronometer.setBase(SystemClock.elapsedRealtime());// 复位
                break;
            case R.id.btn_format:
                chronometer.setFormat("Time：%s");// 更改时间显示格式
                break;
        }
    }
}
