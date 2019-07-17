package com.b.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface a extends IInterface
{
  public abstract String a()
    throws RemoteException;

  public abstract String b()
    throws RemoteException;

  public static abstract class a extends Binder
    implements a
  {
    static final int a = 1;
    static final int b = 2;
    private static final String c = "com.sina.sso.RemoteSSO";

    public a()
    {
      attachInterface(this, "com.sina.sso.RemoteSSO");
    }

    public static a a(IBinder paramIBinder)
    {
      if (paramIBinder == null)
        return null;
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.sina.sso.RemoteSSO");
      if ((localIInterface != null) && ((localIInterface instanceof a)))
        return (a)localIInterface;
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
        paramParcel2.writeString("com.sina.sso.RemoteSSO");
        return true;
      case 1:
        paramParcel1.enforceInterface("com.sina.sso.RemoteSSO");
        String str2 = a();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str2);
        return true;
      case 2:
      }
      paramParcel1.enforceInterface("com.sina.sso.RemoteSSO");
      String str1 = b();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str1);
      return true;
    }

    private static class a
      implements a
    {
      private IBinder a;

      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }

      public String a()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.sina.sso.RemoteSSO");
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public IBinder asBinder()
      {
        return this.a;
      }

      public String b()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.sina.sso.RemoteSSO");
          this.a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        throw localObject;
      }

      public String c()
      {
        return "com.sina.sso.RemoteSSO";
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.b.a.a
 * JD-Core Version:    0.6.0
 */