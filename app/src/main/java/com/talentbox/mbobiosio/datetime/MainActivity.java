package com.talentbox.mbobiosio.datetime;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mbuodile Obiosio on July 10, 2018
 * cazewonder@gmail.com
 */

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.salute)
    TextView salute;
    @Bind(R.id.info)
    TextView info;

    String mSalute;
    String mInfo;
    String mDate;

    Calendar mCalendar;
    SimpleDateFormat mSimpleDateFormat;


    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mCalendar = Calendar.getInstance();
        mSimpleDateFormat = new SimpleDateFormat("HH");
        mDate = mSimpleDateFormat.format(mCalendar.getTime());


        int time = Integer.parseInt(mDate);
        int dayOfWeek = mCalendar.get(Calendar.DAY_OF_WEEK);
        int dayOfMonth = mCalendar.get(Calendar.DAY_OF_MONTH);
        int weekOfYear = mCalendar.get(Calendar.WEEK_OF_YEAR);
        int month = mCalendar.get(Calendar.MONTH);


        if (Calendar.MONDAY == dayOfWeek) {
                mInfo = "It's Monday Pal. Happy New Week";
        } else if (Calendar.WEDNESDAY == dayOfWeek) {
            mInfo = "Hey, It's Wednesday";
        } else if (Calendar.FRIDAY == dayOfWeek) {
            mInfo = "Happy Weekend";
        } else if (Calendar.SUNDAY == dayOfWeek) {
            if (time >= 6 && time < 12) {
                mInfo = "Pray for the world";
            } else {
                mInfo = "Happy Sunday";
            }
        }

        if (mCalendar.get(Calendar.DATE) == 1)
            mInfo = "Happy New Month";

        if (Calendar.YEAR == weekOfYear) {
            if (dayOfMonth >= 0 &&  dayOfMonth < 9) {
                mInfo = "Happy New Year";
            }
        }
        if (Calendar.MARCH == month) {
            if (dayOfMonth >= 25) {
                mInfo = "Happy Independence Bangladesh";
            }
        }
        if (Calendar.MAY == month) {
            if (dayOfMonth >= 1) {
                mInfo = "Happy Worker's Day";
            }
        }
        if (Calendar.AUGUST == month) {
            if (dayOfMonth >= 5 && dayOfMonth < 26) {
                mInfo = "Happy Holidays";
            }
            if (dayOfMonth >= 15) {
                mInfo = "Happy Independence India";
            }
        }
        if (Calendar.OCTOBER == month) {
            if (dayOfMonth >= 1) {
                mInfo = "Happy Independence Day Nigeria";
            }
        }

        info.setText(mInfo);




        /* Salute Part - Working Fine */
        if (time >= 0 && time < 12)
            mSalute = getString(R.string.morning);
        else if (time >= 12 && time < 17)
            mSalute = getString(R.string.afternoon);
        else if (time >= 17 && time < 21)
            mSalute = getString(R.string.evening);
        else if (time >= 21 && time < 24)
            mSalute = getString(R.string.night);
        salute.setText(mSalute);
    }


}
