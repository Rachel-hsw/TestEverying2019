package org.android.agoo.service;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface ElectionReceiverService extends IInterface
{
  public abstract boolean sendElectionResult(Intent paramIntent)
    throws RemoteException;

  public static abstract class Stub extends Binder
    implements ElectionReceiverService
  {
    private static final String DESCRIPTOR = "org.android.agoo.service.ElectionReceiverService";
    static final int TRANSACTION_sendElectionResult = 1;

    public Stub()
    {
      attachInterface(this, "org.android.agoo.service.ElectionReceiverService");
    }

    public static ElectionReceiverService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("org.android.agoo.service.ElectionReceiverService");
      if ((localIInterface != null) && ((localIInterface instanceof ElectionReceiverService)))
        return (ElectionReceiverService)localIInterface;
      return new a(paramIBinder);
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default:
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
        paramParcel2.writeString("org.android.agoo.service.ElectionReceiverService");
        return true;
      case 1:
      }
      paramParcel1.enforceInterface("org.android.agoo.service.ElectionReceiverService");
      Intent localIntent;
      if (paramParcel1.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
        boolean bool = sendElectionResult(localIntent);
        paramParcel2.writeNoException();
        if (!bool)
          break label107;
      }
      label107: for (int i = 1; ; i = 0)
      {
        paramParcel2.writeInt(i);
        return true;
        localIntent = null;
        break;
      }
    }

    static class a
      implements ElectionReceiverService
    {
      private IBinder a;

      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }

      public String a()
      {
        return "org.android.agoo.service.ElectionReceiverService";
      }

      public IBinder asBinder()
      {
        return this.a;
      }

      public boolean sendElectionResult(Intent paramIntent)
        throws RemoteException
      {
        int i = 1;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        while (true)
        {
          try
          {
            localParcel1.writeInterfaceToken("org.android.agoo.service.ElectionReceiverService");
            if (paramIntent == null)
              continue;
            localParcel1.writeInt(1);
            paramIntent.writeToParcel(localParcel1, 0);
            this.a.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            int j = localParcel2.readInt();
            if (j != 0)
            {
              return i;
              localParcel1.writeInt(0);
              continue;
            }
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          i = 0;
        }
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.service.ElectionReceiverService
 * JD-Core Version:    0.6.0
 */