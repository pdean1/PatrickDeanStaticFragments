package cs6242.westga.edu.patrickdeanstaticfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataDisplayFragment extends Fragment {

    private TextView tvDisplay;
    private View     vInfaltedView;
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
        return this.vInfaltedView;
    }
    public void setdNum1(Double dNum1) {
        this.dNum1 = dNum1;
    }
    public void setdNum2(Double dNum2) {
        this.dNum2 = dNum2;
    }
    public void multiply() {
        this.dProduct = this.dNum1 * this.dNum2;
    }
    public void displayProduct() {
        this.tvDisplay.setText(Double.toString(this.dProduct));
    }
}
