package watchtower.ayalacashier;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class CateringSalads extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catering_salads);

        initButtons();
    }

    public void initButtons()
    {
        Button eggSaladButton = (Button)findViewById(R.id.eggSalad);
        Button eggplantSaladButton = (Button)findViewById(R.id.eggplantSalad);
        Button thiniSaladButton = (Button)findViewById(R.id.greedThiniSalad);
        Button avocadoSaladButton = (Button)findViewById(R.id.avocadoSalad);

        if(Cashier.cateringOrder.containsKey(eggSaladButton.getText())) {
            eggSaladButton.setBackground(getDrawable(R.drawable.circle_gray));
            eggSaladButton.setTag(R.string.TAGchecked);
        }
        if(Cashier.cateringOrder.containsKey(eggplantSaladButton.getText())) {
            eggplantSaladButton.setBackground(getDrawable(R.drawable.circle_gray));
            eggplantSaladButton.setTag(R.string.TAGchecked);
        }
        if(Cashier.cateringOrder.containsKey(thiniSaladButton.getText())) {
            thiniSaladButton.setBackground(getDrawable(R.drawable.circle_gray));
            thiniSaladButton.setTag(R.string.TAGchecked);
        }
        if(Cashier.cateringOrder.containsKey(avocadoSaladButton.getText())) {
            avocadoSaladButton.setBackground(getDrawable(R.drawable.circle_gray));
            avocadoSaladButton.setTag(R.string.TAGchecked);
        }
    }

    public void openHugeSalad(View v)
    {
        //final String s1 = getString(R.string.hugeSaladCatering1);
        //final String s2 = getString(R.string.hugeSaladCatering2);
        //final String s3 = getString(R.string.hugeSaladCatering3);
        //final String s4 = getString(R.string.hugeSaladCatering4);
        Log.d("TKT_CateringSalads","openHugeSalad================");
        final String [] saladType = {getString(R.string.hugeSaladCatering1), getString(R.string.hugeSaladCatering2),getString(R.string.hugeSaladCatering3),getString(R.string.hugeSaladCatering4)};
        final boolean [] isCheckedArr = new boolean[4];
        Catering.PRICE = Cashier.CATERING_PRICES[Cashier.SALAD_HUGE];
        Cashier.dialog = new Dialog(this);
        Cashier.dialog.setContentView(R.layout.dialog_catering_huge_salad);
        Cashier.dialog.setCanceledOnTouchOutside(false);
        Button proceed = (Button)Cashier.dialog.findViewById(R.id.proceedDialog);
        final CheckBox salad1 = (CheckBox)Cashier.dialog.findViewById(R.id.hugeSalad1);
        final CheckBox salad2 = (CheckBox)Cashier.dialog.findViewById(R.id.hugeSalad2);
        final CheckBox salad3 = (CheckBox)Cashier.dialog.findViewById(R.id.hugeSalad3);
        final CheckBox salad4 = (CheckBox)Cashier.dialog.findViewById(R.id.hugeSalad4);

        if(Cashier.cateringOrder.containsKey(saladType[0])) {
            salad1.setChecked(true);
            //isCheckedArr[0] = true;
        }
        if(Cashier.cateringOrder.containsKey(saladType[1])) {
            salad2.setChecked(true);
            //isCheckedArr[1] = true;
        }
        if(Cashier.cateringOrder.containsKey(saladType[2])) {
            salad3.setChecked(true);
            //isCheckedArr[2] = true;
        }
        if(Cashier.cateringOrder.containsKey(saladType[3])) {
            salad4.setChecked(true);
            //isCheckedArr[3] = true;
        }

        TextView salad1txt = (TextView)Cashier.dialog.findViewById(R.id.hugeSalad1txt);
        TextView salad2txt = (TextView)Cashier.dialog.findViewById(R.id.hugeSalad2txt);
        TextView salad3txt = (TextView)Cashier.dialog.findViewById(R.id.hugeSalad3txt);
        TextView salad4txt = (TextView)Cashier.dialog.findViewById(R.id.hugeSalad4txt);

        salad1txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catering.textPressHandler(salad1);
            }
        });
        salad2txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catering.textPressHandler(salad2);
            }
        });
        salad3txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catering.textPressHandler(salad3);
            }
        });
        salad4txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catering.textPressHandler(salad4);
            }
        });


        salad1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //checkHandler(s1, isChecked);
                isCheckedArr[0] = isChecked;
            }
        });
        salad2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //checkHandler(s2, isChecked);
                isCheckedArr[1] = isChecked;
            }
        });
        salad3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               // checkHandler(s3, isChecked);
                isCheckedArr[2] = isChecked;
            }
        });
        salad4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //checkHandler(s4, isChecked);
                isCheckedArr[3] = isChecked;
            }
        });



        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catering.checkHandler(saladType,isCheckedArr, Catering.NO_FLAG);
                Cashier.dialog.dismiss();
            }
        });


        Cashier.dialog.show();
    }

    public void openLentilSalad(View v)
    {
        //final String stringLentil = getString(R.string.lentilSaladCateringIngre);
        Log.d("TKT_CateringSalads","openLentilSalad================");
        final String [] stringLentil = {getString(R.string.lentilSaladCateringIngre)};
        final boolean [] isCheckedArr = new boolean[1];
        Catering.PRICE = Cashier.CATERING_PRICES[Cashier.SALAD_LENTIL];
        Cashier.dialog = new Dialog(this);
        Cashier.dialog.setContentView(R.layout.dialog_catering_lentil_salad);
        Cashier.dialog.setCanceledOnTouchOutside(false);
        Button proceed = (Button)Cashier.dialog.findViewById(R.id.proceedDialog);
        final CheckBox lentil = (CheckBox)Cashier.dialog.findViewById(R.id.lentilSaladCheckBox);

        if(Cashier.cateringOrder.containsKey(stringLentil[0])) {
            lentil.setChecked(true);
            //isCheckedArr[0] = true;//redundant? cuz no duplicates in a hash
        }
       TextView lentilTxt = (TextView)Cashier.dialog.findViewById(R.id.lentilSalad1txt);
        //LinearLayout lentilField = (LinearLayout)Cashier.dialog.findViewById(R.id.lentilLayout);
        lentilTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catering.textPressHandler(lentil);
            }
        });

        lentil.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //checkHandler(stringLentil, isChecked);
                isCheckedArr[0] = isChecked;
            }
        });

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catering.checkHandler(stringLentil,isCheckedArr, Catering.NO_FLAG);
                Cashier.dialog.dismiss();
            }
        });

        Cashier.dialog.show();
    }

    public void openQuinoaSalad(View v)
    {
        //final String stringQuinoa = getString(R.string.quinoaSaladCateringIngre);
        final String [] stringQuinoa = {getString(R.string.quinoaSaladCateringIngre)};
        final boolean [] isCheckedArr = new boolean[1];
        Catering.PRICE = Cashier.CATERING_PRICES[Cashier.SALAD_QUINOA];
        Cashier.dialog = new Dialog(this);
        Cashier.dialog.setContentView(R.layout.dialog_catering_quinoa_salad);
        Cashier.dialog.setCanceledOnTouchOutside(false);
        Button proceed = (Button)Cashier.dialog.findViewById(R.id.proceedDialog);
        final CheckBox quinoa = (CheckBox)Cashier.dialog.findViewById(R.id.quinoaSaladCheckBox);

        if(Cashier.cateringOrder.containsKey(stringQuinoa[0]))
            quinoa.setChecked(true);
        TextView quinoaTxt = (TextView)Cashier.dialog.findViewById(R.id.quinoaSaladtxt);

        quinoaTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catering.textPressHandler(quinoa);
            }
        });

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catering.checkHandler(stringQuinoa,isCheckedArr, Catering.NO_FLAG);
                Cashier.dialog.dismiss();
            }
        });

        quinoa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //checkHandler(stringQuinoa, isChecked);
                isCheckedArr[0] = isChecked;
            }
        });

        Cashier.dialog.show();

    }

    public void openTunaSalad(View v)
    {
        //final String stringTuna = getString(R.string.tunaSaladCateringIngre);
        Log.d("TKT_CateringSalads","openTunaSalad================");
        final String [] stringTuna = {getString(R.string.tunaSaladCateringIngre)};
        final boolean [] isCheckedArr = new boolean[1];
        Catering.PRICE = Cashier.CATERING_PRICES[Cashier.SALAD_TUNA];
        Cashier.dialog = new Dialog(this);
        Cashier.dialog.setContentView(R.layout.dialog_catering_tuna_salad);
        Cashier.dialog.setCanceledOnTouchOutside(false);
        Button proceed = (Button)Cashier.dialog.findViewById(R.id.proceedDialog);
        final CheckBox tuna = (CheckBox)Cashier.dialog.findViewById(R.id.tunaSaladCheckBox);

        if(Cashier.cateringOrder.containsKey(stringTuna[0]))
            tuna.setChecked(true);
        TextView tunaTxt = (TextView)Cashier.dialog.findViewById(R.id.tunaSaladtxt);

        tunaTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catering.textPressHandler(tuna);
            }
        });

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catering.checkHandler(stringTuna,isCheckedArr, Catering.NO_FLAG);
                Cashier.dialog.dismiss();
            }
        });

        tuna.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //checkHandler(stringTuna, isChecked);
                isCheckedArr[0] = isChecked;
            }
        });

        Cashier.dialog.show();
    }

    /*
    public void textPressHandler(String saladType, CheckBox check)
    {
        if(check.isChecked())
            check.setChecked(false);
        else
            check.setChecked(true);
        //checkHandler(saladType, check.isChecked());
    }
    */

    /*
    public void checkHandler(String [] saladType, boolean [] isChecked)
    {moved to Catering.class
        Log.d("TKT_cateringSalad","checkHandler==============");
        CateringObjectInfo c = new CateringObjectInfo(Catering.PRICE, "1");

        for(int i = 0; i < saladType.length; i++)
        {
            if(isChecked[i])
                Cashier.cateringOrder.put(saladType[i],c);
        }

    }
*/

    public void openEggSalad(View v)
    {
        //PRICE = Cashier.CATERING_PRICES[4];
        Log.d("TKT_CateringSalads","openEggSalad================");
        Cashier.cateringButtonBackgroundChange(v,this,Cashier.CATERING_PRICES[Cashier.SALAD_EGG]);
    }

    public void openEggplantSalad(View v)
    {
        //PRICE = Cashier.CATERING_PRICES[5];
        Log.d("TKT_CateringSalads","openEggplantSalad================");
        Cashier.cateringButtonBackgroundChange(v, this, Cashier.CATERING_PRICES[Cashier.SALAD_EGGPLANT]);
    }

    public void openThiniSalad(View v)
    {
        //PRICE = Cashier.CATERING_PRICES[6];
        Log.d("TKT_CateringSalads","openThiniSalad================");
        Cashier.cateringButtonBackgroundChange(v, this, Cashier.CATERING_PRICES[Cashier.SALAD_THINI]);
    }

    public void openAvocadoSalad(View v)
    {
        //PRICE = Cashier.CATERING_PRICES[7];
        Log.d("TKT_CateringSalads","openAvocadoSalad================");
        Cashier.cateringButtonBackgroundChange(v, this, Cashier.CATERING_PRICES[7]);
    }




}
