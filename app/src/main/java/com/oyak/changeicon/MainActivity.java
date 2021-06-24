package com.oyak.changeicon;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.SyncStateContract;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Her açıldığında önceden tanımlanmış rasgele bir ikonu göstermek için activity-alias durumunu değiştiriyoruz.
        final int random = new Random().nextInt(5) + 1;

        //hangi ikonu istiyorsak, manifest dosyasında tanımlanmış alias adını cls değeri olarak veriyoruz.
        PackageManager pm = getPackageManager();
        pm.setComponentEnabledSetting(
                getComponentName(),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
        pm.setComponentEnabledSetting(
                new ComponentName(this, "com.oyak.changeicon.MainActivity"+random),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);

        ((TextView)findViewById(R.id.tv_main_info)).setText("Uygulama ikonu "+ random +" olarak değiştirildi.");
    }

}