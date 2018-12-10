package com.myteacher.Schedule;

import com.myteacher.Schedule.Models.ClassLevel;
import com.myteacher.Schedule.Models.ClassType;
import com.myteacher.Schedule.Models.Slot;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static junit.framework.Assert.assertEquals;

public class SlotTest {

    Slot slot1;
    ArrayList<String> students;
    ObjectId id;

    @Before
    public void before(){
        id = new ObjectId("507f1f77bcf86cd799439011");
        ArrayList <String> students = new ArrayList<>();
        students.add("trinity123");
        slot1 = new Slot(id, "23-11-2018", "10:00", "zonio-strings", "abcd-efgh-ijkl-mnop", "ADVANCED", "ONE_ON_ONE", "Exam prep", 1, students, "12:00", "13:00");
    }

    @Test
    public void canTestClassType(){
        assertEquals("ONE_ON_ONE", slot1.getClassType());
    }

    @Test
    public void canTestClassLevel(){
        assertEquals("ADVANCED", slot1.getClassLevel());
    }

    @Test
    public void canFormatDate(){
        String dateFormat = "dd-MM-yyyy HH:mm";
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String dateToFormat = slot1.getDate() + " " + slot1.getStartTime();
        Date expectedDate = new Date("Fri Nov 23 12:00:00 GMT 2018");
        try{

            Date date = formatter.parse(dateToFormat);
            assertEquals(expectedDate, date);
        }
        catch (ParseException e){
            e.printStackTrace();
        }

    }

}
