package cn.psvmc.zjfiledownload.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import cn.psvmc.zjfiledownload.R;
import cn.psvmc.zjfiledownload.ui.fragment.ListViewFragment;


public class AppListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_list);

        Intent intent = getIntent();

        if (savedInstanceState == null) {
            Fragment fragment = new ListViewFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
    }
}
