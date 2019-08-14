package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.VolumeProviderCompat.Callback;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaSessionCompat
{
  public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
  public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
  private final ArrayList<OnActiveChangeListener> mActiveListeners = new ArrayList();
  private final MediaControllerCompat mController;
  private final MediaSessionImpl mImpl;

  private MediaSessionCompat(Context paramContext, MediaSessionImpl paramMediaSessionImpl)
  {
    this.mImpl = paramMediaSessionImpl;
    this.mController = new MediaControllerCompat(paramContext, this);
  }

  public MediaSessionCompat(Context paramContext, String paramString, ComponentName paramComponentName, PendingIntent paramPendingIntent)
  {
    if (paramContext == null)
      throw new IllegalArgumentException("context must not be null");
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("tag must not be null or empty");
    if ((paramComponentName != null) && (paramPendingIntent == null))
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_BUTTON");
      localIntent.setComponent(paramComponentName);
      paramPendingIntent = PendingIntent.getBroadcast(paramContext, 0, localIntent, 0);
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.mImpl = new MediaSessionImplApi21(paramContext, paramString);
      this.mImpl.setMediaButtonReceiver(paramPendingIntent);
    }
    while (true)
    {
      this.mController = new MediaControllerCompat(paramContext, this);
      return;
      this.mImpl = new MediaSessionImplBase(paramContext, paramString, paramComponentName, paramPendingIntent);
    }
  }

  public static MediaSessionCompat obtain(Context paramContext, Object paramObject)
  {
    return new MediaSessionCompat(paramContext, new MediaSessionImplApi21(paramObject));
  }

  public void addOnActiveChangeListener(OnActiveChangeListener paramOnActiveChangeListener)
  {
    if (paramOnActiveChangeListener == null)
      throw new IllegalArgumentException("Listener may not be null");
    this.mActiveListeners.add(paramOnActiveChangeListener);
  }

  public MediaControllerCompat getController()
  {
    return this.mController;
  }

  public Object getMediaSession()
  {
    return this.mImpl.getMediaSession();
  }

  public Object getRemoteControlClient()
  {
    return this.mImpl.getRemoteControlClient();
  }

  public Token getSessionToken()
  {
    return this.mImpl.getSessionToken();
  }

  public boolean isActive()
  {
    return this.mImpl.isActive();
  }

  public void release()
  {
    this.mImpl.release();
  }

  public void removeOnActiveChangeListener(OnActiveChangeListener paramOnActiveChangeListener)
  {
    if (paramOnActiveChangeListener == null)
      throw new IllegalArgumentException("Listener may not be null");
    this.mActiveListeners.remove(paramOnActiveChangeListener);
  }

  public void sendSessionEvent(String paramString, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("event cannot be null or empty");
    this.mImpl.sendSessionEvent(paramString, paramBundle);
  }

  public void setActive(boolean paramBoolean)
  {
    this.mImpl.setActive(paramBoolean);
    Iterator localIterator = this.mActiveListeners.iterator();
    while (localIterator.hasNext())
      ((OnActiveChangeListener)localIterator.next()).onActiveChanged();
  }

  public void setCallback(Callback paramCallback)
  {
    setCallback(paramCallback, null);
  }

  public void setCallback(Callback paramCallback, Handler paramHandler)
  {
    MediaSessionImpl localMediaSessionImpl = this.mImpl;
    if (paramHandler != null);
    while (true)
    {
      localMediaSessionImpl.setCallback(paramCallback, paramHandler);
      return;
      paramHandler = new Handler();
    }
  }

  public void setExtras(Bundle paramBundle)
  {
    this.mImpl.setExtras(paramBundle);
  }

  public void setFlags(int paramInt)
  {
    this.mImpl.setFlags(paramInt);
  }

  public void setMediaButtonReceiver(PendingIntent paramPendingIntent)
  {
    this.mImpl.setMediaButtonReceiver(paramPendingIntent);
  }

  public void setMetadata(MediaMetadataCompat paramMediaMetadataCompat)
  {
    this.mImpl.setMetadata(paramMediaMetadataCompat);
  }

  public void setPlaybackState(PlaybackStateCompat paramPlaybackStateCompat)
  {
    this.mImpl.setPlaybackState(paramPlaybackStateCompat);
  }

  public void setPlaybackToLocal(int paramInt)
  {
    this.mImpl.setPlaybackToLocal(paramInt);
  }

  public void setPlaybackToRemote(VolumeProviderCompat paramVolumeProviderCompat)
  {
    if (paramVolumeProviderCompat == null)
      throw new IllegalArgumentException("volumeProvider may not be null!");
    this.mImpl.setPlaybackToRemote(paramVolumeProviderCompat);
  }

  public void setQueue(List<QueueItem> paramList)
  {
    this.mImpl.setQueue(paramList);
  }

  public void setQueueTitle(CharSequence paramCharSequence)
  {
    this.mImpl.setQueueTitle(paramCharSequence);
  }

  public void setRatingType(int paramInt)
  {
    this.mImpl.setRatingType(paramInt);
  }

  public void setSessionActivity(PendingIntent paramPendingIntent)
  {
    this.mImpl.setSessionActivity(paramPendingIntent);
  }

  public static abstract class Callback
  {
    final Object mCallbackObj;

    public Callback()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.mCallbackObj = MediaSessionCompatApi21.createCallback(new StubApi21(null));
        return;
      }
      this.mCallbackObj = null;
    }

    public void onCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
    {
    }

    public void onCustomAction(String paramString, Bundle paramBundle)
    {
    }

    public void onFastForward()
    {
    }

    public boolean onMediaButtonEvent(Intent paramIntent)
    {
      return false;
    }

    public void onPause()
    {
    }

    public void onPlay()
    {
    }

    public void onPlayFromMediaId(String paramString, Bundle paramBundle)
    {
    }

    public void onPlayFromSearch(String paramString, Bundle paramBundle)
    {
    }

    public void onRewind()
    {
    }

    public void onSeekTo(long paramLong)
    {
    }

    public void onSetRating(RatingCompat paramRatingCompat)
    {
    }

    public void onSkipToNext()
    {
    }

    public void onSkipToPrevious()
    {
    }

    public void onSkipToQueueItem(long paramLong)
    {
    }

    public void onStop()
    {
    }

    private class StubApi21
      implements MediaSessionCompatApi21.Callback
    {
      private StubApi21()
      {
      }

      public void onCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
      {
        MediaSessionCompat.Callback.this.onCommand(paramString, paramBundle, paramResultReceiver);
      }

      public void onCustomAction(String paramString, Bundle paramBundle)
      {
        MediaSessionCompat.Callback.this.onCustomAction(paramString, paramBundle);
      }

      public void onFastForward()
      {
        MediaSessionCompat.Callback.this.onFastForward();
      }

      public boolean onMediaButtonEvent(Intent paramIntent)
      {
        return MediaSessionCompat.Callback.this.onMediaButtonEvent(paramIntent);
      }

      public void onPause()
      {
        MediaSessionCompat.Callback.this.onPause();
      }

      public void onPlay()
      {
        MediaSessionCompat.Callback.this.onPlay();
      }

      public void onPlayFromMediaId(String paramString, Bundle paramBundle)
      {
        MediaSessionCompat.Callback.this.onPlayFromMediaId(paramString, paramBundle);
      }

      public void onPlayFromSearch(String paramString, Bundle paramBundle)
      {
        MediaSessionCompat.Callback.this.onPlayFromSearch(paramString, paramBundle);
      }

      public void onRewind()
      {
        MediaSessionCompat.Callback.this.onRewind();
      }

      public void onSeekTo(long paramLong)
      {
        MediaSessionCompat.Callback.this.onSeekTo(paramLong);
      }

      public void onSetRating(Object paramObject)
      {
        MediaSessionCompat.Callback.this.onSetRating(RatingCompat.fromRating(paramObject));
      }

      public void onSkipToNext()
      {
        MediaSessionCompat.Callback.this.onSkipToNext();
      }

      public void onSkipToPrevious()
      {
        MediaSessionCompat.Callback.this.onSkipToPrevious();
      }

      public void onSkipToQueueItem(long paramLong)
      {
        MediaSessionCompat.Callback.this.onSkipToQueueItem(paramLong);
      }

      public void onStop()
      {
        MediaSessionCompat.Callback.this.onStop();
      }
    }
  }

  static abstract interface MediaSessionImpl
  {
    public abstract Object getMediaSession();

    public abstract Object getRemoteControlClient();

    public abstract MediaSessionCompat.Token getSessionToken();

    public abstract boolean isActive();

    public abstract void release();

    public abstract void sendSessionEvent(String paramString, Bundle paramBundle);

    public abstract void setActive(boolean paramBoolean);

    public abstract void setCallback(MediaSessionCompat.Callback paramCallback, Handler paramHandler);

    public abstract void setExtras(Bundle paramBundle);

    public abstract void setFlags(int paramInt);

    public abstract void setMediaButtonReceiver(PendingIntent paramPendingIntent);

    public abstract void setMetadata(MediaMetadataCompat paramMediaMetadataCompat);

    public abstract void setPlaybackState(PlaybackStateCompat paramPlaybackStateCompat);

    public abstract void setPlaybackToLocal(int paramInt);

    public abstract void setPlaybackToRemote(VolumeProviderCompat paramVolumeProviderCompat);

    public abstract void setQueue(List<MediaSessionCompat.QueueItem> paramList);

    public abstract void setQueueTitle(CharSequence paramCharSequence);

    public abstract void setRatingType(int paramInt);

    public abstract void setSessionActivity(PendingIntent paramPendingIntent);
  }

  static class MediaSessionImplApi21
    implements MediaSessionCompat.MediaSessionImpl
  {
    private PendingIntent mMediaButtonIntent;
    private final Object mSessionObj;
    private final MediaSessionCompat.Token mToken;

    public MediaSessionImplApi21(Context paramContext, String paramString)
    {
      this.mSessionObj = MediaSessionCompatApi21.createSession(paramContext, paramString);
      this.mToken = new MediaSessionCompat.Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj));
    }

    public MediaSessionImplApi21(Object paramObject)
    {
      this.mSessionObj = MediaSessionCompatApi21.verifySession(paramObject);
      this.mToken = new MediaSessionCompat.Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj));
    }

    public Object getMediaSession()
    {
      return this.mSessionObj;
    }

    public Object getRemoteControlClient()
    {
      return null;
    }

    public MediaSessionCompat.Token getSessionToken()
    {
      return this.mToken;
    }

    public boolean isActive()
    {
      return MediaSessionCompatApi21.isActive(this.mSessionObj);
    }

    public void release()
    {
      MediaSessionCompatApi21.release(this.mSessionObj);
    }

    public void sendSessionEvent(String paramString, Bundle paramBundle)
    {
      MediaSessionCompatApi21.sendSessionEvent(this.mSessionObj, paramString, paramBundle);
    }

    public void setActive(boolean paramBoolean)
    {
      MediaSessionCompatApi21.setActive(this.mSessionObj, paramBoolean);
    }

    public void setCallback(MediaSessionCompat.Callback paramCallback, Handler paramHandler)
    {
      MediaSessionCompatApi21.setCallback(this.mSessionObj, paramCallback.mCallbackObj, paramHandler);
    }

    public void setExtras(Bundle paramBundle)
    {
      MediaSessionCompatApi21.setExtras(this.mSessionObj, paramBundle);
    }

    public void setFlags(int paramInt)
    {
      MediaSessionCompatApi21.setFlags(this.mSessionObj, paramInt);
    }

    public void setMediaButtonReceiver(PendingIntent paramPendingIntent)
    {
      this.mMediaButtonIntent = paramPendingIntent;
      MediaSessionCompatApi21.setMediaButtonReceiver(this.mSessionObj, paramPendingIntent);
    }

    public void setMetadata(MediaMetadataCompat paramMediaMetadataCompat)
    {
      MediaSessionCompatApi21.setMetadata(this.mSessionObj, paramMediaMetadataCompat.getMediaMetadata());
    }

    public void setPlaybackState(PlaybackStateCompat paramPlaybackStateCompat)
    {
      MediaSessionCompatApi21.setPlaybackState(this.mSessionObj, paramPlaybackStateCompat.getPlaybackState());
    }

    public void setPlaybackToLocal(int paramInt)
    {
      MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, paramInt);
    }

    public void setPlaybackToRemote(VolumeProviderCompat paramVolumeProviderCompat)
    {
      MediaSessionCompatApi21.setPlaybackToRemote(this.mSessionObj, paramVolumeProviderCompat.getVolumeProvider());
    }

    public void setQueue(List<MediaSessionCompat.QueueItem> paramList)
    {
      Object localObject = null;
      if (paramList != null)
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
          localArrayList.add(((MediaSessionCompat.QueueItem)localIterator.next()).getQueueItem());
        localObject = localArrayList;
      }
      MediaSessionCompatApi21.setQueue(this.mSessionObj, localObject);
    }

    public void setQueueTitle(CharSequence paramCharSequence)
    {
      MediaSessionCompatApi21.setQueueTitle(this.mSessionObj, paramCharSequence);
    }

    public void setRatingType(int paramInt)
    {
      if (Build.VERSION.SDK_INT < 22)
        return;
      MediaSessionCompatApi22.setRatingType(this.mSessionObj, paramInt);
    }

    public void setSessionActivity(PendingIntent paramPendingIntent)
    {
      MediaSessionCompatApi21.setSessionActivity(this.mSessionObj, paramPendingIntent);
    }
  }

  static class MediaSessionImplBase
    implements MediaSessionCompat.MediaSessionImpl
  {
    private final AudioManager mAudioManager;
    private MediaSessionCompat.Callback mCallback;
    private final ComponentName mComponentName;
    private final Context mContext;
    private final RemoteCallbackList<IMediaControllerCallback> mControllerCallbacks = new RemoteCallbackList();
    private boolean mDestroyed = false;
    private Bundle mExtras;
    private int mFlags;
    private final MessageHandler mHandler;
    private boolean mIsActive = false;
    private boolean mIsMbrRegistered = false;
    private boolean mIsRccRegistered = false;
    private int mLocalStream;
    private final Object mLock = new Object();
    private final PendingIntent mMediaButtonEventReceiver;
    private MediaMetadataCompat mMetadata;
    private final String mPackageName;
    private List<MediaSessionCompat.QueueItem> mQueue;
    private CharSequence mQueueTitle;
    private int mRatingType;
    private final Object mRccObj;
    private PendingIntent mSessionActivity;
    private PlaybackStateCompat mState;
    private final MediaSessionStub mStub;
    private final String mTag;
    private final MediaSessionCompat.Token mToken;
    private VolumeProviderCompat.Callback mVolumeCallback = new MediaSessionCompat.MediaSessionImplBase.1(this);
    private VolumeProviderCompat mVolumeProvider;
    private int mVolumeType;

    public MediaSessionImplBase(Context paramContext, String paramString, ComponentName paramComponentName, PendingIntent paramPendingIntent)
    {
      if (paramComponentName == null)
        throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
      this.mContext = paramContext;
      this.mPackageName = paramContext.getPackageName();
      this.mAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
      this.mTag = paramString;
      this.mComponentName = paramComponentName;
      this.mMediaButtonEventReceiver = paramPendingIntent;
      this.mStub = new MediaSessionStub();
      this.mToken = new MediaSessionCompat.Token(this.mStub);
      this.mHandler = new MessageHandler(Looper.myLooper());
      this.mRatingType = 0;
      this.mVolumeType = 1;
      this.mLocalStream = 3;
      if (Build.VERSION.SDK_INT >= 14)
      {
        this.mRccObj = MediaSessionCompatApi14.createRemoteControlClient(paramPendingIntent);
        return;
      }
      this.mRccObj = null;
    }

    private void adjustVolume(int paramInt1, int paramInt2)
    {
      if (this.mVolumeType == 2)
      {
        if (this.mVolumeProvider != null)
          this.mVolumeProvider.onAdjustVolume(paramInt1);
        return;
      }
      this.mAudioManager.adjustStreamVolume(paramInt1, this.mLocalStream, paramInt2);
    }

    private PlaybackStateCompat getStateWithUpdatedPosition()
    {
      long l1 = -1L;
      while (true)
      {
        long l4;
        synchronized (this.mLock)
        {
          PlaybackStateCompat localPlaybackStateCompat1 = this.mState;
          if ((this.mMetadata == null) || (!this.mMetadata.containsKey("android.media.metadata.DURATION")))
            continue;
          l1 = this.mMetadata.getLong("android.media.metadata.DURATION");
          if ((localPlaybackStateCompat1 == null) || ((localPlaybackStateCompat1.getState() != 3) && (localPlaybackStateCompat1.getState() != 4) && (localPlaybackStateCompat1.getState() != 5)))
            break label207;
          long l2 = localPlaybackStateCompat1.getLastPositionUpdateTime();
          long l3 = SystemClock.elapsedRealtime();
          if (l2 <= 0L)
            break label207;
          l4 = ()(localPlaybackStateCompat1.getPlaybackSpeed() * (float)(l3 - l2)) + localPlaybackStateCompat1.getPosition();
          if ((l1 >= 0L) && (l4 > l1))
          {
            PlaybackStateCompat.Builder localBuilder = new PlaybackStateCompat.Builder(localPlaybackStateCompat1);
            localBuilder.setState(localPlaybackStateCompat1.getState(), l1, localPlaybackStateCompat1.getPlaybackSpeed(), l3);
            localPlaybackStateCompat2 = localBuilder.build();
            if (localPlaybackStateCompat2 != null)
              continue;
            localPlaybackStateCompat2 = localPlaybackStateCompat1;
            return localPlaybackStateCompat2;
          }
        }
        if (l4 < 0L)
        {
          l1 = 0L;
          continue;
        }
        l1 = l4;
        continue;
        label207: PlaybackStateCompat localPlaybackStateCompat2 = null;
      }
    }

    private void sendEvent(String paramString, Bundle paramBundle)
    {
      int i = -1 + this.mControllerCallbacks.beginBroadcast();
      while (true)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0)
          localIMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
        try
        {
          localIMediaControllerCallback.onEvent(paramString, paramBundle);
          label36: i--;
          continue;
          this.mControllerCallbacks.finishBroadcast();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          break label36;
        }
      }
    }

    private void sendMetadata(MediaMetadataCompat paramMediaMetadataCompat)
    {
      int i = -1 + this.mControllerCallbacks.beginBroadcast();
      while (true)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0)
          localIMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
        try
        {
          localIMediaControllerCallback.onMetadataChanged(paramMediaMetadataCompat);
          label33: i--;
          continue;
          this.mControllerCallbacks.finishBroadcast();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          break label33;
        }
      }
    }

    private void sendQueue(List<MediaSessionCompat.QueueItem> paramList)
    {
      int i = -1 + this.mControllerCallbacks.beginBroadcast();
      while (true)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0)
          localIMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
        try
        {
          localIMediaControllerCallback.onQueueChanged(paramList);
          label33: i--;
          continue;
          this.mControllerCallbacks.finishBroadcast();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          break label33;
        }
      }
    }

    private void sendQueueTitle(CharSequence paramCharSequence)
    {
      int i = -1 + this.mControllerCallbacks.beginBroadcast();
      while (true)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0)
          localIMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
        try
        {
          localIMediaControllerCallback.onQueueTitleChanged(paramCharSequence);
          label33: i--;
          continue;
          this.mControllerCallbacks.finishBroadcast();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          break label33;
        }
      }
    }

    private void sendSessionDestroyed()
    {
      int i = -1 + this.mControllerCallbacks.beginBroadcast();
      while (true)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0)
          localIMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
        try
        {
          localIMediaControllerCallback.onSessionDestroyed();
          label32: i--;
          continue;
          this.mControllerCallbacks.finishBroadcast();
          this.mControllerCallbacks.kill();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          break label32;
        }
      }
    }

    private void sendState(PlaybackStateCompat paramPlaybackStateCompat)
    {
      int i = -1 + this.mControllerCallbacks.beginBroadcast();
      while (true)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0)
          localIMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
        try
        {
          localIMediaControllerCallback.onPlaybackStateChanged(paramPlaybackStateCompat);
          label33: i--;
          continue;
          this.mControllerCallbacks.finishBroadcast();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          break label33;
        }
      }
    }

    private void sendVolumeInfoChanged(ParcelableVolumeInfo paramParcelableVolumeInfo)
    {
      int i = -1 + this.mControllerCallbacks.beginBroadcast();
      while (true)
      {
        IMediaControllerCallback localIMediaControllerCallback;
        if (i >= 0)
          localIMediaControllerCallback = (IMediaControllerCallback)this.mControllerCallbacks.getBroadcastItem(i);
        try
        {
          localIMediaControllerCallback.onVolumeInfoChanged(paramParcelableVolumeInfo);
          label33: i--;
          continue;
          this.mControllerCallbacks.finishBroadcast();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          break label33;
        }
      }
    }

    private void setVolumeTo(int paramInt1, int paramInt2)
    {
      if (this.mVolumeType == 2)
      {
        if (this.mVolumeProvider != null)
          this.mVolumeProvider.onSetVolumeTo(paramInt1);
        return;
      }
      this.mAudioManager.setStreamVolume(this.mLocalStream, paramInt1, paramInt2);
    }

    private boolean update()
    {
      if (this.mIsActive)
      {
        if (Build.VERSION.SDK_INT >= 8)
        {
          if ((this.mIsMbrRegistered) || ((0x1 & this.mFlags) == 0))
            break label111;
          if (Build.VERSION.SDK_INT < 18)
            break label97;
          MediaSessionCompatApi18.registerMediaButtonEventReceiver(this.mContext, this.mMediaButtonEventReceiver);
          this.mIsMbrRegistered = true;
        }
        label97: label111: 
        do
        {
          if (Build.VERSION.SDK_INT < 14)
            break label256;
          if ((this.mIsRccRegistered) || ((0x2 & this.mFlags) == 0))
            break label168;
          MediaSessionCompatApi14.registerRemoteControlClient(this.mContext, this.mRccObj);
          this.mIsRccRegistered = true;
          return true;
          MediaSessionCompatApi8.registerMediaButtonEventReceiver(this.mContext, this.mComponentName);
          break;
        }
        while ((!this.mIsMbrRegistered) || ((0x1 & this.mFlags) != 0));
        if (Build.VERSION.SDK_INT >= 18)
          MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(this.mContext, this.mMediaButtonEventReceiver);
        while (true)
        {
          this.mIsMbrRegistered = false;
          break;
          MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(this.mContext, this.mComponentName);
        }
        label168: if ((this.mIsRccRegistered) && ((0x2 & this.mFlags) == 0))
        {
          MediaSessionCompatApi14.unregisterRemoteControlClient(this.mContext, this.mRccObj);
          this.mIsRccRegistered = false;
          return false;
        }
      }
      else if (this.mIsMbrRegistered)
      {
        if (Build.VERSION.SDK_INT < 18)
          break label258;
        MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(this.mContext, this.mMediaButtonEventReceiver);
      }
      while (true)
      {
        this.mIsMbrRegistered = false;
        if (this.mIsRccRegistered)
        {
          MediaSessionCompatApi14.unregisterRemoteControlClient(this.mContext, this.mRccObj);
          this.mIsRccRegistered = false;
        }
        label256: return false;
        label258: MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(this.mContext, this.mComponentName);
      }
    }

    public Object getMediaSession()
    {
      return null;
    }

    public Object getRemoteControlClient()
    {
      return this.mRccObj;
    }

    public MediaSessionCompat.Token getSessionToken()
    {
      return this.mToken;
    }

    public boolean isActive()
    {
      return this.mIsActive;
    }

    public void release()
    {
      this.mIsActive = false;
      this.mDestroyed = true;
      update();
      sendSessionDestroyed();
    }

    public void sendSessionEvent(String paramString, Bundle paramBundle)
    {
      sendEvent(paramString, paramBundle);
    }

    public void setActive(boolean paramBoolean)
    {
      if (paramBoolean == this.mIsActive);
      do
      {
        return;
        this.mIsActive = paramBoolean;
      }
      while (!update());
      setMetadata(this.mMetadata);
      setPlaybackState(this.mState);
    }

    public void setCallback(MediaSessionCompat.Callback paramCallback, Handler paramHandler)
    {
      if (paramCallback == this.mCallback)
        return;
      if ((paramCallback == null) || (Build.VERSION.SDK_INT < 18))
      {
        if (Build.VERSION.SDK_INT >= 18)
          MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(this.mRccObj, null);
        if (Build.VERSION.SDK_INT >= 19)
          MediaSessionCompatApi19.setOnMetadataUpdateListener(this.mRccObj, null);
      }
      while (true)
      {
        this.mCallback = paramCallback;
        return;
        if (paramHandler == null)
          new Handler();
        MediaSessionCompat.MediaSessionImplBase.2 local2 = new MediaSessionCompat.MediaSessionImplBase.2(this, paramCallback);
        if (Build.VERSION.SDK_INT >= 18)
        {
          Object localObject2 = MediaSessionCompatApi18.createPlaybackPositionUpdateListener(local2);
          MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(this.mRccObj, localObject2);
        }
        if (Build.VERSION.SDK_INT < 19)
          continue;
        Object localObject1 = MediaSessionCompatApi19.createMetadataUpdateListener(local2);
        MediaSessionCompatApi19.setOnMetadataUpdateListener(this.mRccObj, localObject1);
      }
    }

    public void setExtras(Bundle paramBundle)
    {
      this.mExtras = paramBundle;
    }

    public void setFlags(int paramInt)
    {
      synchronized (this.mLock)
      {
        this.mFlags = paramInt;
        update();
        return;
      }
    }

    public void setMediaButtonReceiver(PendingIntent paramPendingIntent)
    {
    }

    public void setMetadata(MediaMetadataCompat paramMediaMetadataCompat)
    {
      label82: 
      do
      {
        synchronized (this.mLock)
        {
          this.mMetadata = paramMediaMetadataCompat;
          sendMetadata(paramMediaMetadataCompat);
          if (!this.mIsActive)
            return;
        }
        if (Build.VERSION.SDK_INT < 19)
          continue;
        Object localObject4 = this.mRccObj;
        Bundle localBundle2 = null;
        long l;
        if (paramMediaMetadataCompat == null)
        {
          if (this.mState != null)
            break label82;
          l = 0L;
        }
        while (true)
        {
          MediaSessionCompatApi19.setMetadata(localObject4, localBundle2, l);
          return;
          localBundle2 = paramMediaMetadataCompat.getBundle();
          break;
          l = this.mState.getActions();
        }
      }
      while (Build.VERSION.SDK_INT < 14);
      Object localObject3 = this.mRccObj;
      Bundle localBundle1 = null;
      if (paramMediaMetadataCompat == null);
      while (true)
      {
        MediaSessionCompatApi14.setMetadata(localObject3, localBundle1);
        return;
        localBundle1 = paramMediaMetadataCompat.getBundle();
      }
    }

    public void setPlaybackState(PlaybackStateCompat paramPlaybackStateCompat)
    {
      do
      {
        while (true)
        {
          synchronized (this.mLock)
          {
            this.mState = paramPlaybackStateCompat;
            sendState(paramPlaybackStateCompat);
            if (!this.mIsActive)
              return;
          }
          if (paramPlaybackStateCompat != null)
            break;
          if (Build.VERSION.SDK_INT < 14)
            continue;
          MediaSessionCompatApi14.setState(this.mRccObj, 0);
          MediaSessionCompatApi14.setTransportControlFlags(this.mRccObj, 0L);
          return;
        }
        if (Build.VERSION.SDK_INT >= 18)
          MediaSessionCompatApi18.setState(this.mRccObj, paramPlaybackStateCompat.getState(), paramPlaybackStateCompat.getPosition(), paramPlaybackStateCompat.getPlaybackSpeed(), paramPlaybackStateCompat.getLastPositionUpdateTime());
        while (Build.VERSION.SDK_INT >= 19)
        {
          MediaSessionCompatApi19.setTransportControlFlags(this.mRccObj, paramPlaybackStateCompat.getActions());
          return;
          if (Build.VERSION.SDK_INT < 14)
            continue;
          MediaSessionCompatApi14.setState(this.mRccObj, paramPlaybackStateCompat.getState());
        }
        if (Build.VERSION.SDK_INT < 18)
          continue;
        MediaSessionCompatApi18.setTransportControlFlags(this.mRccObj, paramPlaybackStateCompat.getActions());
        return;
      }
      while (Build.VERSION.SDK_INT < 14);
      MediaSessionCompatApi14.setTransportControlFlags(this.mRccObj, paramPlaybackStateCompat.getActions());
    }

    public void setPlaybackToLocal(int paramInt)
    {
      if (this.mVolumeProvider != null)
        this.mVolumeProvider.setCallback(null);
      this.mVolumeType = 1;
      sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, 2, this.mAudioManager.getStreamMaxVolume(this.mLocalStream), this.mAudioManager.getStreamVolume(this.mLocalStream)));
    }

    public void setPlaybackToRemote(VolumeProviderCompat paramVolumeProviderCompat)
    {
      if (paramVolumeProviderCompat == null)
        throw new IllegalArgumentException("volumeProvider may not be null");
      if (this.mVolumeProvider != null)
        this.mVolumeProvider.setCallback(null);
      this.mVolumeType = 2;
      this.mVolumeProvider = paramVolumeProviderCompat;
      sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
      paramVolumeProviderCompat.setCallback(this.mVolumeCallback);
    }

    public void setQueue(List<MediaSessionCompat.QueueItem> paramList)
    {
      this.mQueue = paramList;
      sendQueue(paramList);
    }

    public void setQueueTitle(CharSequence paramCharSequence)
    {
      this.mQueueTitle = paramCharSequence;
      sendQueueTitle(paramCharSequence);
    }

    public void setRatingType(int paramInt)
    {
      this.mRatingType = paramInt;
    }

    public void setSessionActivity(PendingIntent paramPendingIntent)
    {
      synchronized (this.mLock)
      {
        this.mSessionActivity = paramPendingIntent;
        return;
      }
    }

    private static final class Command
    {
      public final String command;
      public final Bundle extras;
      public final ResultReceiver stub;

      public Command(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
      {
        this.command = paramString;
        this.extras = paramBundle;
        this.stub = paramResultReceiver;
      }
    }

    class MediaSessionStub extends IMediaSession.Stub
    {
      MediaSessionStub()
      {
      }

      public void adjustVolume(int paramInt1, int paramInt2, String paramString)
      {
        MediaSessionCompat.MediaSessionImplBase.this.adjustVolume(paramInt1, paramInt2);
      }

      public void fastForward()
        throws RemoteException
      {
        MediaSessionCompat.MediaSessionImplBase.this.mHandler.post(9);
      }

      public Bundle getExtras()
      {
        synchronized (MediaSessionCompat.MediaSessionImplBase.this.mLock)
        {
          Bundle localBundle = MediaSessionCompat.MediaSessionImplBase.this.mExtras;
          return localBundle;
        }
      }

      public long getFlags()
      {
        synchronized (MediaSessionCompat.MediaSessionImplBase.this.mLock)
        {
          long l = MediaSessionCompat.MediaSessionImplBase.this.mFlags;
          return l;
        }
      }

      public PendingIntent getLaunchPendingIntent()
      {
        synchronized (MediaSessionCompat.MediaSessionImplBase.this.mLock)
        {
          PendingIntent localPendingIntent = MediaSessionCompat.MediaSessionImplBase.this.mSessionActivity;
          return localPendingIntent;
        }
      }

      public MediaMetadataCompat getMetadata()
      {
        return MediaSessionCompat.MediaSessionImplBase.this.mMetadata;
      }

      public String getPackageName()
      {
        return MediaSessionCompat.MediaSessionImplBase.this.mPackageName;
      }

      public PlaybackStateCompat getPlaybackState()
      {
        return MediaSessionCompat.MediaSessionImplBase.this.getStateWithUpdatedPosition();
      }

      public List<MediaSessionCompat.QueueItem> getQueue()
      {
        synchronized (MediaSessionCompat.MediaSessionImplBase.this.mLock)
        {
          List localList = MediaSessionCompat.MediaSessionImplBase.this.mQueue;
          return localList;
        }
      }

      public CharSequence getQueueTitle()
      {
        return MediaSessionCompat.MediaSessionImplBase.this.mQueueTitle;
      }

      public int getRatingType()
      {
        return MediaSessionCompat.MediaSessionImplBase.this.mRatingType;
      }

      public String getTag()
      {
        return MediaSessionCompat.MediaSessionImplBase.this.mTag;
      }

      public ParcelableVolumeInfo getVolumeAttributes()
      {
        int i = 2;
        synchronized (MediaSessionCompat.MediaSessionImplBase.this.mLock)
        {
          int j = MediaSessionCompat.MediaSessionImplBase.this.mVolumeType;
          int k = MediaSessionCompat.MediaSessionImplBase.this.mLocalStream;
          VolumeProviderCompat localVolumeProviderCompat = MediaSessionCompat.MediaSessionImplBase.this.mVolumeProvider;
          if (j == i)
          {
            i = localVolumeProviderCompat.getVolumeControl();
            m = localVolumeProviderCompat.getMaxVolume();
            n = localVolumeProviderCompat.getCurrentVolume();
            return new ParcelableVolumeInfo(j, k, i, m, n);
          }
          int m = MediaSessionCompat.MediaSessionImplBase.this.mAudioManager.getStreamMaxVolume(k);
          int n = MediaSessionCompat.MediaSessionImplBase.this.mAudioManager.getStreamVolume(k);
        }
      }

      public boolean isTransportControlEnabled()
      {
        return (0x2 & MediaSessionCompat.MediaSessionImplBase.this.mFlags) != 0;
      }

      public void next()
        throws RemoteException
      {
        MediaSessionCompat.MediaSessionImplBase.this.mHandler.post(7);
      }

      public void pause()
        throws RemoteException
      {
        MediaSessionCompat.MediaSessionImplBase.this.mHandler.post(5);
      }

      public void play()
        throws RemoteException
      {
        MediaSessionCompat.MediaSessionImplBase.this.mHandler.post(1);
      }

      public void playFromMediaId(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        MediaSessionCompat.MediaSessionImplBase.this.mHandler.post(2, paramString, paramBundle);
      }

      public void playFromSearch(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        MediaSessionCompat.MediaSessionImplBase.this.mHandler.post(3, paramString, paramBundle);
      }

      public void previous()
        throws RemoteException
      {
        MediaSessionCompat.MediaSessionImplBase.this.mHandler.post(8);
      }

      public void rate(RatingCompat paramRatingCompat)
        throws RemoteException
      {
        MediaSessionCompat.MediaSessionImplBase.this.mHandler.post(12, paramRatingCompat);
      }

      public void registerCallbackListener(IMediaControllerCallback paramIMediaControllerCallback)
      {
        if (MediaSessionCompat.MediaSessionImplBase.this.mDestroyed);
        try
        {
          paramIMediaControllerCallback.onSessionDestroyed();
          return;
          MediaSessionCompat.MediaSessionImplBase.this.mControllerCallbacks.register(paramIMediaControllerCallback);
          return;
        }
        catch (Exception localException)
        {
        }
      }

      public void rewind()
        throws RemoteException
      {
        MediaSessionCompat.MediaSessionImplBase.this.mHandler.post(10);
      }

      public void seekTo(long paramLong)
        throws RemoteException
      {
        MediaSessionCompat.MediaSessionImplBase.this.mHandler.post(11, Long.valueOf(paramLong));
      }

      public void sendCommand(String paramString, Bundle paramBundle, MediaSessionCompat.ResultReceiverWrapper paramResultReceiverWrapper)
      {
        MediaSessionCompat.MediaSessionImplBase.this.mHandler.post(15, new MediaSessionCompat.MediaSessionImplBase.Command(paramString, paramBundle, MediaSessionCompat.ResultReceiverWrapper.access$600(paramResultReceiverWrapper)));
      }

      public void sendCustomAction(String paramString, Bundle paramBundle)
        throws RemoteException
      {
        MediaSessionCompat.MediaSessionImplBase.this.mHandler.post(13, paramString, paramBundle);
      }

      public boolean sendMediaButton(KeyEvent paramKeyEvent)
      {
        if ((0x1 & MediaSessionCompat.MediaSessionImplBase.this.mFlags) != 0);
        for (int i = 1; ; i = 0)
        {
          if (i != 0)
            MediaSessionCompat.MediaSessionImplBase.this.mHandler.post(14, paramKeyEvent);
          return i;
        }
      }

      public void setVolumeTo(int paramInt1, int paramInt2, String paramString)
      {
        MediaSessionCompat.MediaSessionImplBase.this.setVolumeTo(paramInt1, paramInt2);
      }

      public void skipToQueueItem(long paramLong)
      {
        MediaSessionCompat.MediaSessionImplBase.this.mHandler.post(4, Long.valueOf(paramLong));
      }

      public void stop()
        throws RemoteException
      {
        MediaSessionCompat.MediaSessionImplBase.this.mHandler.post(6);
      }

      public void unregisterCallbackListener(IMediaControllerCallback paramIMediaControllerCallback)
      {
        MediaSessionCompat.MediaSessionImplBase.this.mControllerCallbacks.unregister(paramIMediaControllerCallback);
      }
    }

    private class MessageHandler extends Handler
    {
      private static final int MSG_ADJUST_VOLUME = 16;
      private static final int MSG_COMMAND = 15;
      private static final int MSG_CUSTOM_ACTION = 13;
      private static final int MSG_FAST_FORWARD = 9;
      private static final int MSG_MEDIA_BUTTON = 14;
      private static final int MSG_NEXT = 7;
      private static final int MSG_PAUSE = 5;
      private static final int MSG_PLAY = 1;
      private static final int MSG_PLAY_MEDIA_ID = 2;
      private static final int MSG_PLAY_SEARCH = 3;
      private static final int MSG_PREVIOUS = 8;
      private static final int MSG_RATE = 12;
      private static final int MSG_REWIND = 10;
      private static final int MSG_SEEK_TO = 11;
      private static final int MSG_SET_VOLUME = 17;
      private static final int MSG_SKIP_TO_ITEM = 4;
      private static final int MSG_STOP = 6;

      public MessageHandler(Looper arg2)
      {
        super();
      }

      public void handleMessage(Message paramMessage)
      {
        if (MediaSessionCompat.MediaSessionImplBase.this.mCallback == null)
          return;
        switch (paramMessage.what)
        {
        default:
          return;
        case 1:
          MediaSessionCompat.MediaSessionImplBase.this.mCallback.onPlay();
          return;
        case 2:
          MediaSessionCompat.MediaSessionImplBase.this.mCallback.onPlayFromMediaId((String)paramMessage.obj, paramMessage.getData());
          return;
        case 3:
          MediaSessionCompat.MediaSessionImplBase.this.mCallback.onPlayFromSearch((String)paramMessage.obj, paramMessage.getData());
          return;
        case 4:
          MediaSessionCompat.MediaSessionImplBase.this.mCallback.onSkipToQueueItem(((Long)paramMessage.obj).longValue());
          return;
        case 5:
          MediaSessionCompat.MediaSessionImplBase.this.mCallback.onPause();
          return;
        case 6:
          MediaSessionCompat.MediaSessionImplBase.this.mCallback.onStop();
          return;
        case 7:
          MediaSessionCompat.MediaSessionImplBase.this.mCallback.onSkipToNext();
          return;
        case 8:
          MediaSessionCompat.MediaSessionImplBase.this.mCallback.onSkipToPrevious();
          return;
        case 9:
          MediaSessionCompat.MediaSessionImplBase.this.mCallback.onFastForward();
          return;
        case 10:
          MediaSessionCompat.MediaSessionImplBase.this.mCallback.onRewind();
          return;
        case 11:
          MediaSessionCompat.MediaSessionImplBase.this.mCallback.onSeekTo(((Long)paramMessage.obj).longValue());
          return;
        case 12:
          MediaSessionCompat.MediaSessionImplBase.this.mCallback.onSetRating((RatingCompat)paramMessage.obj);
          return;
        case 13:
          MediaSessionCompat.MediaSessionImplBase.this.mCallback.onCustomAction((String)paramMessage.obj, paramMessage.getData());
          return;
        case 14:
          KeyEvent localKeyEvent = (KeyEvent)paramMessage.obj;
          Intent localIntent = new Intent("android.intent.action.MEDIA_BUTTON");
          localIntent.putExtra("android.intent.extra.KEY_EVENT", localKeyEvent);
          MediaSessionCompat.MediaSessionImplBase.this.mCallback.onMediaButtonEvent(localIntent);
          return;
        case 15:
          MediaSessionCompat.MediaSessionImplBase.Command localCommand = (MediaSessionCompat.MediaSessionImplBase.Command)paramMessage.obj;
          MediaSessionCompat.MediaSessionImplBase.this.mCallback.onCommand(localCommand.command, localCommand.extras, localCommand.stub);
          return;
        case 16:
          MediaSessionCompat.MediaSessionImplBase.this.adjustVolume(((Integer)paramMessage.obj).intValue(), 0);
          return;
        case 17:
        }
        MediaSessionCompat.MediaSessionImplBase.this.setVolumeTo(((Integer)paramMessage.obj).intValue(), 0);
      }

      public void post(int paramInt)
      {
        post(paramInt, null);
      }

      public void post(int paramInt, Object paramObject)
      {
        obtainMessage(paramInt, paramObject).sendToTarget();
      }

      public void post(int paramInt1, Object paramObject, int paramInt2)
      {
        obtainMessage(paramInt1, paramInt2, 0, paramObject).sendToTarget();
      }

      public void post(int paramInt, Object paramObject, Bundle paramBundle)
      {
        Message localMessage = obtainMessage(paramInt, paramObject);
        localMessage.setData(paramBundle);
        localMessage.sendToTarget();
      }
    }
  }

  public static abstract interface OnActiveChangeListener
  {
    public abstract void onActiveChanged();
  }

  public static final class QueueItem
    implements Parcelable
  {
    public static final Parcelable.Creator<QueueItem> CREATOR = new MediaSessionCompat.QueueItem.1();
    public static final int UNKNOWN_ID = -1;
    private final MediaDescriptionCompat mDescription;
    private final long mId;
    private Object mItem;

    private QueueItem(Parcel paramParcel)
    {
      this.mDescription = ((MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel));
      this.mId = paramParcel.readLong();
    }

    public QueueItem(MediaDescriptionCompat paramMediaDescriptionCompat, long paramLong)
    {
      this(null, paramMediaDescriptionCompat, paramLong);
    }

    private QueueItem(Object paramObject, MediaDescriptionCompat paramMediaDescriptionCompat, long paramLong)
    {
      if (paramMediaDescriptionCompat == null)
        throw new IllegalArgumentException("Description cannot be null.");
      if (paramLong == -1L)
        throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
      this.mDescription = paramMediaDescriptionCompat;
      this.mId = paramLong;
      this.mItem = paramObject;
    }

    public static QueueItem obtain(Object paramObject)
    {
      return new QueueItem(paramObject, MediaDescriptionCompat.fromMediaDescription(MediaSessionCompatApi21.QueueItem.getDescription(paramObject)), MediaSessionCompatApi21.QueueItem.getQueueId(paramObject));
    }

    public int describeContents()
    {
      return 0;
    }

    public MediaDescriptionCompat getDescription()
    {
      return this.mDescription;
    }

    public long getQueueId()
    {
      return this.mId;
    }

    public Object getQueueItem()
    {
      if ((this.mItem != null) || (Build.VERSION.SDK_INT < 21))
        return this.mItem;
      this.mItem = MediaSessionCompatApi21.QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
      return this.mItem;
    }

    public String toString()
    {
      return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      this.mDescription.writeToParcel(paramParcel, paramInt);
      paramParcel.writeLong(this.mId);
    }
  }

  static final class ResultReceiverWrapper
    implements Parcelable
  {
    public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new MediaSessionCompat.ResultReceiverWrapper.1();
    private ResultReceiver mResultReceiver;

    ResultReceiverWrapper(Parcel paramParcel)
    {
      this.mResultReceiver = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    }

    public ResultReceiverWrapper(ResultReceiver paramResultReceiver)
    {
      this.mResultReceiver = paramResultReceiver;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      this.mResultReceiver.writeToParcel(paramParcel, paramInt);
    }
  }

  public static final class Token
    implements Parcelable
  {
    public static final Parcelable.Creator<Token> CREATOR = new MediaSessionCompat.Token.1();
    private final Object mInner;

    Token(Object paramObject)
    {
      this.mInner = paramObject;
    }

    public static Token fromToken(Object paramObject)
    {
      if ((paramObject == null) || (Build.VERSION.SDK_INT < 21))
        return null;
      return new Token(MediaSessionCompatApi21.verifyToken(paramObject));
    }

    public int describeContents()
    {
      return 0;
    }

    public Object getToken()
    {
      return this.mInner;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramParcel.writeParcelable((Parcelable)this.mInner, paramInt);
        return;
      }
      paramParcel.writeStrongBinder((IBinder)this.mInner);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat
 * JD-Core Version:    0.6.0
 */