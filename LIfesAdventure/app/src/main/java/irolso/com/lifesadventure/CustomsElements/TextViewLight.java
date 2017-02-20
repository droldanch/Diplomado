package irolso.com.lifesadventure.CustomsElements;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Roldan on 17/12/16.
 */

public class TextViewLight extends TextView {

    public TextViewLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"Fonts/Roboto-Thin.ttf"));
    }


    //

}
