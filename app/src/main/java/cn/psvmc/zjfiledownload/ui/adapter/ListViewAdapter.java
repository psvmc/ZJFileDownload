package cn.psvmc.zjfiledownload.ui.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aspsine.multithreaddownload.util.FileUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.psvmc.zjfiledownload.R;
import cn.psvmc.zjfiledownload.entity.AppInfo;
import cn.psvmc.zjfiledownload.listener.OnItemClickListener;
import cn.psvmc.zjfiledownload.util.ZJFileUtils;
public class ListViewAdapter extends BaseAdapter {

    private List<AppInfo> mAppInfos;

    private OnItemClickListener mListener;

    public ListViewAdapter() {
        this.mAppInfos = new ArrayList<AppInfo>();
    }

    public void setData(List<AppInfo> appInfos) {
        this.mAppInfos.clear();
        this.mAppInfos.addAll(appInfos);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public int getCount() {
        return mAppInfos.size();
    }

    @Override
    public AppInfo getItem(int position) {
        return mAppInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final AppInfo appInfo = mAppInfos.get(position);
        holder.tvName.setText(appInfo.getName());
        holder.tvDownloadPerSize.setText(appInfo.getDownloadPerSize());
        holder.tvStatus.setText(appInfo.getStatusText());
        holder.progressBar.setProgress(appInfo.getProgress());
        holder.btnDownload.setText(appInfo.getButtonText());
        //Picasso.with(parent.getContext()).load(appInfo.getImage()).into(holder.ivIcon);

        holder.ivIcon.setImageDrawable(parent.getResources().getDrawable(R.drawable.big_ico_chm));
        String suffix = FileUtils.getSuffix(appInfo.getUrl());
        Drawable drawable = ZJFileUtils.getDrawableBySuffix(parent.getContext(), suffix);
        if (drawable != null) {
            holder.ivIcon.setImageDrawable(drawable);
        }

        holder.btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(v, position, appInfo);
                }
            }
        });

        return convertView;
    }


    public final static class ViewHolder {

        @Bind(R.id.ivIcon)
        public ImageView ivIcon;

        @Bind(R.id.tvName)
        public TextView tvName;

        @Bind(R.id.btnDownload)
        public Button btnDownload;

        @Bind(R.id.tvDownloadPerSize)
        public TextView tvDownloadPerSize;

        @Bind(R.id.tvStatus)
        public TextView tvStatus;

        @Bind(R.id.progressBar)
        public ProgressBar progressBar;

        public ViewHolder(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
