package android.support.v4.media;

import android.view.KeyEvent;

class TransportMediator$1
  implements TransportMediatorCallback
{
  public long getPlaybackPosition()
  {
    return this.this$0.mCallbacks.onGetCurrentPosition();
  }

  public void handleAudioFocusChange(int paramInt)
  {
    this.this$0.mCallbacks.onAudioFocusChange(paramInt);
  }

  public void handleKey(KeyEvent paramKeyEvent)
  {
    paramKeyEvent.dispatch(this.this$0.mKeyEventCallback);
  }

  public void playbackPositionUpdate(long paramLong)
  {
    this.this$0.mCallbacks.onSeekTo(paramLong);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v4.media.TransportMediator.1
 * JD-Core Version:    0.6.0
 */