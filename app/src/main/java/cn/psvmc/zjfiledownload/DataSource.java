package cn.psvmc.zjfiledownload;

import java.util.ArrayList;
import java.util.List;

import cn.psvmc.zjfiledownload.entity.AppInfo;

public class DataSource {

    private static DataSource sDataSource = new DataSource();

    private static final String[] NAMES = {
            "360手机卫士",
            "小猫",
            "好压"
    };

    private static final String[] IMAGES = {
            "",
            "",
            ""

    };

    private static final String[] URLS = {
            "http://msoftdl.360.cn/mobilesafe/shouji360/360safesis/360MobileSafe_6.2.3.1060.apk",
            "http://imgsrc.baidu.com/forum/pic/item/1ad5ad6eddc451da0e0f7052b6fd5266d1163289.jpg",
            "http://dl.2345.com/haozip/haozip_v5.5.exe"
    };

    public static DataSource getInstance() {
        return sDataSource;
    }

    public List<AppInfo> getData() {
        List<AppInfo> appInfos = new ArrayList<AppInfo>();
        for (int i = 0; i < NAMES.length; i++) {
            AppInfo appInfo = new AppInfo(String.valueOf(i), NAMES[i], IMAGES[i], URLS[i]);
            appInfos.add(appInfo);
        }
        return appInfos;
    }
}
