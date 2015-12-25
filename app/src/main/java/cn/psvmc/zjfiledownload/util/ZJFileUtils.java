package cn.psvmc.zjfiledownload.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.annotation.NonNull;

import java.io.File;

public class ZJFileUtils {
    private static final String DOWNLOAD_DIR = "download";

    public static final File getDownloadDir(Context context) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return new File(context.getExternalCacheDir(), DOWNLOAD_DIR);
        }
        return new File(context.getCacheDir(), DOWNLOAD_DIR);
    }

    public static final String getPrefix(@NonNull String fileName) {
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    public static final String getSuffix(@NonNull String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    //根据后缀获取图片
    public static Drawable getDrawableBySuffix(Context context, String suffix) {
        Resources res = context.getResources();
        suffix = suffix.toLowerCase();
        String name = "big_ico_" + suffix;
        int id = res.getIdentifier(name, "drawable", context.getPackageName());
        try {
            Drawable drawable = res.getDrawable(id);
            return drawable;
        } catch (Exception e) {
            return null;
        }

    }
}
