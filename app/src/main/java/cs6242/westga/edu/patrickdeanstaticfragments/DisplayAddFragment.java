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
public class DisplayAddFragment extends Fragment {

    private View     vThisContext;
    private TextView tvAddDisplay;
    private Double dNum1;
    private Double dProduct;
    private Double dNum2;

    public DisplayAddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.vThisContext = inflater.inflate(R.layout.fragment_display_add, container, false);
        this.tvAddDisplay = (TextView) this.vThisContext.findViewById(R.id.add_display);

        return this.vThisContext;
    }

    public void setNum1(Double dNum1) {
        this.dNum1 = dNum1;
    }
    public void setNum2(Double dNum2) {
        this.dNum2 = dNum2;
    }
    public void add() {
        this.dProduct = this.dNum1 + this.dNum2;
    }
    public void displaySum() {
        this.tvAddDisplay.setText(Double.toString(this.dProduct));
    }
}
