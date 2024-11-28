package com.example.application22024.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application22024.JobDetails;
import com.example.application22024.R;
import com.example.application22024.model.Company;
import com.example.application22024.model.Job;

import java.util.ArrayList;
import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {

    private List<Job> jobList;
    private Context context;
    public JobAdapter(Context context, List<Job> jobList) {
        this.context = context;
        this.jobList = (jobList != null) ? jobList : new ArrayList<>();

    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.job_post, parent, false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        Job job = jobList.get(position);

        // Set data to views
        holder.jobName.setText(job.getTitle());
        holder.employerName.setText(job.getCompany() != null ? job.getCompany().getCompanyName() : "N/A");
        holder.location.setText(job.getWorkLocation());
        holder.jobType.setText(job.getWorkType());
        holder.workplaceType.setText(job.getWorkField());
        holder.duration.setText(job.getWorkPeriod());
        holder.salary.setText(job.getSalary());
        holder.durationType.setText(job.getSalaryType());

        // Set other views such as image or bookmark (optional)
        // Thiết lập OnClickListener cho mỗi mục
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, JobDetails.class);
//            intent.putExtra("job_id", job.getId()); // Gửi ID của job (hoặc thông tin cần thiết khác)
            intent.putExtra("userType", "Employee");
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return (jobList != null && !jobList.isEmpty()) ? jobList.size() : 0;
    }


    public static class JobViewHolder extends RecyclerView.ViewHolder {

        TextView jobName, employerName, location, jobType, workplaceType, duration, salary, durationType;
        ImageView avatar, bookmark;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize views
            jobName = itemView.findViewById(R.id.JobName);
            employerName = itemView.findViewById(R.id.EmployerName);
            location = itemView.findViewById(R.id.location);
            jobType = itemView.findViewById(R.id.JobType);
            workplaceType = itemView.findViewById(R.id.WorkPlaceType);
            duration = itemView.findViewById(R.id.duration);
            salary = itemView.findViewById(R.id.salary);
            durationType = itemView.findViewById(R.id.durationType);

            // Optional views (like avatar and bookmark)
            avatar = itemView.findViewById(R.id.imageViewAvatar);
            bookmark = itemView.findViewById(R.id.bookmark);
        }
    }
}