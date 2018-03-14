package ap.com.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import ap.com.AddUtils;
import ap.com.R;
import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.gridView)
    GridView mGridView;
    private MyAdapter adapter;

    @Override
    public void onCreate() {
        adapter = new MyAdapter(this);
        mGridView.setAdapter(adapter);
        adapter.putNewData(AddUtils.getList());
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (AddUtils.map.containsKey(adapter.getData().get(i)))
                    showActivity(AddUtils.map.get(adapter.getData().get(i)));
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
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
