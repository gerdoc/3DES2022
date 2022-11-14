package gutierrez.galan.german.mydes;

import androidx.appcompat.app.AppCompatActivity;
import gutierrez.galan.german.mydes.des.MyDesUtil;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    public static final String TAG = "GERDOC";
    public static final String KEY = "+4xij6jQRSBdCymMxweza/uMYo+o0EUg";
    private String testClaro = "Hola mundo";
    private String testDesCifrado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main );
        String testCifrado = null;
        MyDesUtil myDesUtil = null;

        myDesUtil = new MyDesUtil( );
        if( isNotNullAndNotEmpty( KEY ) )
        {
            myDesUtil.addStringKeyBase64( KEY );
        }
        if( !isNotNullAndNotEmpty( testClaro ) )
        {
            return;
        }
        Log.i( TAG , testClaro);

        /*testCifrado = myDesUtil.cifrar( testClaro );
        if( !isNotNullAndNotEmpty( testCifrado ) )
        {
            return;
        }
        Log.i( TAG , testCifrado );
         */
        testCifrado = "KdSqSsH+W2gk1j361x9IlQ==";

        testDesCifrado = myDesUtil.desCifrar( testCifrado );
        if( !isNotNullAndNotEmpty( testDesCifrado ) )
        {
            return;
        }
        Log.i( TAG, testDesCifrado );

        Log.i( TAG , myDesUtil.toStringSecreteKey( ) );
    }

    public boolean isNotNullAndNotEmpty( String aux )
    {
        return aux != null && aux.length() > 0;
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        if( testClaro.equals(testDesCifrado ) )
        {
            Toast.makeText( getBaseContext() , "Son iguales" , Toast.LENGTH_LONG ).show( );
        }
        else
        {
            Toast.makeText( getBaseContext() , "Son diferentes" , Toast.LENGTH_LONG ).show( );
        }
    }
}