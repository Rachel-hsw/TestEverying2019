package android.support.v7.internal.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.view.ContextThemeWrapper;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.Map;

public class AppCompatViewInflater
{
  private static final String LOG_TAG = "AppCompatViewInflater";
  private static final Map<String, Constructor<? extends View>> sConstructorMap;
  static final Class<?>[] sConstructorSignature = { Context.class, AttributeSet.class };
  private final Object[] mConstructorArgs = new Object[2];

  static
  {
    sConstructorMap = new ArrayMap();
  }

  private View createView(Context paramContext, String paramString1, String paramString2)
    throws ClassNotFoundException, InflateException
  {
    Constructor localConstructor = (Constructor)sConstructorMap.get(paramString1);
    if (localConstructor == null);
    try
    {
      ClassLoader localClassLoader = paramContext.getClassLoader();
      if (paramString2 != null);
      for (String str = paramString2 + paramString1; ; str = paramString1)
      {
        localConstructor = localClassLoader.loadClass(str).asSubclass(View.class).getConstructor(sConstructorSignature);
        sConstructorMap.put(paramString1, localConstructor);
        localConstructor.setAccessible(true);
        View localView = (View)localConstructor.newInstance(this.mConstructorArgs);
        return localView;
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private View createViewFromTag(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    if (paramString.equals("view"))
      paramString = paramAttributeSet.getAttributeValue(null, "class");
    try
    {
      this.mConstructorArgs[0] = paramContext;
      this.mConstructorArgs[1] = paramAttributeSet;
      if (-1 == paramString.indexOf('.'))
      {
        View localView2 = createView(paramContext, paramString, "android.widget.");
        return localView2;
      }
      View localView1 = createView(paramContext, paramString, null);
      return localView1;
    }
    catch (Exception localException)
    {
      return null;
    }
    finally
    {
      this.mConstructorArgs[0] = null;
      this.mConstructorArgs[1] = null;
    }
    throw localObject;
  }

  private static Context themifyContext(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.View, 0, 0);
    if (paramBoolean1);
    for (int i = localTypedArray.getResourceId(R.styleable.View_android_theme, 0); ; i = 0)
    {
      if ((paramBoolean2) && (i == 0))
      {
        i = localTypedArray.getResourceId(R.styleable.View_theme, 0);
        if (i != 0)
          Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
      }
      int j = i;
      localTypedArray.recycle();
      if ((j != 0) && ((!(paramContext instanceof ContextThemeWrapper)) || (((ContextThemeWrapper)paramContext).getThemeResId() != j)))
        paramContext = new ContextThemeWrapper(paramContext, j);
      return paramContext;
    }
  }

  public final View createView(View paramView, String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramView != null));
    for (Context localContext = paramView.getContext(); ; localContext = paramContext)
    {
      if ((paramBoolean2) || (paramBoolean3))
        localContext = themifyContext(localContext, paramAttributeSet, paramBoolean2, paramBoolean3);
      int i = -1;
      switch (paramString.hashCode())
      {
      default:
      case 1666676343:
      case -339785223:
      case 1601505219:
      case 776382189:
      case -1455429095:
      case 1413872058:
      case -1346021293:
      case -1946472170:
      case 2001146706:
      case -938935918:
      }
      while (true)
        switch (i)
        {
        default:
          if (paramContext != localContext)
          {
            return createViewFromTag(localContext, paramString, paramAttributeSet);
            if (!paramString.equals("EditText"))
              continue;
            i = 0;
            continue;
            if (!paramString.equals("Spinner"))
              continue;
            i = 1;
            continue;
            if (!paramString.equals("CheckBox"))
              continue;
            i = 2;
            continue;
            if (!paramString.equals("RadioButton"))
              continue;
            i = 3;
            continue;
            if (!paramString.equals("CheckedTextView"))
              continue;
            i = 4;
            continue;
            if (!paramString.equals("AutoCompleteTextView"))
              continue;
            i = 5;
            continue;
            if (!paramString.equals("MultiAutoCompleteTextView"))
              continue;
            i = 6;
            continue;
            if (!paramString.equals("RatingBar"))
              continue;
            i = 7;
            continue;
            if (!paramString.equals("Button"))
              continue;
            i = 8;
            continue;
            if (!paramString.equals("TextView"))
              continue;
            i = 9;
          }
          break;
        case 0:
          return new AppCompatEditText(localContext, paramAttributeSet);
        case 1:
          return new AppCompatSpinner(localContext, paramAttributeSet);
        case 2:
          return new AppCompatCheckBox(localContext, paramAttributeSet);
        case 3:
          return new AppCompatRadioButton(localContext, paramAttributeSet);
        case 4:
          return new AppCompatCheckedTextView(localContext, paramAttributeSet);
        case 5:
          return new AppCompatAutoCompleteTextView(localContext, paramAttributeSet);
        case 6:
          return new AppCompatMultiAutoCompleteTextView(localContext, paramAttributeSet);
        case 7:
          return new AppCompatRatingBar(localContext, paramAttributeSet);
        case 8:
          return new AppCompatButton(localContext, paramAttributeSet);
        case 9:
          return new AppCompatTextView(localContext, paramAttributeSet);
        }
      return null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.app.AppCompatViewInflater
 * JD-Core Version:    0.6.0
 */