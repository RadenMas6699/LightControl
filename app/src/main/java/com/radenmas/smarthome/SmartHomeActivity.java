package com.radenmas.smarthome;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.IOException;
import java.util.UUID;

public class SmartHomeActivity extends AppCompatActivity {

    TextView tvDescLamp1, tvDescLamp2, tvDescLamp3, tvDescLamp4, tvDescLamp5, tvDescLamp6, tvDescLamp7, tvDescLamp8;
    ImageView imgLamp1, imgLamp2, imgLamp3, imgLamp4, imgLamp5, imgLamp6, imgLamp7, imgLamp8;

    String address = null;
    private ProgressDialog progress;
    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    private boolean isBtConnected = false;
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_home);

        initView();

        Intent newint = getIntent();
        address = newint.getStringExtra(MainActivity.EXTRA_ADDRESS);

        new ConnectBT().execute();

    }

    private void initView() {
        tvDescLamp1 = findViewById(R.id.tvDescLamp1);
        tvDescLamp2 = findViewById(R.id.tvDescLamp2);
        tvDescLamp3 = findViewById(R.id.tvDescLamp3);
        tvDescLamp4 = findViewById(R.id.tvDescLamp4);
        tvDescLamp5 = findViewById(R.id.tvDescLamp5);
        tvDescLamp6 = findViewById(R.id.tvDescLamp6);
        tvDescLamp7 = findViewById(R.id.tvDescLamp7);
        tvDescLamp8 = findViewById(R.id.tvDescLamp8);

        imgLamp1 = findViewById(R.id.imgLamp1);
        imgLamp2 = findViewById(R.id.imgLamp2);
        imgLamp3 = findViewById(R.id.imgLamp3);
        imgLamp4 = findViewById(R.id.imgLamp4);
        imgLamp5 = findViewById(R.id.imgLamp5);
        imgLamp6 = findViewById(R.id.imgLamp6);
        imgLamp7 = findViewById(R.id.imgLamp7);
        imgLamp8 = findViewById(R.id.imgLamp8);
    }

    private void msg(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }

    @SuppressLint("StaticFieldLeak")
    private class ConnectBT extends AsyncTask<Void, Void, Void> {
        private boolean ConnectSuccess = true;

        @Override
        protected void onPreExecute() {
            progress = ProgressDialog.show(SmartHomeActivity.this, "Connecting...", "Please wait!!!");
        }

        @Override
        protected Void doInBackground(Void... devices) {
            try {
                if (btSocket == null || !isBtConnected) {
                    myBluetooth = BluetoothAdapter.getDefaultAdapter();
                    BluetoothDevice dispositivo = myBluetooth.getRemoteDevice(address);
                    btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    btSocket.connect();
                }
            } catch (IOException e) {
                ConnectSuccess = false;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            if (!ConnectSuccess) {
                msg("Connection Failed. Is it a SPP Bluetooth? Try again.");
                finish();
            } else {
                msg("Connected.");
                isBtConnected = true;
            }
            progress.dismiss();
        }
    }


    public void BtnLamp1(View view) {
        boolean checked = ((ToggleButton) view).isChecked();
        if (checked) {
            imgLamp1.setImageResource(R.drawable.ic_lamp_on);

            if (btSocket != null) {
                try {
                    btSocket.getOutputStream().write("A".getBytes());
                } catch (IOException e) {
                    msg("Error");
                }
            }
        } else {
            imgLamp1.setImageResource(R.drawable.ic_lamp_off);
            if (btSocket != null) {
                try {
                    btSocket.getOutputStream().write("a".getBytes());
                } catch (IOException e) {
                    msg("Error");
                }
            }
        }
    }

    public void BtnLamp2(View view) {
        boolean checked = ((ToggleButton) view).isChecked();
        if (checked) {
            imgLamp2.setImageResource(R.drawable.ic_lamp_on);

            if (btSocket != null) {
                try {
                    btSocket.getOutputStream().write("B".getBytes());
                } catch (IOException e) {
                    msg("Error");
                }
            }
        } else {
            imgLamp2.setImageResource(R.drawable.ic_lamp_off);
            if (btSocket != null) {
                try {
                    btSocket.getOutputStream().write("b".getBytes());
                } catch (IOException e) {
                    msg("Error");
                }
            }
        }
    }

    public void BtnLamp3(View view) {
        boolean checked = ((ToggleButton) view).isChecked();
        if (checked) {
            imgLamp3.setImageResource(R.drawable.ic_lamp_on);

            if (btSocket != null) {
                try {
                    btSocket.getOutputStream().write("C".getBytes());
                } catch (IOException e) {
                    msg("Error");
                }
            }
        } else {
            imgLamp3.setImageResource(R.drawable.ic_lamp_off);
            if (btSocket != null) {
                try {
                    btSocket.getOutputStream().write("c".getBytes());
                } catch (IOException e) {
                    msg("Error");
                }
            }
        }
    }

    public void BtnLamp4(View view) {
        boolean checked = ((ToggleButton) view).isChecked();
        if (checked) {
            imgLamp4.setImageResource(R.drawable.ic_lamp_on);

            if (btSocket != null) {
                try {
                    btSocket.getOutputStream().write("D".getBytes());
                } catch (IOException e) {
                    msg("Error");
                }
            }
        } else {
            imgLamp4.setImageResource(R.drawable.ic_lamp_off);
            if (btSocket != null) {
                try {
                    btSocket.getOutputStream().write("d".getBytes());
                } catch (IOException e) {
                    msg("Error");
                }
            }
        }
    }

    public void BtnLamp5(View view) {
        boolean checked = ((ToggleButton) view).isChecked();
        if (checked) {
            imgLamp5.setImageResource(R.drawable.ic_lamp_on);

            if (btSocket != null) {
                try {
                    btSocket.getOutputStream().write("E".getBytes());
                } catch (IOException e) {
                    msg("Error");
                }
            }
        } else {
            imgLamp5.setImageResource(R.drawable.ic_lamp_off);
            if (btSocket != null) {
                try {
                    btSocket.getOutputStream().write("e".getBytes());
                } catch (IOException e) {
                    msg("Error");
                }
            }
        }
    }

    public void BtnLamp6(View view) {
        boolean checked = ((ToggleButton) view).isChecked();
        if (checked) {
            imgLamp6.setImageResource(R.drawable.ic_lamp_on);

            if (btSocket != null) {
                try {
                    btSocket.getOutputStream().write("F".getBytes());
                } catch (IOException e) {
                    msg("Error");
                }
            }
        } else {
            imgLamp6.setImageResource(R.drawable.ic_lamp_off);
            if (btSocket != null) {
                try {
                    btSocket.getOutputStream().write("f".getBytes());
                } catch (IOException e) {
                    msg("Error");
                }
            }
        }
    }

    public void BtnLamp7(View view) {
        boolean checked = ((ToggleButton) view).isChecked();
        if (checked) {
            imgLamp7.setImageResource(R.drawable.ic_lamp_on);

            if (btSocket != null) {
                try {
                    btSocket.getOutputStream().write("G".getBytes());
                } catch (IOException e) {
                    msg("Error");
                }
            }
        } else {
            imgLamp7.setImageResource(R.drawable.ic_lamp_off);
            if (btSocket != null) {
                try {
                    btSocket.getOutputStream().write("g".getBytes());
                } catch (IOException e) {
                    msg("Error");
                }
            }
        }
    }

    public void BtnLamp8(View view) {
        boolean checked = ((ToggleButton) view).isChecked();
        if (checked) {
            imgLamp8.setImageResource(R.drawable.ic_lamp_on);

            if (btSocket != null) {
                try {
                    btSocket.getOutputStream().write("H".getBytes());
                } catch (IOException e) {
                    msg("Error");
                }
            }
        } else {
            imgLamp8.setImageResource(R.drawable.ic_lamp_off);
            if (btSocket != null) {
                try {
                    btSocket.getOutputStream().write("h".getBytes());
                } catch (IOException e) {
                    msg("Error");
                }
            }
        }
    }
}