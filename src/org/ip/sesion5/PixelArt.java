package org.ip.sesion5;

public class PixelArt {

    // Códigos ANSI para colores de fondo (background)
    // Se recomienda usar estos colores para simular mejor el pixel art.
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK_BG = "\u001B[40m"; // 0
    public static final String ANSI_YELLOW_BG = "\u001B[43m"; // 1
    public static final String ANSI_WHITE_BG = "\u001B[47m"; // 2
    
    // Matriz de 15x15 representando el emoji con gafas
    // 0: Negro, 1: Amarillo, 2: Blanco
    private static final int[][] ICONO_EMOJI = {
        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, // 0
        {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}, 
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
        {1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1},
        {1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1}, 
        {1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1}, 
        {1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1}, 
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
        {0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0}, 
        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0}, 
        {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, 
        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}  //14
    };
    
    public void mostrarPixelArt() {
        int filas = ICONO_EMOJI.length;
        int columnas = ICONO_EMOJI[0].length;
        
        System.out.println("🖼️ Icono Emoji (PixelArt) 🖼️\n");
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int colorCode = ICONO_EMOJI[i][j];
                String ansiColor = getColor(colorCode);
                
                System.out.print(ansiColor + "  " + ANSI_RESET); 
            }
            System.out.println();
        }
        System.out.println("\n" + ANSI_RESET); 
    }
  
    private String getColor(int code) {
        switch (code) {
            case 0:
                return ANSI_BLACK_BG;
            case 1:
                return ANSI_YELLOW_BG;
            case 2:
                return ANSI_WHITE_BG;
            default:
                return ANSI_BLACK_BG; 
        }
    }

    public static void main(String[] args) {
        PixelArt pixelArt = new PixelArt();
        pixelArt.mostrarPixelArt();
    }
}
