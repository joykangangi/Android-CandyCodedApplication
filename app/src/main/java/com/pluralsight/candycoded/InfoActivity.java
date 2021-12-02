package com.pluralsight.candycoded;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.view.View;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);
    }

    //method to attach to the Click Listener on the TextView
    public void createMapIntent(View view) {
        Uri uri = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801"); //uri for the store
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    //attach to the Click Listener on the TextView
    public void createPhoneIntent(View view) {
        Uri uri = Uri.parse("tel:0123456789");
        Intent phIntent = new Intent(Intent.ACTION_DIAL);
        phIntent.setData(uri);
        startActivity(phIntent);
    }


    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***

}
