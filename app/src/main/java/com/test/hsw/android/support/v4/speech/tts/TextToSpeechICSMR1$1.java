package android.support.v4.speech.tts;

import android.speech.tts.UtteranceProgressListener;

final class TextToSpeechICSMR1$1 extends UtteranceProgressListener
{
  public void onDone(String paramString)
  {
    this.val$listener.onDone(paramString);
  }

  public void onError(String paramString)
  {
    this.val$listener.onError(paramString);
  }

  public void onStart(String paramString)
  {
    this.val$listener.onStart(paramString);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v4.speech.tts.TextToSpeechICSMR1.1
 * JD-Core Version:    0.6.0
 */