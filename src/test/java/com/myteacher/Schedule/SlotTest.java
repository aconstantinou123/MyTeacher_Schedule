package com.myteacher.Schedule;

import com.myteacher.Schedule.Models.ClassLevel;
import com.myteacher.Schedule.Models.ClassType;
import com.myteacher.Schedule.Models.Slot;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
        slot1 = new Slot(id, "Thursday 23rd November 2018", "10:00", "zonio-strings", "abcd-efgh-ijkl-mnop", "ADVANCED", "ONE_ON_ONE", "Exam prep", 1, students);
    }

    @Test
    public void canTestClassType(){
        assertEquals("ONE_ON_ONE", slot1.getClassType());
    }

    @Test
    public void canTestClassLevel(){
        assertEquals("ADVANCED", slot1.getClassLevel());
    }

}
