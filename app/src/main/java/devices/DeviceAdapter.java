package devices;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.ImageButton;
import android.view.View.OnClickListener;

import androidx.recyclerview.widget.RecyclerView;

import com.example.csci5115project.R;

import java.util.ArrayList;
import java.util.List;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder> {

    private Context mCtx;

    private List<Device> deviceList;

    boolean click;
    PopupWindow popUp;

    List<String> title = new ArrayList<String>();
    List<String> title2 = new ArrayList<String>();

    int val;

    public DeviceAdapter(Context mCtx, List<Device> deviceList) {
        this.title.clear();
        this.mCtx = mCtx;
        this.deviceList = deviceList;
        this.popUp = null;
        this.val = 0;
        this.title.add("To dispose of an iPhone responsibly, first, back up any important data, then delete all personal information and sign out of all accounts, finally, either recycle it through an Apple Store, trade it in, or donate it to a reputable organization, ensuring it's not simply thrown away as electronic waste. \n \n");
        this.title.add("To recycle an old laptop, wipe the hard drive clean, remove the battery, and take it to a certified e-waste recycling facility that will handle it in an environmentally friendly manner. \n \n");
        this.title.add("Recycling a printer requires disassembling it and separating the parts, so it's best to take it to an e-waste recycling facility or to a manufacturer-sponsored program that can safely dispose of it. \n \n");
        this.title.add("Cell phones can be recycled through a number of options, including mailing them to a recycling company or dropping them off at a local electronics retailer or authorized collection site. \n \n");
        this.title.add("To recycle a television, check with your local waste management facility or an electronics recycling company to see if they accept it, or contact the manufacturer to learn about their recycling program. \n \n");
        this.title.add("Batteries, such as those found in laptops or cell phones, should be recycled separately from the device itself by taking them to a battery recycling center or an e-waste facility that accepts them. \n \n");
        this.title.add("Many companies now offer take-back programs for their products, so check with the manufacturer of your electronic device to see if they have a recycling program in place. \n \n");
        this.title2.add("Extend the life of your electronic devices by keeping them clean, using protective cases, and regularly updating software to reduce the need for replacement. \n \n");
        this.title2.add("Reduce your energy consumption and carbon footprint by turning off electronics when not in use, using power-saving modes, and investing in energy-efficient devices. \n \n");
        this.title2.add("Avoid electronic waste by repairing or upgrading devices instead of buying new ones, or by donating or recycling them through certified programs. \n \n");
        this.title2.add("Use digital alternatives to paper-based processes, such as online bill payment, e-tickets, and e-books, to reduce paper consumption and waste. \n \n");
        this.title2.add("Consider the environmental impact of technology when making purchasing decisions, and choose products with eco-friendly features, such as biodegradable materials and low power consumption. \n \n");
        this.title2.add("Educate yourself about sustainable technology practices and encourage others to do the same, by sharing information about recycling, energy-saving tips, and eco-friendly options for electronic devices. \n \n");
    }

    @Override
    public DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_device, null);
        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DeviceViewHolder holder, int position) {
        Device device = deviceList.get(position);

        TextView img = new TextView(this.mCtx);
        img.setText("Steps to Recycle\n");
        img.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);

        TextView tv = new TextView(this.mCtx);
        tv.setText(this.title.get(position));

        TextView img2 = new TextView(this.mCtx);
        img2.setText("Additional Sustainability Info\n");
        img2.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);

        TextView tv2 = new TextView(this.mCtx);
        tv2.setText(this.title2.get(position));

        holder.textViewTitle.setText(device.getDeviceName());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(device.getImage()));
        this.popUp = new PopupWindow();

        LinearLayout layout = new LinearLayout(this.mCtx);

        holder.imageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click) {
                    popUp.showAtLocation(layout, Gravity.LEFT, 0, 0);
                    popUp.update(00, -30, 750, 1840);
                    click = false;
                } else {
                    popUp.dismiss();
                    click = true;
                }
            }
        });

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.setBackgroundColor(Color.BLACK);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(img, params);
        layout.addView(tv, params);
        layout.addView(img2, params);
        layout.addView(tv2, params);

        popUp.setContentView(layout);
    }

    @Override
    public int getItemCount() {
        return deviceList.size();
    }

    class DeviceViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        ImageView imageView;
        ImageButton imageButton;

        public DeviceViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            imageView = itemView.findViewById(R.id.imageView2);
            imageButton = itemView.findViewById(R.id.imageButton);
        }
    }
}
