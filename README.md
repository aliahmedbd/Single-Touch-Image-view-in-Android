# Single Touch Image view in Android

### Small description:
When we want to touch a little image, our mental model wants to see that image as big size. In this repository, you will find how to create a generic class to make this functionality.

### Technique:
1. I have used a class which has 3 constructors to receive Context, Bitmap, Uri, and Drawable id.
 ```java
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
 ```

2. I create a layout which has a single ImageView to view the desired photo. 

###### dialog_imageview.xml
```xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="wrap_content"
    android:gravity="center"
    android:layout_height="wrap_content">

    <ImageView
        android:id="@+id/imgPhotoViewer"
        android:layout_width="300sp"
        android:layout_height="300sp" />

</LinearLayout>

```


3. In that class create a method which will initialize a dialogue which will contain the layout.
```java
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
```

4. Then I pass the URI, Bitmap or Drawable to that Dialog and finally, Dialog is shown.


### Usage:
1. Create onClickListener in an activity and initialize the class then photo will appear in a single touch
2. In a list also we can add child item click listener then the image will appear in a blink.


#### Thank you and Happy coding.
