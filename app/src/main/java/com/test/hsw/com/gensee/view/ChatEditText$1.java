package com.gensee.view;

import android.text.InputFilter;
import android.text.Spanned;
import com.gensee.chat.gif.SpanResource;

class ChatEditText$1
  implements InputFilter
{
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt1 = SpanResource.getAvatarCount(paramSpanned.toString());
    int i = paramSpanned.toString().length() - arrayOfInt1[1] + arrayOfInt1[0];
    int[] arrayOfInt2 = SpanResource.getAvatarCount(paramCharSequence.toString());
    int j = paramCharSequence.toString().length() - arrayOfInt2[1] + arrayOfInt2[0];
    int k = arrayOfInt1[0] + arrayOfInt2[0];
    int m = i + j;
    if ((k > 20) || (m > 512))
      paramCharSequence = "";
    return paramCharSequence;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.ChatEditText.1
 * JD-Core Version:    0.6.0
 */