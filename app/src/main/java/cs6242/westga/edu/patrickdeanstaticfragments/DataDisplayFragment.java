package cs6242.westga.edu.patrickdeanstaticfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataDisplayFragment extends Fragment {
    private Button   bAdd;
    private TextView tvDisplay;
    private View     vInfaltedView;
    private DataAddListener listener;
    private Double   dNum1;
    private Double   dNum2;
    private Double   dProduct;
    public DataDisplayFragment() {
        this.dNum1 = 0.0;
        this.dNum2 = 0.0;
        this.dProduct = 0.0;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.vInfaltedView = inflater.inflate(R.layout.fragment_data_display, container, false);
        this.tvDisplay = (TextView) this.vInfaltedView.findViewById(R.id.display_data1);
        this.bAdd = (Button) this.vInfaltedView.findViewById(R.id.bAdd);
        this.bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double number1 = dNum1;
                    Double number2 = dNum2;
                    listener.DisplayAdd(number1, number2);
                } catch (Exception e) {
                    TextView display = (TextView) v.findViewById(R.id.display_data1);
                    display.setText("Enter two numbers");
                }
            }
        });
        return this.vInfaltedView;
    }
    public void setNum1(Double dNum1) {
        this.dNum1 = dNum1;
    }
    public void setNum2(Double dNum2) {
        this.dNum2 = dNum2;
    }
    public void multiply() {
        this.dProduct = this.dNum1 * this.dNum2;
    }
    public void displayProduct() {
        this.tvDisplay.setText(Double.toString(this.dProduct));
    }

    /**
     * Called when a fragment is first attached to its context.
     * {@link #onCreate(Bundle)} will be called after this.
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        this.listener = (DataAddListener) context;
        super.onAttach(context);
    }

    /**
     * This is the interface a programmer should use to display an add
     */
    public interface DataAddListener {
        void DisplayAdd(double a, double b);
    }
}
