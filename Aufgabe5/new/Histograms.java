public class Histograms {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Geben Sie die Anzahl der Segmente "
                + "im Histogramm als Programmparameter an.");
            return;
        }

        // Werte von Eingabe lesen (immer Bezeichnung mit Wert)
        String[] input = ReadStrings.readStrings();
        if (input.length < 2) {
            System.out.println("Keine Werte eingegeben.");
            return;
        }

        // Werte aus Eingaben extrahieren (jeder zweite Wert)
        int[] values = new int[input.length / 2];
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.parseInt(input[i * 2 + 1]);
        }

        // Kleinsten Wert berechnen:
        int min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] < min) {
                min = values[i];
            }
        }
        // Größten Wert berechnen:
        int max = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }

        // Die Anzahl der Werte für jedes Segment berechnen:
        int[] counts = new int[Integer.parseInt(args[0])];
        // Abstand zwischen min und max:
        int range = (max - min);
        for (int i2 = 0; i2 < values.length; i2++) {
            int section = (values[i2] - min) * Integer.parseInt(args[0]) / (range+1);
            counts[section] = counts[section] + 1;
        }

        // Werte so normalisieren, dass 50 der Maximalwert ist:
        int[] normalizedCounts = new int[counts.length];
        int res = counts[0];
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > res) {
                res = counts[i];
            }
        }
        int maxCount = res;
        for (int i1 = 0; i1 < counts.length; i1++) {
            normalizedCounts[i1] = counts[i1] * 50 / maxCount;
        }

        // Histogramm als Balken auf der Konsole ausgeben:
        for (int i = 0; i < normalizedCounts.length; i++) {
            int n = normalizedCounts[i];
            for (int j = 0; j < n; j++) {
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
