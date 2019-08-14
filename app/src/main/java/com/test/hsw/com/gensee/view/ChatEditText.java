package com.gensee.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.EditText;
import com.gensee.chat.gif.SpanResource;

public class ChatEditText extends EditText
{
  public ChatEditText(Context paramContext)
  {
    super(paramContext);
    init();
  }

  public ChatEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }

  public ChatEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }

  private void init()
  {
    InputFilter[] arrayOfInputFilter = new InputFilter[1];
    arrayOfInputFilter[0] = new ChatEditText.1(this);
    setFilters(arrayOfInputFilter);
  }

  public String getChatText()
  {
    String str = getText().toString().trim();
    if ("".equals(str))
      return "";
    return SpanResource.convertToSendText(str);
  }

  public String getRichText()
  {
    String str = getText().toString().trim();
    if ("".equals(str))
      return "";
    return SpanResource.convertToSendRichText(str);
  }

  public void insertAvatar(String paramString, int paramInt)
  {
    getText().insert(getSelectionStart(), SpanResource.convetToSpan(paramString.toString(), getContext()));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.ChatEditText
 * JD-Core Version:    0.6.0
 */