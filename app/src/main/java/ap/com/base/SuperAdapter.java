package ap.com.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public abstract class SuperAdapter<T> extends BaseAdapter {

    public List<T> mData = new ArrayList<>();
    public Context mContext;

    public SuperAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return null != mData ? mData.size() : 0;
    }

    @Override
    public T getItem(int i) {
        return null != mData ? mData.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public List<T> getData() {
        if (null == mData) return new ArrayList<>();
        else return mData;
    }

    public void putNewData(List<T> mData) {
        if (null == mData) return;
        this.mData = mData;
        notifyDataSetChanged();
    }

    public void putMoreData(List<T> mData) {
        if (null == mData) return;
        this.mData.addAll(mData);
        notifyDataSetChanged();
    }

    public void clearData() {
        if (null == mData) return;
        mData.clear();
        notifyDataSetChanged();
    }

    public abstract View getView(int i, View view, ViewGroup viewGroup);
}
