package Class;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ltdidong.asynctaskactivity.R;

public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {

    Activity contextParent;

    // Constructor
    public MyAsyncTask(Activity contextParent) {
        this.contextParent = contextParent;
    }

    // Implement method
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Hàm này sẽ chạy đầu tiên
        Toast.makeText(contextParent, "Bắt đầu...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        // Hàm này thực hiện các tác vụ nền
        // Tuyệt đối vẽ giao diện người dùng ở đây
        for (int i = 0; i <= 100; i++) {
            SystemClock.sleep(50); // Mô phỏng quá trình tải
            publishProgress(i);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        // Hàm này cập nhật giao diện người dùng
        super.onProgressUpdate(values);
        ProgressBar progressBar = contextParent.findViewById(R.id.prbDemo);
        progressBar.setProgress(values[0]);
        TextView textView = contextParent.findViewById(R.id.txtStatus);
        textView.setText(values[0] + "%");
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        // Hàm này chạy khi hàm doInBackground kết thúc
        Toast.makeText(contextParent, "Tải hoàn tất!", Toast.LENGTH_SHORT).show();
    }
}