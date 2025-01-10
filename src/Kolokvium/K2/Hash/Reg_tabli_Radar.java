package Kolokvium.K2.Hash;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

class CaughtPerson implements Comparable<CaughtPerson> {
    String fullName;
    int speed;
    int seconds;

    public CaughtPerson(String fullName, int speed, int seconds) {
        this.fullName = fullName;
        this.speed = speed;
        this.seconds = seconds;
    }

    @Override
    public int compareTo(CaughtPerson o) {
        if (this.seconds > o.seconds) {
            return 1;
        } else if (this.seconds < o.seconds) {
            return -1;
        }
        return 0;
    }

}

public class Reg_tabli_Radar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        OBHT<String, String> table = new OBHT<>(n * 2);
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String fullName = parts[1] + " " + parts[2];
            table.insert(parts[0], fullName);
        }
        int MaxSpeedLimit = sc.nextInt();
        sc.nextLine();
        String[] radarData = sc.nextLine().split("\\s+");
        List<CaughtPerson> caughtPeople = new ArrayList<>();
        for (int i = 0; i < radarData.length - 2; i += 3) {
            String regTable = radarData[i];
            int speed = Integer.parseInt(radarData[i + 1]);
            String time = radarData[i + 2];
            String[] timeParts = time.split(":");
            int hour = Integer.parseInt(timeParts[0]);
            int minute = Integer.parseInt(timeParts[1]);
            int second = Integer.parseInt(timeParts[2]);
            int totalSeconds = hour * 3600 + minute * 60 + second;
            int index = table.search(regTable);
            if (index != -1) {
                String fullName = table.getBucket(index).value;
                if (speed > MaxSpeedLimit) {
                    CaughtPerson caughtPerson = new CaughtPerson(fullName, speed, totalSeconds);
                    caughtPeople.add(caughtPerson);
                }
            }
        }
        Collections.sort(caughtPeople);
        for (CaughtPerson caughtPerson : caughtPeople) {
            System.out.println(caughtPerson.fullName);
        }
    }
}
