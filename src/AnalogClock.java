public class AnalogClock {
    /*
    Käsurealt sisendi sisse lugemine ja tulemuse kuvamine
     */
    public static void main(String[] args) {
        AnalogClock analogClock = new AnalogClock();
        System.out.println(analogClock.CalculateAngle(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }

    /*
    Meetod arvutab analoogkella seierite vahelise nurga. Eeldasin, et 0 kraadi algab tunniseierist mistõttu arvutasin,
    milline on nurk tunni- ja minutiseieri vahel alustades kraadide lugemist tunniseierist.
    Meetodile tuleb käsurealt ette anda kaks eraldi parameetrit ning kui need parameetrid ei sobi kellaajaks,
    siis tagastatakse -1.

    Seierite vahelise nurga arvutamine:
    Esimesel juhul tuleb arvutada nurk siis, kui minutiseier on peale tunniseierit ja ta pole nullist möödunud.
    Teisel juhul tuleb arvutada nurk siis, kui minutiseier on peale tunniseierit ja ta on nullist möödunud.
     */

    int CalculateAngle(int hours, int minutes) {
        // Mitu kraadi on üks minut
        int oneMinuteAngle = 360 / 60;
        // Mitu minutit on ühes tunnis
        int oneHourMinutes = 60 / 12;
        // Mitu kraadi on üks tund
        int oneHourAngle = 360 / 12;
        // Seierite vaheline nurk
        int angle;

        if (0 <= minutes && minutes <=60 && 0 <= hours && hours <= 24) {

            if (hours > 12) {
                hours = hours - 12;
            }
            if (minutes == 60) {
                minutes = 0;
            }

            // Mitu kraadi on tunniseier liikunud kahe erineva tunni vahel (näiteks kahe ja kolme vahel)
            int angleOfHourHandByMinutesPassed = Math.round((oneHourAngle * minutes) / 60);
            
            // Seierite vahelise nurga arvutamine
            if (minutes < hours * oneHourMinutes) {
                angle = ((60 - (hours * oneHourMinutes) + minutes) * oneMinuteAngle) - angleOfHourHandByMinutesPassed;
            } else {
                angle = ((minutes - (hours * oneHourMinutes)) * oneMinuteAngle) - angleOfHourHandByMinutesPassed;
            }
        }
        else {
            return -1;
        }

        return angle;
    }


}
