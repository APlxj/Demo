package ap.com.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import ap.com.R;
import butterknife.ButterKnife;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public abstract class BaseActivity extends FragmentActivity {

    public static final String DATA = BaseActivity.class.getName() + "swallow";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        onCreate();
    }

    public abstract int getLayout();

    public abstract void onCreate();

    public void showActivity(Class<?> aClass, String str) {
        Intent intent = new Intent(BaseActivity.this, aClass);
        intent.putExtra(DATA, str);
        startActivity(intent);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void showActivity(Class<?> aClass) {
        showActivity(aClass, "");
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(R.anim.in, R.anim.out);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
