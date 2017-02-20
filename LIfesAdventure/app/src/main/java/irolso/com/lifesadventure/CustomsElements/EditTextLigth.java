package irolso.com.lifesadventure.CustomsElements;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Roldan on 18/12/16.
 */

public class EditTextLigth extends EditText {
    public EditTextLigth(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"Fonts/Roboto-Thin.ttf"));
    }
}
