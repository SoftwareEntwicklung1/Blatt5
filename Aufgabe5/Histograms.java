public class Histograms {
    public static void main(String[] args) {       
        if (args.length == 0) {
            System.out.println("Geben Sie die Anzahl der Segmente "
                + "im Histogramm als Programmparameter an.");
            return;
        }
        int s=Integer.parseInt(args[0]);
        String[] a=lesenEingabe();
        if (a.length < 2) {
            System.out.println("Keine Werte eingegeben.");
            return;
        }
        int[] b=ValuesArray(a);
        int min=minium(b);
        int max=maxium(b);
        int[] c=SegmentV(max,min,s,b);
        int[] d=normalisieren(c);
        printHistograms(c);
    }
    // Werte von Eingabe lesen (immer Bezeichnung mit Wert)
    public static String[] lesenEingabe() {
        String[] input = ReadStrings.readStrings();
        return input;
    }
     // Werte aus Eingaben extrahieren (jeder zweite Wert)
     public static int[]  ValuesArray(String[] input) {
        int[] values = new int[input.length / 2];
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.parseInt(input[i * 2 + 1]);
        }
        return values;
    }
    // Kleinsten Wert berechnen:
    public static int minium(int[] values){ 
        int min = values[0];
           for (int i = 1; i < values.length; i++) {
              if (values[i] < min) {
                  min = values[i];
              }
            }
            return min;
        }
    // Größten Wert berechnen:
    public static int maxium(int[] values) {       
            int max = values[0];
            for (int i = 1; i < values.length; i++) {
                if (values[i] > max) {
                 max = values[i];
                }
            }
            return max;
    }
    // Die Anzahl der Werte für jedes Segment berechnen:
    public static int[] SegmentV(int max,int min,int n,int[] values){
        int[] counts = new int[n];
         // Abstand zwischen min und max:
          int range = (max - min);
          for (int i2 = 0; i2 < values.length; i2++) {
              int section = (values[i2] - min) * n / (range+1);
              counts[section] = counts[section] + 1;
          }
          return counts;
    }
    // Werte so normalisieren, dass 50 der Maximalwert ist:
    public static int[] normalisieren(int[] counts) {
        int[] normalizedCounts = new int[counts.length];
        //
        int res = counts[0];
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > res) {
                 res = counts[i];
            }
        }
        //
        int maxCount = res;
        for (int i1 = 0; i1 < counts.length; i1++) {
            normalizedCounts[i1] = counts[i1]*50 / maxCount;
        }
        return normalizedCounts;
    }
    // Histogramm als Balken auf der Konsole ausgeben:
    public static void printHistograms(int[] normalizedCounts) {
        for (int i = 0; i < normalizedCounts.length; i++) {
            int n = normalizedCounts[i];
            for (int j = 0; j < n; j++) {
                System.out.print("|");
            }
                System.out.println();
            }
        }





}
