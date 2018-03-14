package ap.com.email;

import android.view.View;
import android.widget.EditText;

import ap.com.R;
import ap.com.base.BaseActivity;
import butterknife.BindView;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class EmailActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_email;
    }

    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.title)
    EditText title;
    @BindView(R.id.content)
    EditText content;

    @Override
    public void onCreate() {
    }

    public void senEMail(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Mail1.sendMail(email.getText().toString()
                        , title.getText().toString()
                        , content.getText().toString());
            }
        }).start();

    }
}
