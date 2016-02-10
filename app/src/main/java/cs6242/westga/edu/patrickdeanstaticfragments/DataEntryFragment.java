package cs6242.westga.edu.patrickdeanstaticfragments;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataEntryFragment extends Fragment {

    private EditText etNumber1;
    private EditText etNumber2;
    private DataEntryListener listener;
    public interface DataEntryListener {
        void onDataEntry(double one, double two);
    }

    public DataEntryFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.etNumber1 = (EditText) container.findViewById(R.id.number_1);
        this.etNumber2 = (EditText) container.findViewById(R.id.number_2);
        Button btnMultiply = (Button) container.findViewById(R.id.multiply_button);
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                multiplyButtonClicked(v);
            }
        });
        return inflater.inflate(R.layout.fragment_data_entry, container, false);
    }

    /**
     * Called when a fragment is first attached to its context.
     * {@link #onCreate(Bundle)} will be called after this.
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (DataEntryListener) context;
    }

    public void multiplyButtonClicked(View v) {
        TextView tvTitle = (TextView) v.findViewById(R.id.textView);
        try {
            double number1 = Double.parseDouble(this.etNumber1.getText().toString());
            this.listener.onDataEntry(number1, number1);
            tvTitle.setTextColor(Color.BLACK);
        } catch (Exception e) {
            tvTitle.setTextColor(Color.RED);
        }

    }

}
