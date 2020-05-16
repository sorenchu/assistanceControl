package spinner;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.assistancecontrol.R;

public class CategorySpinner {

    private Spinner spinner;

    public CategorySpinner(Activity activity, int categoryId) {
        this.spinner = (Spinner) activity.findViewById(categoryId);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                activity,
                R.array.category_array,
                android.R.layout.simple_spinner_dropdown_item
        );
        this.spinner.setAdapter(adapter);
    }

    public Spinner getSpinner() {
        return this.spinner;
    }
}
