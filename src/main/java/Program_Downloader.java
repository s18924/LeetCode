public class Program_Downloader {
    public static void main(String[] args) {
        for (int month = 1; month <= 12; month++) {
            for (int day = 1; day < 32; day++) {
                System.out.printf(
                        "%s.%s.2014\n",
                        day<10 ? "0"+day : day,
                        month<10 ? "0"+month : month

                );
            }
        }
    }
}
