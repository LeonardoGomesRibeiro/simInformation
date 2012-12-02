package com.simInformation.siminformation;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.ads.*;

public class SimCardInformationActivity extends Activity {

	private AdView adView, adView1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim_card_information);
   
        adView = new AdView(this, AdSize.BANNER, "a150bb5f148b3e6");
        adView1 = new AdView(this, AdSize.SMART_BANNER, "a150bb5f148b3e6");
        
        RelativeLayout r = (RelativeLayout) findViewById(R.id.relativeLayout);
        
        r.addView(adView);
        r.addView(adView1);
        
        adView.loadAd(new AdRequest());
        adView1.loadAd(new AdRequest());
        
        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        
        String deviceId = tm.getDeviceId();
        
        String deviceSoftwareVersion = tm.getDeviceSoftwareVersion();
        String networkOperator = tm.getNetworkOperator();
        String networkOperatorName = tm.getNetworkOperatorName();
        String serialNumber = tm.getSimSerialNumber();
        String phoneNumber = tm.getLine1Number();
        String simCountry = tm.getSimCountryIso();
        
        TextView deviceIdValue = (TextView)findViewById(R.id.deviceId);
        deviceIdValue.setText(deviceIdValue.getText().toString() + "  " + deviceId);
        
        TextView serialNumberValue = (TextView) findViewById(R.id.serialNumber);
        serialNumberValue.setText(serialNumberValue.getText().toString() + "  " + serialNumber);
        
        TextView networkOperatorValue = (TextView)findViewById(R.id.networkOperator);
        networkOperatorValue.setText(networkOperatorValue.getText().toString() + "  " + networkOperator);
        
        TextView networkOperatorNameValue = (TextView)findViewById(R.id.networkOperatorName);
        networkOperatorNameValue.setText(networkOperatorNameValue.getText().toString() + "  " + networkOperatorName);
        
        TextView deviceSoftwareVersionValue = (TextView)findViewById(R.id.deviceSWVervion);
        deviceSoftwareVersionValue.setText(deviceSoftwareVersionValue.getText().toString() + "  " + deviceSoftwareVersion);
        
        TextView phoneNumberValue = (TextView)findViewById(R.id.phoneNumber);
        phoneNumberValue.setText(phoneNumberValue.getText().toString() + "  " +  phoneNumber);
        
        TextView simCountryValue = (TextView)findViewById(R.id.simCountry);
        simCountryValue.setText(simCountryValue.getText().toString() + "  " +  simCountry);
        
    }

    @Override
    public void onDestroy() {
      if (adView != null) {
        adView.destroy();
      }
      if (adView1 != null) {
    	  adView1.destroy();
      }
      super.onDestroy();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_sim_card_information, menu);
        return true;
    }
    
}
