package ap.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ap.com.base.BaseActivity;
import ap.com.base.SuperAdapter;
import ap.com.video.VideoActivity;
import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.gridView)
    GridView mGridView;
    private MyAdapter adapter;

    @Override
    public void onCreate() {
        adapter = new MyAdapter(this);
        mGridView.setAdapter(adapter);
        adapter.putNewData(getList());
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if ("video".equals(adapter.getData().get(i))) {
                    showActivity(VideoActivity.class);
                }else if ("clock".equals(adapter.getData().get(i))) {
                    showActivity(ClockActivity.class);
                }
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    public List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("video");
        list.add("image");
        list.add("okhttp");
        list.add("volley");
        list.add("clock");
        return list;
    }

    private class MyAdapter extends SuperAdapter<String> {
        public MyAdapter(Context mContext) {
            super(mContext);
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder;
            if (null == view) {
                holder = new ViewHolder();
                view = LayoutInflater.from(mContext).inflate(R.layout.item_main, null);
                holder.tv = view.findViewById(R.id.textView);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            holder.tv.setText(mData.get(i));
            return view;
        }

        class ViewHolder {
            TextView tv;
        }
    }
}
