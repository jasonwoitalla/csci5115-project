package devices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.csci5115project.R;

import java.util.List;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder> {

    private Context mCtx;

    private List<Device> deviceList;

    public DeviceAdapter(Context mCtx, List<Device> deviceList) {
        this.mCtx = mCtx;
        this.deviceList = deviceList;
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

        holder.textViewTitle.setText(device.getDeviceName());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(device.getImage()));
    }

    @Override
    public int getItemCount() {
        return deviceList.size();
    }

    class DeviceViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        ImageView imageView;

        public DeviceViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            imageView = itemView.findViewById(R.id.imageView2);
        }
    }
}
