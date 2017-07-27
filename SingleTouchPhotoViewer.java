package com.grameenphone.onegp.common.app.util;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;

import com.grameenphone.onegp.R;
import com.grameenphone.onegp.model.weather.Image;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Name : Ali Ahmed
 * Email: aliahmedaiub@gmail.com
 * on 7/27/2017.
 */

public class SingleTouchPhotoViewer {

    public Context context;
    ImageView imageView;
    Bitmap mBitmap = null;
    String mUri = null;
    int mDrawable = 0;
    Dialog openDialog;

    public SingleTouchPhotoViewer(Context context, Bitmap bitmap) {
        this.context = context;
        this.mBitmap = bitmap;
        openDialogue();
    }

    public SingleTouchPhotoViewer(Context context, String uri) {
        this.context = context;
        this.mUri = uri;
        openDialogue();
    }

    public SingleTouchPhotoViewer(Context context, int drawableId) {
        this.context = context;
        this.mDrawable = drawableId;
        openDialogue();
    }

    public void openDialogue() {
        openDialog = new Dialog(context);
        openDialog.setContentView(R.layout.dialog_image_viewer);
        imageView = (ImageView) openDialog.findViewById(R.id.imgPhotoViewer);
        if (mBitmap != null) {
            imageView.setImageBitmap(mBitmap);
        } else if (mUri != null) {
            Picasso.with(context).load(mUri).into(imageView);
        } else if (mDrawable != 0) {
            imageView.setImageResource(mDrawable);
        }
        openDialog.show();
    }

}
