package utils;

public class utils {

    //clears the console
    public static void clearConsole() {

        for (int i = 0; i < 50; i++) System.out.println();

    }

    // private static void drawFrame(int height) {
    // String stars = (height % 2 == 0) ? "  *    +    *  " : "    +    *    +";
    // System.out.println(stars);
    
    // System.out.println("     ^     ");
    // System.out.println("    / \\    ");
    // System.out.println("   |   |   ");
    // System.out.println("   |SIM|   ");
    // System.out.println("   |___|   ");
    // System.out.println("    /V\\    ");
    
    // if (height % 2 == 0) {
    //     System.out.println("   v v v   ");
    // } else {
    //     System.out.println("    v v    ");
    // }

    // for (int i = 0; i < height; i++) {
    //     System.out.println();
    // }
    // }

    // public static void animateLaunch() {
    // for (int i = 0; i < 20; i++) {
    //     System.out.print("\033[H\033[2J");
    //     System.out.flush();

    //     drawFrame(i);

    //     try {
    //         Thread.sleep(100);
    //     } catch (InterruptedException e) {
    //         Thread.currentThread().interrupt();
    //     }
    //     }
    // }

    //animates a spiral in ASCII
    public static void animateTimeTravel() {
    int frames = 80; 
    int width = 100;  
    int height = 50; 

    for (int f = 0; f < frames; f++) {
        System.out.print("\033[H\033[2J");
        
        char[][] screen = new char[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) screen[y][x] = ' ';
        }

        double rotationOffset = f * 0.5; 
        
        for (double angle = 0; angle < 15; angle += 0.1) {
            double r = angle * 1.5; 
            int x = (int) (width / 2 + (r * Math.cos(angle + rotationOffset)) * 2); 
            int y = (int) (height / 2 + (r * Math.sin(angle + rotationOffset)));

            if (x >= 0 && x < width && y >= 0 && y < height) {
                if (angle < 3) screen[y][x] = '.';
                else if (angle < 7) screen[y][x] = '*';
                else if (angle < 11) screen[y][x] = '@';
                else screen[y][x] = '#';
            }
        }

        StringBuilder output = new StringBuilder();
        for (int y = 0; y < height; y++) {
            output.append(new String(screen[y])).append("\n");
        }
        System.out.println(output);

        try { Thread.sleep(50); } catch (InterruptedException e) {}
    }
}
}
