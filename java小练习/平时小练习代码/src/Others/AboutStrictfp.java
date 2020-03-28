package Others;

strictfp class AboutStrictfp {
    private static double aDouble = 0.05522222222233212d;
    private static float aFloat = 033311113334410222f;

    public static void main(String[] args) {

        double cDouble = aDouble / aFloat;

        System.out.println("aDouble:" + aDouble);
        System.out.println("aFloat:" + aFloat);
        System.out.println("cDouble:" + cDouble);
    }
}
