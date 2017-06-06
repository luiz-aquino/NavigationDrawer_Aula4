package com.example.logonrm.navigationdrawer.navigationdrawer.Fragments;


import android.os.Bundle;
import android.renderscript.Double2;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.logonrm.navigationdrawer.navigationdrawer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormularioFragment extends Fragment implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        this.calcular(v);
    }

    private EditText edtValor1;
    private EditText edtValor2;
    private TextView tvResult;
    private Button btSomar, btSubtrair, btMultiplicar, btDivide;

    public FormularioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_formulario, container, false);

        edtValor1 = (EditText) itemView.findViewById(R.id.edtVal1);
        edtValor2 = (EditText) itemView.findViewById(R.id.edtVal2);
        tvResult = (TextView) itemView.findViewById(R.id.tvResultado);
        btSomar = (Button) itemView.findViewById(R.id.btPlus);
        btSubtrair = (Button) itemView.findViewById(R.id.btMinus);
        btMultiplicar = (Button) itemView.findViewById(R.id.btTimes);
        btDivide = (Button) itemView.findViewById(R.id.btDivide);

        btSomar.setOnClickListener(this);
        btSubtrair.setOnClickListener(this);
        btDivide.setOnClickListener(this);
        btMultiplicar.setOnClickListener(this);
        return  itemView;
    }

    public void calcular(View view){
        String strVal1 = edtValor1.getText().toString();
        String strVal2 = edtValor2.getText().toString();

        if(strVal1 != null && strVal1.isEmpty()){
            return;
        }

        if(strVal2 != null && strVal1.isEmpty()){
            return;
        }

        Double dbV1 = Double.parseDouble(strVal1);
        Double dbV2 = Double.parseDouble(strVal2);
        Double result = 0.0;

        switch (view.getId()){
            case R.id.btPlus:
                result = dbV1 + dbV2;
                break;
            case R.id.btMinus:
                result = dbV1 - dbV2;
                break;
            case R.id.btTimes:
                result = dbV1 * dbV2;
                break;
            case R.id.btDivide:
                if(dbV2 == 0)
                    return;
                result = dbV1 / dbV2;
                break;
            default:
                break;
        }

        tvResult.setText(result.toString());

    }
}
